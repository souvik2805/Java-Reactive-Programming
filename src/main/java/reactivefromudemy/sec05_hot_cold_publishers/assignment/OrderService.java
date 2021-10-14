package reactivefromudemy.sec05_hot_cold_publishers.assignment;

import java.time.Duration;
import java.util.Objects;

import reactor.core.publisher.Flux;

public class OrderService {

	private Flux<PurchaseOrder> flux;

	public Flux<PurchaseOrder> orderStream() {
		if (Objects.isNull(flux))
			flux = getOrderStream();
		return flux;
	}

	private Flux<PurchaseOrder> getOrderStream() {
		return Flux.interval(Duration.ofMillis(100)).map(i -> new PurchaseOrder()).publish().refCount(2);
	}

}
