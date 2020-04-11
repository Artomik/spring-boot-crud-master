package com.crud.springbootcrud.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Produtor {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private String nome;
    
    private Date dtNascimento;
 
    private String nacional;
    
    private String estilo;
    
    private String descricao;

    public Produtor() {}

    public Produtor(String nome, Date dtNascimento, String nacional, String estilo, String descricao) {
        this.nome = nome;
        this.dtNascimento = dtNascimento;
        this.nacional = nacional;
        this.estilo = estilo;
        this.descricao = descricao;
    }
        
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getNacional() {
		return nacional;
	}

	public void setNacional(String nacional) {
		this.nacional = nacional;
	}

	public String getEstilo() {
		return estilo;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
    public String toString() {
		return "Produtor{" + "id=" + id + ", nome =" + nome + ", dtNascimento =" + dtNascimento + ", nacional =" + nacional + ","
				+ " estilo =" + estilo + ", descricao = " + descricao + "}";
    
	}

}
