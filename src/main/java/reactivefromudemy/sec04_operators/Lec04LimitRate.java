package reactivefromudemy.sec04_operators;

import reactivefromudemy.courseUtil.Util;
import reactor.core.publisher.Flux;

public class Lec04LimitRate {

	public static void main(String[] args) {
		// limitRate(100) % 75 => after 75 item request for next slot
		
		//Flux.range(1, 1000).log().limitRate(100).subscribe(Util.subscriber());
		
		// limitRate(100, 99) => after 99 item request for next slot
//		Flux.range(1, 1000).log().limitRate(100, 99).subscribe(Util.subscriber());
		
		
		// limitRate(100, 100) => not working like that here it will be 75 %
		// limitRate(100, 100) ===> will be  => limitRate(100, 0) - Littile bit confusing
		
	}
}
