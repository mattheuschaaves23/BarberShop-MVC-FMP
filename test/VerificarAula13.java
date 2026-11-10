import Controller.AgendaController;
import Controller.Helper.AgendaHelper;
import Controller.Helper.IHelper;
import Model.Agendamento;
import Model.DAO.*;
import View.Agenda;
import javax.swing.SwingUtilities;

public class VerificarAula13 {
    private static void conferir(boolean condicao, String mensagem) {
        if (!condicao) throw new AssertionError(mensagem);
    }

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            Banco.inicia();
            Agenda tela = new Agenda();
            try {
                AgendaController controller = new AgendaController(tela);
                IHelper<Agendamento> helper = new AgendaHelper(tela);
                conferir(tela.getTblAgenda().getRowCount() == new AgendamentoDAO().selectAll().size(), "Carga da tabela");
                conferir(tela.getCmbCliente().getItemCount() == new ClienteDAO().selectAll().size(), "Carga dos clientes");
                conferir(tela.getCmbServico().getItemCount() == new ServicoDAO().selectAll().size(), "Carga dos serviços");
                tela.getCmbServico().setSelectedIndex(0);
                conferir(tela.getTxtValor().getText().equals("35,00"), "Preço do corte");
                tela.getCmbServico().setSelectedIndex(1);
                conferir(tela.getTxtValor().getText().equals("30,00"), "Preço dinâmico da barba");
                tela.getCmbCliente().setSelectedIndex(1);
                conferir(tela.getTxtNome().getText().equals("Ana"), "Cliente dinâmico");
                tela.getTxtData().setText("09/11/2026");
                tela.getTxtHora().setText("14:30");
                tela.getTxtObservacoes().setText("Verificação Aula 13");
                Agendamento modelo = helper.obterModelo();
                conferir(modelo.getValor() == 30f && modelo.getCliente().getNome().equals("Ana"), "Leitura polimórfica");
                tela.getBtnAgendar().doClick();
                conferir(new AgendamentoDAO().selectAll().size() == 2, "Botão grava no DAO");
                conferir(tela.getTblAgenda().getRowCount() == 2, "Botão atualiza tabela");
                conferir(tela.getTxtData().getText().isEmpty() && tela.getTxtHora().getText().isEmpty(), "Limpeza após salvar");
                helper.setarModelo(modelo);
                conferir(tela.getTxtHora().getText().equals("14:30"), "Preenchimento polimórfico");
                helper.limparTela();
                controller.atualizaTabela();
                controller.atualizaTabela();
                conferir(tela.getTblAgenda().getRowCount() == 2, "Atualização sem duplicar linhas");
                tela.getCmbServico().setSelectedIndex(-1);
                conferir(tela.getTxtValor().getText().isEmpty(), "Seleção vazia limpa o valor");
                try {
                    helper.obterModelo();
                    throw new AssertionError("Seleção vazia deve ser rejeitada");
                } catch (IllegalArgumentException esperado) {
                    conferir(esperado.getMessage().contains("Selecione"), "Mensagem da validação");
                }
                System.out.println("14 verificações da Aula 13 aprovadas. JTable, combos, valor, IHelper e botão Agendar.");
            } finally {
                tela.dispose();
                Banco.inicia();
            }
        });
    }
}
