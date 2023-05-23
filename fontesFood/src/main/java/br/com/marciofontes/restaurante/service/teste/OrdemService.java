package br.com.marciofontes.restaurante.service.teste;

import br.com.marciofontes.restaurante.dao.CardapioDao;
import br.com.marciofontes.restaurante.dao.ClienteDao;
import br.com.marciofontes.restaurante.dao.OrdemDao;
import br.com.marciofontes.restaurante.entity.Cliente;
import br.com.marciofontes.restaurante.entity.Endereco;
import br.com.marciofontes.restaurante.entity.Ordem;
import br.com.marciofontes.restaurante.entity.OrdensCardapio;
import br.com.marciofontes.restaurante.util.CargaDeDadosUtil;
import br.com.marciofontes.restaurante.util.JPAUtil;

import javax.persistence.EntityManager;

public class OrdemService {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManagerFontesFood();
        entityManager.getTransaction().begin();
        OrdemDao ordemDao = new OrdemDao(entityManager);

        CargaDeDadosUtil.cadastrarCategorias(entityManager);
        CargaDeDadosUtil.cadastrarProdutosCardapio(entityManager);
        CargaDeDadosUtil.cadastrarClientes(entityManager);
        CargaDeDadosUtil.cadastrarOrdensClientes(entityManager);

        System.out.println(ordemDao.consultarItensMaisVendidos());
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}

