package reactivefromudemy.sec02_flux.assignment;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class StockPriceAssignment {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(1);

		StockPricePublisher.getPrice().subscribeWith(new Subscriber<Integer>() {

			private Subscription subscription;

			@Override
			public void onSubscribe(Subscription s) {
				this.subscription = s;
				s.request(Long.MAX_VALUE);
			}

			@Override
			public void onNext(Integer t) {
				System.out.println(LocalDateTime.now() + " : Price : " + t);
				if (t > 100 || t < 90) {
					this.subscription.cancel();
					latch.countDown();
				}
			}

			@Override
			public void onError(Throwable t) {
				latch.countDown();
			}

			@Override
			public void onComplete() {
				latch.countDown();
			}

		});
		
		latch.await();
	}
}
