package reactivefromudemy.sec05_hot_cold_publishers;

import java.time.Duration;
import java.util.stream.Stream;

import reactivefromudemy.courseUtil.Util;
import reactor.core.publisher.Flux;

public class Lec05HotPublishAutoConnect {

	public static void main(String[] args) {

		// share() => publish().refCount(1)
		// autoConnect - minimun subscriber require to start
		// If source is active then everyone get the data from that single source.
		// But if source is in completed state then autoConnect do't ReSubcribe
		Flux<String> movieStream = Flux.fromStream(() -> getMovie()).delayElements(Duration.ofSeconds(1)).publish()
				.autoConnect(1);
		// autoConnect(0) => Start immediately no minimum subscriber require
		movieStream.subscribe(Util.subscriber("Sam"));

		
		Util.sleepSeconds(10);
		System.out.println("Mike is about to join");

		movieStream.subscribe(Util.subscriber("Mike"));
		Util.sleepSeconds(60);
	}

	// movie-theatre
	private static Stream<String> getMovie() {
		System.out.println("Got the movie streaming request");
		return Stream.of("Scene 1", "Scene 2", "Scene 3", "Scene 4", "Scene 5", "Scene 6", "Scene 7");
	}
}
