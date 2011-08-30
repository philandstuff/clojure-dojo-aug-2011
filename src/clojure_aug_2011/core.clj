(ns clojure-aug-2011.core
  (:gen-class))

(defn which-player [board]
  (let [xs (count (filter #(= \x %) board))
	os (count (filter #(= \0 %) board))]
    (if (= xs os) \0 \x)))

(defn indexed-board [board] (vector (seq board)))

#_(defn row-is-win [ib c1 c2 c3]
  (let [player (which-player ib)
	contents (map ib [c1 c2 c3])]
    (when
	(and
	 (= 2 (count #(= player %) contents)
	      )
	 (= 1 (count #(= \- %) contents))))))

#_(defn instant-horiz-win [board]
  (let [player (which-player board)
	ib (indexed-board board)]
        (row-is-win ib 0 1 2)
	))

#_(defn instant-win [board]
  (instant-horiz-win board))

(defn choice [board]
  (cond ;(instant-win board) (instant-win board)
	(= \- (nth board 4)) 4
	(= \- (nth board 2)) 2
	(= \- (nth board 6)) 6
	(= \- (nth board 0)) 0
	(= \- (nth board 8)) 8
	:else (.indexOf board "-")))

(defn -main [prev]
  (println (choice prev)))