package reactivefromudemy.sec11_sinks;

import reactivefromudemy.courseUtil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class Lec04SinkMulti {

	public static void main(String[] args) {
//		Sinks.Many<Object> sink = Sinks.many().multicast().onBackpressureBuffer();

		// disable the data history(cache),
		Sinks.Many<Object> sink = Sinks.many().multicast().directAllOrNothing();

		Flux<Object> flux = sink.asFlux();

		sink.tryEmitNext("hi");
		sink.tryEmitNext("i am souvik");

		flux.subscribe(Util.subscriber("Sam"));

		flux.subscribe(Util.subscriber("Mike"));
		sink.tryEmitNext("?");

		flux.subscribe(Util.subscriber("ABC"));
		sink.tryEmitNext("hello");
	}

}
