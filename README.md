# SpringMVC

### Model-View-Controller

Это принцип построения архитектуры большого приложения, при котором оно разбивается на три части.

* Model. В ней содержится код, который делает все то, для чего приложение создавалось (обработка данных). Mодель потом уведомит все View об изменении данных, чтобы они отображали только актуальное их состояние.

* View - отображение данных пользователю. В ней содержится код, который управляет показом окон, страниц, сообщений и т.д.

* Controller - обработка действий пользователя (любые действия пользователя, направленные на изменения модели), добавление данных в Модель. 

Такой подход позволяет независимо делать три вещи: логику программы (Model), механизм показа всех данных программы пользователю (View), обрабатывать ввод/действия пользователя (Controller).

[MVC wiki](https://ru.wikipedia.org/wiki/Model-View-Controller)

[MVC JavaRush](https://javarush.ru/quests/lectures/questcollections.level06.lecture01)


### model
src/main/java.ru.spring.mvc/model

### view
src/main/java.ru.spring.mvc/view

### controller
src/main/java.ru.spring.mvc/controllers

[!боже мой это прекрасно](https://github.com/cvenkman/Winx/raw/master/winx.jpeg)
