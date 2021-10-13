package reactivefromudemy.sec04_operators;

import java.util.Objects;

import reactivefromudemy.courseUtil.Util;
import reactor.core.publisher.Flux;

public class Lec03DoCallbacks {

	public static void main(String[] args) {
		Flux.create(fluxSink -> {
			System.out.println(" Inside Create");
			for (int i = 0; i < 5; i++) {
				fluxSink.next(i);
			}
			fluxSink.complete();
//			fluxSink.error(new RuntimeException("Opps"));
			System.out.println("++++++ Completed ++++++");
		}).doOnComplete(() -> System.out.println("doOnComplete")).doFirst(() -> System.out.println("doFirst : 1"))
				.doOnNext(s -> System.out.println("DoOnNext : " + s))
				.doOnSubscribe(s -> System.out.println("doOnSubscriber 1 : " + s))
				.doOnRequest(l -> System.out.println("doOnRequest : " + l))
				.doFirst(() -> System.out.println("doFirst : 2"))
				.doOnError(err -> System.out.println("doOnError : " + err.getMessage()))
				.doOnTerminate(() -> System.out.println("DoOnTerminate"))
				.doOnCancel(() -> System.out.println("doOnCancel"))
				.doFinally(signal -> System.out.println("doFinally : " + signal))
				.doOnSubscribe(s -> System.out.println("doOnSubscriber 2 : " + s))
				.doFirst(() -> System.out.println("doFirst : 3"))
				.doOnDiscard(Objects.class, o -> System.out.println("doOnDiscord : " + o))
				.take(2)
				.doFinally(signal -> System.out.println("doFinally 2: " + signal))
				.subscribe(Util.subscriber());

		// The execution happen from botton to top.

// NOTE: 1 The execution order for doFist() (botton to top);
//		doFirst : 3
//		doFirst : 2
//		doFirst : 1

// NOTE: 2 For doOnSubscribe execution order from top to bottom
//		doOnSubscriber 1 : reactor.core.publisher.FluxPeekFuseable$PeekConditionalSubscriber@36bc55d
//		doOnSubscriber 2 : reactor.core.publisher.FluxDoFinally$DoFinallyConditionalSubscriber@564fabc8

// NOTE: 3 
//		doOnComplete
//		DoOnTerminate
//		.. Completed 
//		doFinally : onComplete

// NOTE: 3.1
//		doOnError : Opps
//		DoOnTerminate
//		..Error : Opps
//		doFinally : onError
	}

// NOTE: 3.2 doOnTerminate call all the time, But doOnComplete/doOnError call when it happen.

// NOTE: 4 But doOnTerminate not executing when there is a take operators
//	doOnCancel
//	doFinally : cancel

// **** If we want to somethings after everything, doFinally is the best place.
}
