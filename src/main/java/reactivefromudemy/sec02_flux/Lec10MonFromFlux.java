package reactivefromudemy.sec02_flux;

import reactivefromudemy.courseUtil.Util;
import reactor.core.publisher.Flux;

public class Lec10MonFromFlux {

	public static void main(String[] args) {
		
		// Whatever the item fist go through the next, that will only item seleted for MONO
		Flux.range(1, 10).next().subscribe(Util.onNext(), Util.OnError(), Util.OnComplete());
		
		Flux.range(1, 10).filter(i -> i> 3).next().subscribe(Util.onNext(), Util.OnError(), Util.OnComplete());
		
		Flux.range(1, 10).next().filter(i -> i> 3).subscribe(Util.onNext(), Util.OnError(), Util.OnComplete());
	}

}
