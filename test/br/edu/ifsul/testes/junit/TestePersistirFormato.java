package br.edu.ifsul.testes.junit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import br.edu.ifsul.modelo.Formato;
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
public class TestePersistirFormato {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirFormato() {
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
           Formato fm = new Formato();
           fm.setNome("Texto");
           em.getTransaction().begin();
           em.persist(fm);
           em.getTransaction().commit();
        }catch(Exception e){
            exception = true;
        }
        Assert.assertEquals(false, exception);
    
    }
    
}
