(ns para.views
    (:require [re-frame.core :as re-frame]))

(defn main-panel []
  (let [spendings @(re-frame/subscribe [:spendings])]
   [:div
     [:div "Hello there from " @(re-frame/subscribe [:name])]
     (println spendings)

     [:ul 
       (map 
         (fn [[k v]]
           ^{:key k} [:li k "--" v])
         spendings
       )]
     [:input ]
   ]
 )
)
