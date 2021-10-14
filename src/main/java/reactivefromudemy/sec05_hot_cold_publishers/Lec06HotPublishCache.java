package reactivefromudemy.sec05_hot_cold_publishers;

import java.time.Duration;
import java.util.stream.Stream;

import reactivefromudemy.courseUtil.Util;
import reactor.core.publisher.Flux;

public class Lec06HotPublishCache {

	public static void main(String[] args) {

		// cache => publish().replay int max
		Flux<String> movieStream = Flux.fromStream(() -> getMovie()).delayElements(Duration.ofSeconds(1)).cache(2);
		movieStream.subscribe(Util.subscriber("Sam"));

		Util.sleepSeconds(5);
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
