package reactivefromudemy.sec03_flux_programmatically;

import reactivefromudemy.courseUtil.Util;
import reactor.core.publisher.Flux;

public class Lec01FluxCreateUtilIndiaCome {

	public static void main(String[] args) {

//		Flux.create(fluxSink -> {
//			for (int i = 0; i < 10; i++) {
//				fluxSink.next(Util.faker().country().name());
//			}
//			fluxSink.complete();
//		}).subscribe(Util.subscriber());

		
		Flux.create(fluxSink -> {

			String country;
			do {
				country = Util.faker().country().name();
				fluxSink.next(country);
			} while (!country.toLowerCase().equals("india"));
			fluxSink.complete();

		}).subscribe(Util.subscriber());
	}
}
