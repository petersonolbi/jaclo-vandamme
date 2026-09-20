<img align="right" width="50%" src="Jean-Cloud Vandamme.jpg">

# jaclo-vandamme
Integrating Java and Clojure with AWS and Azure services.

[![Eclipse IDE](https://img.shields.io/badge/Eclipse%20IDE-blue?logo=eclipseide)](https://eclipseide.org)
[![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ%20IDEA-blue?logo=intellijidea)](https://www.jetbrains.com/idea)
[![Swagger](https://img.shields.io/badge/Swagger-blue?logo=swagger)](https://swagger.io)

## ⚡️Run the project

<details open><summary><b>Build and run with <a href="https://en.wikipedia.org/wiki/Java_(programming_language)">Java</b>:<br><br>

1. **Install [JDK 25](https://www.oracle.com/java/technologies/downloads)**.  
   _To validate the installation, open the command line and typing: `java --version`._

</details>

<details open><summary><b>Build and run with <a href="https://en.wikipedia.org/wiki/Java_(programming_language)">Azure:</b><br><br>

1. Install Azure CLI on Windows by opening PowerShell and typing `winget install -e --id Microsoft.AzureCLI`.  
   _To verify the installation, run `az -v`._
2. Log in to Azure by typing `az login` in PowerShell.  
   _To verify the installation, run `az account show`._

<details open><summary><b><a href="https://en.wikipedia.org/wiki/Java_(programming_language)">Key Vault</a></b>:<br><br></summary>

**In PowerShell**:

1. Create Key Vault: `az keyvault create --name "kv-jaclo" --resource-group jaclo-vandamme --location 'eastus' --retention-days 7`.
2. Assign Key Vault permissions: `az role assignment create --assignee-object-id "<logged-in>" --assignee-principal-type User --role "Key Vault Administrator" --scope "/subscriptions/<subscription-id>/resourceGroups/jaclo-vandamme/providers/Microsoft.KeyVault/vaults/kv-jaclo"`
3. Create Secret: `az keyvault secret set -vault-name "kv-jaclo" --name "kv-jaclo-environment" -- value "JaClo-Vandamme"`.
4. When you access `http://localhost:8080/swagger-ui/index.html` and execute the "Key Vault" service, you should see the following logs:

```bash
KeyVault : Loaded into the Spring Environment and injected via @Value: 'jje'.
KeyVault : Create secret 'key-jaclo-secretclient' via SecretClient: 'com.azure.security.keyvault.secrets.models.KeyVaultSecret@56'.
KeyVault : Loaded programmatically via SecretClient: KeyVaultSecret='𣰜𦵚⾌ᗙ𩬻𘣙'.
KeyVault : Delete secret 'key-jaclo-secretclient' via SecretClient: 'com.azure.core.util.polling.SimpleSyncPoller@d310f70'.
```

</details>

</details>