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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="paciente")
@Inheritance(strategy= InheritanceType.JOINED)
public class Paciente implements Serializable
{
    @Id
    @SequenceGenerator(name="seq_paciente", sequenceName="seq_paciente_id", allocationSize=1)
    @GeneratedValue(generator="seq_paciente", strategy= GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name="nome", nullable=false)
    @NotNull(message="O nome deve ser informado")
    @NotBlank(message="O nome nao pode estar em branco")
    @Length(max=50, message="O nome nao pode ter mais de {max} caracteres")
    private String nome;
    
    @Column(name="nascimento", nullable=false)
    @NotNull(message="O nascimento deve ser informado")
    @Temporal(TemporalType.DATE)
    private Calendar nascimento;
    
    @Column(name="telefone", nullable=false)
    @NotNull(message="O telefone deve ser informado")
    @NotBlank(message="O telefone nao pode estar em branco")
    @Length(max=20, message="O telefone nao pode ter mais de {max} caracteres")
    private String telefone;
    
    @Column(name="seco", nullable=false)
    @NotNull(message="O sexo deve ser informado")
    @NotBlank(message="O sexo nao pode estar em branco")
    @Length(max=1, message="O sexo nao pode ter mais de {max} caracteres")
    private String sexo;
   
    @Column(name="historico", nullable=false)
    @NotNull(message="O historico deve ser informado")
    @NotBlank(message="O historico nao pode estar em branco")
    @Length(max=50, message="O historico nao pode ter mais de {max} caracteres")
    private String historico;
    
    @Column(name="peso", nullable=false)
    @NotNull(message="O peso deve ser informado")
    private Double peso;
   
    @Column(name="altura", nullable=false)
    @NotNull(message="A altura deve ser informada")
    private Double altura;

    public Paciente() {
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

    public Calendar getNascimento() 
    {
        return nascimento;
    }

    public void setNascimento(Calendar nascimento) 
    {
        this.nascimento = nascimento;
    }

    public String getTelefone()
    {
        return telefone;
    }

    public void setTelefone(String telefone) 
    {
        this.telefone = telefone;
    }

    public String getSexo() 
    {
        return sexo;
    }

    public void setSexo(String sexo) 
    {
        this.sexo = sexo;
    }

    public String getHistorico() 
    {
        return historico;
    }

    public void setHistorico(String historico) 
    {
        this.historico = historico;
    }

    public Double getPeso() 
    {
        return peso;
    }

    public void setPeso(Double peso) 
    {
        this.peso = peso;
    }

    public Double getAltura() 
    {
        return altura;
    }

    public void setAltura(Double altura)
    {
        this.altura = altura;
    }

    @Override
    public int hashCode() 
    {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.id);
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
        
        final Paciente other = (Paciente) obj;
        
        if (!Objects.equals(this.id, other.id)) 
        {
            return false;
        }
        return true;
    }   
}
