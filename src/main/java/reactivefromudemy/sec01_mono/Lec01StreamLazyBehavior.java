package reactivefromudemy.sec01_mono;

import java.util.stream.Stream;

public class Lec01StreamLazyBehavior {

	public static void main(String[] args) {

		Stream<Integer> stream = Stream.of(1).map(i -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return i * 2;
		});

		System.out.println(stream); // java.util.stream.ReferencePipeline$3@2a3046da
		
		
		// Why : Beacuse stream is Lazy in nature, It will not do any thing unless it
		// connected to terminal operator.
		// Let's do it
		stream.forEach(System.out::println); // 2
	}
}
