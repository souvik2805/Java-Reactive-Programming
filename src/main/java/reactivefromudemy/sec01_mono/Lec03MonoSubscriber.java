package reactivefromudemy.sec01_mono;

import reactivefromudemy.courseUtil.Util;
import reactor.core.publisher.Mono;

public class Lec03MonoSubscriber {

	public static void main(String[] args) {

		// Publisher
		// Mono<String> mono = Mono.just("ball").map(l -> l / 0);

		Mono<Integer> mono = Mono.just(1).map(l -> l / 0);

		// 1
		mono.subscribe(item -> System.out.println(item), err -> System.out.println(err.getMessage()),
				() -> System.out.println("Completed"));

		// 2
		mono.subscribe(Util.onNext(), Util.OnError(), Util.OnComplete());

	}
}
