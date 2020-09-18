(ns number-word-converter.wordify
  (:require [number-word-converter.words :as words]))

(def keywordise (comp keyword str))

(defn wordify [num]
  (if (zero? num)
    words/zero
    (str ((keywordise (int (/ num 10))) words/tens)
         ((keywordise (mod num 10)) words/integers))))