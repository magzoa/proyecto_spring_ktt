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

import py.edu.facitec.model.Post;
import py.edu.facitec.repository.PostRepository;
								
@RestController
@RequestMapping("/posts")   //afecta a todos los métodos de la clase.
public class PostController {
	
	
	@Autowired //Inicializacion
	private PostRepository postRepository;
	
				// /posts    GET
	@GetMapping //RESPONDERA AL MÉTODO GET
	public ResponseEntity<List<Post>> getAll(){
		
		List<Post> posts=new ArrayList<Post>();
	   
		posts=postRepository.findAll();
		
	try {
		return new ResponseEntity<>(posts, HttpStatus.OK);
	} catch (Exception e) {
		
	return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
		
	}
	       // /posts    post
	@PostMapping  
	public ResponseEntity<Post> guardar(@RequestBody Post post){
		
		try {
			//este metodo retorna la entidad guardada
			Post postRetorno=postRepository.save(post);
			
return new ResponseEntity<Post>(postRetorno,HttpStatus.OK);
			
		} catch (Exception e) {
			
return new ResponseEntity<>(null,HttpStatus.EXPECTATION_FAILED);				
		}
		
	}
	
			//	  /posts/1    GET    
	@GetMapping("/{id}")
	public ResponseEntity<Post> getById(@PathVariable("id") Long id){
	       Optional<Post> retorno=   postRepository.findById(id); 
	       if(retorno.isPresent()) {	   
	return new ResponseEntity<Post>(retorno.get() ,HttpStatus.OK); 
	       }else {
	    	   
	   return new ResponseEntity<>(HttpStatus.NOT_FOUND); 	   
	    	   
	       }
		    
	}
	
	
	
			//posts /1      DELETE
		
	@DeleteMapping("/{id}")
	public ResponseEntity<Post> deleteById(@PathVariable Long id){
		
	       	 try {
				postRepository.deleteById(id);  
				return new ResponseEntity<>(HttpStatus.OK);
			} catch (Exception e) {
		
				
				return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED); 
			} 
	}
}
