package br.com.marciofontes.restaurante.util;

import br.com.marciofontes.restaurante.dao.*;
import br.com.marciofontes.restaurante.entity.*;

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
        Cardapio acaraje = new Cardapio("Acarajé", "Bolinho frito de massa de feijão-fradinho recheado com vatapá, camarão, caruru e pimenta!",
                true, BigDecimal.valueOf(15.00), categorias.get(0));
        Cardapio feijoada = new Cardapio("Feijoada", "Prato típico brasileiro composto de feijão preto cozido com diferentes tipos de carne!",
                true, BigDecimal.valueOf(35.00), categorias.get(1));
        Cardapio tapioca = new Cardapio("Tapioca", "Panqueca feita com goma de mandioca e recheada com diversos ingredientes!",
                true, BigDecimal.valueOf(12.00), categorias.get(2));
        Cardapio acai = new Cardapio("Açaí", "Creme de frutas congeladas, geralmente servido com granola e acompanhamentos!",
                true, BigDecimal.valueOf(20.00), categorias.get(3));

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
        cardapioDao.cadastrar(acaraje);
        entityManager.flush();
        cardapioDao.cadastrar(feijoada);
        entityManager.flush();
        cardapioDao.cadastrar(tapioca);
        entityManager.flush();
        cardapioDao.cadastrar(acai);
        entityManager.flush();

        entityManager.clear();
    }

    public static void cadastrarClientes(EntityManager entityManager) {

        ClienteDao clienteDao = new ClienteDao(entityManager);
        EnderecoDao enderecoDao = new EnderecoDao(entityManager);

        Endereco endereco1 = new Endereco("123456", "Rua das Flores", "Casa 43", "Belo Horizonte", "MG");
        Cliente cliente1 = new Cliente("12345678901", "Felipe Ribeiro");
        cliente1.addEndereco(endereco1);

        Endereco endereco2 = new Endereco("654321", "Avenida dos Sonhos", "Apartamento 1001", "Belo Horizonte", "MG");
        Cliente cliente2 = new Cliente("111111111111", "Cleber Machado");
        cliente2.addEndereco(endereco2);

        Endereco endereco3 = new Endereco("987654", "Rua do Sol", "Apartamento 203", "Belo Horizonte", "MG");
        Cliente cliente3 = new Cliente("09876543210", "Calvin Coelho");
        cliente3.addEndereco(endereco3);

        Endereco endereco4 = new Endereco("321654", "Rua dos Amores", "Apartamento 101", "Belo Horizonte", "MG");
        Cliente cliente4 = new Cliente("111111111123", "Tayane Lopes");
        cliente4.addEndereco(endereco4);

        Endereco endereco5 = new Endereco("789123", "Avenida das Estrelas", "Apartamento 1001", "Belo Horizonte", "MG");
        Cliente cliente5 = new Cliente("111111111145", "Denise Costa");
        cliente5.addEndereco(endereco5);

        Endereco endereco6 = new Endereco("456789", "Rua das Cores", "Casa 27", "Belo Horizonte", "MG");
        Cliente cliente6 = new Cliente("111111111345", "Claudia Rosa");
        cliente6.addEndereco(endereco6);

        enderecoDao.cadastrar(endereco1);
        clienteDao.cadastrar(cliente1);
        enderecoDao.cadastrar(endereco2);
        clienteDao.cadastrar(cliente2);
        enderecoDao.cadastrar(endereco3);
        clienteDao.cadastrar(cliente3);
        enderecoDao.cadastrar(endereco4);
        clienteDao.cadastrar(cliente4);
        enderecoDao.cadastrar(endereco5);
        clienteDao.cadastrar(cliente5);
        enderecoDao.cadastrar(endereco6);
        clienteDao.cadastrar(cliente6);

        entityManager.flush();
        entityManager.clear();
    }

    public static void cadastrarOrdensClientes(EntityManager entityManager) {
        ClienteDao clienteDao = new ClienteDao(entityManager);
        CardapioDao cardapioDao = new CardapioDao(entityManager);
        OrdemDao ordemDao = new OrdemDao(entityManager);
        List<Cliente> clientes = clienteDao.consultarTodos();
        List<Cardapio> cardapioList = cardapioDao.consultarTodos();

        Ordem ordemFelipe = new Ordem(clientes.get(0));
        ordemFelipe.addOrdensCardapio(new OrdensCardapio(cardapioList.get(9), 2));
        ordemFelipe.addOrdensCardapio(new OrdensCardapio(cardapioList.get(5), 3));

        Ordem ordemCleber = new Ordem(clientes.get(1));
        ordemCleber.addOrdensCardapio(new OrdensCardapio(cardapioList.get(9), 22));
        ordemCleber.addOrdensCardapio(new OrdensCardapio(cardapioList.get(1), 2));
        ordemCleber.addOrdensCardapio(new OrdensCardapio(cardapioList.get(7), 3));

        Ordem ordemCalvin = new Ordem(clientes.get(2));
        ordemCalvin.addOrdensCardapio(new OrdensCardapio(cardapioList.get(2), 50));
        ordemCalvin.addOrdensCardapio(new OrdensCardapio(cardapioList.get(5), 3));

        Ordem ordemTayane = new Ordem(clientes.get(3));
        ordemTayane.addOrdensCardapio(new OrdensCardapio(cardapioList.get(9), 2));
        ordemTayane.addOrdensCardapio(new OrdensCardapio(cardapioList.get(2), 3));

        Ordem ordemDenise = new Ordem(clientes.get(4));
        ordemDenise.addOrdensCardapio(new OrdensCardapio(cardapioList.get(4), 2));
        ordemDenise.addOrdensCardapio(new OrdensCardapio(cardapioList.get(8), 5));

        Ordem ordemClaudia = new Ordem(clientes.get(5));
        ordemClaudia.addOrdensCardapio(new OrdensCardapio(cardapioList.get(9), 2));
        ordemClaudia.addOrdensCardapio(new OrdensCardapio(cardapioList.get(5), 3));

        ordemDao.cadastrar(ordemFelipe);
        ordemDao.cadastrar(ordemCleber);
        ordemDao.cadastrar(ordemCalvin);
        ordemDao.cadastrar(ordemTayane);
        ordemDao.cadastrar(ordemDenise);
        ordemDao.cadastrar(ordemClaudia);

        entityManager.flush();
        entityManager.clear();
    }

}
