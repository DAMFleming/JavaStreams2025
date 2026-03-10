package fp.dam.java.streams.classicmodels;

import java.time.LocalDate;
import java.util.Objects;

public class Order implements Comparable<Order> {

	private int orderNumber;
	private LocalDate orderDate;
	private LocalDate requiredDate;
	private LocalDate shippedDate;
	private String status;
	private String comments;
	private int customerNumber;
	
	public Order(String csvLine) {
		String [] tokens = csvLine.split("\\|");
		orderNumber = Integer.parseInt(tokens[0]);
		orderDate = tokens[1].length() == 0 ? null: LocalDate.parse(tokens[1]);
		requiredDate = tokens[2].length() == 0 ? null: LocalDate.parse(tokens[2]);
		shippedDate = tokens[3].length() == 0 ? null: LocalDate.parse(tokens[3]);
		status = tokens[4];
		comments = tokens[5];
		customerNumber = Integer.parseInt(tokens[6]);
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public LocalDate getRequiredDate() {
		return requiredDate;
	}

	public LocalDate getShippedDate() {
		return shippedDate;
	}
	
	public String getStatus() {
		return status;
	}

	public String getComments() {
		return comments;
	}

	public int getCustomerNumber() {
		return customerNumber;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(comments, customerNumber, orderDate, orderNumber, requiredDate, shippedDate, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(comments, other.comments) && customerNumber == other.customerNumber
				&& Objects.equals(orderDate, other.orderDate) && orderNumber == other.orderNumber
				&& Objects.equals(requiredDate, other.requiredDate) && Objects.equals(shippedDate, other.shippedDate)
				&& Objects.equals(status, other.status);
	}

	@Override
	public String toString() {
		return "Order [orderNumber=" + orderNumber + ", orderDate=" + orderDate + ", requiredDate=" + requiredDate
				+ ", shippedDate=" + shippedDate + ", status=" + status + ", comments=" + comments + ", customerNumber="
				+ customerNumber + "]";
	}

	@Override
	public int compareTo(Order o) {
		int r = orderDate.compareTo(o.orderDate);
		return r == 0 ? orderNumber - o.orderNumber : r;
	}
	
	
	
}
