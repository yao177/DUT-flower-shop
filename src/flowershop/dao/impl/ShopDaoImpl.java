package flowershop.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import flowershop.dao.BaseDao;
import flowershop.dao.ShopDao;
import flowershop.entity.Shop;

public class ShopDaoImpl extends BaseDao implements ShopDao{

	@Override
	public void add(Shop shop) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			stmt = conn.createStatement();
			int tiny=(shop.issIsShopped()==true)?1:0;
			String sql="insert into shop values("+shop.getsId()+","+shop.getsUserId()+","+tiny+","+shop.getsMoney()+")";
			stmt.executeUpdate(sql);
			sql="create table "+"shop"+Integer.toString(shop.getsId())+"(fId int,fNum int,primary key(fId));";
			stmt.executeUpdate(sql);
			Set<Integer> keys=shop.getsBasket().keySet();
			for(Integer key:keys) {
				int fid=key.intValue();
				//System.out.println(fid);
				int fnum=shop.getsBasket().get(key).intValue();
				sql="insert into "+"shop"+Integer.toString(shop.getsId())+" values("+fid+","+fnum+")";
				stmt.executeUpdate(sql);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, stmt, rs);
		}
		
	}

	@Override
	/*public void delete(Shop shop) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			stmt = conn.createStatement();
			String sql = "drop table "+"";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, stmt, rs);
		}
		
	}

	@Override*/
	public void update(Shop shop) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = this.getConnection();
			stmt = conn.createStatement();
			int tiny=(shop.issIsShopped()==true)?1:0;
			String sql="update shop set userId="+shop.getsUserId()+",isShopped="+tiny+",money="+shop.getsMoney()+" where id="+shop.getsId()+"";
			stmt.executeUpdate(sql);
			sql="select shop where id="+shop.getsId()+"";
			rs=stmt.executeQuery(sql);
			String id="";
			while(rs.next()) {
				id=Integer.toString(rs.getInt("id"));
			}
			Set<Integer> keys=shop.getsBasket().keySet();
			for(Integer key:keys) {
				int fid=key.intValue();
				int fnum=shop.getsBasket().get(key).intValue();
				sql="insert "+"shop"+Integer.toString(shop.getsId())+"values("+fid+","+fnum+")";
				stmt.executeUpdate(sql);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, stmt, rs);
		}
		
	}

	@Override
	public Shop findById(int id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Shop shop=new Shop();
		try {
			conn = this.getConnection();
			stmt = conn.createStatement();
			String sql="select * from shop where id="+id+"";
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				shop.setsId(rs.getInt("id"));
				shop.setsUserId(rs.getInt("userId"));
				shop.setsIsShopped(rs.getBoolean("isShopped"));
				shop.setsMoney(rs.getDouble("money"));
				String tableId="shop"+Integer.toString(rs.getInt("id"));
				sql="select * from "+tableId;
				Statement sstmt=conn.createStatement();
				ResultSet rrs=sstmt.executeQuery(sql);
				while(rrs.next()) {
					shop.getsBasket().put(Integer.valueOf(rrs.getInt("fId")), Integer.valueOf(rrs.getInt("fNum")));
				}
			}
		} catch (SQLException e) {
			//e.printStackTrace();
		} finally {
			this.closeAll(conn, stmt, rs);
		}
		return shop;
	}

	@Override
	public List<Shop> findByUseId(int id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Shop> shopList=new ArrayList<Shop>();
		try {
			conn = this.getConnection();
			stmt = conn.createStatement();
			String sql="select * from shop where userId="+id+"";
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				Shop shop =new Shop();
				shop.setsId(rs.getInt("id"));
				String tableId="shop"+Integer.toString(rs.getInt("id"));
				sql="select * from "+tableId;
				Statement sstmt=conn.createStatement();
				ResultSet rrs=sstmt.executeQuery(sql);
				while(rrs.next()) {
					shop.getsBasket().put(Integer.valueOf(rrs.getInt("fId")), Integer.valueOf(rrs.getInt("fNum")));
				}
				shop.setsUserId(rs.getInt("userId"));
				shop.setsIsShopped(rs.getBoolean("isShopped"));
				shop.setsMoney(rs.getDouble("money"));
				shopList.add(shop);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, stmt, rs);
		}
		return shopList;
	}

	@Override
	public int findAllNum() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Shop> shopList=new ArrayList<Shop>();
		try {
			conn = this.getConnection();
			stmt = conn.createStatement();
			String sql="select * from shop";
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				Shop shop =new Shop();
				shop.setsId(rs.getInt("id"));
				String tableId="shop"+Integer.toString(rs.getInt("id"));
				sql="select * from "+tableId;
				Statement sstmt=conn.createStatement();
				ResultSet rrs=sstmt.executeQuery(sql);
				while(rrs.next()) {
					shop.getsBasket().put(Integer.valueOf(rrs.getInt("fId")), Integer.valueOf(rrs.getInt("fNum")));
				}
				shop.setsUserId(rs.getInt("userId"));
				shop.setsIsShopped(rs.getBoolean("isShopped"));
				shop.setsMoney(rs.getDouble("money"));
				shopList.add(shop);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll(conn, stmt, rs);
		}
		return shopList.size();
	}
}
