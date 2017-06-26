package Putlock;

import org.springframework.data.repository.CrudRepository;

public interface putRepository extends CrudRepository<Putlock, Long> {

	Iterable<Putlock>findByName(String name);
        
}
