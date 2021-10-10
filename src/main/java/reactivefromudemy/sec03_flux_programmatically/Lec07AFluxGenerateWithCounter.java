package reactivefromudemy.sec03_flux_programmatically;

import reactivefromudemy.courseUtil.Util;
import reactor.core.publisher.Flux;

public class Lec07AFluxGenerateWithCounter {

	public static void main(String[] args) {

		// complete if country is india
		// complete if the couter is > 10

		Flux.generate(() -> 1, (counter, synchronousSink) -> {
			String country = Util.faker().country().name();
			synchronousSink.next(country);
			if (country.toLowerCase().equals("india") || counter >= 10) {
				synchronousSink.complete();
			}
			return counter + 1;
		}).subscribe(Util.subscriber());
	}

}
