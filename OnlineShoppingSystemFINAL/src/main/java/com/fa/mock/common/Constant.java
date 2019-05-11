package com.fa.mock.common;

public class Constant {
	public static final String LOGIN_CUSTOMER = "FROM Customer WHERE User_Name = :userName AND Password = :password";
	public static final String LOGIN_ADMIN = "FROM UserSystem WHERE User_Name = :userName AND Password = :password";
	public static final String GET_USER_ROLE = "SELECT Role.Role_Name FROM " + 
			"((Role INNER JOIN UserSystem_Role ON Role.Role_Id = UserSystem_Role.Role_Id) " + 
			"       INNER JOIN UserSystem ON UserSystem.User_Id=  UserSystem_Role.User_Id )";
	public static final String GET_ALL_PRODUCT = "FROM Product";
	public static final String GET_PRODUCT = "FROM Product WHERE Product_Id = :productId";
	
	public static final String GET_ALL_CATEGORY = "FROM Category";
	public static final String GET_All_MANUFACTURER = "From Manufacturer";
	public static final String GET_PRODUCT_BY_CATEGORY = "From Category WHERE Category_Id = (SELECT Category_Id FROM dbo.Category WHERE category_Name = :category_Name)";
	public static final String GET_PRODUCT_BY_MANUFACTURER = "From Manufacturer WHERE Manufacturer_Id = (SELECT Manufacturer_Id FROM dbo.Manufacturer WHERE Manufacturer_Name = :Manufacturer_Name)";
	public static final String DATE_FORMATE = "yyyy-MM-dd HH:mm:ss";
	public static final String INSERT_ORDERDETAILS = "INSERT INTO OrderDetails(Product_Id, Order_Id, Unit_Price, Quantity) VALUES (?, ?, ?, ?)";
	public static final String GET_LIST_PRODUCT_BY_CATEGORY = "From Product WHERE Category_Id = :Category_Id";
	public static final String GET_LIST_PRODUCT_BY_MANUFACTURER = "From Product WHERE Manufacturer_Id = :Manufacturer_Id";
	public static final String COUNT_TOTAL_PRODUCT = "SELECT COUNT(*) FROM Product";
	public static final int OFFSET = 0;
	public static final int MAX_RESULT_PER_PAGE = 8;
	public static final String FIND_PRODUCT_BY_NAME = "FROM Product WHERE Product_Name LIKE :productName";
}
