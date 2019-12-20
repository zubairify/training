package com.papaya.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.papaya.bean.LoginBean;
import com.papaya.bean.ProductBean;
import com.papaya.bean.UserBean;

public class ShoppingDaoImpl implements ShoppingDao {
	
	private Connection getConnection() throws SQLException {
		DataSource ds = null;
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/myoracle");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new SQLException(e.getMessage());
		}
		Connection conn = ds.getConnection();
		return conn;
	}

	@Override
	public UserBean authenticate(LoginBean login) {
		String sql = "select * from users where email=? and password=?";
		Connection conn = null;
		UserBean user = null;
		
		try {
			conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, login.getEmail());
			stmt.setString(2, login.getPassword());
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				user = new UserBean();
				user.setName(rs.getString(1));
				user.setEmail(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setAge(rs.getInt(4));
				user.setGender(rs.getString(5));
				user.setCity(rs.getString(6));
				user.setMobile(rs.getString(7));
			}
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean persist(UserBean user) {
		String sql = "insert into users values (?,?,?,?,?,?,?)";
		Connection conn = null;
		
		try {
			conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getPassword());
			stmt.setInt(4, user.getAge());
			stmt.setString(5, user.getGender());
			stmt.setString(6, user.getCity());
			stmt.setString(7, user.getMobile());
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public ProductBean getProduct(int code) {
		String sql = "select * from products where code=?";
		Connection conn = null;
		ProductBean product = null;
		
		try {
			conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, code);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				product = new ProductBean();
				product.setCode(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setPrice(rs.getDouble(3));
			} 
			return product;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<ProductBean> getCatalog() {
		String sql = "select * from products";
		Connection conn = null;
		List<ProductBean> catalog = new ArrayList<ProductBean>();
		
		try {
			conn = getConnection();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			while(rs.next()) {
				ProductBean product = new ProductBean();
				product.setCode(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setPrice(rs.getDouble(3));
				catalog.add(product);
			}
			return catalog;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}

