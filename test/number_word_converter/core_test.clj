(ns number-word-converter.core-test
  (:require [clojure.test :refer :all]
            [number-word-converter.core :refer :all]))

(deftest number-word-conversion
  (testing "should return one when 1 provided"
    (is (= (word-from-number 1) "one"))))

(deftest non-integer-inputs
  (testing "should throw an exception when a string is provided"
    (is (thrown-with-msg? Exception
                          #"Input must be an integer in the range 0 to 999,999,999 inclusive"
                          (word-from-number "not an int"))))
  (testing "should throw an exception when a negative integer is provided"
    (is (thrown-with-msg? Exception
                          #"Input must be an integer in the range 0 to 999,999,999 inclusive"
                          (word-from-number -2))))
  (testing "should throw an exception when an integer greater than 999,999,999 is provided"
    (is (thrown-with-msg? Exception
                          #"Input must be an integer in the range 0 to 999,999,999 inclusive"
                          (word-from-number 1000000000)))))
