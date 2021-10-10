package reactivefromudemy.sec03_flux_programmatically.assignment;

import java.nio.file.Path;
import java.nio.file.Paths;

import reactivefromudemy.courseUtil.Util;

public class Lec10FileReaderServiceAssignment {

	public static void main(String[] args) {
		FileReaderService readerService = new FileReaderService();
		Path path = Paths.get("src/main/resources/assignment/sec03_fluxProgram/file01.txt");

		readerService.read(path).take(20).subscribe(Util.subscriber());

	}
}
