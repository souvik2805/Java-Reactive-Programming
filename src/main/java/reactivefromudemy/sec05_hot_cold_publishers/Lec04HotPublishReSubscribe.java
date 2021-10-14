package reactivefromudemy.sec05_hot_cold_publishers;

import java.time.Duration;
import java.util.stream.Stream;

import reactivefromudemy.courseUtil.Util;
import reactor.core.publisher.Flux;

public class Lec04HotPublishReSubscribe {

	public static void main(String[] args) {

		// share() => publish().refCount(1)
		// refCount - minimun subscriber require to start
		// If source is active then everyone get the data from that single source.
		// But if source is in completed state then it again start => i.e ReSubcribe
		Flux<String> movieStream = Flux.fromStream(() -> getMovie()).delayElements(Duration.ofSeconds(1)).publish()
				.refCount(1);
		movieStream.subscribe(Util.subscriber("Sam"));

		Util.sleepSeconds(10);

		// Not active source, so ReSubcribe
		movieStream.subscribe(Util.subscriber("Mike"));
		Util.sleepSeconds(60);
	}

	// movie-theatre
	private static Stream<String> getMovie() {
		System.out.println("Got the movie streaming request");
		return Stream.of("Scene 1", "Scene 2", "Scene 3", "Scene 4", "Scene 5", "Scene 6", "Scene 7");
	}
}
