package reactivefromudemy.sec09_batching;

import java.time.Duration;

import reactivefromudemy.courseUtil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec04Window {

	public static void main(String[] args) {

		// Buffer give list of data, where as window give the flux of data

		eventStream()
//		.window(5)
		.window(Duration.ofSeconds(2))
		.flatMap(flux -> saveEvents(flux)).subscribe(Util.subscriber());

		Util.sleepSeconds(60);
	}

	private static Flux<String> eventStream() {
		return Flux.interval(Duration.ofMillis(300)).map(i -> "event : " + i);
	}

	// by then() operator it give a signal of complete
	private static Mono<Void> saveEvents(Flux<String> flux) {
		return flux.doOnNext(e -> System.out.println("Saving : " + e)).doOnComplete(() -> {
			System.out.println("saving this batch");
			System.out.println("------------------");
		}).then();
	}
}
