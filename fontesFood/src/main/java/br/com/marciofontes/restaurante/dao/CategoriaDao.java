package br.com.marciofontes.restaurante.dao;

import br.com.marciofontes.restaurante.entity.Cardapio;
import br.com.marciofontes.restaurante.entity.Categoria;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoriaDao {
    private final EntityManager entityManager;

    public CategoriaDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(final Categoria categoria) {
        this.entityManager.persist(categoria);
    }

    public Categoria consultar(final Integer id) {
        return this.entityManager.find(Categoria.class, id);
    }

    public List<Categoria> consultarTodos() {
        String sql = "SELECT c FROM Categoria c";
        return this.entityManager.createQuery(sql, Categoria.class).getResultList();
    }

    public void atualizar(final Categoria categoria) {
        this.entityManager.merge(categoria);
    }

    public void excluir(final Categoria categoria) {
        this.entityManager.remove(categoria);
    }
}
