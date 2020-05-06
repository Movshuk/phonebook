Служба phonebook для хранения данных абонентов через REST сервис.

###Инсталяция:
(тесты пропускаются)
mvn -Dmaven.test.skip=true install

###Swagger:
http://localhost:8080/swagger-ui.html#/

###Примеры запросов
    http://localhost:8080/api/phonebook/persons/search?firstName=Leo
    http://localhost:8080/api/phonebook/all-details/28

###При работе с /api/phonebook/persons/search
1) Если параметр поиска заполнен - возвращаются записи, удовлетворяющие поиску
2) Если параметру пустой - то возвращаются все записи в таблице

###Junit
Протестирован класс PersonServiceImpl

###Сборка Docker:
sudo docker-compose up

###Примечание:
    Убедиться что время сервера MySql UTC