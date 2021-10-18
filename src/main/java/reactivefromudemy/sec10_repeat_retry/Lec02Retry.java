package reactivefromudemy.sec10_repeat_retry;

import java.util.concurrent.atomic.AtomicInteger;

import reactivefromudemy.courseUtil.Util;
import reactor.core.publisher.Flux;

public class Lec02Retry {

	private static AtomicInteger atomicInteger = new AtomicInteger(1);

	public static void main(String[] args) {
		getIntegers().retry(2).subscribe(Util.subscriber());
	}

	private static Flux<Integer> getIntegers() {
		return Flux.range(1, 3).doOnSubscribe(s -> System.out.println("Subscribed **"))
				.doOnComplete(() -> System.out.println("Completed **"))
				.map(i -> i / Util.faker().random().nextInt(0, 2)).doOnError(err -> System.out.println(" ERROR **"));
	}
}
