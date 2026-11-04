package View;

import Model.Agendamento;
import Model.Cliente;
import Model.Datas;
import Model.Pessoa;
import Model.Servico;
import Model.Usuario;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente(1, "Jorge", 'M', "14/06/1997", "0000-0000",
                "jorge@example.test", "RG-DEMO-01", "Rua Exemplo, 100", "00000-000");
        Usuario usuario = new Usuario(1, "barbeiro", 'M', "16/08/1995", "0000-0000",
                "barbeiro@example.test", "RG-DEMO-03", "demo123", "administrador");
        Servico servico = new Servico(1, "Corte", 35f);
        Agendamento agendamento = new Agendamento(1, cliente, servico, servico.getValor(),
                "04/11/2026", "09:00", "Atendimento de demonstração");

        System.out.println("=== Aula 12 | Modelos ==="); // Breakpoint: modelos inicializados.
        exibirHeranca(cliente);
        exibirHeranca(usuario);
        System.out.println(agendamento);
        System.out.println("Tipo da data: " + agendamento.getData().getClass().getName());
        if (args.length == 0 || !"--model-only".equals(args[0])) {
            Ui.iniciar(() -> Ui.abrir(new Login()));
        }
    }

    private static void exibirHeranca(Pessoa pessoa) {
        System.out.printf("%s extends %s | %s | nascimento: %s%n", pessoa.getClass().getSimpleName(),
                pessoa.getClass().getSuperclass().getSimpleName(), pessoa.getNome(),
                Datas.exibir(pessoa.getDataNascimento(), "dd/MM/yyyy"));
    }
}
