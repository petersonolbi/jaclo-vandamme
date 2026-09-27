(ns com.github.jaclovandamme.adapters.keyvault.key-vault-config
  (:import
    [com.azure.identity DefaultAzureCredentialBuilder]
    [com.azure.security.keyvault.secrets SecretClientBuilder]))

(defn create-secret-client [vault-url]
  (let [credential (-> (DefaultAzureCredentialBuilder.)
                       (.build))]
    (-> (SecretClientBuilder.)
        (.vaultUrl vault-url)
        (.credential credential)
        (.buildClient))))