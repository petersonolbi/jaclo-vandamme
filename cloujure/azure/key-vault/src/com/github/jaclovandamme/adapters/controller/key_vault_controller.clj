(ns com.github.jaclovandamme.adapters.controller.key-vault-controller
  (:require
    [com.github.jaclovandamme.adapters.keyvault.key-vault :as secret]))

(defn create-secret [secret-client]
  (fn [request]
    (let [{:keys [secret-name secret-value]} (:json-params request)
          secret-name (secret/create-secret secret-client secret-name secret-value)]
      {:status 201 :body (.getName secret-name)})))

(defn delete-secret [secret-client]
  (fn [request]
    (let [secret-name (get-in request [:path-params :secret-name])]
      (secret/delete-secret secret-client secret-name)
      {:status 200})))

(defn get-secret [secret-client]
  (fn [request]
    (let [secret-name (get-in request [:path-params :secret-name])]
      {:status 200 :body (secret/get-secret secret-client secret-name)})))