package com.crud.springbootcrud.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Music {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private String genero;
    
    private String produtor;
 
    private String musica;
    
    private String gravadora;

    public Music() {}

    public Music(String genero, String produtor, String musica, String gravadora) {
        this.genero = genero;
        this.produtor = produtor;
        this.musica = musica;
        this.gravadora = gravadora;
    }
    
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getProdutor() {
		return produtor;
	}

	public void setProdutor(String produtor) {
		this.produtor = produtor;
	}

	public String getMusica() {
		return musica;
	}

	public void setMusica(String musica) {
		this.musica = musica;
	}

	public String getGravadora() {
		return gravadora;
	}

	public void setGravadora(String gravadora) {
		this.gravadora = gravadora;
	}
	@Override
    public String toString() {
		return "Music{" + "id=" + id + ", produtor=" + produtor + ", musica =" + musica + ","
				+ " gravadora=" + gravadora + '}';
    
	}

}
