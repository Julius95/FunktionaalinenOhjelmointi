(ns test-lein.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!")
  ;T.1
  (println (+ 4 (* 2 5)))
  (println (+ 1 2 3 4 5))
  (println((fn [name] (str "Tervetuloa Tylypahkaan " name)) "Julius"))
  (def person {:name {:first "Urho" :middle "Kaleva" :last "Kekkonen"}})
  (println (get-in person[:name :middle]))
  )

(defn square[x] (* x x))

(defn karkausvuosi?[v] 
  (or
    (and 
         (= (rem v 4) 0) 
         (not= (rem v 100) 0)
    )
    (= (rem v 400) 0))
)