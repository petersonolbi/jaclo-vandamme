(ns com.github.jaclovandamme.adapters.keyvault.key-vault
  (:import
    [com.azure.security.keyvault.secrets SecretClient]))

(defn create-secret [^SecretClient client secret-name secret-value]
  (.setSecret client secret-name secret-value))

(defn delete-secret [^SecretClient client secret-name]
  (.beginDeleteSecret client secret-name))

(defn get-secret [^SecretClient client secret-name]
  (-> client
      (.getSecret secret-name)
      (.getValue)))