package org.example;


import org.example.ex1.ValidarSenha;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidadorSenhaTest {
    private final ValidarSenha validador = new ValidarSenha();

    @Test
    @DisplayName("CT01 - Senha válida")
    void ct01_senhaValida() {
        assertTrue(validador.validarSenha("Java@12345"));
    }

    @Test
    @DisplayName("CT02 - Menor que 10 caracteres")
    void ct02_menorQue10Caracteres() {
        assertFalse(validador.validarSenha("Java@123"));
    }

    @Test
    @DisplayName("CT03 - Maior que 12 caracteres")
    void ct03_maiorQue12Caracteres() {
        assertFalse(validador.validarSenha("Java@12345678"));
    }

    @Test
    @DisplayName("CT04 - Sem número")
    void ct04_semNumero() {
        assertFalse(validador.validarSenha("Java@Testes"));
    }

    @Test
    @DisplayName("CT05 - Sem letra")
    void ct05_semLetra() {
        assertFalse(validador.validarSenha("123456@7890"));
    }

    @Test
    @DisplayName("CT06 - Sem caractere especial")
    void ct06_semEspecial() {
        assertFalse(validador.validarSenha("Java1234567"));
    }

    @Test
    @DisplayName("CT07 - Senha nula")
    void ct07_senhaNula() {
        assertFalse(validador.validarSenha(null));
    }

    @Test
    @DisplayName("CT08 - Senha vazia")
    void ct08_senhaVazia() {
        assertFalse(validador.validarSenha(""));
    }

    @Test
    @DisplayName("CT09 - Exatamente 10 caracteres")
    void ct09_exatamente10Caracteres() {
        assertTrue(validador.validarSenha("Java@12345"));
    }

    @Test
    @DisplayName("CT10 - Exatamente 12 caracteres")
    void ct10_exatamente12Caracteres() {
        assertTrue(validador.validarSenha("Java@1234567"));
    }

    @Test
    @DisplayName("CT11 - Senha só com espaços")
    void ct11_senhaSoComEspacos() {
        assertFalse(validador.validarSenha("          "));
    }


}
