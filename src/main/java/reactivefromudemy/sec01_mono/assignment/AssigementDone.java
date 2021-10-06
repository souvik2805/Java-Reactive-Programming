package reactivefromudemy.sec01_mono.assignment;

import reactivefromudemy.courseUtil.Util;

public class AssigementDone {

	public static void main(String[] args) {

		// FileService.write("file3.txt", "This is file3").subscribe(Util.onNext(),
		// Util.OnError(), Util.OnComplete());

		//FileService.read("file3.txt").subscribe(Util.onNext(), Util.OnError(), Util.OnComplete());
		FileService.delete("file3.txt").subscribe(Util.onNext(), Util.OnError(), Util.OnComplete());
	}
}
