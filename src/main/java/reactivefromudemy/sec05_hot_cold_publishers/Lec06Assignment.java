package reactivefromudemy.sec05_hot_cold_publishers;

import reactivefromudemy.courseUtil.Util;
import reactivefromudemy.sec05_hot_cold_publishers.assignment.InventoryService;
import reactivefromudemy.sec05_hot_cold_publishers.assignment.OrderService;
import reactivefromudemy.sec05_hot_cold_publishers.assignment.RevenueService;

public class Lec06Assignment {

	public static void main(String[] args) {
		OrderService orderService = new OrderService();
		RevenueService revenueService = new RevenueService();
		InventoryService inventoryService = new InventoryService();

		// revenue and inv - observe the order stream
		orderService.orderStream().subscribe(revenueService.subscribeOrderStream());
		orderService.orderStream().subscribe(inventoryService.subscribeOrderStream());

		inventoryService.inventoryStream().subscribe(Util.subscriber("inventory"));
		revenueService.revenueStream().subscribe(Util.subscriber("revenue"));

		Util.sleepSeconds(60);
	}
}
