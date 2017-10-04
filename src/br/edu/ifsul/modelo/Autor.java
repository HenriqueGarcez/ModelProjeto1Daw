/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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

/**
 *
 * @author henri
 */
@Entity
@Table(name = "autor")
public class Autor implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_autor", sequenceName = "seq_autor_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_autor", strategy = GenerationType.SEQUENCE)
    private Integer Id;
    @NotNull(message = "Preencha o campo nome")
    @NotBlank(message = "O nome não pode estar em branco")
    @Length(max = 11, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name = "nome", length = 11, nullable = false)
    private String nome;
    @Column(name = "bibliografia", nullable = true, columnDefinition = "text")
    private String bibliografia;
    @ManyToMany
    @JoinTable(name = "autoria",
                    joinColumns = @JoinColumn(name = "autor", referencedColumnName = "id", nullable = false),
                    inverseJoinColumns = @JoinColumn(name = "livro_basico", referencedColumnName = "ISBN", nullable=false))
    private List<LivroBasico> livros = new ArrayList<>();
    
    public Autor(){
    
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBibliografia() {
        return bibliografia;
    }

    public void setBibliografia(String bibliografia) {
        this.bibliografia = bibliografia;
    }
    
    

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.Id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Autor other = (Autor) obj;
        if (!Objects.equals(this.Id, other.Id)) {
            return false;
        }
        return true;
    }

    public List<LivroBasico> getLivros() {
        return livros;
    }

    public void setLivros(List<LivroBasico> livros) {
        this.livros = livros;
    }
    
    
    
    
}
