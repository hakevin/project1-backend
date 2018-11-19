
package com.revature.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.JoinReimbBean;
import com.revature.beans.ReimbursementBean;
import com.revature.connection.ConnectionUtil;

public class ReimbursementDAOImpl implements ReimbursementDAO {

	@Override
	public List<JoinReimbBean> getReimbursementList(int author) {
		List<JoinReimbBean> reimburse = new ArrayList<JoinReimbBean>();
		Connection con = ConnectionUtil.getConnection();
		try {
			System.out.println(author);
			PreparedStatement ps = con.prepareStatement("select er.reimb_id, er.reimb_amount, er.reimb_submitted, er.reimb_resolved, er.reimb_description, eu.user_first_name as author_fname, eu.user_last_name as author_lname, \r\n" + 
					"ue.user_first_name as resolver_fname, ue.user_last_name as resolver_lname, s.reimb_status, t.reimb_type, er.reimb_author, er.reimb_resolver, er.reimb_status_id, \r\n" + 
					"er.reimb_type_id from ers_reimbursement er\r\n" + 
					"join ers_users eu on eu.ers_users_id = er.reimb_author\r\n" + 
					"join ers_users ue on ue.ers_users_id = er.reimb_resolver\r\n" + 
					"join ers_reimbursement_status s ON s.reimb_status_id = er.reimb_status_id\r\n" + 
					"join ers_reimbursement_type t ON t.reimb_type_id = er.reimb_type_id\r\n" + 
					"where eu.ers_users_id = ?");
			ps.setInt(1, author);
			JoinReimbBean s = null;
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				s = new JoinReimbBean(
						rs.getInt("reimb_id"),
						rs.getInt("reimb_amount"), 
						rs.getString("reimb_submitted"), 
						rs.getString("reimb_resolved"), 
						rs.getString("reimb_description"), 
						rs.getString("author_fname"),
						rs.getString("author_lname"), 
						rs.getString("resolver_fname"), 
						rs.getString("resolver_lname"), 
						rs.getString("reimb_status"),
						rs.getString("reimb_type"),
						rs.getInt("reimb_author"),
						rs.getInt("reimb_resolver"),
						rs.getInt("reimb_status_id"),
						rs.getInt("reimb_type_id"));
					reimburse.add(s);
			}
			
			return reimburse;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return reimburse;
	}
	
	@Override
	public List<JoinReimbBean> getAllReimbursements() {
		List<JoinReimbBean> reimburse = new ArrayList<JoinReimbBean>();
		Connection con = ConnectionUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select er.reimb_id, er.reimb_amount, er.reimb_submitted, er.reimb_resolved, er.reimb_description, eu.user_first_name as author_fname, eu.user_last_name as author_lname, \r\n" + 
					"ue.user_first_name as resolver_fname, ue.user_last_name as resolver_lname, s.reimb_status, t.reimb_type, er.reimb_author, er.reimb_resolver, er.reimb_status_id, \r\n" + 
					"er.reimb_type_id from ers_reimbursement er\r\n" + 
					"join ers_users eu on eu.ers_users_id = er.reimb_author\r\n" + 
					"join ers_users ue on ue.ers_users_id = er.reimb_resolver\r\n" + 
					"join ers_reimbursement_status s ON s.reimb_status_id = er.reimb_status_id\r\n" + 
					"join ers_reimbursement_type t ON t.reimb_type_id = er.reimb_type_id\r\n" + 
					"where eu.ers_users_id = er.reimb_author and ue.ers_users_id = er.reimb_resolver;");
			JoinReimbBean s = null;
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				s = new JoinReimbBean(
						rs.getInt("reimb_id"),
						rs.getInt("reimb_amount"), 
						rs.getString("reimb_submitted"), 
						rs.getString("reimb_resolved"), 
						rs.getString("reimb_description"), 
						rs.getString("author_fname"),
						rs.getString("author_lname"), 
						rs.getString("resolver_fname"), 
						rs.getString("resolver_lname"), 
						rs.getString("reimb_status"),
						rs.getString("reimb_type"),
						rs.getInt("reimb_author"),
						rs.getInt("reimb_resolver"),
						rs.getInt("reimb_status_id"),
						rs.getInt("reimb_type_id"));
					reimburse.add(s);
			}
			
			return reimburse;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return reimburse;
	}
	
	@Override
	public void submitReimbursementList(ReimbursementBean rBean) {
		Connection con = ConnectionUtil.getConnection();
		try {
			System.out.println(rBean);
			PreparedStatement ps = con.prepareStatement
						("insert into ers_reimbursement values (NEXTVAL('reimb_id_seq'), ?, now(), now(), ?, ?, 2, 2, ?)");
			
			ps.setFloat(1, rBean.getAmount());
			ps.setString(2, rBean.getDescription());
			ps.setInt(3, rBean.getAuthor());
			ps.setInt(4, rBean.getTypeID());
			ps.executeUpdate();
			
	

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public void approve(ReimbursementBean rBean) {
		try {
			Connection con = ConnectionUtil.getConnection();
			System.out.println(rBean);
			PreparedStatement ps = con.prepareStatement
						("UPDATE ers_reimbursement SET reimb_status_id = 1, reimb_resolver = 2 WHERE reimb_id= ?");
			
			ps.setInt(1, rBean.getID());
			ps.executeUpdate();
			
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deny(ReimbursementBean rBean) {
		try {
			Connection con = ConnectionUtil.getConnection();
			System.out.println(rBean);
			PreparedStatement ps = con.prepareStatement
						("UPDATE ers_reimbursement SET reimb_status_id = 3, reimb_resolver = 2 WHERE reimb_id = ?");
			
			ps.setInt(1, rBean.getID());
			ps.executeUpdate();
			
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
