(ns clojure-aug-2011.core
  (:gen-class))

(defn choice [board]
  (cond (= \- (nth board 4)) 5
	(= \- (nth board 0)) 0
	(= \- (nth board 6)) 6
	(= \- (nth board 2)) 2
	(= \- (nth board 8)) 8
	:else (inc (.indexOf board "-"))))

(defn -main [prev]
  (println (choice prev)))