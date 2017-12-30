/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.primefaces.managedBean;

import br.edu.primefaces.model.Pessoa;
import br.edu.primefaces.repository.PessoaRepository;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author renato
 */
@ManagedBean
@RequestScoped
public class PessoaMB {

    private Pessoa pessoa;

    private List<Pessoa> pessoas;

    public void adicionar() {

        EntityManager manager = this.getEntityManager();

        PessoaRepository repository = new PessoaRepository(manager);

        repository.adicionarPessoa(this.pessoa);
        this.pessoa = new Pessoa();
        this.pessoas = null;

    }

    private EntityManager getEntityManager() {

        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) ec.getRequest();
        EntityManager manager = (EntityManager) request.getAttribute("EntityManager");

        return manager;

    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

}
