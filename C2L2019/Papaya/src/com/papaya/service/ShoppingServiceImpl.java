package com.papaya.service;

import java.util.List;

import com.papaya.bean.LoginBean;
import com.papaya.bean.ProductBean;
import com.papaya.bean.UserBean;
import com.papaya.dao.ShoppingDao;
import com.papaya.dao.ShoppingDaoImpl;

public class ShoppingServiceImpl implements ShoppingService {
	private ShoppingDao dao;
	
	public ShoppingServiceImpl() {
		dao = new ShoppingDaoImpl();
	}
	
	@Override
	public UserBean authenticate(LoginBean login) {
		return dao.authenticate(login);
	}

	@Override
	public boolean persist(UserBean user) {
			return dao.persist(user);
	}

	@Override
	public List<ProductBean> getCatalog() {
		return dao.getCatalog();
	}

	@Override
	public ProductBean getProduct(int code) {
		return dao.getProduct(code);
	}
}
