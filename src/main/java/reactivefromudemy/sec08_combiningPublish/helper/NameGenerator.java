package reactivefromudemy.sec08_combiningPublish.helper;

import java.util.ArrayList;
import java.util.List;

import reactivefromudemy.courseUtil.Util;
import reactor.core.publisher.Flux;

public class NameGenerator {

	private List<String> list = new ArrayList<>();

	public Flux<String> generateNames() {
		return Flux.generate(stringSynchronousSink -> {
			System.out.println("generate fresh");
			Util.sleepSeconds(1);
			String name = Util.faker().name().firstName();
			list.add(name);
			stringSynchronousSink.next(name);
		}).cast(String.class).startWith(getFromCache());
	}

	private Flux<String> getFromCache() {
		return Flux.fromIterable(list);
	}

}
