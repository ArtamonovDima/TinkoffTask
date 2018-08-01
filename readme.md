Для реализации использовались:
- java 8
- selenium webdriver
- testng
- maven
- allure

Для запуска требуется:
- java 8
- google chrome
- maven
- запуск через терминал среды разработки командой "mvn test"

Отчет:
- делается через терминал среды разработки командой "mvn site"
- находится в target/site/allure-maven.html

Реализовано:
- архитектура разбита на три слоя: класс для работы с элементами который содержит инстанс драйвера,
объекты страниц с локаторами и методами для их обработки, сами тестовые классы.
- применены паттерны singleton, page object.
- для поиска элементов применял явные ожидания и xpath.

Техники тест дизайна:
- эквивалентное разделение
- анализ граничных значений
- причина / следствие.


Что можно было бы улучшить:
- добавить в проект слушателя, логгирование
- дополнительные классы-обертки для элементов
- фабрику для драйвера
- дата провайдеры для тестовых данных
- при надобности распараллеливание через testng.xml.



