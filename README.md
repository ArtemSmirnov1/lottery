# LotteryService

Для запуска нужно склонировать репозиторий на локальную машину, через cmd или другой терминал зайти в директорию со скачанным проектом и выполнить команду docker-compose up --build, после чего выполнять запросы

Для выполнения запроса добавления участника нужно использовать следующую конфигурацию тела запроса:

{
  "name":"<имя>",
  "age":<возраст>,
  "city":"<город>"
}

Для запуска бэкенда без докера нужно поменять значение свойства `application.profile` на "local" в файле server/src/main/resources/application.properties
