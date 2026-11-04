package Model.DAO;

import Model.Agendamento;
import java.util.ArrayList;
import java.util.Objects;

/** Adaptação do DAO da Aula 12 com atribuição de ID e validação de horário. */
public class AgendamentoDAO {
    public void insert(Agendamento registro) {
        Objects.requireNonNull(registro, "Agendamento obrigatório.");
        synchronized (Banco.class) {
            if (registro.getId() != 0) throw new IllegalArgumentException("O agendamento já possui um identificador.");
            conferirHorario(registro);
            int maiorId = Banco.agendamento.stream().mapToInt(Agendamento::getId).max().orElse(0);
            registro.setId(maiorId + 1);
            Banco.agendamento.add(registro);
        }
    }

    public boolean update(Agendamento registro) {
        Objects.requireNonNull(registro, "Agendamento obrigatório.");
        synchronized (Banco.class) {
            for (int i = 0; i < Banco.agendamento.size(); i++) {
                if (Banco.agendamento.get(i).getId() == registro.getId()) {
                    conferirHorario(registro);
                    Banco.agendamento.set(i, registro);
                    return true;
                }
            }
            return false;
        }
    }

    public boolean delete(Agendamento registro) {
        Objects.requireNonNull(registro, "Agendamento obrigatório.");
        synchronized (Banco.class) {
            return Banco.agendamento.removeIf(item -> item.getId() == registro.getId());
        }
    }

    public ArrayList<Agendamento> selectAll() {
        synchronized (Banco.class) { return new ArrayList<>(Banco.agendamento); }
    }

    private static void conferirHorario(Agendamento registro) {
        boolean ocupado = Banco.agendamento.stream().anyMatch(item -> item.getId() != registro.getId()
                && item.getData().equals(registro.getData()));
        if (ocupado) throw new IllegalArgumentException("Já existe um atendimento nesse horário.");
    }
}
