package reactivefromudemy.sec13_setpverifier;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import reactivefromudemy.sec09_batching.helper.BookOrder;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class Lec04AssertTest {

	@Test
	public void test1() {
		Mono<BookOrder> mono = Mono.fromSupplier(() -> new BookOrder());
		StepVerifier.create(mono).assertNext(b-> Assertions.assertNotNull(b.getAuthoer()))
		.verifyComplete();
	}
	
	@Test
	public void test2() {
		Mono<BookOrder> mono = Mono.fromSupplier(() -> new BookOrder()).delayElement(Duration.ofSeconds(3));
		StepVerifier.create(mono).assertNext(b-> Assertions.assertNotNull(b.getAuthoer()))
		.verifyComplete();
	}
	
	@Test
	public void test3() {
		Mono<BookOrder> mono = Mono.fromSupplier(() -> new BookOrder()).delayElement(Duration.ofSeconds(3));
		StepVerifier.create(mono).assertNext(b-> Assertions.assertNotNull(b.getAuthoer()))
		.expectComplete()
		.verify(Duration.ofSeconds(2));
	}
}
