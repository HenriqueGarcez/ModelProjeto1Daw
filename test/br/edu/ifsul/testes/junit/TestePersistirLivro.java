/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Catalogo;
import br.edu.ifsul.modelo.Formato;
import br.edu.ifsul.modelo.Idioma;
import br.edu.ifsul.modelo.Livro;
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
public class TestePersistirLivro {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirLivro() {
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
           Idioma i = em.find(Idioma.class, 1);
           Formato fm = em.find(Formato.class, 1);
           Catalogo c = em.find(Catalogo.class, 2);
           Livro l = new Livro();
           l.setISBN("234");
           l.setAtivo(true);
           l.setTitulo("1903");
           l.setEditora("Namco");
           l.setDataPublicacao(new GregorianCalendar(2010, Calendar.APRIL, 27));
           l.setCodigoBarras("6536153527153");
           l.setNumeroPaginas(367);
           l.setDataCadastro(new GregorianCalendar(2013, Calendar.MAY, 10));
           l.setValor(99.99);
           l.setIdioma(i);
           l.setFormato(fm);
           l.setCatalogo(c);
           em.getTransaction().begin();
           em.persist(l);
           em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            exception = true;
        }
        Assert.assertEquals(false, exception);
    
    }
    
}
