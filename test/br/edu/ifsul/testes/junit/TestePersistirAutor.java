/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Autor;
import br.edu.ifsul.modelo.LivroBasico;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
public class TestePersistirAutor {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirAutor() {
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
           Autor at = new Autor();
           at.setNome("Peter Squil");
           at.setBibliografia("escritor barroco");
           em.getTransaction().begin();
           em.persist(at);
           em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            exception = true;
        }
        Assert.assertEquals(false, exception);
    
    }
    
}
