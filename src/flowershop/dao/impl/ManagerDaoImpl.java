package flowershop.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import flowershop.dao.BaseDao;
import flowershop.dao.ManagerDao;
import flowershop.entity.Customer;
import flowershop.entity.Manager;

public class ManagerDaoImpl extends BaseDao implements ManagerDao{

	@Override
	public void add(Manager manager) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			stmt = conn.createStatement();
			String sql="insert into manager values("+manager.getUserId()+",'"+manager.getUserName()+"','"+manager.getUserPassword()+"')";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, stmt, rs);
		}
		
	}

	@Override
	public void delete(Manager manager) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			stmt = conn.createStatement();
			String sql="delete from manager where id='"+manager.getUserId()+"')";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, stmt, rs);
		}
		
	}

	@Override
	public void update(Manager manager) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			stmt = conn.createStatement();
			String sql="update manager set name='"+manager.getUserName()+"',password='"+manager.getUserPassword()+"'"
					+ " where id="+manager.getUserId()+"";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, stmt, rs);
		}
	}

	@Override
	public Manager findById(int id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Manager manager =new Manager();
		try {
			conn = this.getConnection();
			stmt = conn.createStatement();
			String sql="select * from manager where id="+id+"";
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				manager.setUserId(rs.getInt("id"));
				manager.setUserName(rs.getString("name"));
				manager.setUserPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, stmt, rs);
		}
		return manager;
		
	}
	public List<Manager> findAll(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Manager> managerList =new ArrayList<Manager>();
		try {
			conn = this.getConnection();
			stmt = conn.createStatement();
			String sql="select * from manager";
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				Manager manager=new Manager();
				manager.setUserId(rs.getInt("id"));
				manager.setUserName(rs.getString("name"));
				manager.setUserPassword(rs.getString("password"));
				managerList.add(manager);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, stmt, rs);
		}
		return managerList;
		
	}

}
