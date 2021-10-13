package reactivefromudemy.sec04_operators;

import reactivefromudemy.courseUtil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec06OnErrorFallbackResume {

	public static void main(String[] args) {
		Flux.range(1, 10).log().map(i -> 10 / (5 - i))
				// .onErrorReturn(-80)
				// .onErrorResume(e -> fallback())
				.onErrorContinue((err, obj) -> {
                 
				}).subscribe(Util.subscriber());
		
		// onErrorReturn
		// onErrorResume 
		// Both of this end the loop
		
		// But onErrorContinue do't end the loop
	}

	private static Mono<Integer> fallback() {
		return Mono.fromSupplier(() -> Util.faker().random().nextInt(100, 200));
	}
}
