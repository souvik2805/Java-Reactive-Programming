package reactivefromudemy.sec03_flux_programmatically.helper;

import java.util.function.Consumer;

import reactivefromudemy.courseUtil.Util;
import reactor.core.publisher.FluxSink;

public class NameProducer implements Consumer<FluxSink<String>> {

	private FluxSink<String> fluxSink;

	@Override
	public void accept(FluxSink<String> t) {
		this.fluxSink = t;
	}

	public void produce() {
		String name = Util.faker().name().fullName();
		String thread = Thread.currentThread().getName();
		this.fluxSink.next(thread + " : " + name);
	}
}
