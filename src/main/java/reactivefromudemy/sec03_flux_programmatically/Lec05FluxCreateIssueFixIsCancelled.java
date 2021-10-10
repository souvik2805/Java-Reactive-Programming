package reactivefromudemy.sec03_flux_programmatically;

import reactivefromudemy.courseUtil.Util;
import reactivefromudemy.sec03_flux_programmatically.helper.NameProducer;
import reactor.core.publisher.Flux;

public class Lec05FluxCreateIssueFixIsCancelled {

	public static void main(String[] args) {
		Flux.create(fluxSink -> {
			String country;
			do {
				country = Util.faker().country().name();
				System.out.println("Emitting country : " + country);
				fluxSink.next(country);
			} while (!country.toLowerCase().equals("india") && !fluxSink.isCancelled());
			fluxSink.complete();

		}).take(3).subscribe(Util.subscriber());
	}
}
