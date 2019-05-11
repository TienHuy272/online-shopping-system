CREATE DATABASE SHOPPING 
GO
USE SHOPPING	

DROP DATABASE SHOPPING
GO
CREATE TABLE dbo.UserSystem
(
	User_Id int IDENTITY(1,1),
	User_Name varchar(50),
	Password varchar(50),
	CONSTRAINT PK_ADMIN PRIMARY KEY (User_Id)
)
GO

CREATE TABLE dbo.Product
(
	Product_Id int IDENTITY(1,1),
	Manufacturer_Id int,
	Category_Id int,
	Product_Name VARCHAR(100) UNIQUE NOT NULL,
	Unit_Price FLOAT NOT NULL,
	Units_In_Stock INT NOT NULL,
	Description VARCHAR(100),
	Condition VARCHAR(10),
	Product_Image_File VARCHAR(100),
	CONSTRAINT PK_PRODUCT PRIMARY KEY (Product_Id),
	CONSTRAINT FK_PRODUCT_MANUFACTURER FOREIGN KEY (Manufacturer_Id) REFERENCES Manufacturer(Manufacturer_Id),
	CONSTRAINT FK_PRODUCT_CATEGORY FOREIGN KEY (Category_Id) REFERENCES Category(Category_Id)
)
GO
CREATE TABLE dbo.Manufacturer 

(	
	Manufacturer_Id int IDENTITY,
	Manufacturer varchar(50),
	CONSTRAINT PK_MANUFACTURE PRIMARY KEY (Manufacturer_Id),
)
GO
CREATE TABLE dbo.Category
(
	Category_Id int IDENTITY,
	Catetory varchar(50),
	CONSTRAINT PK_CATEGORY PRIMARY KEY (Category_Id) ,
)
GO
CREATE TABLE dbo.Customer(
	Customer_Id int IDENTITY(1,1),
	User_Name VARCHAR(50) UNIQUE NOT NULL,
	Password VARCHAR(50) NOT NULL,
	Last_Name VARCHAR(50) NOT NULL,
	First_Name VARCHAR(50) NOT NULL,
	Country VARCHAR(50),
	Company_Name VARCHAR(50),
	City VARCHAR(50),
	State VARCHAR(10),
	Phone VARCHAR(20),
	CONSTRAINT PK_CUSTOMER PRIMARY KEY (Customer_Id)
)​
GO
CREATE TABLE dbo.Orders 
(
	Order_Id int IDENTITY(1,1),
	Customer_Id int,
	Order_Date date,
	CONSTRAINT PK_ORDER PRIMARY KEY (Order_Id),
	CONSTRAINT FK_ORDER_CUSTOMER FOREIGN KEY (Customer_Id) REFERENCES Customer(Customer_Id),
)

GO

CREATE TABLE dbo.OrderDetails 
(
	OrderDetails_Id int IDENTITY,
	Order_Id int,
	Product_Id int,
	Quantity int,
	Card_Number INT,
	Expires VARCHAR(6),
	Security_Code INT,
	Billing_Address_1 TEXT ,
	Billing_Address_2 TEXT ,
	Postal_Code INT,
	CONSTRAINT PK_ORDERDETAILS PRIMARY KEY (OrderDetails_Id),
	CONSTRAINT FK_ORDERDETAILS_ORDER  FOREIGN KEY (Order_Id) REFERENCES Orders(Order_Id),
	CONSTRAINT FK_ORDERDETAILS_PRODUCT FOREIGN KEY (Product_Id) REFERENCES Product(Product_Id)
)

INSERT INTO dbo.Customer (User_Name, Password, Last_Name, First_Name) VALUES ('tienhuy', '123', 'nguyen', 'tien huy')

SELECT * FROM dbo.Customer
SELECT * FROM dbo.Customer WHERe User_Name = 'tienhuy' AND Password = '123'
SELECT * FROM dbo.Product
GO
