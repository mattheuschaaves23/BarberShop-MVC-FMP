package Controller.Helper;

import Model.Agendamento;
import Model.Cliente;
import Model.Datas;
import Model.Servico;
import View.Agenda;
import java.util.List;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class AgendaHelper implements IHelper<Agendamento> {
    private final Agenda view;

    public AgendaHelper(Agenda view) { this.view = view; }

    @Override public Agendamento obterModelo() {
        Cliente cliente = (Cliente) view.getCmbCliente().getSelectedItem();
        Servico servico = (Servico) view.getCmbServico().getSelectedItem();
        if (cliente == null || servico == null) {
            throw new IllegalArgumentException("Selecione o cliente e o serviço.");
        }
        return new Agendamento(0, cliente, servico, servico.getValor(),
                view.getTxtData().getText().trim(), view.getTxtHora().getText().trim(),
                view.getTxtObservacoes().getText().trim());
    }

    @Override public void setarModelo(Agendamento modelo) {
        view.getCmbCliente().setSelectedItem(modelo.getCliente());
        view.getCmbServico().setSelectedItem(modelo.getServico());
        view.getTxtData().setText(Datas.exibir(modelo.getData(), "dd/MM/yyyy"));
        view.getTxtHora().setText(modelo.getHora());
        view.getTxtObservacoes().setText(modelo.getObservacao());
        view.getTxtValor().setText(moeda(modelo.getValor()));
    }

    @Override public void limparTela() {
        view.getTxtData().setText("");
        view.getTxtHora().setText("");
        view.getTxtObservacoes().setText("");
        atualizarSelecao();
        view.getTxtData().requestFocusInWindow();
    }

    public void preencherTabela(List<Agendamento> registros) {
        DefaultTableModel tabela = (DefaultTableModel) view.getTblAgenda().getModel();
        tabela.setRowCount(0);
        for (Agendamento item : registros) {
            tabela.addRow(new Object[]{item.getId(), item.getObservacao(), item.getCliente().getNome(),
                item.getServico().getDescricao(), Datas.exibir(item.getData(), "dd/MM/yyyy"),
                item.getHora(), moeda(item.getValor())});
        }
    }

    @SuppressWarnings("unchecked")
    public void preencherClientes(List<Cliente> clientes) {
        view.getCmbCliente().setModel(new DefaultComboBoxModel<>(clientes.toArray(Cliente[]::new)));
    }

    @SuppressWarnings("unchecked")
    public void preencherServicos(List<Servico> servicos) {
        view.getCmbServico().setModel(new DefaultComboBoxModel<>(servicos.toArray(Servico[]::new)));
    }

    public void atualizarSelecao() {
        Cliente cliente = (Cliente) view.getCmbCliente().getSelectedItem();
        Servico servico = (Servico) view.getCmbServico().getSelectedItem();
        view.getTxtNome().setText(cliente == null ? "" : cliente.getNome());
        view.getTxtValor().setText(servico == null ? "" : moeda(servico.getValor()));
    }

    private static String moeda(float valor) {
        return String.format(Locale.forLanguageTag("pt-BR"), "%.2f", valor);
    }
}
