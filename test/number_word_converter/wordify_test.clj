(ns number-word-converter.wordify-test
  (:require [clojure.test :refer :all]
            [number-word-converter.wordify :refer :all]))

(deftest word-seq-test
  (testing "should produce sequence of words for number"
    (is (= (word-seq 521) '("five" "hundred" "and" "twenty" "one")))))

(deftest stringify-word-seq-test
  (testing "should turn a word seq into a string without nils"
    (is (= (stringify-word-seq '("this" "is" nil "a" "string")) "this is a string"))))

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
    (is (= (wordify 100) "one hundred")))
  (testing "should return one hundred and twenty one when 101 provided"
    (is (= (wordify 101) "one hundred and one")))
  (testing "should return nine hundred and nineteen when 919 provided"
    (is (= (wordify 919) "nine hundred and nineteen"))))
