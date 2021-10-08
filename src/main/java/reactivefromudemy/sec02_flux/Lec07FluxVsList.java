package reactivefromudemy.sec02_flux;

import java.util.List;

import reactivefromudemy.courseUtil.Util;
import reactivefromudemy.sec02_flux.helper.NameGenerator;

public class Lec07FluxVsList {
	public static void main(String[] args) {

//		List<String> names = NameGenerator.getNames(5);
//		System.out.println(names);

		NameGenerator.getNamesFlux(5).subscribe(Util.onNext());

	}
}
