package Model;

import java.util.Date;

public class Usuario extends Pessoa {
    private String senha;
    private String nivelAcesso;

    /** A ordem dos parâmetros acompanha o Banco fornecido na Aula 12. */
    public Usuario(int id, String nome, char sexo, String nascimento, String telefone, String email,
                   String rg, String senha, String nivelAcesso) {
        super(id, nome, sexo, nascimento, telefone, email, rg);
        this.senha = senha;
        this.nivelAcesso = nivelAcesso;
    }

    /** Assinatura compatível com os exemplos da Aula 11. */
    public Usuario(int id, String nome, String senha, int nivelAcesso, char sexo, Date nascimento,
                   String telefone, String email, String rg, String enderecoAnterior) {
        super(id, nome, sexo, nascimento, telefone, email, rg);
        this.senha = senha;
        this.nivelAcesso = nivelAcesso == 1 ? "administrador" : "funcionario";
    }

    public Usuario(int id, String nome, String senha) {
        this(id, nome, '\0', null, null, null, null, senha, "funcionario");
    }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
    public String getNivelAcesso() { return nivelAcesso; }
    public void setNivelAcesso(String nivelAcesso) { this.nivelAcesso = nivelAcesso; }

    @Override public String toString() {
        return "Usuario{id=" + getId() + ", nome='" + getNome() + "', nivelAcesso=" + nivelAcesso + "}";
    }
}
