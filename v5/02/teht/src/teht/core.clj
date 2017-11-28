(ns teht.core
  (:gen-class))
(require '[clojure.set :as set])

(defn teht1[]
  (println "Anna numero : ")
  (def numero (Integer. (read-line)))
  (println(if (>= 0 numero)
    "Virhe annettu luku ei ole nollaa suurempi!"
    (if (= (rem numero 2) 0)
      "Luku on jaollinen"
      "Luku ei ole jaollinen"
    )
  ))
)

(defn teht2[]
  (println "Anna numero : ")
  (def input (Integer. (read-line)))
  (if (>= 0 input)
    (do 
      (println "Virhe annettu luku ei ole nollaa suurempi!")
      (recur)
    )
    (println 
      (
        if(= (rem input 2) 0)
          "Luku on jaollinen"
          "Luku ei ole jaollinen"
      )   
    )
  )
)

(defn teht3[end]
  (loop [x 0]
    (when(<= x end)
      (println x)
      (recur (+ x 3))
    )
  )
)


(defn teht4[maara];(def arvotut #{})
  (def arvotut (set ()))
  (loop [x maara]
    (if(not= 0 x)
      (do
        (def arpa (+(rand-int 39) 1)) ;rand-int n-1
        (if (contains? arvotut arpa)
          (recur x)
          (do
            (def arvotut (conj arvotut arpa))
            (recur (- x 1))
          )
        )
      )
    )
  )
  arvotut
)

(defn teht5[p q]
  (if (= q 0)
    p
    (recur q (rem p q))
  )

)

(defn -main[& args]
  (println "Lottonumerot : " (teht4 7))
  (println "102 ja 68 GCD : "(teht5 102 68))
  (teht1)
  (teht2)
  (teht3 30)
)
