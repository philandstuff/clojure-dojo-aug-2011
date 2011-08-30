(ns clojure-aug-2011.test.core
  (:use [clojure-aug-2011.core] :reload)
  (:use [clojure.test]))

(deftest test-which-player
  (is (= \x (which-player "0--------")))
	(is (= \0 (which-player "0-x------"))))
	
(deftest test-insta-win
	(is (= 2 (instant-win "00-xx----"))))
