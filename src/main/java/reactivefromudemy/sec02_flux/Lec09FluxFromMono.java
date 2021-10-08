package reactivefromudemy.sec02_flux;

import reactivefromudemy.courseUtil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec09FluxFromMono {

	public static void main(String[] args) {

		Mono<String> mono = Mono.just("a");
		Flux<String> flux = Flux.from(mono);

		flux.subscribe(Util.onNext());
	}
}
