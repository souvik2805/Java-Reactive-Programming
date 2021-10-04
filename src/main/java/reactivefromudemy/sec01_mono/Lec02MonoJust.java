package reactivefromudemy.sec01_mono;

import reactor.core.publisher.Mono;

public class Lec02MonoJust {

	public static void main(String[] args) {

		// publisher
		Mono<Integer> mono = Mono.just(1);

		System.out.println(mono); // MonoJust

		// In Reactive Programming nothing happen until you subscribe
		mono.subscribe(i -> System.out.println("Received : " + i));

	}
}
