package reactivefromudemy.sec04_operators;

import java.time.Duration;

import reactivefromudemy.courseUtil.Util;
import reactor.core.publisher.Flux;

public class Lec07TimeOut {

	public static void main(String[] args) {
		getOrderNumbers().timeout(Duration.ofSeconds(2), fallback()).subscribe(Util.subscriber());

		Util.sleepSeconds(60);
	}

	private static Flux<Integer> getOrderNumbers() {
		return Flux.range(1, 10).delayElements(Duration.ofSeconds(1));
	}

	private static Flux<Integer> fallback() {
		return Flux.range(800, 1000).delayElements(Duration.ofSeconds(2));
	}
}
