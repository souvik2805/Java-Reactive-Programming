package reactivefromudemy.sec11_sinks;

import reactivefromudemy.courseUtil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class Lec02SinkUniCast {

	public static void main(String[] args) {

		// handle through which we would push items
		Sinks.Many<Object> sink = Sinks.many().unicast().onBackpressureBuffer();

		// Handle through which subscriber received items
		Flux<Object> flux = sink.asFlux();

		flux.subscribe(Util.subscriber("sam"));
		flux.subscribe(Util.subscriber("mike"));

		sink.tryEmitNext("Hi");
		sink.tryEmitNext("Souvik");
		sink.tryEmitNext("How are you ?");
		sink.tryEmitComplete();
	}

}
