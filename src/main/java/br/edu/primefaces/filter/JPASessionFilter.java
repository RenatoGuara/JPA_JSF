/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.primefaces.filter;

import br.edu.primefaces.repository.ConnectionHelper;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 *
 * @author renato
 */
@WebFilter
public class JPASessionFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        try {

            ConnectionHelper.currentSession().getTransaction().begin();
            chain.doFilter(request, response);
            ConnectionHelper.currentSession().getTransaction().commit();

        } catch (IOException | ServletException e) {

            throw new ServletException(e);

        } finally {

            ConnectionHelper.closeCurrentSession();
        }

    }

    @Override
    public void destroy() {

    }

}
