package reactivefromudemy.sec03_flux_programmatically;

import reactivefromudemy.courseUtil.Util;
import reactor.core.publisher.Flux;

public class Lec04FluxTake {

	public static void main(String[] args) {
		Flux.range(1, 10).log().take(3).log().subscribe(Util.subscriber());
	}
}
