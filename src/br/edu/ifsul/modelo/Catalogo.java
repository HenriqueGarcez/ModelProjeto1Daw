/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author henri
*/ 
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "catalogo")
public class Catalogo implements Serializable{
      @Id
      @SequenceGenerator(name = "seq_catalogo", sequenceName = "seq_catalogo_id", allocationSize = 1)
      @GeneratedValue(generator = "seq_catalogo", strategy = GenerationType.SEQUENCE)
      private Integer id;
      @NotNull(message = "Preencha o campo nome")
      @NotBlank(message = "O nome não pode estar em branco")
      @Length(max = 40, message = "O nome não pode ter mais que {max} caracteres")
      @Column(name = "nome", length = 40, nullable = false)
      private String nome;
      @NotNull(message = "Preencha o campo descricao")
      @NotBlank(message = "O descricao não pode estar em branco")
      @Length(max = 50, message = "O descricao não pode ter mais que {max} caracteres")
      @Column(name = "descricao", length = 50, nullable = false)
      private String descricao;
      @ManyToOne
      @JoinColumn(name="livraria_id", referencedColumnName = "id", nullable = false)
      @ForeignKey(name="fk_livraria_id")
      private Livraria livraria;
      @OneToMany(mappedBy = "catalogo", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
      private List<Livro> livros = new ArrayList<>();
      
    public Catalogo(){
    
    }
    
    public void adicionarLivro(Livro obj){
    
        obj.setCatalogo(this);
        this.getLivros().add(obj);
    }
    
    public void removerCatalogo(int index){
    
        this.getLivros().remove(index);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSite() {
        return getDescricao();
    }

    public void setSite(String descricao) {
        this.setDescricao(descricao);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.id);
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
        final Catalogo other = (Catalogo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public Livraria getLivraria() {
        return livraria;
    }

    public void setLivraria(Livraria livraria) {
        this.livraria = livraria;
    }
    
      
}

