package reactivefromudemy.sec12_context;

import reactivefromudemy.courseUtil.Util;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;

public class Lec01Context {

	public static void main(String[] args) {
		getWelcomeMsg()
		.contextWrite(context->context.put("user", context.get("user").toString().toUpperCase()))
//		.contextWrite(Context.of("usera", "souvik"))
		.contextWrite(Context.of("user", "sam"))
		.subscribe(Util.subscriber());
	}

	private static Mono<String> getWelcomeMsg() {
//		return Mono.fromSupplier(() -> {
//			return "Welcome";
//		});

		return Mono.deferContextual(context -> {
			if (context.hasKey("user")) {
				return Mono.just("Welcome " + context.get("user"));
			} else {
				return Mono.error(new RuntimeException("Unauthenticated"));
			}
		});
	}
}
