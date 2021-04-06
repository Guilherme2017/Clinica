package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="receituario")
public class Receituario implements Serializable
{
    @Id
    @SequenceGenerator(name="seq_receituario", sequenceName="seq_receituario_id", allocationSize=1)
    @GeneratedValue(generator="seq_receituario", strategy= GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name="posologia", nullable=false)
    @NotNull(message="A posologia deve ser informada")
    @NotBlank(message="A posologia nao pode estar em branco")
    @Length(max=50, message="A posologia nao pode ter mais de {max} caracteres")
    private String posologia;
    
    @Column(name="validade", nullable=false)
    @NotNull(message="A validade deve ser informada")
    @Temporal(TemporalType.DATE)
    private Calendar validade;
    
    @ManyToMany
    @JoinTable(name="receitar", joinColumns= @JoinColumn(name="medicamento", referencedColumnName="id", 
               nullable=false), inverseJoinColumns= @JoinColumn(name="receituario", referencedColumnName="id",
               nullable=false)) 
    private List<Medicamento> receitar = new ArrayList<>();

    public Receituario() {
    }

    public Integer getId() 
    {
        return id;
    }

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public String getPosologia() 
    {
        return posologia;
    }

    public void setPosologia(String posologia) 
    {
        this.posologia = posologia;
    }

    public Calendar getValidade() 
    {
        return validade;
    }

    public void setValidade(Calendar validade) 
    {
        this.validade = validade;
    }

    public List<Medicamento> getReceitar() 
    {
        return receitar;
    }

    public void setReceitar(List<Medicamento> receitar) 
    {
        this.receitar = receitar;
    }

    @Override
    public int hashCode() 
    {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        
        final Receituario other = (Receituario) obj;
        
        if (!Objects.equals(this.id, other.id)) 
        {
            return false;
        }
        
        return true;
    }   
}
