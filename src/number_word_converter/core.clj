(ns number-word-converter.core
  (:gen-class))

(def integers-as-words
  {:0 "zero"
   :1 "one"
   :2 "two"
   :3 "three"
   :4 "four"
   :5 "five"
   :6 "six"
   :7 "seven"
   :8 "eight"
   :9 "nine"})

(defn- is-valid [input]
  (and (int? input)
       (not (neg-int? input))
       (<= input 999999999)))

(defn word-from-number [num]
  (if (is-valid num)
    ((keyword (str num)) integers-as-words)
    (throw (Exception. "Input must be an integer in the range 0 to 999,999,999 inclusive"))))
