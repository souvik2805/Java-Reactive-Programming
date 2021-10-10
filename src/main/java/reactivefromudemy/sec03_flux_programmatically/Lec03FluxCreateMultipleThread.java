package reactivefromudemy.sec03_flux_programmatically;

import reactivefromudemy.courseUtil.Util;
import reactivefromudemy.sec03_flux_programmatically.helper.NameProducer;
import reactor.core.publisher.Flux;

public class Lec03FluxCreateMultipleThread {

	public static void main(String[] args) {
		NameProducer nameProducer = new NameProducer();

		Flux.create(nameProducer).subscribe(Util.subscriber());

//		Runnable runnable = () -> nameProducer.produce();
		Runnable runnable = nameProducer::produce;

		for (int i = 0; i < 10; i++) {
			new Thread(runnable).start();
		}
		
//		Util.sleepSeconds(2);

	}
}
