package com.github.jaclovandamme.adapters.controller;

import com.github.jaclovandamme.adapters.keyvault.KeyVault;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class KeyVaultController {
    public final KeyVault keyVault;

    @GetMapping("key-vault")
    public void keyVault() {
        keyVault.onAzure();
    }
}