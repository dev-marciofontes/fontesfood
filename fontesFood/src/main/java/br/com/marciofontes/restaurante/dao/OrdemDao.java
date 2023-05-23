package br.com.marciofontes.restaurante.dao;

import br.com.marciofontes.restaurante.entity.Ordem;
import br.com.marciofontes.restaurante.vo.ItensPrincipaisVo;

import javax.persistence.EntityManager;
import java.util.List;

public class OrdemDao {

    private EntityManager entityManager;

    public OrdemDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(final Ordem ordem) {
        this.entityManager.persist(ordem);
    }

    public Ordem consultarPorId(final Integer id) {
        return this.entityManager.find(Ordem.class, id);
    }

    public List<Ordem> consultarTodos() {
        String jpql = "SELECT o FROM Ordem o";
        return this.entityManager.createQuery(jpql, Ordem.class).getResultList();
    }

    public List<ItensPrincipaisVo> consultarItensMaisVendidos() {
        String jpql = "SELECT new br.com.marciofontes.restaurante.vo.ItensPrincipaisVo(" +
                " c.nome, SUM(oc.quantidade)) FROM OrdensCardapio oc " +
                "JOIN oc.cardapio c " +
                "GROUP BY c.nome " +
                "ORDER BY SUM(oc.quantidade) DESC";

        return this.entityManager.createQuery(jpql, ItensPrincipaisVo.class)
                .setMaxResults(10)
                .getResultList();
    }

    public void atualizar(final Ordem ordem) {
        this.entityManager.merge(ordem);
    }

    public void excluir(final Ordem ordem) {
        this.entityManager.remove(ordem);
    }
}
