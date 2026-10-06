package org.example;

import org.example.ex1.AutenticacaoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AutenticacaoServiceTest {
    private AutenticacaoService autenticacaoService;

    @BeforeEach
    void setUp() {
        autenticacaoService = new AutenticacaoService();
    }

    @Test
    @DisplayName("AUT01 - Usuário válido + senha válida")
    void aut01() {
        assertTrue(autenticacaoService.autenticar("admin", "Java@12345"));
    }

    @Test
    @DisplayName("AUT02 - Usuário inexistente")
    void aut02() {
        assertFalse(autenticacaoService.autenticar("inexistente", "Java@12345"));
    }

    @Test
    @DisplayName("AUT03 - Senha inválida")
    void aut03() {
        assertFalse(autenticacaoService.autenticar("admin", "Errada123"));
    }

    @Test
    @DisplayName("AUT04 - Usuário nulo")
    void aut04() {
        assertFalse(autenticacaoService.autenticar(null, "Java@12345"));
    }

    @Test
    @DisplayName("AUT05 - Senha nula")
    void aut05() {
        assertFalse(autenticacaoService.autenticar("admin", null));
    }

    @Test
    @DisplayName("AUT06 - Usuário vazio")
    void aut06() {
        assertFalse(autenticacaoService.autenticar("", "Java@12345"));
    }

    @Test
    @DisplayName("AUT07 - Senha vazia")
    void aut07() {
        assertFalse(autenticacaoService.autenticar("admin", ""));
    }

    @Test
    @DisplayName("AUT08 - Usuário bloqueado")
    void aut08() {
        assertFalse(autenticacaoService.autenticar("bloqueado", "Java@12345"));
    }

    @Test
    @DisplayName("AUT09 - 1ª tentativa inválida")
    void aut09() {
        assertFalse(autenticacaoService.autenticar("admin", "Errada1"));
        assertFalse(autenticacaoService.isBloqueado());
    }

    @Test
    @DisplayName("AUT10 - 2ª tentativa inválida")
    void aut10() {
        autenticacaoService.autenticar("admin", "Errada1");
        assertFalse(autenticacaoService.autenticar("admin", "Errada2"));
        assertFalse(autenticacaoService.isBloqueado());
    }

    @Test
    @DisplayName("AUT11 - 3ª tentativa inválida")
    void aut11() {
        autenticacaoService.autenticar("admin", "Errada1");
        autenticacaoService.autenticar("admin", "Errada2");
        assertFalse(autenticacaoService.autenticar("admin", "Errada3"));
        assertTrue(autenticacaoService.isBloqueado());
    }

    @Test
    @DisplayName("AUT12 - Tentativa após bloqueio")
    void aut12() {
        autenticacaoService.autenticar("admin", "Errada1");
        autenticacaoService.autenticar("admin", "Errada2");
        autenticacaoService.autenticar("admin", "Errada3");
        assertFalse(autenticacaoService.autenticar("admin", "Java@12345"));
    }
}
