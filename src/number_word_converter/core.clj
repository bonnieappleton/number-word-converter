(ns number-word-converter.core
  (:gen-class))

(def integers-as-words
  {:1 "one"
   :2 "two"
   :3 "three"
   :4 "four"
   :5 "five"
   :6 "six"
   :7 "seven"
   :8 "eight"
   :9 "nine"})

(def tens-as-words
  {:1 "ten"
   :2 "twenty"
   :3 "thirty"
   :4 "forty"
   :5 "fifty"
   :6 "sixty"
   :7 "seventy"
   :8 "eighty"
   :9 "ninety"})

(def zero "zero")

(defn- is-valid [input]
  (and (int? input)
       (not (neg-int? input))
       (<= input 999999999)))

(def keywordise (comp keyword str))

(defn word-from-number [num]
  (if (is-valid num)
    (if (zero? num)
      zero
      (str ((keywordise (int (/ num 10))) tens-as-words)
           ((keywordise (mod num 10)) integers-as-words)))
    (throw (Exception. "Input must be an integer in the range 0 to 999,999,999 inclusive"))))
