(ns re-frame-minimalistic-example.events
  (:require [re-frame.core :as re-frame]))

(re-frame/reg-event-db
 :initialize
 (fn [_]
   {:greeting "Hello world!"}))
