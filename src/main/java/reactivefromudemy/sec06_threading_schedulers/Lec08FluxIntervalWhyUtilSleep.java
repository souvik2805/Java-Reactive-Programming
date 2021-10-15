package reactivefromudemy.sec06_threading_schedulers;

import java.time.Duration;

import reactivefromudemy.courseUtil.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec08FluxIntervalWhyUtilSleep {

	public static void main(String[] args) {

//		public static Flux<Long> interval(Duration period) {
//			return interval(period, Schedulers.parallel());
//		}

		// Flux interval, delay etc. uses the Schedulers.parallel(), which can't
		// override by subscribeOn, that why we have to sleep the main thread
		Flux.interval(Duration.ofMillis(1)).subscribeOn(Schedulers.boundedElastic()).subscribe(Util.subscriber());

		Util.sleepSeconds(5);
	}
}
