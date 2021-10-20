package reactivefromudemy.sec13_setpverifier;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class Lec02SetupVerifierErrorTest {

	@Test
	public void test1() {
		Flux<Integer> flux = Flux.just(1, 2, 3);
		Flux<Integer> error = Flux.error(new RuntimeException("oops"));

		Flux<Integer> concate = Flux.concat(flux, error);
		StepVerifier.create(concate).expectNext(1, 2, 3).verifyError();

	}

	@Test
	public void test2() {
		Flux<Integer> flux = Flux.just(1, 2, 3);
		Flux<Integer> error = Flux.error(new RuntimeException("oops"));
		Flux<Integer> concate = Flux.concat(flux, error);

		StepVerifier.create(concate).expectNext(1, 2, 3).verifyError(RuntimeException.class);
	}
	
	@Test
	public void test3() {
		Flux<Integer> flux = Flux.just(1, 2, 3);
		Flux<Integer> error = Flux.error(new RuntimeException("oops"));
		Flux<Integer> concate = Flux.concat(flux, error);

		StepVerifier.create(concate).expectNext(1, 2, 3).verifyErrorMessage("oops");
	}
}
