package reactivefromudemy.sec04_operators.helper;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

public class OrderService {

	private static Map<Integer, List<PurchaseOrder>> db = new HashMap<>();

	static {
		List<PurchaseOrder> list1 = Arrays.asList(new PurchaseOrder(1), new PurchaseOrder(1), new PurchaseOrder(1));
		List<PurchaseOrder> list2 = Arrays.asList(new PurchaseOrder(2), new PurchaseOrder(2), new PurchaseOrder(2));
		db.put(1, list1);
		db.put(2, list2);
	}

//	public static Flux<PurchaseOrder> getOrders(int userId) {
//		return Flux.create(purchaseOrderSink -> {
//			db.get(userId).forEach(purchaseOrderSink::next);
//			purchaseOrderSink.complete();
//		});
//	}

//	public static Flux<Object> getOrders(int userId) {
//		return Flux.create(purchaseOrderSink -> {
//			db.get(userId).forEach(purchaseOrderSink::next);
//			purchaseOrderSink.complete();
//		}).delayElements(Duration.ofSeconds(1));
//	}

	public static Flux<PurchaseOrder> getOrders(int userId) {
		return Flux.create((FluxSink<PurchaseOrder> purchaseOrderFluxSink) -> {
			db.get(userId).forEach(purchaseOrderFluxSink::next);
			purchaseOrderFluxSink.complete();
		}).delayElements(Duration.ofSeconds(1));
	}
}
