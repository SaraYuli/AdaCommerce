package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class RepositorioMemoria<T> implements Repositorio<T> {
    private List<T> lista = new ArrayList<>();
    private Function<T, String> idExtractor;

    public RepositorioMemoria(Function<T, String> idExtractor) {
        this.idExtractor = idExtractor;
    }

    @Override
    public void salvar(T entidade) {
        lista.add(entidade);
    }

    @Override
    public List<T> listar() {
        return lista;
    }

    @Override
    public T buscarPorId(String id) {
        for (T entidade : lista) {
            if (idExtractor.apply(entidade).equals(id)) {
                return entidade;
            }
        }
        return null;
    }

    @Override
    public void atualizar(T entidade) {
        String id = idExtractor.apply(entidade);
        for (int i = 0; i < lista.size(); i++) {
            if (idExtractor.apply(lista.get(i)).equals(id)) {
                lista.set(i, entidade);
                return;
            }
        }
    }
}

