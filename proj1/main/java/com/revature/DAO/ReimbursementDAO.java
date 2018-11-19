package com.revature.DAO;

import java.util.List;

import com.revature.beans.JoinReimbBean;
import com.revature.beans.ReimbursementBean;

public interface ReimbursementDAO{
	public abstract List<JoinReimbBean> getReimbursementList(int author);

	public abstract void submitReimbursementList(ReimbursementBean rBean);
	
	public abstract void approve(ReimbursementBean rBean);
	
	public abstract void deny(ReimbursementBean rBean);

	public abstract List<JoinReimbBean> getAllReimbursements();
	
}
