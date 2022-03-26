package toto.xdev.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import toto.xdev.modet.LastMessage;

@Repository
public interface LastMessageRepository extends MongoRepository<LastMessage, String> {
	//LastMessage findByMessage(String id);
}
