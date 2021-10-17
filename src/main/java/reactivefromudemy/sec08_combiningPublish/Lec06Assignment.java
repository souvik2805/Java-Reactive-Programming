package reactivefromudemy.sec08_combiningPublish;

import java.time.Duration;

import reactivefromudemy.courseUtil.Util;
import reactivefromudemy.sec08_combiningPublish.helper.AmericanAirlines;
import reactivefromudemy.sec08_combiningPublish.helper.Emirates;
import reactivefromudemy.sec08_combiningPublish.helper.QatarFlights;
import reactor.core.publisher.Flux;

public class Lec06Assignment {

	public static void main(String[] args) {
		final int carPrice = 10000;

		Flux.combineLatest(monthStream(), demandStream(), (month, demand) -> {
			return (carPrice - (month * 100)) * demand;
		}).subscribe(Util.subscriber());

		Util.sleepSeconds(10);
	}

	private static Flux<Long> monthStream() {
		return Flux.interval(Duration.ZERO, Duration.ofSeconds(1));
	}

	private static Flux<Double> demandStream() {
		return Flux.interval(Duration.ofSeconds(3)).map(i -> Util.faker().random().nextInt(80, 120) / 100d)
				.startWith(1d);
	}

}
