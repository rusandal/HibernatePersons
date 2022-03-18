## Rest контроллер взаимодействия с БД (Hibernate)

### Описание
RestController предоставляющий возможность получать данные из БД, предварительно созданной с помощью миграции Liquebase.

### Предварительная настройка
Для функционирования программы необходимо:
1. Поднять Docker контейнер с БД. 
``` Пример
docker run -v /mysql_data:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=mysql -p 3306:3306  mysql
```
2. Изменить адрес БД в application.properties на внешний порт контейнера с MySql.
```
spring.datasource.url=jdbc:mysql://192.168.99.100:3306/person
```
3. Запустить Docker image.

### Создание таблиц БД и наполнение (Liquebase)
Для создания и наполнения используется liquebase framework. Мастер changelog (db.changelog-master.yaml) имеет 3 записи. 
1. Создание таблицы
2. Модификация таблицы
3. Наполнение таблицы данными

### Entity
```
@Entity
public class Persons{
    @Column(columnDefinition = "serial")
    private Integer id;
    @EmbeddedId
    private RelationShipId relationShipId;;
    private String phoneNumber;
    @Column(nullable = false)
    private String cityOfLiving;
}
@Embeddable
public class RelationShipId implements Serializable {
    private String name;
    private String surname;
    private Integer age;
}
```


### Реализация
#### Методы контроллера
Получение списка жителей:
1. По городу (вариант 1 - ... extends JpaRepository<Persons, RelationShipId>)
2. По городу (вариант 2 - EntityManager)
3. Отсортированный по возрасту (... extends JpaRepository<Persons, RelationShipId>)
4. Отсортированный по имени и фамилии (... extends JpaRepository<Persons, RelationShipId>)

### Используемые технологии
Spring Boot Web, Jpa/Hibernate, Docker, Liquebase