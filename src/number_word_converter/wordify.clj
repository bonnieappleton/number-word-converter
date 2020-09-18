(ns number-word-converter.wordify
  (:require [number-word-converter.words :as words]))

(def keywordise (comp keyword str))

(defn reverse-seq-from-number [num]
  (->> num
       str
       seq
       reverse
       (map (comp read-string str))))

(defn word-seq [[int-value ten-value hundred-value]]
  (let [hundreds-words (if (pos-int? hundred-value) [((keywordise hundred-value) words/integers) "hundred"])
        and (if (and (pos-int? hundred-value) (or (pos-int? ten-value) (pos-int? int-value))) ["and"])
        tens-words (if (= ten-value 1)
                     [((keywordise int-value) words/teens)]
                     [((keywordise ten-value) words/tens)
                      ((keywordise int-value) words/integers)])]
    (concat hundreds-words and tens-words)))

(defn stringify-word-seq [word-seq]
  (->> word-seq
       (remove nil?)
       (interpose " ")
       (apply str)))

(defn wordify [num]
  (if (zero? num)
    words/zero
    (-> num
        reverse-seq-from-number
        word-seq
        stringify-word-seq)))