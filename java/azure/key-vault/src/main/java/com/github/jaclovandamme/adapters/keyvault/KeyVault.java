package com.github.jaclovandamme.adapters.keyvault;

import com.azure.security.keyvault.secrets.SecretClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static org.apache.commons.lang3.RandomStringUtils.secure;

@Slf4j
@RequiredArgsConstructor
@Component
public class KeyVault {
    private static final String KEY_NAME = "kv-jaclo-secretclient";

    @Value("${kv-jaclo-environment}") private String environmentKey;
    private final SecretClient secretClient;

    public void onAzure() {
        log.info("Loaded into the Spring Environment and injected via @Value: '{}'.", environmentKey);
        programmatically();
    }

    private void programmatically() {
        // Attempt secret recovery if recently soft-deleted.
        try { secretClient.beginRecoverDeletedSecret(KEY_NAME).waitForCompletion(); } catch(Exception e) { log.warn("Recovery deleted secret error: '{}'.", e.getMessage()); }

        log.info("Create secret '{}' via SecretClient: '{}'.", KEY_NAME, secretClient.setSecret(KEY_NAME, secure().next(10)));
        log.info("Loaded programmatically via SecretClient: KeyVaultSecret='{}'.", secretClient.getSecret(KEY_NAME).getValue());
        log.info("Delete secret '{}' via SecretClient: '{}'.", KEY_NAME, secretClient.beginDeleteSecret(KEY_NAME));
    }
}