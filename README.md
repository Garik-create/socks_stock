# socks_stock
Проект по создангию приложения учёта носков на складе.

Данное приложение позволяет:
учесть приход и отпуск носков;
узнать общее количество носков определенного цвета и состава в данный момент времени.
Внешний интерфейс приложения представлен в виде REST запросов, которые можно осуществлять через POSTMAN - клиента.

Для запуска приложения необходимо скачать проект с GitHub, запустить проект через среду разработки JAVA. Т.к. приложение не подразумевает его распространения, то отсутствует его -jar файл.
Ссылка на проект осуществляется через Пулл-реквест на GitHub.

После того, как проект будет запущен, пользователю необходимо открыть страничку в интернете https://web.postman.co/, где пользователь создаёт своё рабочее пространство для осуществления веб-запросов.

Приложение предназначено для работы с внешней БД. Для подключения к БД необходимо запускать программу с указанием следующих параметров для JVM:
- spring.datasource.url=
- spring.datasource.username=
- spring.datasource.password=

Пользователь с ролью кладовщика (едиственная роль) может осуществлять следующие запросы:
- POST /api/socks/income - Регистрирует приход носков на склад. При этом в теле запроса надо указать:
  - color — цвет носков, строка (например, black, red, yellow);
  - cottonPart — процентное содержание хлопка в составе носков, целое число от 0 до 100 (например, 30, 18, 42);
  - quantity — количество пар носков, целое число больше 0.
- POST /api/socks/outcome - Регистрирует отпуск носков со склада. Здесь параметры запроса аналогичные, но общее количество носков указанного цвета и состава не увеличивается, а уменьшается.
    
Параметры запросов передаются в теле запроса в виде JSON-объекта.
Результаты запросов отображается в интерфейсе POSTMAN - клиента. При этом в БД заносятся полученные данные из запроса.

- GET /api/socks - Возвращает общее количество носков на складе, соответствующих переданным в параметрах критериям запроса.

Параметры запроса передаются в URL:

 * color — цвет носков, строка;
 * operation — оператор сравнения значения количества хлопка в составе носков, одно значение из: moreThan, lessThan, equal;
 * cottonPart — значение процента хлопка в составе носков из сравнения.
   
Результатом запроса будет ответ в виде числа, показывающего количество оставшихся на складе ностов указанного в запросе цвета и процента содержания хлопка.


