package reactivefromudemy.sec02_flux;

import java.util.concurrent.atomic.AtomicReference;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import reactivefromudemy.courseUtil.Util;
import reactor.core.publisher.Flux;

public class Lec06Subscription {

	public static void main(String[] args) {

		AtomicReference<Subscription> atomicReference = new AtomicReference<>();

		Flux.range(1, 20).log().subscribeWith(new Subscriber<Integer>() {

			@Override
			public void onSubscribe(Subscription s) {
				System.out.println("Received Sub : " + s);
				atomicReference.set(s);
			}

			@Override
			public void onNext(Integer t) {
				System.out.println("onNext : " + t);
			}

			@Override
			public void onError(Throwable t) {
				System.out.println("onError : " + t.getMessage());
			}

			@Override
			public void onComplete() {
				System.out.println("onComplete");
			}

		});

		Util.sleepSeconds(3);
		atomicReference.get().request(3);
		Util.sleepSeconds(5);
		atomicReference.get().request(3);
		Util.sleepSeconds(5);
		System.out.println("Going to cancel");
		atomicReference.get().cancel();
		Util.sleepSeconds(3);
		atomicReference.get().request(3);
		Util.sleepSeconds(3);
	}
}
