package reactivefromudemy.sec09_batching;

import java.time.Duration;

import reactivefromudemy.courseUtil.Util;
import reactor.core.publisher.Flux;

public class Lec05Group {

	public static void main(String[] args) {
		Flux.range(1, 30).delayElements(Duration.ofSeconds(1)).groupBy(i -> i % 2)
				.subscribe(groupFlux -> process(groupFlux, groupFlux.key()));

		Util.sleepSeconds(60);
	}

	private static void process(Flux<Integer> flux, int key) {
		System.out.println("called");
		flux.subscribe(i -> System.out.println("Key : " + key + ", item: " + i));
	}
}
