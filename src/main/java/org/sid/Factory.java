package org.sid;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import reactor.core.publisher.Flux;

@Component
public class Factory {
	public Flux<Product> produce(){
		
		List<Product> list_product =  new ArrayList<>();
		list_product.add(Product.builder().id(0).name("bean").price(10).build());
		list_product.add(Product.builder().id(1).name("java").price(15).build());
		list_product.add(Product.builder().id(2).name("black bean").price(7).build());
		Flux<Product> Products_1 = Flux.fromIterable(list_product);
		
		return Products_1; 
	}
	
	public Flux<String> nameOfProducts(){
		return Flux.just("bean","java","black bean");
		
	}
}
