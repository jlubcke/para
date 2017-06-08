(ns para.events
    (:require [re-frame.core :as re-frame]
              [para.db :as db]))

(re-frame/reg-event-db
 :initialize-db
 (fn  [_ _]
   db/default-db))

(re-frame/reg-event-db
  :name
  (fn [db [_ name]]
    (assoc db :name name)))


(re-frame/reg-event-db
  :amount
  (fn [db [_ amount]]
    (assoc db :amount amount)))


(re-frame/reg-event-db
  :new-spending
  (fn [db [_ spender amount]]
    (println (str spender))
    (println (str db))
    (let [
      db (assoc db :name nil)
      db (assoc db :amount nil)
      db (assoc-in db [:spendings spender] amount)
    ] db)))