package reactivefromudemy.courseUtil;

import java.util.function.Consumer;

import org.reactivestreams.Subscriber;

import com.github.javafaker.Faker;

public class Util {

	private static final Faker FAKER = Faker.instance();

	public static Consumer<Object> onNext() {
		return o -> System.out.println("Received : " + o);
	}

	public static Consumer<Throwable> OnError() {
		return e -> System.out.println("ERROR : " + e.getMessage());
	}

	public static Runnable OnComplete() {
		return () -> System.out.println("Completed");
	}

	public static Faker faker() {
		return FAKER;
	}

	public static void sleepSeconds(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static Subscriber<Object> subscriber() {
		return (Subscriber<Object>) new DefaultSubscriber();
	}

	public static Subscriber<Object> subscriber(String name) {
		return (Subscriber<Object>) new DefaultSubscriber(name);
	}
}
