package com.care.KorTravel.dto;

public class PaymentDTO {
	  private String id;
	    private String payDate;
	    private String payOption;
	    private String ticketName;
	    private String ticketPerson;
	    private int totalPrice;
	    private int num;
	    private String img;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getPayDate() {
			return payDate;
		}
		public void setPayDate(String payDate) {
			this.payDate = payDate;
		}
		public String getPayOption() {
			return payOption;
		}
		public void setPayOption(String payOption) {
			this.payOption = payOption;
		}
		public String getTicketName() {
			return ticketName;
		}
		public void setTicketName(String ticketName) {
			this.ticketName = ticketName;
		}
		public String getTicketPerson() {
			return ticketPerson;
		}
		public void setTicketPerson(String ticketPerson) {
			this.ticketPerson = ticketPerson;
		}
		public int getTotalPrice() {
			return totalPrice;
		}
		public void setTotalPrice(int totalPrice) {
			this.totalPrice = totalPrice;
		}
		public int getNum() {
			return num;
		}
		public void setNum(int num) {
			this.num = num;
		}
		public String getImg() {
			return img;
		}
		public void setImg(String img) {
			this.img = img;
		}
}
