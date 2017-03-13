(ns re-frame-minimalistic-example.core
  (:require [reagent.core :as reagent]
            [re-frame.core :as re-frame]

            [re-frisk.core :refer [enable-re-frisk!]]

            [re-frame-minimalistic-example.events]
            [re-frame-minimalistic-example.subs]
            [re-frame-minimalistic-example.views :refer [app]]))

(defn startup []
  (enable-console-print!)
  (enable-re-frisk!)
  (re-frame/dispatch-sync [:initialize])
  (re-frame/clear-subscription-cache!)
  (->> (.getElementById js/document "app")
       (reagent/render [app])))
