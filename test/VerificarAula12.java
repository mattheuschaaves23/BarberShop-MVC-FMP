import Model.*;
import Model.DAO.*;
import View.Login;
import Controller.Helper.LoginHelper;
import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Modifier;

public class VerificarAula12 {
    private static int checks;

    private static void verificar(boolean condicao, String descricao) {
        if (!condicao) throw new AssertionError(descricao);
        checks++;
    }

    private static void rejeitar(Runnable acao, String descricao) {
        try { acao.run(); }
        catch (IllegalArgumentException esperado) {
            checks++;
            return;
        }
        throw new AssertionError(descricao);
    }

    public static void main(String[] args) throws Exception {
        verificar(Modifier.isAbstract(Pessoa.class.getModifiers()), "Pessoa deve ser abstrata");
        verificar(Cliente.class.getSuperclass() == Pessoa.class, "Cliente herda de Pessoa");
        verificar(Usuario.class.getSuperclass() == Pessoa.class, "Usuario herda de Pessoa");
        verificar(Datas.exibir(Datas.converter("29/02/2000", "dd/MM/yyyy"), "dd/MM/yyyy").equals("29/02/2000"), "Dia bissexto válido");
        rejeitar(() -> Datas.converter("29/02/2026", "dd/MM/yyyy"), "Dia bissexto inválido");
        rejeitar(() -> Datas.converter("04/11/2026 24:00", "dd/MM/yyyy HH:mm"), "Hora inválida");
        rejeitar(() -> Datas.converter("04/11/2026texto", "dd/MM/yyyy"), "Data com sufixo");

        UsuarioDAO usuarios = new UsuarioDAO();
        verificar(usuarios.selectPorNomeESenha(new Usuario(0,"barbeiro","demo123")) != null, "Credencial válida");
        verificar(usuarios.selectPorNomeESenha(new Usuario(0,"barbeiro","errada")) == null, "Senha errada");
        verificar(usuarios.selectPorNomeESenha(new Usuario(0,"inexistente","demo123")) == null, "Usuário inexistente");
        AgendamentoDAO dao = new AgendamentoDAO();
        Agendamento primeiro = dao.selectAll().get(0);
        int quantidade = dao.selectAll().size();
        Agendamento repetido = new Agendamento(0, primeiro.getCliente(), primeiro.getServico(), 35f,
                "04/11/2026 09:00", "");
        rejeitar(() -> dao.insert(repetido), "Horário repetido");
        verificar(dao.selectAll().size() == quantidade, "Rejeição preserva registros");
        Agendamento novo = new Agendamento(0, primeiro.getCliente(), primeiro.getServico(), 35f,
                "04/11/2026", "10:30", "Teste");
        dao.insert(novo);
        verificar(dao.selectAll().size() == quantidade+1 && novo.getId() > primeiro.getId(), "Inserção em memória");
        verificar(novo.getHora().equals("10:30"), "Hora coerente");
        novo.setHora("11:15");
        verificar(Datas.exibir(novo.getData(),"HH:mm").equals("11:15"), "Atualização coerente");

        SwingUtilities.invokeAndWait(VerificarAula12::verificarFluxo);
        System.out.println(checks + " verificações de herança, datas, DAO e navegação aprovadas.");
    }

    private static void verificarFluxo() {
        Login login = new Login();
        login.setVisible(true);
        try {
            LoginHelper helper = new LoginHelper(login);
            helper.setarModelo(new Usuario(0, "barbeiro", "demo123"));
            verificar(helper.obterModelo().getNome().equals("barbeiro"), "Helper lê o usuário");
            verificar(helper.obterModelo().getSenha().equals("demo123"), "Helper lê a senha");
            helper.limparTela();
            verificar(login.getTxtUsuario().getText().isEmpty() && login.getTxtSenha().getPassword().length == 0,
                    "Helper limpa os campos");
            login.setTxtUsuario("barbeiro");
            login.setTxtSenha("errada");
            login.getRootPane().getDefaultButton().doClick();
            verificar(login.isShowing(), "Login permanece aberto com credencial inválida");
            verificar(janela("BarberShop | Menu principal") == null, "Menu não abre com senha inválida");
            login.setTxtSenha("demo123");
            login.getRootPane().getDefaultButton().doClick();
            JFrame menu = janela("BarberShop | Menu principal");
            verificar(menu != null && !login.isDisplayable(), "Login válido abre menu e fecha login");
            menu.getJMenuBar().getMenu(1).getItem(0).doClick();
            verificar(janela("BarberShop | Agenda") != null, "Menu abre a Agenda");
        } finally {
            for (Window janela : Window.getWindows()) janela.dispose();
        }
    }

    private static JFrame janela(String titulo) {
        for (Window janela : Window.getWindows()) {
            if (janela instanceof JFrame quadro && quadro.isShowing() && quadro.getTitle().equals(titulo)) {
                return quadro;
            }
        }
        return null;
    }
}
