package repository;

import java.util.List;

public interface Repositorio<T> {
    void salvar(T entidade);
    List<T> listar();
    T buscarPorId(String id);
    void atualizar(T entidade);
}
