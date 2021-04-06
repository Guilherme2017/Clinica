package junit;

import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Assert;
import modelo.Consulta;
import modelo.Exame;
import modelo.Medico;
import modelo.Paciente;
import modelo.Receituario;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestePersistirConsulta 
{
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirConsulta() {
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
           Consulta c= new Consulta();
           Medico m= new Medico();
           Paciente p= new Paciente();
           Exame ex= new Exame();
           Receituario r= new Receituario();
           c.setData(Calendar.getInstance());
           c.setHora(Calendar.getInstance());
           c.setPreconsulta("Razoalmente");
           c.setPosconsulta("Tomar medicamentos");
           c.setMedico(em.find(Medico.class, 2));
           c.setPaciente(em.find(Paciente.class, 1));
           c.setExame(em.find(Exame.class, 1));
           c.setReceituario(em.find(Receituario.class, 1));
           em.getTransaction().begin();
           em.persist(c);
           em.getTransaction().commit();
        } catch(Exception e) {
            resultado= false;
            e.printStackTrace();
        }
       
       Assert.assertEquals(false, resultado);
    }
}
