package com.sampoytech.shopaholic;

import java.io.IOException;
import java.util.ArrayList;

public abstract class Connection 
{
	abstract Boolean delete(String id) throws IOException;
	abstract Boolean updateUser(User user) throws IOException;
	abstract Boolean updateProduct(Product product)throws IOException ;
	abstract Boolean adderUser(User user) throws IOException;
	abstract Boolean adderProduct(Product product) throws IOException;
	abstract ArrayList<User> listerUser() throws IOException;
	abstract ArrayList<Product> listerProduct() throws IOException;
	abstract User selectUser(String id) throws IOException;
	abstract Product selectProduct(String id) throws IOException;	
}
