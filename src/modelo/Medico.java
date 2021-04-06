package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="medico")
@Inheritance(strategy= InheritanceType.JOINED)
public class Medico extends Paciente implements Serializable 
{
    @Column(name="crm", nullable=false)
    @NotNull(message="O crm deve ser informado")
    @NotBlank(message="O crm nao pode estar em branco")
    @Length(max=20, message="O crm nao pode ter mais de {max} caracteres")
    private String crm;
    
    @NotNull(message="A especialidade deve ser informada")
    @ManyToOne
    @JoinColumn(name="especialidade", referencedColumnName="id", nullable=false)
    @ForeignKey(name="fk_especialidade_id")
    private Especialidade especialidade;

    public Medico() {
    }

    public String getCrm() 
    {
        return crm;
    }

    public void setCrm(String crm) 
    {
        this.crm = crm;
    }

    public Especialidade getEspecialidade() 
    {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) 
    {
        this.especialidade = especialidade;
    }  
}
