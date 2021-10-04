package reactivefromudemy.sec01_mono;

import java.util.concurrent.CompletableFuture;

import reactivefromudemy.courseUtil.Util;
import reactor.core.publisher.Mono;

public class Lec08MonoFromFuture {

	public static void main(String[] args) {

		Mono.fromFuture(getName()).subscribe(Util.onNext());

		Util.sleepSeconds(4);

	}

	private static CompletableFuture<String> getName() {
		return CompletableFuture.supplyAsync(() -> Util.faker().name().fullName());
	}
}
