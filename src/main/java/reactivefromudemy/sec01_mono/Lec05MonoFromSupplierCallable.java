package reactivefromudemy.sec01_mono;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

import reactivefromudemy.courseUtil.Util;
import reactor.core.publisher.Mono;

public class Lec05MonoFromSupplierCallable {

	public static void main(String[] args) {

		// use just only when you have data already
		// Mono<String> mono = Mono.just(getName()); // Not suitable for this case

		// Supplier is java function interface (Java 8) , It will not accept any input ,
		// But it is suppose to give you Output

		// Approach 1
		// Mono<String> mono = Mono.fromSupplier(() -> getName());

		// Approach 2
//		Supplier<String> stringSupplier = () -> getName();
//		Mono<String> mono = Mono.fromSupplier(stringSupplier);

		// Callable is a Java function Interface, It will not accept any input.
		Callable fromCallable = () -> getName();
		Mono<String> mono = Mono.fromCallable(fromCallable);

		mono.subscribe(Util.onNext());
		// User Java Coverage(Eclipse) for better understand

	}

	private static String getName() {
		System.out.println("Generating name ...");
		return Util.faker().name().fullName();
	}
}
