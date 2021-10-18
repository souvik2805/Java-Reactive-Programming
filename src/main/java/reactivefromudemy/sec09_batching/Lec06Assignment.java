package reactivefromudemy.sec09_batching;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import reactivefromudemy.courseUtil.Util;
import reactivefromudemy.sec09_batching.assignment.OrderProcessor;
import reactivefromudemy.sec09_batching.assignment.OrderService;
import reactivefromudemy.sec09_batching.assignment.PurchaseOrder;
import reactor.core.publisher.Flux;

public class Lec06Assignment {

	public static void main(String[] args) {
		Map<String, Function<Flux<PurchaseOrder>, Flux<PurchaseOrder>>> map = Map.of( "Kids",
				OrderProcessor.kidsProcessing(),"Automotive", OrderProcessor.automotiveProcessing());
		
		Set<String> set  = map.keySet();
		
		OrderService.orderStream().
		filter(p ->set.contains(p.getCategory()))
		.groupBy(PurchaseOrder::getCategory)
		.flatMap(groupFlux-> map.get(groupFlux.key()).apply(groupFlux))
		.subscribe(Util.subscriber());
		
		
		Util.sleepSeconds(60);
	}
}
