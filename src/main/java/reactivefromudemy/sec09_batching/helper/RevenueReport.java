package reactivefromudemy.sec09_batching.helper;

import java.time.LocalDateTime;
import java.util.Map;

public class RevenueReport {

	private LocalDateTime localDateTime = LocalDateTime.now();
	private Map<String, Double> revenue;

	public RevenueReport(Map<String, Double> revenue) {
		this.revenue = revenue;
	}

	@Override
	public String toString() {
		return "RevenueReport [localDateTime=" + localDateTime + ", revenue=" + revenue + "]";
	}

}
