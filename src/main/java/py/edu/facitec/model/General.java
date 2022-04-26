package py.edu.facitec.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

//Clase padre
//Atributos a utilizarse dentro de la herencia
@MappedSuperclass
public abstract class General {
	
	@Id //Clave primaria
	
	//Generacion automatica
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

}
