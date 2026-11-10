package Controller;

import Controller.Helper.AgendaHelper;
import Model.Agendamento;
import Model.DAO.AgendamentoDAO;
import Model.DAO.ClienteDAO;
import Model.DAO.ServicoDAO;
import View.Agenda;
import javax.swing.JOptionPane;

public class AgendaController {
    private final Agenda view;
    private final AgendaHelper helper;
    private final AgendamentoDAO dao = new AgendamentoDAO();

    public AgendaController(Agenda view) {
        this.view = view;
        this.helper = new AgendaHelper(view);
    }

    public void atualizaTabela() { helper.preencherTabela(dao.selectAll()); }
    public void atualizaCliente() { helper.preencherClientes(new ClienteDAO().selectAll()); }
    public void atualizaServico() { helper.preencherServicos(new ServicoDAO().selectAll()); }
    public void atualizarSelecao() { helper.atualizarSelecao(); }

    public void agendar() {
        view.getBtnAgendar().setSelected(false);
        try {
            Agendamento agendamento = helper.obterModelo();
            dao.insert(agendamento);
            atualizaTabela();
            helper.limparTela();
        } catch (IllegalArgumentException erro) {
            JOptionPane.showMessageDialog(view, erro.getMessage(), "Confira o agendamento", JOptionPane.WARNING_MESSAGE);
        }
    }
}
