(ns number-word-converter.wordify-test
  (:require [clojure.test :refer :all]
            [number-word-converter.wordify :refer [wordify]]))

(deftest wordify-single-digits
  (testing "should return zero when 0 provided"
    (is (= (wordify 0) "zero")))
  (testing "should return one when 1 provided"
    (is (= (wordify 1) "one")))
  (testing "should return nine when 9 provided"
    (is (= (wordify 9) "nine"))))

(deftest wordify-double-digits
  (testing "should return ten when 10 provided"
    (is (= (wordify 10) "ten"))))
