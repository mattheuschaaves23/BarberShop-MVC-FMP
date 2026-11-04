package Controller.Helper;

import Model.Usuario;
import View.Login;
import java.util.Arrays;

/** Adaptação do LoginHelper fornecido no material da Aula 12. */
public class LoginHelper implements IHelper<Usuario> {
    private final Login view;

    public LoginHelper(Login view) { this.view = view; }

    @Override public Usuario obterModelo() {
        char[] senha = view.getTxtSenha().getPassword();
        try {
            return new Usuario(0, view.getTxtUsuario().getText().trim(), new String(senha));
        } finally {
            Arrays.fill(senha, '\0');
        }
    }

    @Override public void setarModelo(Usuario modelo) {
        view.getTxtUsuario().setText(modelo.getNome());
        view.getTxtSenha().setText(modelo.getSenha());
    }

    @Override public void limparTela() {
        view.getTxtUsuario().setText("");
        view.getTxtSenha().setText("");
        view.getTxtUsuario().requestFocusInWindow();
    }
}
