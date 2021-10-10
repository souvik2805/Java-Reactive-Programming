package reactivefromudemy.sec03_flux_programmatically.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Consumer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

public class FileReaderService {

	private Callable<BufferedReader> openReader(Path path) {
		return () -> Files.newBufferedReader(path);
	}

	private BiFunction<BufferedReader, SynchronousSink<String>, BufferedReader> read() {
		return (br, sink) -> {
			try {
				String line = br.readLine();
				if (Objects.isNull(line)) {
					sink.complete();
				} else {
					sink.next(line);
				}
			} catch (IOException e) {
				sink.error(e);
			}
			return br;
		};
	}

	private Consumer<BufferedReader> closeReader() {
		return br -> {
			try {
				br.close();
				System.out.println("***Closed***");
			} catch (IOException e) {
				e.printStackTrace();
			}
		};
	}

	public Flux<String> read(Path path) {
		return Flux.generate(openReader(path), read(), closeReader());
	}
}
