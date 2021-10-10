package reactivefromudemy.sec03_flux_programmatically;

import reactivefromudemy.courseUtil.Util;
import reactor.core.publisher.Flux;

public class Lec07AFluxGenerateUtillIndiaCome {

	public static void main(String[] args) {

		Flux.generate(sysnchronousSink -> {
			String country = Util.faker().country().name();
			System.out.println("Emitting : " + country);
			sysnchronousSink.next(country);
			if (country.toLowerCase().equals("india")) {
				sysnchronousSink.complete();
			}
		}).subscribe(Util.subscriber());
	}

}
