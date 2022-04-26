package py.edu.facitec.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Comentario extends General {
	
	
	private String texto;
	
	private Integer estrellas;
	
	//MUCHOS A UNO
	//
	@ManyToOne
	private Suscrito suscrito;
	
	//MUCHOS A UNO
	
	@JsonBackReference(value = "post_comentario")
	@ManyToOne
	private Post post;
	
	//GETTER AND SETTERS

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Integer getEstrellas() {
		return estrellas;
	}

	public void setEstrellas(Integer estrellas) {
		this.estrellas = estrellas;
	}

	public Suscrito getSuscrito() {
		return suscrito;
	}

	public void setSuscrito(Suscrito suscrito) {
		this.suscrito = suscrito;
	}
	
	//TO STRING

	@Override
	public String toString() {
		return "Comentario [texto=" + texto + ", estrellas=" + estrellas + ", suscrito=" + suscrito + "]";
	}

}
