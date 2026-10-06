package org.example;

import org.example.ex1.ValidarSenha;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidacaoSenhaService {
    private ValidarSenha service =
            new ValidarSenha();

    @org.junit.jupiter.api.Test
    public void deveAceitarSenhaValida() {
        String senha = "Java@12345";
        boolean resultado =
                service.validarSenha(senha);
        assertTrue(resultado);
    }
}
