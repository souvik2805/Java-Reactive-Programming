package reactivefromudemy.sec04_operators;

import reactivefromudemy.courseUtil.Util;
import reactor.core.publisher.Flux;

public class Lec01Handle {

	public static void main(String[] args) {
		// handle = filter + map
		Flux.range(1, 20).handle((integer, synchronousSink) -> {
			if (integer % 2 == 0) {
				synchronousSink.next(integer); // filter
			} else {
				synchronousSink.next(integer + "a"); // map
			}
		}).subscribe(Util.subscriber());

		Flux.range(1, 20).handle((integer, synchronousSink) -> {
			if (integer == 7) {
				synchronousSink.complete(); // filter
			} else {
				synchronousSink.next(integer); // map
			}
		}).subscribe(Util.subscriber());
	}
}
