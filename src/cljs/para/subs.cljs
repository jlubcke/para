(ns para.subs
    (:require-macros [reagent.ratom :refer [reaction]])
    (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub
 :name
 (fn [db]
   (:name db)))

(re-frame/reg-sub
 :amount
 (fn [db]
   (:amount db)))

(re-frame/reg-sub
 :spendings
 (fn [db]
   (:spendings db)))
