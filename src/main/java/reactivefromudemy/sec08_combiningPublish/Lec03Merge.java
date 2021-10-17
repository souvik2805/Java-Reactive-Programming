package reactivefromudemy.sec08_combiningPublish;

import reactivefromudemy.courseUtil.Util;
import reactivefromudemy.sec08_combiningPublish.helper.AmericanAirlines;
import reactivefromudemy.sec08_combiningPublish.helper.Emirates;
import reactivefromudemy.sec08_combiningPublish.helper.QatarFlights;
import reactor.core.publisher.Flux;

public class Lec03Merge {

	public static void main(String[] args) {
//
//		QatarFlights.getFlights().concat(Emirates.getFlights(), AmericanAirlines.getFlights())
//				.subscribe(Util.subscriber());

		// Above not work

		Flux.merge(QatarFlights.getFlights(), Emirates.getFlights(), AmericanAirlines.getFlights())
				.subscribe(Util.subscriber());
		
		Util.sleepSeconds(60);

	}
}
