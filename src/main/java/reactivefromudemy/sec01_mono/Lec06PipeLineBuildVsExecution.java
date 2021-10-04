package reactivefromudemy.sec01_mono;

import reactivefromudemy.courseUtil.Util;
import reactor.core.publisher.Mono;

public class Lec06PipeLineBuildVsExecution {

	public static void main(String[] args) {

		// This are the building the pipeline
		getName();
		getName();
		getName();

		// This is building pipeline and Execution
		getName().subscribe(Util.onNext());

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
