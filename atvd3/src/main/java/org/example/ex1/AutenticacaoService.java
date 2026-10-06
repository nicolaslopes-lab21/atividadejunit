package org.example.ex1;

public class AutenticacaoService {

    private int tentativasInvalidas = 0;
    private boolean usuarioBloqueado = false;

    public boolean autenticar(String login, String senha) {
        if (login == null || login.isBlank() || senha == null || senha.isBlank()) {
            return false;
        }

        if ("bloqueado".equals(login) || usuarioBloqueado) {
            return false;
        }

        if (!"admin".equals(login)) {
            return false;
        }

        if ("Java@12345".equals(senha)) {
            tentativasInvalidas = 0;
            return true;
        }

        tentativasInvalidas++;
        if (tentativasInvalidas >= 3) {
            usuarioBloqueado = true;
        }

        return false;
    }

    public boolean isBloqueado() {
        return usuarioBloqueado;
    }
}
