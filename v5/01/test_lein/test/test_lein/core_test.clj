(ns test-lein.core-test
    (:use test-lein.core)
    (:use  midje.sweet))

(defn square[x] (* x x))

(defn karkausvuosi?[v] 
  (or
    (and 
         (= (rem v 4) 0) 
         (not= (rem v 100) 0)
    )
    ;||
    (= (rem v 400) 0))
)
  
  
  (facts "square tehtävä 4"
  (square 2) => 4
  (square 7) => 49
  (square -3) => 9)

(tabular "karkausvuosi? tehtävä 5 "
  (fact
    (karkausvuosi? ?vuosi) => ?expected)
    ?vuosi   ?expected
    100     false
    200     false
    400     true
    800     true
    2000    true
    2200    false
    12      true
    20      true
    15      false
    1913    false)
