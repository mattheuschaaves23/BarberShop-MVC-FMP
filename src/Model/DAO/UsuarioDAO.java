package Model.DAO;

import Model.Usuario;
import java.util.ArrayList;
import java.util.Objects;

/** Adaptação do DAO do material da Aula 12, com operações por identificador. */
public class UsuarioDAO {
    public void insert(Usuario registro) {
        Objects.requireNonNull(registro, "Registro obrigatório.");
        synchronized (Banco.class) {
            if (Banco.usuario.stream().anyMatch(item -> item.getId() == registro.getId())) {
                throw new IllegalArgumentException("Já existe um registro com esse identificador.");
            }
            Banco.usuario.add(registro);
        }
    }

    public boolean update(Usuario registro) {
        Objects.requireNonNull(registro, "Registro obrigatório.");
        synchronized (Banco.class) {
            for (int i = 0; i < Banco.usuario.size(); i++) {
                if (Banco.usuario.get(i).getId() == registro.getId()) {
                    Banco.usuario.set(i, registro);
                    return true;
                }
            }
            return false;
        }
    }

    public boolean delete(Usuario registro) {
        Objects.requireNonNull(registro, "Registro obrigatório.");
        synchronized (Banco.class) {
            return Banco.usuario.removeIf(item -> item.getId() == registro.getId());
        }
    }

    public ArrayList<Usuario> selectAll() {
        synchronized (Banco.class) { return new ArrayList<>(Banco.usuario); }
    }

    public Usuario selectPorNomeESenha(Usuario modelo) {
        if (modelo == null || modelo.getNome() == null || modelo.getSenha() == null) return null;
        synchronized (Banco.class) {
            return Banco.usuario.stream()
                    .filter(item -> item.getNome().equalsIgnoreCase(modelo.getNome().trim())
                            && Objects.equals(item.getSenha(), modelo.getSenha()))
                    .findFirst().orElse(null);
        }
    }
}
