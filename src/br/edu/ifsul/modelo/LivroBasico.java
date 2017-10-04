/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author henri
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "livro_basico") 
public class LivroBasico implements Serializable {
    @Id
    @Length(max = 12, message = "O ISBN não pode ter mais que {max} caracteres")
    @Column(name = "ISBN", length = 12, nullable = false)
    private String ISBN;
    @NotNull(message = "Preencha o campo titulo")
    @NotBlank(message = "O titulo não pode estar em branco")
    @Length(max = 40, message = "O titulo não pode ter mais que {max} caracteres")
    @Column(name = "titulo", length = 50, nullable = false)
    private String titulo;
    @Column(name = "resumo", nullable = true, columnDefinition = "text" )
    private String resumo;
    @NotNull(message = "Preencha o campo editora")
    @NotBlank(message = "A editora não pode estar em branco")
    @Column(name = "editora", length = 50, nullable = false)
    private String editora;
    @Temporal(TemporalType.DATE)
    @Column(name = "data_publicacao")
    private Calendar dataPublicacao;

    @ManyToMany
    @JoinTable(name = "autoria",
                joinColumns = @JoinColumn(name = "livro_basico", referencedColumnName = "ISBN", nullable=false),
                inverseJoinColumns = @JoinColumn(name = "autor", referencedColumnName = "id", nullable=false))
    private List<Autor> autores = new ArrayList<>();

    
    public LivroBasico(){
    }
    

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }
    

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Calendar getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Calendar dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.ISBN);
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
        final LivroBasico other = (LivroBasico) obj;
        if (!Objects.equals(this.ISBN, other.ISBN)) {
            return false;
        }
        return true;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }
    
    
    
    
    
}
