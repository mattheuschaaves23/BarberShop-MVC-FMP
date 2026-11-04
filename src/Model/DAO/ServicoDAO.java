package Model.DAO;

import Model.Servico;
import java.util.ArrayList;
import java.util.Objects;

/** Adaptação do DAO do material da Aula 12, com operações por identificador. */
public class ServicoDAO {
    public void insert(Servico registro) {
        Objects.requireNonNull(registro, "Registro obrigatório.");
        synchronized (Banco.class) {
            if (Banco.servico.stream().anyMatch(item -> item.getId() == registro.getId())) {
                throw new IllegalArgumentException("Já existe um registro com esse identificador.");
            }
            Banco.servico.add(registro);
        }
    }

    public boolean update(Servico registro) {
        Objects.requireNonNull(registro, "Registro obrigatório.");
        synchronized (Banco.class) {
            for (int i = 0; i < Banco.servico.size(); i++) {
                if (Banco.servico.get(i).getId() == registro.getId()) {
                    Banco.servico.set(i, registro);
                    return true;
                }
            }
            return false;
        }
    }

    public boolean delete(Servico registro) {
        Objects.requireNonNull(registro, "Registro obrigatório.");
        synchronized (Banco.class) {
            return Banco.servico.removeIf(item -> item.getId() == registro.getId());
        }
    }

    public ArrayList<Servico> selectAll() {
        synchronized (Banco.class) { return new ArrayList<>(Banco.servico); }
    }
}
