/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Idioma;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author henri
 */
public class TestePersistirIdioma {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirIdioma() {
    }
    
    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("DAW-PU");
        em = emf.createEntityManager();
    } 
    
    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    
    @Test
    public void teste(){
        boolean exception = false;
        try{
           Idioma i = new Idioma();
           i.setNome("Inglês");
           i.setSigla("US");
           em.getTransaction().begin();
           em.persist(i);
           em.getTransaction().commit();
        }catch(Exception e){
            exception = true;
        }
        Assert.assertEquals(false, exception);
    
    }
    
}
