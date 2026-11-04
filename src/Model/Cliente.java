package Model;

import java.util.Date;

public class Cliente extends Pessoa {
    private String endereco;
    private String cep;

    public Cliente(int id, String nome, char sexo, String nascimento, String telefone, String email, String rg,
                   String endereco, String cep) {
        super(id, nome, sexo, nascimento, telefone, email, rg);
        this.endereco = endereco;
        this.cep = cep;
    }

    public Cliente(int id, String nome, char sexo, Date nascimento, String telefone, String email, String rg,
                   String endereco, String cep) {
        super(id, nome, sexo, nascimento, telefone, email, rg);
        this.endereco = endereco;
        this.cep = cep;
    }

    public Cliente(int id, String nome, char sexo, String telefone, String endereco) {
        this(id, nome, sexo, (Date) null, telefone, null, null, endereco, null);
    }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }

    @Override public String toString() { return getNome(); }
}
