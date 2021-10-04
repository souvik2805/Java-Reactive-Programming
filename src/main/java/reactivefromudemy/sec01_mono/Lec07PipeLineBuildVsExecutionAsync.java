package reactivefromudemy.sec01_mono;

import reactivefromudemy.courseUtil.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class Lec07PipeLineBuildVsExecutionAsync {

	public static void main(String[] args) {

		// This is building pipeline and Execution in blocking way.
		// getName().subscribe(Util.onNext());

		// This is async way.
		getName().subscribeOn(Schedulers.boundedElastic()).subscribe(Util.onNext());

		Util.sleepSeconds(4);

	}

	private static Mono<String> getName() {
		System.out.println("entered getname method");
		return Mono.fromSupplier(() -> {
			System.out.println("Generating name...");
			Util.sleepSeconds(3);
			return Util.faker().name().fullName();
		}).map(String::toUpperCase);
	}
}
