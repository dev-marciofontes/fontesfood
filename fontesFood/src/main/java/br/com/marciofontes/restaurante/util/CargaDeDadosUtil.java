package br.com.marciofontes.restaurante.util;

import br.com.marciofontes.restaurante.dao.CardapioDao;
import br.com.marciofontes.restaurante.dao.CategoriaDao;
import br.com.marciofontes.restaurante.entity.Cardapio;
import br.com.marciofontes.restaurante.entity.Categoria;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CargaDeDadosUtil {

    private CargaDeDadosUtil() {
    }

    public static void cadastrarCategorias(EntityManager entityManager) {
        Categoria entrada = new Categoria("Entradas");
        Categoria salada = new Categoria("Saladas");
        Categoria principal = new Categoria("Pratos Principais");
        Categoria sobremesa = new Categoria("Sobremesas");

        CategoriaDao categoriaDao = new CategoriaDao(entityManager);

        categoriaDao.cadastrar(entrada);
        entityManager.flush();
        categoriaDao.cadastrar(salada);
        entityManager.flush();
        categoriaDao.cadastrar(principal);
        entityManager.flush();
        categoriaDao.cadastrar(sobremesa);
        entityManager.flush();
        entityManager.clear();
    }

    public static void cadastrarProdutosCardapio(EntityManager entityManager) {
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);
        CardapioDao cardapioDao = new CardapioDao(entityManager);

        List<Categoria> categorias = categoriaDao.consultarTodos();

        Cardapio risoto = new Cardapio("Risoto de camarão", "Risoto acompanhado com deliciosos camarões gigantes da Austrália!",
                true, BigDecimal.valueOf(88.50), categorias.get(2));

        Cardapio bifeAncho = new Cardapio("Bife Ancho Angus", "Delicioso bife ancho Angus grelhado e no ponto!",
                true, BigDecimal.valueOf(67.50), categorias.get(2));

        Cardapio cordeiro = new Cardapio("Cordeiro Real", "Deliciosa carne de cordeiro real com molho de hortelã caseiro!",
                true, BigDecimal.valueOf(67.50), categorias.get(2));

        Cardapio batataRustica = new Cardapio("Batata Rústica", "Deliciosa bata rústica feita na casa!",
                true, BigDecimal.valueOf(67.50), categorias.get(0));

        Cardapio saladaEspecial = new Cardapio("Salada Especial da Casa", "Deliciosa salada feita com um mix de 45 folhas!",
                true, BigDecimal.valueOf(27.50), categorias.get(1));

        Cardapio sorveteMagico = new Cardapio("Sorvete Mágico 5 Leites", "Delicioso sorvete especial do chefe, feito com 5 leites diferenciados!",
                true, BigDecimal.valueOf(37.50), categorias.get(3));

        cardapioDao.cadastrar(risoto);
        entityManager.flush();
        cardapioDao.cadastrar(bifeAncho);
        entityManager.flush();
        cardapioDao.cadastrar(cordeiro);
        entityManager.flush();
        cardapioDao.cadastrar(batataRustica);
        entityManager.flush();
        cardapioDao.cadastrar(saladaEspecial);
        entityManager.flush();
        cardapioDao.cadastrar(sorveteMagico);
        entityManager.flush();
        entityManager.clear();
    }

}
