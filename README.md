# Product-demo
A demo application to create edit and delete products.
It's possible to create products by sending a message to an ActiveMQ queue

## Start MySQL
```
docker run -d --name mysql_database -e MYSQL_USER=user -e MYSQL_PASSWORD=pass -e MYSQL_ROOT_PASSWORD=pass -e MYSQL_DATABASE=db -p 3306:3306 centos/mysql-57-centos7
```

## Start ActiveMQ
```
docker run --name='activemq' -d -p 61616:61616 -p 8161:8161 webcenter/activemq:latest
```
## Start the application
```
mvn clean install
java -jar target/spring-boot-web-0.0.2-SNAPSHOT.jar
```
Browse to [http://localhost:8080](http://localhost:8080)

## ActiveMq Console

Browse to [send to queue](http://localhost:8161/admin/send.jsp?JMSDestination=product.queue&JMSDestinationType=queue)
user: admin
password: admin

Send a product example :
```
{
"productId": "coffee-1",
"name": "coffee",
"price": 10.5
}
```
