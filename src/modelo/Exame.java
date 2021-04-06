package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="exame")
public class Exame implements Serializable
{   
    @Id
    @SequenceGenerator(name="seq_exame", sequenceName="seq_exame_id", allocationSize=1)
    @GeneratedValue(generator="seq_exame", strategy= GenerationType.SEQUENCE)
    private Integer id;
   
    @Column(name="nome", nullable=false)
    @NotNull(message="O nome deve ser informado")
    @NotBlank(message="O nome nao pode estar em branco")
    @Length(max=50, message="O nome nao pode ter mais de {max} caracteres")
    private String nome;
    
    @Column(name="descricao", nullable=false)
    @NotNull(message="A descricao deve ser informada")
    @NotBlank(message="A descricao nao pode estar em branco")
    @Length(max=50, message="A descricao nao pode ter mais de {max} caracteres")
    private String descricao;
    
    public Exame() {
    }

    public Integer getId() 
    {
        return id;
    }

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public String getDescricao() 
    {
        return descricao;
    }

    public void setDescricao(String descricao) 
    {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() 
    {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.id);
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
        
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Exame other = (Exame) obj;
        
        if (!Objects.equals(this.id, other.id)) 
        {
            return false;
        }
        
        return true;
    }  
}
