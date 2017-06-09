(ns para.views
    (:require
       [re-frame.core :as re-frame]))

(defn spending-form []
  [:div
     [:h2 "Name"]
     [:input {
        :value @(re-frame/subscribe [:name])
        :on-change #(re-frame/dispatch [:name (-> % .-target .-value)])
     }]
     [:h2 "Spending"]
     [:input {
        :value @(re-frame/subscribe [:amount])
        :on-change #(re-frame/dispatch [:amount (-> % .-target .-value)])
     }]
     [:submit {
       :type "button"
       :on-click #(re-frame/dispatch [:new-spending @(re-frame/subscribe [:name]) @(re-frame/subscribe [:amount])])
      } "Add"]
  ])

(defn main-panel []
  (let [spendings @(re-frame/subscribe [:spendings])]
   [:div
     [:div "Hello there from " @(re-frame/subscribe [:name])]
     [:table 
       (map 
         (fn [[k v]]
           ^{:key k} [:tr 
             [:td k]
             [:td v] 
             [:td [:a {:on-click #(re-frame/dispatch [:edit k])}"Edit"]]
             [:td [:a {:on-click #(re-frame/dispatch [:delete k])}"Delete"]]
           ])
         spendings
       )]
     (spending-form)
   ]
 )
)
