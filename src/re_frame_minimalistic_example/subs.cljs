(ns re-frame-minimalistic-example.subs
  (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub
 :todos
 (fn [db]
   db))

(re-frame/reg-sub
 :completed-count
 (fn [db]
   (count (filter :checked (vals db)))))

(re-frame/reg-sub
 :uncompleted-count
 (fn [db]
   (count (filter (complement :checked) (vals db)))))
