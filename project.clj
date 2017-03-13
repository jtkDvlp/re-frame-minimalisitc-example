(defproject re-frame-minimalistic-example "1.0.0"
  :description "A minimalistic todo list with re-frame"
  :url "https://github.com/jtkDvlp/re-frame-minimalistic-example"
  :license {:name "MIT"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.229"]

                 [re-frame "0.9.1"]]

  :min-lein-version "2.5.3"

  :source-paths ["src"]

  :clean-targets ^{:protect false} ["resources/public/js" "target"]

  :plugins [[lein-cljsbuild "1.1.4" :exclusions [[org.clojure/clojure]]]]

  :profiles
  {:dev
   {:dependencies [[figwheel-sidecar "0.5.8"]
                   [com.cemerick/piggieback "0.2.1"]
                   [re-frisk "0.3.2"]]

    :plugins [[lein-figwheel "0.5.0-1"]]}}

  :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}

  :cljsbuild
  {:builds
   [{:id "dev"
     :source-paths ["src"]
     :figwheel {:on-jsload "re-frame-minimalistic-example.core/startup"}
     :compiler {:source-map-timestamp true
                :main re-frame-minimalistic-example.main
                :asset-path "js/out"
                :output-to "resources/public/js/main.js"
                :output-dir "resources/public/js/out"}}]})
