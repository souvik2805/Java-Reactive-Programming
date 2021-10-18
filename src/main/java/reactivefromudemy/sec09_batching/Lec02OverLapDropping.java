package reactivefromudemy.sec09_batching;

import java.time.Duration;

import reactivefromudemy.courseUtil.Util;
import reactor.core.publisher.Flux;

public class Lec02OverLapDropping {

	public static void main(String[] args) {
			
			// List of 5 item 
			eventStream()
			.buffer(3,1) // print last 3 item , maxSize = 3, skip = 1
			.subscribe(Util.subscriber());
			
			Util.sleepSeconds(60);
		}

		private static Flux<String> eventStream() {
			return Flux.interval(Duration.ofMillis(300))
//					.take(3)
					.map(i -> "event : " + i);
		}
}
