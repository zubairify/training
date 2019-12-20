package com.papaya.dao;

import java.util.List;

import com.papaya.bean.LoginBean;
import com.papaya.bean.ProductBean;
import com.papaya.bean.UserBean;

public interface ShoppingDao {
	
	UserBean authenticate(LoginBean login);
	
	boolean persist(UserBean user);	
	
	List<ProductBean> getCatalog();
	
	ProductBean getProduct(int code);
}
