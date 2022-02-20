#Проект Кофемашина
## Техническое задание

Необходимо реализовать логику простой кофемашины.

### Параметры кофемашины
Все параметры должны быть переданы в виде целых чисел в качестве аргументов самой программы и в том же порядке, в котором они перечислены ниже.

Объем резервуара для кофе (мл)
Объем резервуара для воды (мл)
Объем резервуара для молока (мл)
Изготавливаемые напитки

### Кофемашина должна уметь готовить следующие напитки:

- Ристретто: 50% кофе, 50% воды.
- Эспрессо: 30% кофе, 70% воды.
- Лунго: 15% кофе, 85% воды.
- Капучино: 15% кофе, 40% воды, 45% молока.
- Латте: 10% кофе, 30% воды, 60% молока.

### Команды кофемашины
Все команды вводятся в виде обычных строк через стандартный поток ввода (System.in). Каждая команда вводится на отдельной строке. Все команды являются регистро-независимыми.

- water N - залить N мл воды.
- milk N - залить N мл молока.
- coffee N - засыпать N мл кофе.
- latte N - приготовить латте на N мл. Приготовление происходит только при N >= 10.
- ristretto N - приготовить ристретто на N мл. Приготовление происходит только при N >= 10.
- cappuccino N - приготовить капучино на N мл. Приготовление происходит только при N >= 10.
- lungo N - приготовить лунго на N мл. Приготовление происходит только при N >= 10.
- espresso N - приготовить эспрессо на N мл. Приготовление происходит только при N >= 10.
- turn off - отключение. После получения команды отключения кофемашина должна завершить свою работу.

Пример
```
latte 200
ristretto 30
lungo 150
water 100
espresso 50
turn off
```
Результат
После выполнения каждой команды (кроме turn off) кофемашина должна вывести на стандартный поток вывода (System.out) одну строку, в которой через символ пробела указать текущий объем кофе, воды и молока, оставшихся в резервуарах после приготовления.

Пример
```
1000 2000 1900
990 1970 1840
```
Технические требования
Программа должна быть написана на языке программирования Java
Сборка программы должна осуществляться с помощью Maven

Исходный код программы должен быть размещён в отдельном репозитории вашего аккаунта на сайте GitHub
Файл программы должен называться coffee-machine.jar и запускаться с помощью команды java -jar coffee-machine.jar ...
Дополнительно
Всё, что не регламентировано в данном условии можно реализовывать по собственному усмотрению.

