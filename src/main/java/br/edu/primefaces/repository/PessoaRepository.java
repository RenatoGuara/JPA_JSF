/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.primefaces.repository;

import br.edu.primefaces.model.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author renato
 */
public class PessoaRepository {

    EntityManager manager;

    public PessoaRepository(EntityManager manager) {
        this.manager = manager;
    }

    public void adicionarPessoa(Pessoa pessoa) {

        this.manager.persist(pessoa);
        this.manager.getTransaction().commit();
        

    }

    public List<Pessoa> buscaTodas() {

        Query query = manager.createQuery("SELECT p FROM Pessoa p");
        return query.getResultList();

    }

}
