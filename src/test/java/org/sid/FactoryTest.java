package org.sid;


import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.internal.runners.statements.ExpectException;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class FactoryTest {
	
	@Test
	public void shoudRetourn_allNames(){
		//given
		Factory factory = new Factory();
		//when
		Flux<String> names= 	factory.nameOfProducts();
		//then 
		StepVerifier.create(names.log()).expectNextCount(3)
		         .verifyComplete();
	}

	@Test
	public void shoudRetourn_allProduce(){
		//given
		Factory factory = new Factory();
		Product the_first  = Product.builder().id(0).name("bean").price(10).build();
		Product the_second = Product.builder().id(1).name("java").price(15).build();
		Product the_third  = Product.builder().id(2).name("black bean").price(7).build();
		//when
		Flux<Product> products= 	factory.produce();
		//then
		 StepVerifier.create(products.log())
		 .expectNext(the_first)
		 .expectNext(the_second)
		 .expectNext(the_third)
		         .verifyComplete();
	}
}
