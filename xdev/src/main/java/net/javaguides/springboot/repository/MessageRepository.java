package net.javaguides.springboot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Message;

@Repository
public interface MessageRepository extends MongoRepository<Message, String> {
	//Message findByMessage(String id);
}
