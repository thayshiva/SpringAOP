package org.hibernate.tutorial.domain;

import java.util.Date;

public class Event {
	private long id;
	private String title;
	private Date date;
	
	public Event(){
	}

	public long getId() {
		return id;
	}

	private void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
