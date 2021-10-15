package reactivefromudemy.sec06_threading_schedulers;

import java.util.ArrayList;
import java.util.List;

import reactivefromudemy.courseUtil.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec07Parallel {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();

		Flux.range(1, 1000).parallel().runOn(Schedulers.parallel())
//		.doOnNext(i -> printThreadName("next: " + i))
				.subscribe(v -> list.add(v));

		System.out.println(list.size()); // the size is not 1000, it is changing everytime
		// As arraylis is not thread safe, so it not the reactor responsibity in this
		// parallel() case

		Flux.range(1, 10).parallel().runOn(Schedulers.parallel()).doOnNext(i -> printThreadName("next : " + i))
				.sequential().subscribe(v -> printThreadName("sub : " + v));
		Util.sleepSeconds(5);
	}

	private static void printThreadName(String msg) {
		System.out.println(msg + "\t\t: Thread : " + Thread.currentThread().getName());
	}
}
