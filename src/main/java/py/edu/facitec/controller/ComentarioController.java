package py.edu.facitec.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import py.edu.facitec.model.Comentario;
import py.edu.facitec.repository.ComentarioRepository;
								
@RestController
@RequestMapping("/comentarios")   //afecta a todos los métodos de la clase.
public class ComentarioController {
	
	
	@Autowired //Inicializacion
	private ComentarioRepository comentarioRepository;
	
				// /comentarios    GET
	@GetMapping //RESPONDERA AL MÉTODO GET
	public ResponseEntity<List<Comentario>> getAll(){
		
		List<Comentario> comentarios=new ArrayList<Comentario>();
	   
		comentarios=comentarioRepository.findAll();
		
	try {
		return new ResponseEntity<>(comentarios, HttpStatus.OK);
	} catch (Exception e) {
		
	return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
		
	}
	       // /comentarios    comentario
	@PostMapping  
	public ResponseEntity<Comentario> guardar(@RequestBody Comentario comentario){
		
		try {
			//este metodo retorna la entidad guardada
			Comentario comentarioRetorno=comentarioRepository.save(comentario);
			
return new ResponseEntity<Comentario>(comentarioRetorno,HttpStatus.OK);
			
		} catch (Exception e) {
			
return new ResponseEntity<>(null,HttpStatus.EXPECTATION_FAILED);				
		}
		
	}
	
			//	  /comentarios/1    GET    
	@GetMapping("/{id}")
	public ResponseEntity<Comentario> getById(@PathVariable("id") Long id){
	       Optional<Comentario> retorno=   comentarioRepository.findById(id); 
	       if(retorno.isPresent()) {	   
	return new ResponseEntity<Comentario>(retorno.get() ,HttpStatus.OK); 
	       }else {
	    	   
	   return new ResponseEntity<>(HttpStatus.NOT_FOUND); 	   
	    	   
	       }
		    
	}
	
	
	
			//comentarios /1      DELETE
		
	@DeleteMapping("/{id}")
	public ResponseEntity<Comentario> deleteById(@PathVariable Long id){
		
	       	 try {
				comentarioRepository.deleteById(id);  
				return new ResponseEntity<>(HttpStatus.OK);
			} catch (Exception e) {
		
				
				return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED); 
			} 
	}
}
