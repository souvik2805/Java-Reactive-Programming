package reactivefromudemy.sec02_flux;

import java.time.Duration;

import reactivefromudemy.courseUtil.Util;
import reactor.core.publisher.Flux;

public class Lec08FluxInterval {
	public static void main(String[] args) {

		// Periodically excuting code
		// Example: In Stock market if you want to update the user regarding the stock
		// price
		// then this method is very helpfull
		
		Flux.interval(Duration.ofSeconds(1)).subscribe(Util.onNext());
		
		Util.sleepSeconds(5);
	}
}
