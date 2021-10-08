package reactivefromudemy.sec02_flux;

import reactor.core.publisher.Flux;

public class Lec02MultipleSubscribers {

	public static void main(String[] args) {
		Flux<Integer> integerFlux = Flux.just(1, 2, 3, 4);

		Flux<Integer> evenInteger = integerFlux.filter(i -> i % 2 == 0);

		evenInteger.subscribe(i -> System.out.println("Even flux = " + i));

		integerFlux.subscribe(i -> System.out.println("Sub 1: " + i));
		integerFlux.subscribe(i -> System.out.println("Sub 2: " + i));
	}
}
