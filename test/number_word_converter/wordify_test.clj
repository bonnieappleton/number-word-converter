(ns number-word-converter.wordify-test
  (:require [clojure.test :refer :all]
            [number-word-converter.wordify :refer :all]))

(deftest number-to-seq-test
  (testing "should turn number into a seq of the digits"
    (is (= (seq-from-number 1234) '(1 2 3 4)))))

(deftest three-digit-word-seq-test
  (testing "should produce sequence of words for sequence of ints in reverse"
    (is (= (three-digit-word-seq '(1 2 5)) '("five" "hundred" "and" "twenty" "one"))))
  (testing "should remove null values from seq"
    (is (= (three-digit-word-seq '(0 0 1)) '("one" "hundred")))))

(deftest decorate-word-seqs-test
  (testing "should add thousand and million decoration if there are numbers in those seqs"
    (is (= (decorate-word-seqs '(() ("not empty") ("another seq"))) '(["another seq"] "million" ["not empty"] "thousand" []))))
  (testing "should not add thousand decoration if thousand seq is empty"
    (is (= (decorate-word-seqs '(() () ())) '([] [] [])))))

(deftest word-seq-test
  (testing "should turn a sequence of numbers into a word sequence"
    (is (= (word-seq '(5 2 1)) '("five" "hundred" "and" "twenty" "one")))))

(deftest stringify-word-seq-test
  (testing "should turn a word seq into a string without nils"
    (is (= (stringify-word-seq '("this" "is" "a" "string")) "this is a string"))))

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

(deftest wordify-thousands
  (testing "should return one thousand when 1000 provided"
    (is (= (wordify 1000) "one thousand")))
  (testing "should return nine thousand nine hundred and ninety nine when 9999 provided"
    (is (= (wordify 9999) "nine thousand nine hundred and ninety nine")))
  (testing "should return one thousand and one when 1001 provided"
    (is (= (wordify 1001) "one thousand and one"))))

(deftest wordify-millions
  (testing "should return fifty six million nine hundred and forty five thousand seven hundred and eighty one"
    (is (= (wordify 56945781) "fifty six million nine hundred and forty five thousand seven hundred and eighty one")))
  (testing "should return one million and one when 1000001 provided"
    (is (= (wordify 1000001) "one million and one"))))
