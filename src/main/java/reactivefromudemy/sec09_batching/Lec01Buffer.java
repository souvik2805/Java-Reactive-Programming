package reactivefromudemy.sec09_batching;

import java.time.Duration;

import reactivefromudemy.courseUtil.Util;
import reactor.core.publisher.Flux;

public class Lec01Buffer {

	public static void main(String[] args) {
	
		// List of 5 item 
		eventStream()
		//.buffer(5)
		// .buffer(Duration.ofSeconds(2))
		.bufferTimeout(5, Duration.ofSeconds(2)) // either give list of 5 or wait 2 second, which ever happend first give it
		.subscribe(Util.subscriber());
		
		Util.sleepSeconds(60);
	}

	private static Flux<String> eventStream() {
		return Flux.interval(Duration.ofMillis(300))
//				.take(3)
				.map(i -> "event : " + i);
	}
}
