(ns clojure-aug-2011.test.core
  (:use [clojure-aug-2011.core] :reload)
  (:use [clojure.test]))

(deftest test-which-player
  (is (= \x (which-player "0--------")))
  (is (= \0 (which-player "0-x------"))))
	
(deftest test-row-is-win
  (is (= nil (row-is-win [\- \- \- \- \- \- \- \- \-] [0 1 2])))
  (is (= 2 (row-is-win [\0 \0 \-
			\- \x \x
			\- \- \-] [0 1 2])))
  (is (= 6 (row-is-win [\x \0 \-
			\x \0 \0
			\- \- \-] [0 3 6])))
  )

(deftest test-insta-win
	(is (= 2 (instant-win "00-xx----"))))

(deftest test-choice
  (is (= 4 (choice "---------")))
  (is (= 2 (choice "----0----")))
  (is (= 6 (choice "--0-x---0")))
  (is (= 6 (choice "xx0-0----")))
  (is (= 5 (choice "xx000---x"))))
