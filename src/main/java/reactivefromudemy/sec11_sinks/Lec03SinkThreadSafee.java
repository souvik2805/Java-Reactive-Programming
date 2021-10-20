package reactivefromudemy.sec11_sinks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import reactivefromudemy.courseUtil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class Lec03SinkThreadSafee {

	public static void main(String[] args) {

		Sinks.Many<Object> sink = Sinks.many().unicast().onBackpressureBuffer();

		Flux<Object> flux = sink.asFlux();

		List<Object> list = new ArrayList<>();
		flux.subscribe(list::add);

//		for (int i = 0; i < 1000; i++) {
//			final int j = i;
//			CompletableFuture.runAsync(() -> {
//				sink.tryEmitNext(j);
//			});
//		}

		for (int i = 0; i < 1000; i++) {
			final int j = i;
			CompletableFuture.runAsync(() -> {
				// Incase of error, retry again => return true
				sink.emitNext(j, (signalType, emitResult) -> {
//					System.out.println(emitResult.name());
					return true;
				});
			});
		}

		Util.sleepSeconds(3);
		System.out.println(list.size());

	}

}
