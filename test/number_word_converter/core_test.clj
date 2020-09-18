(ns number-word-converter.core-test
  (:require [clojure.test :refer :all]
            [number-word-converter.core :refer :all]))

(deftest number-word-conversion
  (testing "should return zero when 0 provided"
    (is (=  (word-from-number 0) "zero"))))
