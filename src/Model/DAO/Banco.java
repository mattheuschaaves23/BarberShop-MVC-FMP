package Model.DAO;

import Model.Agendamento;
import Model.Cliente;
import Model.Servico;
import Model.Usuario;
import java.util.ArrayList;

/** Adaptação do Banco da Aula 12. Toda a carga é fictícia e fica em memória. */
public final class Banco {
    static final ArrayList<Usuario> usuario = new ArrayList<>();
    static final ArrayList<Cliente> cliente = new ArrayList<>();
    static final ArrayList<Servico> servico = new ArrayList<>();
    static final ArrayList<Agendamento> agendamento = new ArrayList<>();

    static { inicia(); }

    private Banco() {}

    public static synchronized void inicia() {
        usuario.clear();
        cliente.clear();
        servico.clear();
        agendamento.clear();

        Usuario barbeiro = new Usuario(1, "barbeiro", 'M', "18/07/1990", "0000-0000",
                "barbeiro@example.test", "RG-DEMO-03", "demo123", "administrador");
        usuario.add(barbeiro);
        usuario.add(new Usuario(2, "recepcao", 'F', "09/05/1996", "0000-0000",
                "recepcao@example.test", "RG-DEMO-04", "demo456", "funcionario"));

        Cliente jorge = new Cliente(1, "Jorge", 'M', "14/06/1997", "0000-0000", "jorge@example.test",
                "RG-DEMO-01", "Rua Exemplo, 100", "00000-000");
        cliente.add(jorge);
        cliente.add(new Cliente(2, "Ana", 'F', "29/02/2000", "0000-0000", "ana@example.test",
                "RG-DEMO-02", "Rua Exemplo, 200", "00000-000"));

        Servico corte = new Servico(1, "Corte", 35f);
        servico.add(corte);
        servico.add(new Servico(2, "Barba", 30f));
        agendamento.add(new Agendamento(1, jorge, corte, corte.getValor(), "04/11/2026", "09:00",
                "Atendimento de demonstração"));
    }
}
