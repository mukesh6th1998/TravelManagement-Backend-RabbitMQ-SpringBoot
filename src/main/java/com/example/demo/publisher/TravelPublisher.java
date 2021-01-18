package com.example.demo.publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.MessageConfig;
import com.example.demo.model.Travels;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TravelPublisher {
	
	@Autowired
	 RabbitTemplate temp;
	
	@PostMapping("/add")
	public String add(@RequestBody Travels travel) {
		temp.convertAndSend(MessageConfig.EXCHANGE, MessageConfig.ROUTING_KEY, travel);
		return "Journey added successfully";
	}
	
}
