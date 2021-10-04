package reactivefromudemy.sec01_mono;

import reactivefromudemy.courseUtil.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class Lec07PipeLineBuildVsExecutionBlock {

	public static void main(String[] args) {

		// Block()
		// block wait for this result, But it will block the main thread
		// Here we do't have to provide the consumer
		// like this

		// Basically iit is a blocking mono subscriber
		// This is use full for Testing purpose
		String name = getName().subscribeOn(Schedulers.boundedElastic()).block();

		
		// block() internally subscribe and give the result
		System.out.println(name);

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
