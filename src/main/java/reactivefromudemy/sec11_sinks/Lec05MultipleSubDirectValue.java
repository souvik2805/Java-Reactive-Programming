package reactivefromudemy.sec11_sinks;

import java.time.Duration;

import reactivefromudemy.courseUtil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class Lec05MultipleSubDirectValue {

	public static void main(String[] args) {

		System.setProperty("reactor.bufferSize.small", "16");

//		Sinks.Many<Object> sink = Sinks.many().multicast().directAllOrNothing();
		Sinks.Many<Object> sink = Sinks.many().multicast().directBestEffort();

		Flux<Object> flux = sink.asFlux();

		flux.subscribe(Util.subscriber("sam"));
		flux.delayElements(Duration.ofMillis(200)).subscribe(Util.subscriber("mike"));

		for (int i = 0; i < 100; i++) {
			sink.tryEmitNext(i);
		}

		Util.sleepSeconds(10);
	}
}
