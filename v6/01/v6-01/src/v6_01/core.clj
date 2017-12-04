(ns v6-01.core
  (:gen-class))

(def food-journal
  [{:kk 3 :paiva 1 :neste 5.3 :vesi 2.0}
   {:kk 3 :paiva 2 :neste 5.1 :vesi 3.0}
   {:kk 3 :paiva 13 :neste 4.9 :vesi 2.0}
   {:kk 4 :paiva 5 :neste 5.0 :vesi 2.0}
   {:kk 4 :paiva 10 :neste 4.2 :vesi 2.5}
   {:kk 4 :paiva 15 :neste 4.0 :vesi 2.8}
   {:kk 4 :paiva 29 :neste 3.7 :vesi 2.0}
   {:kk 4 :paiva 30 :neste 3.7 :vesi 1.0}])


(def lamp2015 [-5 -6 -1 2 8 14 18 16 13 7 2 -3])
(def lamp2016 [-4 -5 -3 1 9 15 19 17 12 8 2 -3])

;Makroja
(def summa #(reduce + %))
(def keskiarvo #(/ (summa %) (count %) ) ) ;parametrina taulukko
(def laske #(reduce + (:neste %)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println
    (keskiarvo
      (filter #(> %1 0)
        (map #(/ (+ %1 %2) 2)  lamp2015 lamp2016)
      )
    )
  ) ;10.1875
  
  (println
      (reduce + (map #(- (:neste %)  (:vesi %)) (filter #(= (:kk %) 4) food-journal)));filter #(= (:kk %) 4 (reduce + (:neste %)
  )

  (println
    (map 
     (fn [x] 
       (merge-with + 
           (select-keys x [:kk :paiva])
           {:muuneste (format "%.2f" (- (:neste x) (:vesi x))) } 
       )
     ) 
     (filter #(= (:kk %) 4) food-journal)
    )
  )
)
;(filter #(= (:kk %) 4) food-journal)