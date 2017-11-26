(defproject test_lein "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot test-lein.core
  :target-path "target/%s"
  :profiles {
    	:dev {
  	    :dependencies [[midje "1.7.0"]]
  	    :plugins [[lein-midje "2.0.0-SNAPSHOT"]]}
      :uberjar {
              :aot :all}})
