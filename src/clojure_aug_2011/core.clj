(ns clojure-aug-2011.core
  (:gen-class))

(defn choice [board]
  (inc (.indexOf board "-")))

(defn -main [prev]
  (println (choice prev)))