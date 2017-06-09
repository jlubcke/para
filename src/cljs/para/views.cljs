(ns para.views
    (:require
       [re-frame.core :as re-frame]))

(defn spending-form []
  (let [name @(re-frame/subscribe [:name])
        amount @(re-frame/subscribe [:amount])]
    [:h2 "Spendings"]
    [:table
      [:tr
       [:th "Name"]
       [:th "Spending"]
      ]
      [:tr
        [:td
          [:input {
            :value amount
            :on-change #(re-frame/dispatch [:name (-> % .-target .-value)])
          }]
        ]
        [:td
          [:input {
            :value amount
            :on-change #(re-frame/dispatch [:amount (-> % .-target .-value)])
          }]
        ]
      ]
      [:tr
        [:td
          [:submit {
            :type "button"
            :on-click #(re-frame/dispatch [:new-spending name amount])
          } "Add"]
        ]
      ]
    ]
  )
)

(defn row [[k v]]
  ^{:key k}
  [:tr 
    [:td k]
    [:td v] 
    [:td [:a {:on-click #(re-frame/dispatch [:edit k])}"Edit"]]
    [:td [:a {:on-click #(re-frame/dispatch [:delete k])}"Delete"]]
  ]
)

(defn main-panel []
  (let [spendings @(re-frame/subscribe [:spendings])]
   [:div
     [:table (map row spendings)]
     [:div "Modifying" @(re-frame/subscribe [:name])]
     (spending-form)
   ]
 )
)
