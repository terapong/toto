package toto.xdev.controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import toto.xdev.modet.LastMessage;
import toto.xdev.modet.Message;
import toto.xdev.service.MessageService;
import toto.xdev.service.LastMessageService;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Consumer {
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private LastMessageService lastMessageService;
	
	@RabbitListener(queues = "queue.A")
	private void receive(Message message) {
		
		Calendar cal;
		cal = Calendar.getInstance();
		
		message.setUpdateDate(cal.getTime());
		messageService.addMessage(message);
		
		//delete all lastMessage
		
		//insert lastMessage
		
		LastMessage lastMessage = new LastMessage();
		lastMessage.setHumidity(message.getHumidity());
		lastMessage.setTemperature(message.getTemperature());
		lastMessage.setName(message.getName());
		lastMessage.setUpdateDate(message.getUpdateDate());
		
		
		List<LastMessage> lastMessages = lastMessageService.getAllLastMessage();
		
		if(lastMessages.size() == 0) {
			lastMessageService.addLastMessage(lastMessage);
		} else {
			LastMessage m = lastMessages.get(0);
			lastMessageService.deleteLastMessage(m.getId());
			lastMessageService.addLastMessage(lastMessage);
		}

//		System.out.println("Name : " + message.getName());
//		System.out.println("Temperature : " + message.getTemperature());
//		System.out.println("Humidity : " + message.getHumidity());
//		System.out.println("Update date : " + message.getUpdateDate());
//		System.out.println("Message received from QUEUE A -> " + message);
//		System.out.println("");
	}
	
//	@RabbitListener(queues = "queue.B")
//	private void receiveFromB(Message message) {
//		System.out.println("Name : " + message.getName());
//		System.out.println("Temperature : " + message.getTemperature());
//		System.out.println("Humidity : " + message.getHumidity());
//		
//		System.out.println("Message received from QUEUE B -> " + message);
//		System.out.println("");
//	}
//	
//	@RabbitListener(queues = "queue.C")
//	private void receiveFromC(Message message) {
//		System.out.println("Name : " + message.getName());
//		System.out.println("Temperature : " + message.getTemperature());
//		System.out.println("Humidity : " + message.getHumidity());
//		
//		System.out.println("Message received from QUEUE C -> " + message);
//		System.out.println("");
//	}
//	
//	@RabbitListener(queues = "queue.all")
//	private void receiveFromAll(Message message) {
//		System.out.println("Name : " + message.getName());
//		System.out.println("Temperature : " + message.getTemperature());
//		System.out.println("Humidity : " + message.getHumidity());
//		
//		System.out.println("Message received from QUEUE All -> " + message);
//		System.out.println("");
//	}
}
