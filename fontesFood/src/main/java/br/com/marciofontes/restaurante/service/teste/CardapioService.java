package br.com.marciofontes.restaurante.service.teste;

import br.com.marciofontes.restaurante.dao.CardapioDao;
import br.com.marciofontes.restaurante.util.CargaDeDadosUtil;
import br.com.marciofontes.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CardapioService {

    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerFontesFood();
        CardapioDao cardapioDao = new CardapioDao(entityManager);

        entityManager.getTransaction().begin();
        CargaDeDadosUtil.cadastrarCategorias(entityManager);
        CargaDeDadosUtil.cadastrarProdutosCardapio(entityManager);
        System.out.println("Lista de produtos por valor: " + cardapioDao.consultarPorValor(BigDecimal.valueOf(67.50)));
        entityManager.close();
    }


}
