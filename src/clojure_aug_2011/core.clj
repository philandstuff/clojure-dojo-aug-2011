(ns clojure-aug-2011.core
  (:gen-class))

(defn choice [board]
  (cond (= \- (nth board 4)) 5
	(= \- (nth board 0)) 1
	(= \- (nth board 6)) 7
	(= \- (nth board 2)) 3
	(= \- (nth board 8)) 9
	:else (inc (.indexOf board "-"))))

(defn -main [prev]
  (println (choice prev)))