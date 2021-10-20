package reactivefromudemy.sec13_setpverifier;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class Lec05VirtualTimeTest {

	//@Test
	public void test1() {
		StepVerifier.create(timeConsumingFlux()).expectNext("1a", "2a", "3a", "4a").verifyComplete();
	}
	

	@Test
	public void test2() {
		StepVerifier.withVirtualTime(()-> timeConsumingFlux())
		.thenAwait(Duration.ofSeconds(30))
		.expectNext("1a", "2a", "3a", "4a").verifyComplete();
	}
	
	@Test
	public void test3() {
		StepVerifier.withVirtualTime(()-> timeConsumingFlux())
		.expectSubscription()
		.expectNoEvent(Duration.ofSeconds(5))
		.thenAwait(Duration.ofSeconds(30))
		.expectNext("1a", "2a", "3a", "4a").verifyComplete();
	}

	private Flux<String> timeConsumingFlux() {
		return Flux.range(1, 4).delayElements(Duration.ofSeconds(5)).map(i -> i + "a");
	}
}
