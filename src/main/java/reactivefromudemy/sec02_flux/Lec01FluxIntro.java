package reactivefromudemy.sec02_flux;

import reactivefromudemy.courseUtil.Util;
import reactor.core.publisher.Flux;

public class Lec01FluxIntro {

	public static void main(String[] args) {
		Flux<Object> flux = Flux.just(1, 2, 3, "A", "souvik");
		flux.subscribe(Util.onNext(), Util.OnError(), Util.OnComplete());
	}
}
