(ns re-frame-minimalistic-example.events
  (:require [re-frame.core :as re-frame]))

(re-frame/reg-event-db
 :initialize
 (fn [_]
   {(random-uuid)
    {:description "what do you have todo?"
     :checked false}}))

(re-frame/reg-event-db
 :add-todo
 (fn [db [event]]
   (let [id
         (random-uuid)

         todo
         {:description "what do you have todo?"
          :checked false}]

     (assoc db id todo))))

(re-frame/reg-event-db
 :remove-todo
 (fn [db [event todo-id]]
   (dissoc db todo-id)))

(re-frame/reg-event-db
 :edit-todo
 (fn [db [event todo-id todo-description]]
   (assoc-in db [todo-id :description] todo-description)))

(re-frame/reg-event-db
 :toggle-todo-done
 (fn [db [event todo-id]]
   (update-in db [todo-id :checked] not)))
