(ns clojure-aug-2011.core
  (:gen-class))

(defn instant-horiz-win [board]
  (let [cells (seq board)
	row1 (take 3 cells)
	row2 (take 3 (drop 3 cells))
	row3 (take 3 (drop 6 cells))]
    ))

(defn instant-win [board]
  (instant-horiz-win board))

(defn choice [board]
  (cond ;;(instant-win board) (instant-win board)
	(= \- (nth board 4)) 4
	(= \- (nth board 0)) 0
	(= \- (nth board 6)) 6
	(= \- (nth board 2)) 2
	(= \- (nth board 8)) 8
	:else (.indexOf board "-")))

(defn -main [prev]
  (println (choice prev)))