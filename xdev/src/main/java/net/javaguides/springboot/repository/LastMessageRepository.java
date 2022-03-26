package net.javaguides.springboot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.LastMessage;

@Repository
public interface LastMessageRepository extends MongoRepository<LastMessage, String> {
	//LastMessage findByMessage(String id);
}
