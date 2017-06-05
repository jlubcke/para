(ns para.events
    (:require [re-frame.core :as re-frame]
              [para.db :as db]))

(re-frame/reg-event-db
 :initialize-db
 (fn  [_ _]
   db/default-db))

(re-frame/reg-event-db
 :new-spending
 (fn [db [_ [spender amount]]]
   (println (str spender))
      (println (str db))
   (assoc-in db [:spendings spender] amount)))