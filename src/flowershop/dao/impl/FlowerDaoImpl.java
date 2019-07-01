package flowershop.dao.impl;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import flowershop.dao.BaseDao;
import flowershop.dao.FlowerDao;

import flowershop.entity.Flower;

public class FlowerDaoImpl extends BaseDao implements FlowerDao{

	@Override
	public void add(Flower flower) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			stmt = conn.createStatement();
			String sql="insert into flower values("+flower.getfId()+",'"+flower.getfName()+"','"+flower.getfType()+"',"+flower.getfNum()+","+flower.getfPrice()+","+flower.getfUpNum()+",'"+flower.getfUpTime()+"',"+flower.getfSell()+")";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, stmt, rs);
		}
	}

	@Override
	public void delete(Flower flower) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			stmt = conn.createStatement();
			String sql = "delete from flower where id="+flower.getfId()+"";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, stmt, rs);
		}
		
	}

	@Override
	public void update(Flower flower) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			stmt = conn.createStatement();
			String sql = "update flower set name='"+flower.getfName()+"',type='"+flower.getfType()+"',num="+flower.getfNum()+",price="+flower.getfPrice()+",upNum="+flower.getfUpNum()+",upTime='"+flower.getfUpTime()+"',sell="+flower.getfSell()+" where id="+flower.getfId()+"";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, stmt, rs);
		}
	}

	@Override
	public Flower findById(int id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Flower flower=null;
		try {
			conn = this.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from flower where id="+id+"";
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				flower=new Flower();
				flower.setfId(rs.getInt("id"));
				flower.setfName(rs.getString("name"));
				flower.setfType(rs.getString("type"));
				flower.setfNum(rs.getInt("num"));
				flower.setfPrice(rs.getDouble("price"));
				flower.setfUpNum(rs.getInt("upNum"));
				flower.setfUpTime(rs.getString("upTime"));
				flower.setfSell(rs.getDouble("sell"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, stmt, rs);
		}
		return flower;
	}

	@Override
	public Flower findByName(String name) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Flower flower=null;
		try {
			conn = this.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from flower where id="+name+"";
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				flower=new Flower();
				flower.setfId(rs.getInt("id"));
				flower.setfName(rs.getString("name"));
				flower.setfType(rs.getString("type"));
				flower.setfNum(rs.getInt("num"));
				flower.setfPrice(rs.getDouble("price"));
				flower.setfUpNum(rs.getInt("upNum"));
				flower.setfUpTime(rs.getString("upTime"));
				flower.setfSell(rs.getDouble("sell"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, stmt, rs);
		}
		return flower;
	}

	@Override
	public List<Flower> findByType(String type) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Flower> flowerList=new ArrayList<Flower>();
		try {
			conn = this.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from flower where type="+type+"";
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				Flower flower=new Flower();
				flower.setfId(rs.getInt("id"));
				flower.setfName(rs.getString("name"));
				flower.setfType(rs.getString("type"));
				flower.setfNum(rs.getInt("num"));
				flower.setfPrice(rs.getDouble("price"));
				flower.setfUpNum(rs.getInt("upNum"));
				flower.setfUpTime(rs.getString("upTime"));
				flower.setfSell(rs.getDouble("sell"));
				flowerList.add(flower);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, stmt, rs);
		}
		return flowerList;
	}

	@Override
	public List<Flower> findByPrice(double price) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Flower> flowerList=new ArrayList<Flower>();
		try {
			conn = this.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from flower where price="+price+"";
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				Flower flower=new Flower();
				flower.setfId(rs.getInt("id"));
				flower.setfName(rs.getString("name"));
				flower.setfType(rs.getString("type"));
				flower.setfNum(rs.getInt("num"));
				flower.setfPrice(rs.getDouble("price"));
				flower.setfUpNum(rs.getInt("upNum"));
				flower.setfUpTime(rs.getString("upTime"));
				flower.setfSell(rs.getDouble("sell"));
				flowerList.add(flower);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, stmt, rs);
		}
		return flowerList;
	}

	@Override
	public List<Flower> findAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Flower> flowerList=new ArrayList<Flower>();
		try {
			conn = this.getConnection();
			stmt = conn.createStatement();
			String sql = "select * from flower order by sell";
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				Flower flower=new Flower();
				flower.setfId(rs.getInt("id"));
				flower.setfName(rs.getString("name"));
				flower.setfType(rs.getString("type"));
				flower.setfNum(rs.getInt("num"));
				flower.setfPrice(rs.getDouble("price"));
				flower.setfUpNum(rs.getInt("upNum"));
				flower.setfUpTime(rs.getString("upTime"));
				flower.setfSell(rs.getDouble("sell"));
				flowerList.add(flower);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, stmt, rs);
		}
		return flowerList;
	}
	
}
