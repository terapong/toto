package net.javaguides.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Message;
import net.javaguides.springboot.repository.MessageRepository;

@Repository
public class MessageService {

	@Autowired
	private MessageRepository repo;
	
	public void addMessage(Message e) {
		repo.save(e);
	}
	
	public List<Message> getAllMessage() {
		return repo.findAll();
	}
	
	public void deleteMessage(String id) {
		repo.deleteById(id);
	}
	
	public Message getMessage(String id) {
		System.out.println("id " + id);
		Optional<Message> e = repo.findById(id);
		if(e.isPresent()) {
			return  e.get();
		} 
		return null;
	}//db.message.find().sort({_id:-1}).limit(1);
	
//	public Message getLastMessage() {
//		Optional<Message> e = repo.fi
//		System.out.print("Last message: ");
//	}
}
