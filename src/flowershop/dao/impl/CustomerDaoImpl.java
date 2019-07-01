package flowershop.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import flowershop.dao.BaseDao;
import flowershop.dao.CustomerDao;
import flowershop.entity.Customer;

public class CustomerDaoImpl extends BaseDao implements CustomerDao{

	@Override
	public void add(Customer customer) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			stmt = conn.createStatement();
			String sql="insert into customer values("+customer.getUserId()+",'"+customer.getUserName()+"','"+customer.getUserPassword()+"',"+customer.getVipLevel()+","+customer.getcBalance()+")";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, stmt, rs);
		}
		
	}

	@Override
	public void delete(Customer customer) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			stmt = conn.createStatement();
			String sql="delete from customer where id='"+customer.getUserId()+"'";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, stmt, rs);
		}
		
	}

	@Override
	public void update(Customer customer) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			stmt = conn.createStatement();
			String sql="update customer set name='"+customer.getUserName()+"',password='"+customer.getUserPassword()+"'"
					+ ",vipLevel="+customer.getVipLevel()+",balance="+customer.getcBalance()+" where id="+customer.getUserId()+"";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, stmt, rs);
		}
		
	}

	@Override
	public Customer findById(int id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Customer customer=new Customer();
		try {
			conn = this.getConnection();
			stmt = conn.createStatement();
			String sql="select * from customer where id="+id+"";
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				customer.setUserId(rs.getInt("id"));
				customer.setUserName(rs.getString("name"));
				customer.setUserPassword(rs.getString("password"));
				customer.setVipLevel(rs.getInt("vipLevel"));
				customer.setcBalance(rs.getDouble("balance"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, stmt, rs);
		}
		return customer;
	}

	@Override
	public List<Customer> findByName(String name) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Customer> customerList=new ArrayList<Customer>();
		try {
			conn = this.getConnection();
			stmt = conn.createStatement();
			String sql="select * from customer where name='"+name+"'";
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				Customer customer=new Customer();
				customer.setUserId(rs.getInt("id"));
				customer.setUserName(rs.getString("name"));
				customer.setUserPassword(rs.getString("password"));
				customer.setVipLevel(rs.getInt("vipLevel"));
				customer.setcBalance(rs.getDouble("balance"));
				customerList.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, stmt, rs);
		}
		return customerList;
	}

	@Override
	public List<Customer> findByVipLevel(int level) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Customer> customerList=new ArrayList<Customer>();
		try {
			conn = this.getConnection();
			stmt = conn.createStatement();
			String sql="select * from customer where vipLevel="+level+"";
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				Customer customer=new Customer();
				customer.setUserId(rs.getInt("id"));
				customer.setUserName(rs.getString("name"));
				customer.setUserPassword(rs.getString("password"));
				customer.setVipLevel(rs.getInt("vipLevel"));
				customer.setcBalance(rs.getDouble("balance"));
				customerList.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, stmt, rs);
		}
		return customerList;
	}
	public List<Customer> findAll(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Customer> customerList=new ArrayList<Customer>();
		try {
			conn = this.getConnection();
			stmt = conn.createStatement();
			String sql="select * from customer";
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				Customer customer=new Customer();
				customer.setUserId(rs.getInt("id"));
				customer.setUserName(rs.getString("name"));
				customer.setUserPassword(rs.getString("password"));
				customer.setVipLevel(rs.getInt("vipLevel"));
				customer.setcBalance(rs.getDouble("balance"));
				customerList.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, stmt, rs);
		}
		return customerList;
	}

}
