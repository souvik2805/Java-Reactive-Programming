package reactivefromudemy.sec02_flux;

import java.util.List;
import java.util.stream.Stream;

import reactivefromudemy.courseUtil.Util;
import reactor.core.publisher.Flux;

public class Lec04FluxFromStream {

	public static void main(String[] args) {
		List<Integer> list = List.of(1, 2, 3, 4, 5);

		Stream<Integer> stream = list.stream();

		// stream.forEach(System.out::println);
		// stream.forEach(System.out::println); //stream has already been operated upon
		// or closed

		Flux<Integer> integerFlux = Flux.fromStream(stream);
		integerFlux.subscribe(Util.onNext());

		integerFlux.subscribe(Util.onNext()); // stream has already been operated upon or closed

		// Solution
		Flux<Integer> integerFlux2 = Flux.fromStream(() -> list.stream());
	}
}
