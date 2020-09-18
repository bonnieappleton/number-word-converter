(ns number-word-converter.core
  (:require [number-word-converter.wordify :as w]))

(defn- is-valid [input]
  (and (int? input)
       (not (neg-int? input))
       (<= input 999999999)))

(defn word-from-number [num]
  (if (is-valid num)
    (w/wordify num)
    (throw (Exception. "Input must be an integer in the range 0 to 999,999,999 inclusive"))))
