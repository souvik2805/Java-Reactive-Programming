package reactivefromudemy.sec10_repeat_retry;

import java.util.concurrent.atomic.AtomicInteger;

import reactivefromudemy.courseUtil.Util;
import reactor.core.publisher.Flux;

public class Lec01Repeat {

	private static AtomicInteger atomicInteger = new AtomicInteger(1);

	public static void main(String[] args) {
		getIntegers()
		//.repeat(2) // 2 more time
		.repeat(()->atomicInteger.get() < 14)
				.subscribe(Util.subscriber());
	}

	private static Flux<Integer> getIntegers() {
		return Flux.range(1, 3).doOnSubscribe(s -> System.out.println("Subscribed **"))
				.doOnComplete(() -> System.out.println("Completed **")).map(i -> atomicInteger.getAndIncrement());
	}
}
