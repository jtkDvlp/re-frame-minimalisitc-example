(ns re-frame-minimalistic-example.views
  (:require [re-frame.core :as re-frame]))

(defn todo-item
  [id {:keys [description checked] :as todo}]
  (.debug js/console "todo-item rendered")
  [:li
   [:input
    {:type "checkbox"
     :checked checked
     :on-change #(re-frame/dispatch [:toggle-todo-done id])}]
   [:input
    {:type "text"
     :value description
     :on-change #(re-frame/dispatch [:edit-todo id (-> % .-target .-value)])}]
   [:button
    {:on-click #(re-frame/dispatch [:remove-todo id])}
    "delete"]])

(defn todo-list
  []
  (let [todos
        @(re-frame/subscribe [:todos])

        completed-count
        @(re-frame/subscribe [:completed-count])

        uncompleted-count
        @(re-frame/subscribe [:uncompleted-count])]

    [:div
     [:h1 "Your todos"]

     [:div
      [:div completed-count " todos done / " uncompleted-count " todos open"
       (.debug js/console "count rendered")]
      [:button
       {:on-click #(re-frame/dispatch [:add-todo])}
       "add new todo"
       (.debug js/console "add-button rendered")]]

     [:div
      (if (seq todos)
        [:ul
         (.debug js/console "list rendered")
         (for [[id todo] todos]
           (do (.debug js/console "loop todo-item")
               ^{:key id} [todo-item id todo]))]
        [:i "you have nothing todo!"])]]))

(defn app
  []
  [todo-list])
