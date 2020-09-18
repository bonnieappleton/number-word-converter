(ns number-word-converter.wordify
  (:require [number-word-converter.words :as words]))

(def keywordise (comp keyword str))

(defn- teen? [num]
  (and (> num 10) (< num 20)))

(defn wordify [num]
  (if (zero? num)
    words/zero
    (clojure.string/trim
      (let [hundred-value (int (/ num 100))
            rest (mod num 100)]
        (str (if (pos-int? hundred-value) (str ((keywordise hundred-value) words/integers) " " "hundred"))
             (if (teen? num)
               ((keywordise (mod num 10)) words/teens)
               (str ((keywordise (int (/ num 10))) words/tens)
                    " "
                    ((keywordise (mod num 10)) words/integers))))))))