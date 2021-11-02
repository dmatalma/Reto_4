package co.usa.ciclo3.reto4.repository.crud;

import co.usa.ciclo3.reto4.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message,Integer> {
}
