package View;
import Model.Cliente;
import Model.Servico;
import Model.Usuario;
import java.util.Date;

/** Executar ou depurar este arquivo; colocar breakpoint na primeira impressão. */
public class Main {
    public static void main(String[] args) {
        Servico servico = new Servico(1, "Barba", 30.0f);
        Cliente cliente = new Cliente(1, "Jorge", 'M', "(00) 00000-0000", "Rua Exemplo, 100");
        Usuario usuario = new Usuario(1, "barbeiro", "senha-ficticia");
        Cliente clienteCompleto = new Cliente(2, "Ana", 'F', new Date(0), "(00) 00000-0000", "ana@example.test", "RG-TESTE", "Rua Exemplo, 200", "00000-000");
        Usuario usuarioCompleto = new Usuario(2, "recepcao", "senha-ficticia", 1, 'F', new Date(0), "(00) 00000-0000", "recepcao@example.test", "RG-TESTE", "Rua Exemplo, 300");
        System.out.println("=== BarberShop: teste dos modelos ==="); // BREAKPOINT: inspecionar os cinco objetos
        System.out.println(servico);
        System.out.println(cliente);
        System.out.println(usuario);
        System.out.println(clienteCompleto);
        System.out.println(usuarioCompleto);
        System.out.println("Descrição: " + servico.getDescricao() + " | Valor: " + servico.getValor());
        if (args.length == 0 || !"--model-only".equals(args[0])) {
            Ui.iniciar(() -> new Login().setVisible(true));
        }
    }
}
