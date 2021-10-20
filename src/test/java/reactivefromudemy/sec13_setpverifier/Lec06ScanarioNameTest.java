package reactivefromudemy.sec13_setpverifier;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.test.StepVerifierOptions;

public class Lec06ScanarioNameTest {

//	@Test
	public void test1() {
		Flux<String> flux = Flux.just("a", "b", "c");

		StepVerifierOptions scenarioName = StepVerifierOptions.create().scenarioName("alphabet-test");

		StepVerifier.create(flux, scenarioName).expectNextCount(45).verifyComplete();

	}

	@Test
	public void test2() {
		Flux<String> flux = Flux.just("a", "b1", "c");

		StepVerifier.create(flux)
		.expectNext("a")
		.as("a-test")
		.expectNext("b")
		.as("b-test")
		.expectNext("c")
		.as("c-test")
		.verifyComplete();

	}

}
