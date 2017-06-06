(ns para.views
    (:require
       [reagent.core :as reagent]
       [re-frame.core :as re-frame]))

(defonce spender (reagent/atom "Foo"))
(defonce amount (reagent/atom 17))

(defn spending-form []
  [:form
     [:h2 "Name"]
     [:input {
       :value @spender
       :on-change #(reset! spender (-> % .-target .-value))
     }
     ]
     [:h2 "Spending"]
     [:input {
        :value @amount
       :on-change #(reset! amount (-> % .-target .-value))

     }]
     [:submit {
       :type "button"
       :on-click #(re-frame/dispatch [:new-spending [@spender @amount]])
      } "Add"]
     
  ])

(defn main-panel []
  (let [spendings @(re-frame/subscribe [:spendings])]
   [:div
     [:div "Hello there from " @(re-frame/subscribe [:name])]
     [:table 
       (map 
         (fn [[k v]]
           ^{:key k} [:tr [:td k] [:td v]])
         spendings
       )]
     (spending-form)
   ]
 )
)
