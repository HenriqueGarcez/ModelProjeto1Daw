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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author henri
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "livro")
public class Livro extends LivroBasico implements Serializable {
    @NotNull(message = "Preencha o campo codigo de barras")
    @NotBlank(message = "O codigo de barras não pode estar em branco")
    @Length(max = 20, message = "O codigo de darras não pode ter mais que {max} caracteres")
    @Column(name = "codigoBarras", length = 20, nullable = false)
    private String codigoBarras;
    @Column(name = "numeroPaginas", columnDefinition = "integer" )
    private Integer numeroPaginas;
    @Column( name = "ativo")
    private Boolean ativo;
    @Temporal(TemporalType.DATE)
    @Column(name = "dataCadastro")
    private Calendar dataCadastro;
    @Column(name = "valor", columnDefinition = "numeric(10,2)", nullable = false)
    private Double valor;
    @ManyToOne
    @JoinColumn(name="catalogo_id", referencedColumnName = "id", nullable = false)
    @ForeignKey(name="fk_catalogo_id")
    private Catalogo catalogo;
    @ManyToOne
    @JoinColumn(name="idioma_id", referencedColumnName = "id", nullable = false)
    @ForeignKey(name="fk_idioma_id")
    private Idioma idioma;
    @ManyToOne
    @JoinColumn(name="formato_id", referencedColumnName = "id", nullable = false)
    @ForeignKey(name="fk_formato_id")
    private Formato formato;
    
    public Livro(){
        
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(Integer numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Calendar getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Calendar dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public Formato getFormato() {
        return formato;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }

    
    
    
}
