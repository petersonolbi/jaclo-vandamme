(ns com.github.jaclovandamme.adapters.controller.key-vault-routes
  (:require
    [com.github.jaclovandamme.adapters.controller.key-vault-controller :as controller]
    [io.pedestal.http.body-params :as body-params]
    [io.pedestal.http.route :as route]))

(defn routes [secret-client]
  (route/expand-routes
    #{["/create-secret" :post [(body-params/body-params) (controller/create-secret secret-client)] :route-name :create-secret]
      ["/delete-secret/:secret-name" :delete (controller/delete-secret secret-client) :route-name :delete-secret]
      ["/get-secret/:secret-name" :get (controller/get-secret secret-client) :route-name :get-secret]}))