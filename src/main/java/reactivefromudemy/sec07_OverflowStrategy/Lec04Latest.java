package reactivefromudemy.sec07_OverflowStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import reactivefromudemy.courseUtil.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec04Latest {

	public static void main(String[] args) {

		// 75 % 16 => 12
		System.setProperty("reactor.bufferSize.small", "16");

		Flux.create(fluxSink -> {
			for (int i = 1; i < 201; i++) {
				fluxSink.next(i);
				System.out.println("Pushed: " + i);
				Util.sleepMillis(1);
			}
			fluxSink.complete();
		}).
		onBackpressureLatest() // Latest value
		.publishOn(Schedulers.boundedElastic()).doOnNext(i -> {
			Util.sleepMillis(10);
		}).subscribe(Util.subscriber());

		Util.sleepSeconds(10);
	}
}
