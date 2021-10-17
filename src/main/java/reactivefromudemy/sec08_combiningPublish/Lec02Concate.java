package reactivefromudemy.sec08_combiningPublish;

import reactivefromudemy.courseUtil.Util;
import reactor.core.publisher.Flux;

public class Lec02Concate {

	public static void main(String[] args) {
		
		Flux<String> flux1 = Flux.just("a", "b");
		Flux<String> flux2 = Flux.error(new RuntimeException("oops"));
		Flux<String> flux3 = Flux.just("c", "D", "E");

		// concate work only after flux completed
//		Flux<String> flux = flux1.concatWith(flux2);

//		Flux<String> flux = Flux.concat(flux1, flux2, flux3); // a b opps

		Flux<String> flux = Flux.concatDelayError(flux1, flux2, flux3); // a b c D E opps

		flux.subscribe(Util.subscriber());

	}
}
