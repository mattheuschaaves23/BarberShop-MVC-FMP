package Model;

import java.util.Date;
import java.util.Objects;

public class Agendamento {
    private int id;
    private Cliente cliente;
    private Servico servico;
    private float valor;
    private Date data;
    private String hora;
    private String observacao;

    public Agendamento(int id, Cliente cliente, Servico servico, float valor, String dataHora, String observacao) {
        this.id = id;
        setCliente(cliente);
        setServico(servico);
        setValor(valor);
        setData(Datas.converter(dataHora, "dd/MM/yyyy HH:mm"));
        setObservacao(observacao);
    }

    public Agendamento(int id, Cliente cliente, Servico servico, float valor, String data, String hora, String observacao) {
        this(id, cliente, servico, valor, data + " " + hora, observacao);
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = Objects.requireNonNull(cliente, "Cliente obrigatório."); }
    public Servico getServico() { return servico; }
    public void setServico(Servico servico) { this.servico = Objects.requireNonNull(servico, "Serviço obrigatório."); }
    public float getValor() { return valor; }
    public void setValor(float valor) {
        if (!Float.isFinite(valor) || valor < 0) throw new IllegalArgumentException("Valor inválido.");
        this.valor = valor;
    }
    public Date getData() { return new Date(data.getTime()); }
    public final void setData(Date data) {
        this.data = new Date(Objects.requireNonNull(data, "Data obrigatória.").getTime());
        this.hora = Datas.exibir(this.data, "HH:mm");
    }
    public String getHora() { return hora; }
    public void setHora(String hora) {
        setData(Datas.converter(Datas.exibir(data, "dd/MM/yyyy") + " " + hora, "dd/MM/yyyy HH:mm"));
    }
    public String getObservacao() { return observacao; }
    public void setObservacao(String observacao) { this.observacao = observacao == null ? "" : observacao; }

    @Override public String toString() {
        return "Agendamento " + id + " | " + cliente.getNome() + " | " + servico.getDescricao()
                + " | " + Datas.exibir(data, "dd/MM/yyyy HH:mm") + " | R$ " + valor;
    }
}
