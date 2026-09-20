<img align="right" width="20%" src="Jean-Cloud Vandamme.jpg">

# jaclo-vandamme
Integrating Java and Clojure with AWS and Azure services.

[![Eclipse IDE](https://img.shields.io/badge/Eclipse%20IDE-blue?logo=eclipseide)](https://eclipseide.org)
[![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ%20IDEA-blue?logo=intellijidea)](https://www.jetbrains.com/idea)

## ⚡️Run the project

<details open><summary><b>Build and run with <a href="https://en.wikipedia.org/wiki/Java_(programming_language)">Java</a></b>:<br><br></summary>

1. **Install [JDK 25](https://www.oracle.com/java/technologies/downloads)**.  
   _To validate the installation, open the command line and type: `java --version`._

</details>

<details open><summary><b>Build and run with <a href="https://en.wikipedia.org/wiki/Java_(programming_language)">Azure</a>:</b><br><br></summary>

1. **Install Azure CLI on Windows** by openning PowerShell and typing `winget install -e --id Microsoft.AzureCLI`.  
   _To validate the installation typing `az -v`._
2. **Log in Azure** by typing `az login` in PowerShell.  
   _To validate the installation typing `az account show`._

<details open><summary><b><a href="https://en.wikipedia.org/wiki/Java_(programming_language)">Key Vault</a></b>:<br><br></summary>

1. **Create Key Vault** by openning PowerShell and typing `az keyvault create --name "kv-jaclo" --resource-group jaclo-vandamme --location 'eastus' --retention-days 7`.
2. `az role assignment create --assignee-object-id "dfb6cb0d-d31e-44a4-bc98-37fb7a2155f8" --assignee-principal-type User --role "Key Vault Secrets Officer" --scope  "/subscriptions/a7014c2b-6fd8-4978-be84-1099962dfe6f/resourceGroups/jaclo-vandamme/providers/Microsoft.KeyVault/vaults/kv-jaclo"`
3. `az role assignment create --assignee-object-id "dfb6cb0d-d31e-44a4-bc98-37fb7a2155f8" --assignee-principal-type User --role "Key Vault Administrator" --scope "/subscriptions/a7014c2b-6fd8-4978-be84-1099962dfe6f/resourceGroups/jaclo-vandamme/providers/Microsoft.KeyVault/vaults/kv-jaclo"`
4. **Create Secret** by openning PowerShell and typing ``.

```bash
KeyVault : Loaded into the Spring Environment and injected via @Value: 'jje'.
KeyVault : Create secret 'key-jaclo-secretclient' via SecretClient: 'com.azure.security.keyvault.secrets.models.KeyVaultSecret@56'.
KeyVault : Loaded programmatically via SecretClient: KeyVaultSecret='𣰜𦵚⾌ᗙ𩬻𘣙'.
KeyVault : Delete secret 'key-jaclo-secretclient' via SecretClient: 'com.azure.core.util.polling.SimpleSyncPoller@d310f70'.
```

</details>

http://localhost:8080/swagger-ui/index.html

</details>