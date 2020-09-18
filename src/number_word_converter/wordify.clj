(ns number-word-converter.wordify
  (:require [number-word-converter.words :as words]))

(def keywordise (comp keyword str))

(defn- teen? [num]
  (and (> num 10) (< num 20)))

(defn word-seq [num]
  (let [hundred-value (int (/ num 100))
        rest (mod num 100)]
    (concat (if (pos-int? hundred-value) [((keywordise hundred-value) words/integers) "hundred"])
            (if (and (pos-int? hundred-value) (pos-int? rest)) ["and"])
            (if (teen? rest)
              [((keywordise (mod rest 10)) words/teens)]
              [((keywordise (int (/ rest 10))) words/tens)
               ((keywordise (mod rest 10)) words/integers)]))))

(defn stringify-word-seq [word-seq]
  (->> word-seq
       (remove nil?)
       (interpose " ")
       (apply str)))

(defn wordify [num]
  (if (zero? num)
    words/zero
    (-> num
        word-seq
        stringify-word-seq)))