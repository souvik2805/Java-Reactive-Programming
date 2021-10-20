package reactivefromudemy.sec11_sinks;

import reactivefromudemy.courseUtil.Util;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

public class Lec01SinkOne {

	public static void main(String[] args) {

		// Mono 1 value / empty/ error
		Sinks.One<Object> sink = Sinks.one();

		Mono<Object> mono = sink.asMono();

		mono.subscribe(Util.subscriber("same"));
		mono.subscribe(Util.subscriber("mike"));

//		sink.tryEmitValue("Hi");
//		sink.tryEmitEmpty();
//		sink.tryEmitError(new RuntimeException("err"));

//		sink.emitValue("Hi", (signalType, emitResult) -> {
//			System.out.println(signalType.name());
//			System.out.println(emitResult.name());
//			return false;
//		});
//
//		// This error as mono accept only one value
//		sink.emitValue("Hello", (signalType, emitResult) -> {
//			System.out.println(signalType.name());
//			System.out.println(emitResult.name());
//			return false;
//		});

		sink.tryEmitValue("Hello");

	}

}
