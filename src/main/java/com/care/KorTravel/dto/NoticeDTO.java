package com.care.KorTravel.dto;

public class NoticeDTO {

	private int num, hit;
	private String title, content, writeDate;
	private int next, last;
	private String nexttitle, lasttitle;
	private String fileName;
	
	
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getNext() {
		return next;
	}
	public void setNext(int next) {
		this.next = next;
	}
	public int getLast() {
		return last;
	}
	public void setLast(int last) {
		this.last = last;
	}
	public String getNexttitle() {
		return nexttitle;
	}
	public void setNexttitle(String nexttitle) {
		this.nexttitle = nexttitle;
	}
	public String getLasttitle() {
		return lasttitle;
	}
	public void setLasttitle(String lasttitle) {
		this.lasttitle = lasttitle;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
}
