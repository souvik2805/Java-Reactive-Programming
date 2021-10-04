package reactivefromudemy.sec01_mono;

import reactivefromudemy.courseUtil.Util;
import reactor.core.publisher.Mono;

public class Lec09MonoFromRunnable {

	public static void main(String[] args) {

		// Runnable does not accept any parameter and it also not return parameter as
		// well

		// Sometimes there will be some time consuming operation
		// I want to be notified when the opeation is completed at that time Runnable is
		// very useful

		Mono.fromRunnable(timeConsumingProcess()).subscribe(Util.onNext(), Util.OnError(), () -> {
			System.out.println("Process is done. Sending emails.....");
		});

	}

	private static Runnable timeConsumingProcess() {
		return () -> {
			Util.sleepSeconds(3);
			System.out.println("Operation completed");
		};
	}
}
