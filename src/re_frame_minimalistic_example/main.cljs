(ns re-frame-minimalistic-example.main
  (:require [re-frame-minimalistic-example.core :refer [startup]]))

(defn ^:export init []
  (startup))
