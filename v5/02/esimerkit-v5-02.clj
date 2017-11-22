;; if examples
;-----
(if true
  "By Zeus's hammer!"
  "By Aquaman's trident!")
; => "By Zeus's hammer!"
;-----
(if false
  "By Zeus's hammer!"
  "By Aquaman's trident!")
; => "By Aquaman's trident!"

;-----
(if false
  "By Odin's Elbow!")
; => nil
;-----
(if true
  (do (println "Success!")
      "By Zeus's hammer!")
  (do (println "Failure!")
      "By Aquaman's trident!"))
; => Success!
; => "By Zeus's hammer!"

;-----
;; More boolean operators
(when true
  (println "Success!")
  "abra cadabra")
; => Success!
; => "abra cadabra"

;-----
(nil? 1)
; => false
;-----
(nil? nil)
; => true
;-----
(if "bears eat beets"
  "bears beets Battlestar Galactica")
; => "bears beets Battlestar Galactica"
;-----
(if nil
  "This won't be the result because nil is falsey"
  "nil is falsey")
; => "nil is falsey"
;-----
(= 1 1)
; => true
;-----
(= nil nil)
; => true
;-----
(= 1 2)
; => false
;-----
(or false nil :large_I_mean_venti :why_cant_I_just_say_large)
; => :large_I_mean_venti
;-----
(or (= 0 1) (= "yes" "no"))
; => false
;-----
(or nil)
; => nil
;-----
(and :free_wifi :hot_coffee)
; => :hot_coffee
;-----
(and :feelin_super_cool nil false)
; => nil
;-----
;; Special forms
(if boolean-form
  then-form
  optional-else-form)

;-----
(if good-mood
  (tweet walking-on-sunshine-lyrics)
  (tweet mopey-country-song-lyrics))

;-----
;; Defining your own function
(defn too-enthusiastic
  "Return a cheer that might be a bit too enthusiastic"
  [name]
  (str "OH. MY. GOD! " name " YOU ARE MOST DEFINITELY LIKE THE BEST "
       "MAN SLASH WOMAN EVER I LOVE YOU AND WE SHOULD RUN AWAY SOMEWHERE"))

(too-enthusiastic "Zelda")
; => "OH. MY. GOD! Zelda YOU ARE MOST DEFINITELY LIKE THE BEST MAN SLASH WOMAN EVER I LOVE YOU AND WE SHOULD RUN AWAY SOMEWHERE"
;-----
(defn number-comment
  [x]
  (if (> x 6)
    "Oh my gosh! What a big number!"
    "That number's OK, I guess"))

(number-comment 5)
; => "That number's OK, I guess"

(number-comment 7)
; => "Oh my gosh! What a big number!"
;-----
;; Loop
(loop [iteration 0]
  (println (str "Iteration " iteration))
  (if (> iteration 3)
    (println "Goodbye!")
    (recur (inc iteration))))
; => Iteration 0
; => Iteration 1
; => Iteration 2
; => Iteration 3
; => Iteration 4
; => Goodbye!

;-----
(defn recursive-printer
  ([]
   (recursive-printer 0))
  ([iteration]
   (println iteration)
   (if (> iteration 3)
     (println "Goodbye!")
     (recursive-printer (inc iteration)))))
(recursive-printer)
; => Iteration 0
; => Iteration 1
; => Iteration 2
; => Iteration 3
; => Iteration 4
; => Goodbye!

;-----
(defn example
 [value]
 (condp = value
 1 "one"
 2 "two"
 3 "three"
 (str "unexpected value, " value)))
(example 2) 
; => "two"
(example 9) 
; => "unexpected value, 9"
 
;-----
 (doseq [a [1 2]
         b [3 4]]
         (println a b))
; => 1 3
; => 1 4
; => 2 3
; => 2 4
; => nil

;-----
;; Regular expressions
#"regular-expression"

(re-find #"^left-" "left-eye")
; => "left-"

(re-find #"^left-" "cleft-chin")
; => nil

(re-find #"^left-" "wongleblart")
; => nil
