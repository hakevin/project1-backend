package com.revature.beans;

public class JoinReimbBean {
	private int ID;
	private int amount;
	private String submitted;
	private String resolved;
	private String description;
	private String firstName;
	private String lastName;
	private String resolverFirst;
	private String resolverLast;
	private String status;
	private String type;
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getResolverFirst() {
		return resolverFirst;
	}
	public void setResolverFirst(String resolverFirst) {
		this.resolverFirst = resolverFirst;
	}
	public String getResolverLast() {
		return resolverLast;
	}
	public void setResolverLast(String resolverLast) {
		this.resolverLast = resolverLast;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
		return "JoinReimbBean [ID=" + ID + ", amount=" + amount + ", submitted=" + submitted + ", resolved=" + resolved
				+ ", description=" + description + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", resolverFirst=" + resolverFirst + ", resolverLast=" + resolverLast + ", status=" + status
				+ ", type=" + type + ", author=" + author + ", resolver=" + resolver + ", statusID=" + statusID
				+ ", typeID=" + typeID + "]";
	}
	public JoinReimbBean(int iD, int amount, String submitted, String resolved, String description, String firstName,
			String lastName, String resolverFirst, String resolverLast, String status, String type, int author,
			int resolver, int statusID, int typeID) {
		super();
		ID = iD;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.firstName = firstName;
		this.lastName = lastName;
		this.resolverFirst = resolverFirst;
		this.resolverLast = resolverLast;
		this.status = status;
		this.type = type;
		this.author = author;
		this.resolver = resolver;
		this.statusID = statusID;
		this.typeID = typeID;
	}
	public JoinReimbBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
