package py.edu.facitec.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import py.edu.facitec.model.Suscrito;
import py.edu.facitec.repository.SuscritoRepository;



			// URL a la cual va responder
//Controlador es un intermediario entre el servidor
//y el cliente
@RequestMapping("/suscritos")
@RestController
public class SuscritoControllerOld {
	
	//Dao
	@Autowired //Iniciar o crear el objeto.
	//Injección de dependencia.
	//Spring Boot gestionaria el objeto
	private SuscritoRepository suscritoRepository;
	
	//Retorna la lista de suscritos en formato JSON.
	//URL /suscritos  verbo: GET
@GetMapping	
public List<Suscrito>	suscritos(){
	
	System.out.println("Listando elementos");
	List<Suscrito> retorno=suscritoRepository.findAll();
	
	return retorno;
}
	//Value   Agregar una url al establecido más arriba por RequestMapping
// URL   /suscritos/3x   método: GET
@GetMapping(value = "/{codigo}")
public Optional<Suscrito> obtenerSuscrito(@PathVariable Long codigo){
	
Optional<Suscrito> retorno=suscritoRepository.findById(codigo);
	
return retorno;
}


//Value   Agregar una url al establecido más arriba por RequestMapping
//URL   /suscritos/3x   método: DELETE
@DeleteMapping(value = "/eliminar/{codigo}")
public void eliminarSuscrito(@PathVariable Long codigo){
	
	suscritoRepository.deleteById(codigo);

}


@PostMapping
public Suscrito registrar(@RequestBody Suscrito suscrito) {
	
	System.out.println("Registrando un Suscrito");
	
	Suscrito retorno=suscritoRepository.save(suscrito);
	
	
	return retorno;
	
}








	
		
	
	
	
	
	

}
