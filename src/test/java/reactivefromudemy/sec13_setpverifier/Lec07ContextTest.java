package reactivefromudemy.sec13_setpverifier;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import reactor.test.StepVerifierOptions;
import reactor.util.context.Context;

public class Lec07ContextTest {

	@Test
	public void test1() {
		StepVerifier.create(getWelComeMessage()).verifyError(RuntimeException.class);
	}

	@Test
	public void test2() {
		StepVerifierOptions options = StepVerifierOptions.create().withInitialContext(Context.of("user", "sam"));
		StepVerifier.create(getWelComeMessage(), options).expectNext("Welcome sam").verifyComplete();
	}

	private Mono<String> getWelComeMessage() {
		return Mono.deferContextual(context -> {
			if (context.hasKey("user")) {
				return Mono.just("Welcome " + context.get("user"));
			} else {
				return Mono.error(new RuntimeException("Unauthenticated"));
			}
		});
	}

}
