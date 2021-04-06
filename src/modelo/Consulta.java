package modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="consulta")
@Inheritance(strategy= InheritanceType.JOINED)
public class Consulta implements Serializable
{
    @Id
    @SequenceGenerator(name="seq_consulta", sequenceName="seq_consulta_id", allocationSize=1)
    @GeneratedValue(generator="seq_consulta", strategy= GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name="data", nullable=false)
    @NotNull(message="A data deve ser informada")
    @Temporal(TemporalType.DATE)
    private Calendar data;
    
    @Column(name="hora", nullable=false)
    @NotNull(message="A hora deve ser informada")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar hora;
    
    @Column(name="preconsulta", nullable=false)
    @NotNull(message="A preconsulta deve ser informada")
    @NotBlank(message="A preconsulta nao pode estar em branco")
    @Length(max=50, message="A preconsulta nao pode ter mais de {max} caracteres")
    private String preconsulta;
    
    @Column(name="posconsulta", nullable=false)
    @NotNull(message="A posconsulta deve ser informada")
    @NotBlank(message="A posconsulta nao pode estar em branco")
    @Length(max=50, message="A posconsulta nao pode ter mais de {max} caracteres")
    private String posconsulta;
    
    @NotNull(message="O medico deve ser informado")
    @ManyToOne
    @JoinColumn(name="medico", referencedColumnName="id", nullable=false)
    @ForeignKey(name="fk_medico_id")
    private Medico medico;
    
    @NotNull(message="O paciente deve ser informado")
    @ManyToOne
    @JoinColumn(name="paciente", referencedColumnName="id", nullable=false)
    @ForeignKey(name="fk_paciente_id")
    private Paciente paciente;
    
    @NotNull(message="O exame deve ser informado")
    @ManyToOne
    @JoinColumn(name="exame", referencedColumnName="id", nullable=false)
    @ForeignKey(name="fk_exame_id")
    private Exame exame;
    
    @NotNull(message="O receituario deve ser informado")
    @ManyToOne
    @JoinColumn(name="receituario", referencedColumnName="id", nullable=false)
    @ForeignKey(name="fk_receituario_id")
    private Receituario receituario;
    
    public Consulta() {
    }
    
    public Integer getId() 
    {
        return id;
    }

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Calendar getData() 
    {
        return data;
    }

    public void setData(Calendar data) 
    {
        this.data = data;
    }
    
    public Calendar getHora() 
    {
        return hora;
    }

    public void setHora(Calendar hora) 
    {
        this.hora = hora;
    }

    public String getPreconsulta() 
    {
        return preconsulta;
    }

    public void setPreconsulta(String preconsulta) 
    {
        this.preconsulta = preconsulta;
    }

    public String getPosconsulta() 
    {
        return posconsulta;
    }

    public void setPosconsulta(String posconsulta) 
    {
        this.posconsulta = posconsulta;
    }

    public Medico getMedico() 
    {
        return medico;
    }

    public void setMedico(Medico medico) 
    {
        this.medico = medico;
    }

    public Paciente getPaciente() 
    {
        return paciente;
    }

    public void setPaciente(Paciente paciente) 
    {
        this.paciente = paciente;
    }
    
    public Exame getExame() 
    {
        return exame;
    }

    public void setExame(Exame exame) 
    {
        this.exame = exame;
    }
    
    public Receituario getReceituario() 
    {
        return receituario;
    }

    public void setReceituario(Receituario receituario) 
    {
        this.receituario = receituario;
    }

    @Override
    public int hashCode() 
    {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) 
    {
        if (this == obj) 
        {
            return true;
        }
        
        if (obj == null) 
        {
            return false;
        }
        
        if (getClass() != obj.getClass()) 
        {
            return false;
        }
        
        final Consulta other = (Consulta) obj;
        
        if (!Objects.equals(this.id, other.id)) 
        {
            return false;
        }
        
        return true;
    }    
}
