(ns number-word-converter.wordify
  (:require [number-word-converter.words :as words]))

(def keywordise (comp keyword str))

(defn- teen? [num]
  (and (> num 10) (< num 20)))

(defn wordify [num]
  (cond
    (zero? num) words/zero
    (teen? num) ((keywordise (mod num 10)) words/teens)
    :else (clojure.string/trim (str ((keywordise (int (/ num 10))) words/tens)
                                    " "
                                    ((keywordise (mod num 10)) words/integers)))))