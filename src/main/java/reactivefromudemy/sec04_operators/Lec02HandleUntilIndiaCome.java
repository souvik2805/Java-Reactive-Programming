package reactivefromudemy.sec04_operators;

import reactivefromudemy.courseUtil.Util;
import reactor.core.publisher.Flux;

public class Lec02HandleUntilIndiaCome {

	public static void main(String[] args) {
//		Flux.generate(SynchronouSink -> {
//			SynchronouSink.next(Util.faker().country().name());
//		}).handle((country, synchronousSink) -> {
//			System.out.println("Getting : " + country);
//			if (country.toString().toLowerCase().equals("india")) {
//				synchronousSink.complete();
//			} else {
//				synchronousSink.next(country);
//			}
//
//		}).subscribe(Util.subscriber());

		Flux.generate(synchronouSink -> synchronouSink.next(Util.faker().country().name())).map(Object::toString)
				.handle((s, synchronouSink) -> {
					synchronouSink.next(s);
					if (s.toLowerCase().equals("india")) {
						synchronouSink.complete();
					}
				}).subscribe(Util.subscriber());
	}
}
