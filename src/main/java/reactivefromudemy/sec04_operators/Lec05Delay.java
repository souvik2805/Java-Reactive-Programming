package reactivefromudemy.sec04_operators;

import java.time.Duration;

import reactivefromudemy.courseUtil.Util;
import reactor.core.publisher.Flux;

public class Lec05Delay {

	public static void main(String[] args) {

		// As there is a delay, so it do't produce all the 100 item in One go
		// It product 32 item, if it consume 75 % of 32, then it again product 32 item

		// Why 32 ?

		// Queues // reactor.bufferSize.x", "32"
		// And its mininum value atleast 8,
		// Let us set this value to 9

		System.setProperty("reactor.bufferSize.x", "9");

		Flux.range(1, 100).log().delayElements(Duration.ofSeconds(1)).subscribe(Util.subscriber());

		Util.sleepSeconds(60);
	}
}
