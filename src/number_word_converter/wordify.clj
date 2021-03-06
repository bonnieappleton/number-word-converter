(ns number-word-converter.wordify
  (:require [number-word-converter.words :as words]))

(def keywordise (comp keyword str))

(defn seq-from-number [num]
  (->> num
       str
       seq
       (map (comp read-string str))))

(defn three-digit-word-seq [[int-value ten-value hundred-value]]
  (let [hundreds-words (if (pos-int? hundred-value) [((keywordise hundred-value) words/integers) words/hundred])
        and (if (and (pos-int? hundred-value)
                     (or (pos-int? ten-value) (pos-int? int-value)))
              [words/and])
        tens-words (if (= ten-value 1)
                     [((keywordise int-value) words/teens)]
                     [((keywordise ten-value) words/tens)
                      ((keywordise int-value) words/integers)])]
    (remove nil? (concat hundreds-words and tens-words))))

(defn decorate-word-seqs [[hundred-seq thousand-seq million-seq]]
  (let [millions? (seq million-seq)
        thousands? (seq thousand-seq)
        and? (and (or thousands? millions?) (seq hundred-seq) (not-any? #{words/hundred} hundred-seq))]
    (->> [million-seq
          (if millions? words/million)
          thousand-seq
          (if thousands? words/thousand)
          (if and? words/and)
          hundred-seq]
         (remove nil?))))

(defn word-seq [number-seq]
  (->> number-seq
       reverse
       (partition-all 3)
       (map three-digit-word-seq)
       decorate-word-seqs
       flatten))

(defn stringify-word-seq [word-seq]
  (->> word-seq
       (interpose " ")
       (apply str)))

(defn wordify [num]
  (if (zero? num)
    words/zero
    (->> num
         seq-from-number
         word-seq
         stringify-word-seq)))