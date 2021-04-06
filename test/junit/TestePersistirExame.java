package junit;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Exame;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestePersistirExame 
{
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirExame() {
    }
    
    @Before
    public void setUp() 
    {
       emf= Persistence.createEntityManagerFactory("ClinicaPU");
       em= emf.createEntityManager();
    }
    
    @After
    public void tearDown() 
    {
       em.close();
       emf.close();
    }
    
    @Test
    public void teste()
    {
      boolean resultado= false;
      
        try{
          Exame ex= new Exame();
          ex.setNome("Ultrassonografia");
          ex.setDescricao("Ultrassonografia do pulmão");
          em.getTransaction().begin();
          em.persist(ex);
          em.getTransaction().commit();
        } catch(Exception e){
          resultado= false;
          e.printStackTrace();
        }
      
      Assert.assertEquals(false, resultado);
    }  
}