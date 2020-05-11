# Phonebook
* Java
* Maven
* Hibernate
* Spring
* Swagger
* MySql
* Docker

### Смотреть на Heroku: https://phonebookrest.herokuapp.com/swagger-ui.html
Служба phonebook для хранения и обработки данных абонентов через REST сервис.

***
### Инсталяция:
(тесты пропускаются)
mvn -Dmaven.test.skip=true install

### DataBase:
![image](https://github.com/Movshuk/phonebook/blob/master/database/database_s.png)

### Swagger:
http://localhost:8080/swagger-ui.html#/

### Примеры запросов
    http://localhost:8080/api/phonebook/persons/search?firstName=Leo
    http://localhost:8080/api/phonebook/all-details/28

### При работе с /api/phonebook/persons/search
1. Если параметр поиска заполнен - возвращаются записи, удовлетворяющие поиску
2. Если параметру пустой - то возвращаются все записи в таблице

### Junit
Протестирован класс PersonServiceImpl

### Сборка Docker:
sudo docker-compose up

### Примечание:
* Убедиться что время сервера MySql UTC
* Убедиться что порт 3306 свободен для MySql сервера
* Docker построит службы на localhost для сервера и 3306 порту для MySql сервера
* Удаление записей из связанных таблиц One-To-Many организованной каскадно
* ./database содержит файл dump.sql для построения базы данных
