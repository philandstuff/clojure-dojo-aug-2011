(ns clojure-aug-2011.core
  (:gen-class))

(defn which-player [board]
  (let [xs (count (filter #(= \x %) board))
	os (count (filter #(= \0 %) board))]
    (if (= xs os) \0 \x)))

(defn indexed-board [board] (vec board))

(defn index-of-empty [indexed-board c1 c2 c3]
  (first (filter #(= \- (indexed-board %)) [c1 c2 c3])))

(defn row-is-win [indexed-board [c1 c2 c3]]
  (let [player (which-player indexed-board)
	row-contents (map indexed-board [c1 c2 c3])
	]
    (when
	(and
	 (= 2 (count (filter #(= player %) row-contents)))
	 (= 1 (count (filter #(= \- %) row-contents))))
      (index-of-empty indexed-board c1 c2 c3))))

(def all-rows [[0 1 2] [3 4 5] [6 7 8] [0 3 6] [1 4 7] [2 5 8] [0 4 8] [2 4 6]])

(defn instant-win [board]
  (some (partial row-is-win (indexed-board board)) all-rows))

(defn choice [board]
  (cond (instant-win board) (instant-win board)
	(= \- (nth board 4)) 4
	(= \- (nth board 2)) 2
	(= \- (nth board 6)) 6
	(= \- (nth board 0)) 0
	(= \- (nth board 8)) 8
	:else (.indexOf board "-")))

(defn -main [prev]
  (println (choice prev)))