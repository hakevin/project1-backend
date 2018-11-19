package com.revature.beans;

public class ReimbursementBean {
	
	private int ID;
	private int amount;
	private String submitted;
	private String resolved;
	private String description;
	private int author;
	private int resolver;
	private int statusID;
	private int typeID;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getSubmitted() {
		return submitted;
	}
	public void setSubmitted(String submitted) {
		this.submitted = submitted;
	}
	public String getResolved() {
		return resolved;
	}
	public void setResolved(String resolved) {
		this.resolved = resolved;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAuthor() {
		return author;
	}
	public void setAuthor(int author) {
		this.author = author;
	}
	public int getResolver() {
		return resolver;
	}
	public void setResolver(int resolver) {
		this.resolver = resolver;
	}
	public int getStatusID() {
		return statusID;
	}
	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}
	public int getTypeID() {
		return typeID;
	}
	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}
	@Override
	public String toString() {
		return "ReimbursementBean [ID=" + ID + ", amount=" + amount + ", submitted=" + submitted + ", resolved="
				+ resolved + ", description=" + description + ", author=" + author + ", resolver=" + resolver
				+ ", statusID=" + statusID + ", typeID=" + typeID + "]";
	}
	public ReimbursementBean(int iD, int amount, String submitted, String resolved, String description, int author,
			int resolver, int statusID, int typeID) {
		super();
		ID = iD;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.author = author;
		this.resolver = resolver;
		this.statusID = statusID;
		this.typeID = typeID;
	}
	
	public ReimbursementBean(int iD) {
	ID = iD;	
	}
	
	public ReimbursementBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
