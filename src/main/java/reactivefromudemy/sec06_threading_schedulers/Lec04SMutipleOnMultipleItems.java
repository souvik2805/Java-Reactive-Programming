package reactivefromudemy.sec06_threading_schedulers;

import reactivefromudemy.courseUtil.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec04SMutipleOnMultipleItems {

	public static void main(String[] args) {

		Flux<Object> flux = Flux.create(fluxSink -> {
			printThreadName("create");
			for (int i = 0; i < 4; i++) {
				fluxSink.next(i);
			}
			fluxSink.complete();
		}).doOnNext(i -> printThreadName("next:" + i));

		flux.subscribeOn(Schedulers.parallel()).subscribe(v -> printThreadName("sub " + v));
		flux.subscribeOn(Schedulers.boundedElastic()).subscribe(v -> printThreadName("sub " + v));

		Util.sleepSeconds(5);
	}

	private static void printThreadName(String msg) {
		System.out.println(msg + "\t\t: Thread : " + Thread.currentThread().getName());
	}
}
