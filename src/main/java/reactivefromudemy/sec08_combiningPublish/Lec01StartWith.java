package reactivefromudemy.sec08_combiningPublish;

import reactivefromudemy.courseUtil.Util;
import reactivefromudemy.sec08_combiningPublish.helper.NameGenerator;

public class Lec01StartWith {

	public static void main(String[] args) {

		NameGenerator generator = new NameGenerator();

		generator.generateNames().take(2).subscribe(Util.subscriber("souvik"));

		generator.generateNames().take(2).subscribe(Util.subscriber("abc"));
		generator.generateNames().filter(n -> n.startsWith("A")).take(3).subscribe(Util.subscriber("xyz"));
	}
}
