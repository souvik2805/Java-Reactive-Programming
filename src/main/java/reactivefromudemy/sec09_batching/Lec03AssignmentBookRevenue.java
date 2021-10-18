package reactivefromudemy.sec09_batching;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import reactivefromudemy.courseUtil.Util;
import reactivefromudemy.sec09_batching.helper.BookOrder;
import reactivefromudemy.sec09_batching.helper.RevenueReport;
import reactor.core.publisher.Flux;

public class Lec03AssignmentBookRevenue {

	public static void main(String[] args) {
		Set<String> allowedCategory = Set.of("Science fiction", "Fantasy", "Suspense/Thriller");

		bookStream().filter(book -> allowedCategory.contains(book.getCategory())).buffer(Duration.ofSeconds(5))
				.map(list -> revenueCalculate(list)).subscribe(Util.subscriber());
		
		Util.sleepSeconds(60);
	}

	private static RevenueReport revenueCalculate(List<BookOrder> books) {
		Map<String, Double> map = books.stream()
				.collect(Collectors.groupingBy(BookOrder::getCategory, Collectors.summingDouble(BookOrder::getPrice)));

		return new RevenueReport(map);
	}

	private static Flux<BookOrder> bookStream() {
		return Flux.interval(Duration.ofMillis(200)).map(i -> new BookOrder());
	}
}
