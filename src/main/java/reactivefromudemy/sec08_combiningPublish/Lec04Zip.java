package reactivefromudemy.sec08_combiningPublish;

import reactivefromudemy.courseUtil.Util;
import reactivefromudemy.sec08_combiningPublish.helper.AmericanAirlines;
import reactivefromudemy.sec08_combiningPublish.helper.Emirates;
import reactivefromudemy.sec08_combiningPublish.helper.QatarFlights;
import reactor.core.publisher.Flux;

public class Lec04Zip {

	public static void main(String[] args) {

		Flux.zip(getBody(), getTires(), getEngine()).subscribe(Util.subscriber());


	}

	private static Flux<String> getBody() {
		return Flux.range(1, 5).map(i -> "body");
	}

	private static Flux<String> getEngine() {
		return Flux.range(1, 2).map(i -> "engine");
	}

	private static Flux<String> getTires() {
		return Flux.range(1, 5).map(i -> "tires");
	}
}
