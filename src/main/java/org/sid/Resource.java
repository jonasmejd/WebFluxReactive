package org.sid;

import java.time.Duration;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class Resource {

	private Factory factory;
	
	
	public Resource(Factory factory) {
		this.factory = factory;
	}
	
	@GetMapping(value = "/products" ,produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Product> getAllProcuct(){
		Flux<Long> interval=Flux.interval(Duration.ofMillis(1000));
		Flux<Product> products= factory.produce();
		return Flux.zip(interval,products).map(
				data ->{
					return data.getT2();
				}).share();
	}
	
	@GetMapping(value = "/names")
	public Flux<String> getAllNames(){
		return factory.nameOfProducts();
	}	
}


