package reactivefromudemy.sec02_flux;

import java.util.Arrays;
import java.util.List;

import reactivefromudemy.courseUtil.Util;
import reactor.core.publisher.Flux;

public class Lec03FluxFromArrayOrList {

	public static void main(String[] args) {

		List<String> strings = Arrays.asList("a", "b", "c");
		Flux.fromIterable(strings).subscribe(Util.onNext());

		Integer[] arr = { 1, 2, 2 };
		Flux.fromArray(arr).subscribe(Util.onNext());
	}

}
