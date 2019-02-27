# three2one assessment

1. **Clone the application**

	```bash
	git clone https://github.com/Sherif93/three2one
	cd three2one
	```

2. **Run the app**

	You can run the spring boot app by typing the following command -

	```bash
	mvn spring-boot:run
	```

	The server will start on port 8080.

3. **H2 in-memory database**

    open http://localhost:8080/h2-console
    JDBC URL: jdbc:h2:mem:testdb

4. **Call APIs**
    
    All APIs are required to enter Basic Auth: 
        Username: user1
        Password: user1Pass
    
    Except listing all courses (  http://localhost:8080/api/courses/all ) can be called without authentication
	

