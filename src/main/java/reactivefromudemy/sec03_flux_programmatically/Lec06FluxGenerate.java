package reactivefromudemy.sec03_flux_programmatically;

import reactivefromudemy.courseUtil.Util;
import reactor.core.publisher.Flux;

public class Lec06FluxGenerate {

	public static void main(String[] args) {

		// Generate is like a while loop(util complete or error happen), so only one
		// synchronousSink possible
		Flux.generate(synchronousSink -> {
			System.out.println("Emitting.");
			synchronousSink.next(Util.faker().country().name());
//			synchronousSink.complete();
//			synchronousSink.error(new RuntimeException("ddd"));
		}).take(4).subscribe(Util.subscriber());
	}
}
