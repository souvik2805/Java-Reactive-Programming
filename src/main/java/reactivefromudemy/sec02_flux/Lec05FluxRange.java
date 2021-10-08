package reactivefromudemy.sec02_flux;

import reactivefromudemy.courseUtil.Util;
import reactor.core.publisher.Flux;

public class Lec05FluxRange {

	public static void main(String[] args) {
		Flux.range(3, 10).subscribe(Util.onNext());
		
		Flux.range(3, 10).map(i -> Util.faker().name().fullName()).subscribe(Util.onNext());
	}
}
