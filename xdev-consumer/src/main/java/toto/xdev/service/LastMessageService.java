package toto.xdev.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import toto.xdev.modet.LastMessage;
import toto.xdev.repository.LastMessageRepository;

@Repository
public class LastMessageService {
	
	@Autowired
	private LastMessageRepository repo;

	public void addLastMessage(LastMessage e) {
		repo.save(e);
	}
	
	public List<LastMessage> getAllLastMessage() {
		return repo.findAll();
	}
	
	public void deleteLastMessage(String id) {
		repo.deleteById(id);
	}
	
	public LastMessage getLastMessage(String id) {
		System.out.println("id " + id);
		Optional<LastMessage> e = repo.findById(id);
		if(e.isPresent()) {
			return  e.get();
		} 
		return null;
	}
}
