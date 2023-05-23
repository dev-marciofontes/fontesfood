package br.com.marciofontes.restaurante.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static final EntityManagerFactory FONTESFOOD = Persistence.createEntityManagerFactory("fontesFood");

    public static EntityManager getEntityManagerFontesFood() {
        return FONTESFOOD.createEntityManager();
    }

}
