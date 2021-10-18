package reactivefromudemy.sec10_repeat_retry;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

import reactivefromudemy.courseUtil.Util;
import reactor.core.publisher.Flux;
import reactor.util.retry.Retry;

public class Lec02RetryWithDelay {

	private static AtomicInteger atomicInteger = new AtomicInteger(1);

	public static void main(String[] args) {
		getIntegers().retryWhen(Retry.fixedDelay(2, Duration.ofSeconds(2))).subscribe(Util.subscriber());
		
		Util.sleepSeconds(60);
	}

	private static Flux<Integer> getIntegers() {
		return Flux.range(1, 3).doOnSubscribe(s -> System.out.println("Subscribed **"))
				.doOnComplete(() -> System.out.println("Completed **"))
				.map(i -> i / Util.faker().random().nextInt(0, 2)).doOnError(err -> System.out.println(" ERROR **"));
	}
}
