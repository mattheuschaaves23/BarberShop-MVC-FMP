package Model.DAO;

import Model.Cliente;
import java.util.ArrayList;
import java.util.Objects;

/** Adaptação do DAO do material da Aula 12, com operações por identificador. */
public class ClienteDAO {
    public void insert(Cliente registro) {
        Objects.requireNonNull(registro, "Registro obrigatório.");
        synchronized (Banco.class) {
            if (Banco.cliente.stream().anyMatch(item -> item.getId() == registro.getId())) {
                throw new IllegalArgumentException("Já existe um registro com esse identificador.");
            }
            Banco.cliente.add(registro);
        }
    }

    public boolean update(Cliente registro) {
        Objects.requireNonNull(registro, "Registro obrigatório.");
        synchronized (Banco.class) {
            for (int i = 0; i < Banco.cliente.size(); i++) {
                if (Banco.cliente.get(i).getId() == registro.getId()) {
                    Banco.cliente.set(i, registro);
                    return true;
                }
            }
            return false;
        }
    }

    public boolean delete(Cliente registro) {
        Objects.requireNonNull(registro, "Registro obrigatório.");
        synchronized (Banco.class) {
            return Banco.cliente.removeIf(item -> item.getId() == registro.getId());
        }
    }

    public ArrayList<Cliente> selectAll() {
        synchronized (Banco.class) { return new ArrayList<>(Banco.cliente); }
    }
}
