# Library Management System using XForms
An application to manage the books in library

### Technology used

* Java
* XForms

### Installation and Configuration

* Persistence: MySQL database
* url: "jdbc:mysql://localhost:3306/fuji"
* DB name: fuji
* user name: "root"
* password: "root"

### Steps to run the app:
1. Clone the repository into a folder
2. Execute the DB scripts, which is in the misc folder in a file named library.sql.
3. Import the project in eclipse. File --> Import -> Existing Projects into workspace.
4. Make sure Tomcat is added to Eclipse.
5. Right click the project --> Run As --> Run on Server.

* Note: Please run Tomcat on port 9999.
	
### Tests for all DB operations are in test source folder (Using JUnit)

### Screen prints 
### 1. Home Screen - (Has navigation to Add and View page)

![alt text](/misc/home.jpg "Title")

### 2. Add Book screen

Success flow

![alt text](/misc/add1.jpg "Title")

When not all fields are entered/fields entered with unexpected format

![alt text](/misc/add2.jpg "Title")


### 3. View Screen

Searching for books (Wildcard search)

![alt text](/misc/view1.jpg "Title")

When title not entered

![alt text](/misc/view2.jpg "Title")

### 4. Borrow books

When books are available, borrowing books will reduce the copies left

![alt text](/misc/borr1.jpg "Title")

When books are not available, borrowing books option is not available

![alt text](/misc/borr2.jpg "Title")

### 5. Return books

When books are borrowed, returning books will increase the copies left

![alt text](/misc/return1.jpg "Title")

When books are not borrowed, return books option is not available

![alt text](/misc/return2.jpg "Title")

