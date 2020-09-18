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

(defn word-from-number [num]
  ((keyword (str num)) integers-as-words))
