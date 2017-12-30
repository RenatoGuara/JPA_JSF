/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.primefaces.main;

import br.edu.primefaces.model.Pessoa;
import br.edu.primefaces.repository.PessoaRepository;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author renato
 */
public class SchemaGeneration {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("K19_PU");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        PessoaRepository repository = new PessoaRepository(manager);
        Pessoa p = new Pessoa();
        p.setNome("Renato com Tom cat de novo!!!!!!!!");
        
        repository.adicionarPessoa(p);
        
        
        

        System.out.println("Conectou!!!!" +p.getNome());

    }

}
