package reactivefromudemy.sec01_mono;

import reactivefromudemy.courseUtil.Util;
import reactor.core.publisher.Mono;

public class Lec04MonoEmptyOrError {

	public static void main(String[] args) {
		userRepository(3).subscribe(Util.onNext(), Util.OnError(), Util.OnComplete());

	}

	private static Mono<String> userRepository(int userId) {

		if (userId == 1) {
			return Mono.just(Util.faker().name().firstName());
		} else if (userId == 2) {
			return Mono.empty();
		} else {
			return Mono.error(new RuntimeException("Not in the allowed range"));
		}
	}

}
