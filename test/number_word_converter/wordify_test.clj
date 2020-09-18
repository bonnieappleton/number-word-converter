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
    (is (= (wordify 10) "ten")))
  (testing "should return twenty one when 21 provided"
    (is (= (wordify 21) "twenty one")))
  (testing "should return seventeen when 17 provided"
    (is (= (wordify 17) "seventeen"))))

(deftest wordify-triple-digits
  (testing "should return one hundred when 100 provided"
    (is (= (wordify 100) "one hundred"))))
