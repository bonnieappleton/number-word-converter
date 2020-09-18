(ns number-word-converter.core-test
  (:require [clojure.test :refer :all]
            [number-word-converter.core :refer :all]))

(deftest number-word-conversion
  (testing "should return zero when 0 provided"
    (is (=  (word-from-number 0) "zero")))
  (testing "should return one when 1 provided"
    (is (=  (word-from-number 1) "one")))
  (testing "should return nine when 9 provided"
    (is (=  (word-from-number 9) "nine"))))
