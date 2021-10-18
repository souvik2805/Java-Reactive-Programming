package reactivefromudemy.sec09_batching.helper;

import com.github.javafaker.Book;

import reactivefromudemy.courseUtil.Util;

public class BookOrder {

	private String title;
	private String authoer;
	private String category;
	private double price;

	public BookOrder() {
		Book book = Util.faker().book();
		this.title = book.title();
		this.authoer = book.author();
		this.category = book.genre();
		this.price = Double.parseDouble(Util.faker().commerce().price());
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthoer() {
		return authoer;
	}

	public void setAuthoer(String authoer) {
		this.authoer = authoer;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "BookOrder [title=" + title + ", authoer=" + authoer + ", category=" + category + ", price=" + price
				+ "]";
	}

}
