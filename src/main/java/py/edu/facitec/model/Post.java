package py.edu.facitec.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;


//Creación de la tabla.
@Entity
public class Post extends General{
	
	private String titulo;
	private String autor;
	private LocalDate fecha;
	private String texto;
	
	@JsonManagedReference(value = "post_comentario")
	@OneToMany(mappedBy = "post")
	private List<Comentario> comentarios;
	
	//GETTER AND SETTERS

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
	//TO STRING

	@Override
	public String toString() {
		return "Post [titulo=" + titulo + ", autor=" + autor + ", fecha=" + fecha + ", texto=" + texto
				+ ", comentarios=" + comentarios + "]";
	}
	

}
