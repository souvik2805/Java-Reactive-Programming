package reactivefromudemy.sec12_context;

import reactivefromudemy.courseUtil.Util;
import reactivefromudemy.sec12_context.helper.BookService;
import reactivefromudemy.sec12_context.helper.UserService;
import reactor.util.context.Context;

public class Lec02ContextRateLimitDemo {

	public static void main(String[] args) {
//		
		BookService.getBook().repeat(3).contextWrite(UserService.userCategoryContext())
				.contextWrite(Context.of("user", "mike")).subscribe(Util.subscriber());
	}

}
