package Controller;

import Controller.Helper.LoginHelper;
import Model.DAO.UsuarioDAO;
import Model.Usuario;
import View.Login;
import View.MenuPrincipal;

/** Adaptação do controller fornecido no material da Aula 12. */
public class LoginController {
    private final Login view;
    private final LoginHelper helper;
    private final UsuarioDAO dao;

    public LoginController(Login view) {
        this.view = view;
        this.helper = new LoginHelper(view);
        this.dao = new UsuarioDAO();
    }

    public void entrarNoSistema() {
        Usuario credencial = helper.obterModelo();
        if (credencial.getNome().isBlank() || credencial.getSenha().isBlank()) {
            view.mostrarMensagem("Preencha usuário e senha.");
            return;
        }
        Usuario autenticado = dao.selectPorNomeESenha(credencial);
        if (autenticado == null) {
            view.mostrarMensagem("Usuário ou senha inválidos.");
            view.getTxtSenha().setText("");
            view.getTxtSenha().requestFocusInWindow();
            return;
        }
        helper.limparTela();
        MenuPrincipal menu = new MenuPrincipal();
        menu.setVisible(true);
        view.dispose();
    }
}
