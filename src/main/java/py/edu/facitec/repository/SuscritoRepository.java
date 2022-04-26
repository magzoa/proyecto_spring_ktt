package py.edu.facitec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import py.edu.facitec.model.Suscrito;

public interface SuscritoRepository extends JpaRepository<Suscrito, Long> { //CLASE --> "Suscrito" y 
																			//TIPO DE DATO DE ID --> "Long"

}
 