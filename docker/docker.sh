docker run -d --name mysql_database -e MYSQL_USER=user -e MYSQL_PASSWORD=pass -e MYSQL_ROOT_PASSWORD=pass -e MYSQL_DATABASE=db -p 3306:3306 centos/mysql-57-centos7

docker run --name='activemq' -d -p 61616:61616 -p 8161:8161 webcenter/activemq:latest


http://localhost:8080

http://localhost:8161/admin/queues.jsp

{
"productId": "coffee-1",
"name": "coffee",
"price": 10.5
}
