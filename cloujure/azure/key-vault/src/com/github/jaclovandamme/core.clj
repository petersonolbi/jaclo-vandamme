(ns com.github.jaclovandamme.core
  (:require
    [com.github.jaclovandamme.adapters.keyvault.key-vault-config :as secret-config]
    [com.github.jaclovandamme.adapters.controller.key-vault-routes :as secret-routes]
    [io.pedestal.http :as http]))

(def vault-url
  "https://kv-jaclo.vault.azure.net")

(defn -main [& _]
  (let [secret-client (secret-config/create-secret-client vault-url)

        service
        {::http/routes (secret-routes/routes secret-client)
         ::http/type :jetty
         ::http/port 8080
         ::http/join? false}]

    (-> service
        http/create-server
        http/start)))