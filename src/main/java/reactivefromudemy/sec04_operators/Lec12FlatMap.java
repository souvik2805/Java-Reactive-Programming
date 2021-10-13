package reactivefromudemy.sec04_operators;

import reactivefromudemy.courseUtil.Util;
import reactivefromudemy.sec04_operators.helper.OrderService;
import reactivefromudemy.sec04_operators.helper.UserService;

public class Lec12FlatMap {

	public static void main(String[] args) {
//		UserService.getUsers().map(user -> OrderService.getOrders(user.getUserId())).subscribe(Util.subscriber());
//		UserService.getUsers().flatMap(user -> OrderService.getOrders(user.getUserId())).subscribe(Util.subscriber());
		
		UserService.getUsers().concatMap(user -> OrderService.getOrders(user.getUserId())).subscribe(Util.subscriber());
		
		
		Util.sleepSeconds(50);
	}
}
