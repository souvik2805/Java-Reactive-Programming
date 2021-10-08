package reactivefromudemy.sec02_flux;

import reactivefromudemy.courseUtil.Util;
import reactor.core.publisher.Flux;

public class Lec05FluxRangeLog {

	public static void main(String[] args) {

		Flux.range(3, 5).log().map(i -> Util.faker().name().fullName()).log().subscribe(Util.onNext());
	}
}
