package reactivefromudemy.sec03_flux_programmatically;

import reactivefromudemy.courseUtil.Util;
import reactivefromudemy.sec03_flux_programmatically.helper.NameProducer;
import reactor.core.publisher.Flux;

public class Lec02FluxCreateRefactoring {

	public static void main(String[] args) {
		NameProducer nameProducer = new NameProducer();

		Flux.create(nameProducer).subscribe(Util.subscriber());
		nameProducer.produce();
	}
}
