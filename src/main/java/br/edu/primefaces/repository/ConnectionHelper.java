/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.primefaces.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author renato
 */
public class ConnectionHelper {

    private static EntityManagerFactory factory;
    private static ThreadLocal<EntityManager> sessions = new ThreadLocal<>();

    static {

        try {

            factory = Persistence.createEntityManagerFactory("K19_PU");

        } catch (Throwable t) {

            throw new ExceptionInInitializerError(t);
        }

    }

    public static EntityManager openSession() {

        if (sessions.get() == null) {
            sessions.set(factory.createEntityManager());
        }

        return sessions.get();
    }

    public static EntityManager currentSession() {

        if (sessions.get() == null) {
            openSession();
        }
        return sessions.get();

    }

    public static void closeCurrentSession() {

        sessions.get().close();
        sessions.set(null);
    }

    public static void shutdown() {

        factory.close();
    }

    public static EntityManagerFactory getFactory() {

        return factory;
    }
}
