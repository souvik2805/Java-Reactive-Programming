package reactivefromudemy.sec07_OverflowStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import reactivefromudemy.courseUtil.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec03CapturingDroppedValues {

	public static void main(String[] args) {

		List<Object> list = new ArrayList<>();
//		Queues
		// system.getProperty("reactor.bufferSize.small", "256"))

		// 75 % 16 => 12
		System.setProperty("reactor.bufferSize.small", "16");

		Flux.create(fluxSink -> {
			for (int i = 1; i < 501; i++) {
				fluxSink.next(i);
				System.out.println("Pushed: " + i);
				Util.sleepMillis(1);
			}
			fluxSink.complete();
		}).onBackpressureDrop(list::add).publishOn(Schedulers.boundedElastic()).doOnNext(i -> {
			Util.sleepMillis(10);
		}).subscribe(Util.subscriber());

		Util.sleepSeconds(10);
		System.out.println(list);
	}
}
