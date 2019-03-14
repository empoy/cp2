package com.sampoytech.shopaholic;

import java.util.ArrayList;

public abstract class Connection {
	abstract Boolean delete(String id);
	abstract Boolean updateUser(User user);
	abstract Boolean updateProduct(Product product) ;
	abstract Boolean adder(Object obj);
	abstract ArrayList<User> listerUser();
	abstract ArrayList<Product> listerProduct();
	abstract Object select(String id);
	
}
