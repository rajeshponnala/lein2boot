(defproject animals "1.0.0"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-3211"]
                 [org.clojure/core.async "0.1.346.0-17112a-alpha"]
                 [ring-server "0.4.0"]
                 [org.webjars/bootstrap "3.2.0"]
                 [cljs-http "0.1.30"]
                 [compojure "1.3.4"]
                 [liberator "0.13"]
                 [fogus/ring-edn "0.2.0"]
                 [clj-json "0.5.3"]
                 [reagent "0.5.0"]
                 [prismatic/schema "0.4.3"]]

  :resource-paths ["assets" "out"]

  :clean-targets ^{:protect false} [:target-path :compile-path "out"]

  :source-paths ["src"]

  :aliases {"build" ["do" "clean" ["cljsbuild" "once" "prod"] "uberjar"]}

  :profiles {:dev {:plugins [[lein-cljsbuild "1.0.5"]
                             [lein-figwheel "0.3.1"]]
                   :figwheel {:http-server-root "public"
                              :port 3449}}}

  :cljsbuild {:builds {:dev {:source-paths ["src-cljs" "src-cljs-dev"]
                             :figwheel {:on-jsload "animals.main/fig-reload"}
                             :compiler {:output-to "out/main.js"
                                        :output-dir "out"
                                        :optimizations :none
                                        :asset-path ""
                                        :main "animals.main"
                                        :source-map true}}
                       :prod {:source-paths ["src-cljs" "src-cljs-prod"]                              
                              :compiler {:output-to "out/main.js"                                         
                                         :optimizations :advanced}}}}

  :repl-options {:init-ns animals.server}

  :global-vars {*print-length* 20}

  :main animals.uberjar

  :aot [animals.uberjar])
