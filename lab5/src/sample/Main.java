package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class Main extends Application {

    // Глобальная переменная для назначения каждому счёту уникального номера
    public static int allAccount = 1;

    // Доступные валюты и их отношение к доллару
    public enum Currency {
        ruble, // 0,013
        dollar, // 1
        euro, // 1,19
        czk // 0,045
    }

    // Создание списка клиентов
    public static ArrayList<Person> client = new ArrayList<>();

    // Переменная для выбора пользователя
    public static int clientNumT;
    public static int accountNumT;

    Stage window;
    Scene scene1, scene2, scene3, scene4, scene5, scene6, scene7, scene8, scene9, scene10;

    @Override
    public void start(Stage primaryStage){
        window = primaryStage;
        window.setTitle("Я название программы!");


        ///////////////////////////////////////////////////////////////////////////
        //////////////////////////СТАРТОВОЕ МЕНЮ///////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////

        StackPane menu1 = new StackPane();

        Label clientInfo = new Label();
        clientInfo.setText(ClientInfo());
        Label all_accounts = new Label();


        // Создание кнопок
        Button new_person_button = new Button("НОВЫЙ ПОЛЬЗОВАТЕЛЬ");
            new_person_button.setStyle("-fx-background-color: #33FF00");
        Button choose_person_button = new Button("ВЫБОР СУЩЕСТВУЮЩЕГО ПОЛЬЗОВАТЕЛЯ");
            choose_person_button.setStyle("-fx-background-color: #FFFF00");
        Button exit_button = new Button("ВЫХОД");
            exit_button.setStyle("-fx-background-color: #ff0000");

        // Добавдение кнопок на экран
        menu1.getChildren().add(new_person_button);
        menu1.getChildren().add(choose_person_button);
        menu1.getChildren().add(exit_button);

        // Выравнивание кнопок
        StackPane.setAlignment(new_person_button, Pos.TOP_CENTER);
        StackPane.setAlignment(choose_person_button, Pos.CENTER);
        StackPane.setAlignment(exit_button, Pos.BOTTOM_CENTER);

        // Присваивание действий кнопкам
        new_person_button.setOnAction(e -> window.setScene(scene2));
        choose_person_button.setOnAction(e -> window.setScene(scene3));
        exit_button.setOnAction(e -> Platform.exit());

        scene1 = new Scene(menu1, 750, 750, Color.web("#006699"));
        menu1.setBackground(Background.EMPTY);


        ///////////////////////////////////////////////////////////////////////////
        //////////////////////////МЕНЮ НОВОГО ПОЛЬЗОВАТЕЛЯ/////////////////////////
        ///////////////////////////////////////////////////////////////////////////

        StackPane menu2 = new StackPane();

        // Создание кнопок и полей
        TextField name = new TextField("Имя");
        TextField surname = new TextField("Фамилия");
        TextField passport = new TextField("Номер пасспорта");
        Button add_new_button = new Button("Добавить");
            add_new_button.setStyle("-fx-background-color: #33FF00");
        Button back_button = new Button("НАЗАД");
            back_button.setStyle("-fx-background-color: #ff0000");

        // Добавдение кнопок и полей на экран
        menu2.getChildren().add(back_button);
        menu2.getChildren().add(name);
        menu2.getChildren().add(surname);
        menu2.getChildren().add(passport);
        menu2.getChildren().add(add_new_button);

        // Выравнивание кнопок и полей
        StackPane.setAlignment(back_button, Pos.BOTTOM_LEFT);
        StackPane.setAlignment(add_new_button, Pos.BOTTOM_RIGHT);
        StackPane.setAlignment(name, Pos.CENTER_LEFT);
        name.setMaxSize(150,50);
        StackPane.setAlignment(surname, Pos.CENTER);
        surname.setMaxSize(150,50);
        StackPane.setAlignment(passport, Pos.CENTER_RIGHT);
        passport.setMaxSize(150,50);

        // Присваивание действий кнопкам
        back_button.setOnAction(e -> window.setScene(scene1));
        add_new_button.addEventHandler(ActionEvent.ACTION, (e)-> {
            window.setScene(scene1);
            client.add(new Person(name.getText(), surname.getText(),passport.getText()));
            clientInfo.setText(ClientInfo());
        });

        scene2 = new Scene(menu2, 750, 750, Color.web("#006699"));
        menu2.setBackground(Background.EMPTY);

        ///////////////////////////////////////////////////////////////////////////
        //////////////////////////МЕНЮ ВСЕХ ПОЛЬЗОВАТЕЛЕЙ//////////////////////////
        ///////////////////////////////////////////////////////////////////////////

        VBox menu3 = new VBox(50);

        // Создание кнопок и полей
        TextField personNum = new TextField("Выберите пользователя (номер)");
        Button back2_button = new Button("НАЗАД");
            back2_button.setStyle("-fx-background-color: #ff0000");
        Button person_agree_button = new Button("Выбрать");
        person_agree_button.setStyle("-fx-background-color: #33FF00");

        // Добавдение кнопок и полей на экран
        menu3.getChildren().add(clientInfo);
        menu3.getChildren().add(personNum);
        menu3.getChildren().add(person_agree_button);
        menu3.getChildren().add(back2_button);


        // Выравнивание кнопок и полей
            personNum.setMaxSize(250,30);

        // Присваивание действий кнопкам
        back2_button.setOnAction(e -> window.setScene(scene1));

        Label currentClientInfo = new Label();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        Label fullInfo = new Label();
        alert.setTitle("ИНФОРМАЦИЯ ПО СЧЁТУ");
        alert.setHeaderText("Все средства:");

        person_agree_button.addEventHandler(ActionEvent.ACTION, (e)-> {
            clientNumT = Integer.parseInt(personNum.getText());
            currentClientInfo.setText(client.get(clientNumT).toText());
            alert.setContentText(client.get(clientNumT).toTextFull());
            fullInfo.setText(client.get(clientNumT).toTextFull());
            clientInfo.setText(ClientInfo());
            all_accounts.setText(client.get(clientNumT).toTextFull());
            window.setScene(scene4);
        });

        scene3 = new Scene(menu3, 750, 750, Color.web("#006699"));
        menu3.setBackground(Background.EMPTY);


        ///////////////////////////////////////////////////////////////////////////
        //////////////////////////МЕНЮ ОДНОГО ПОЛЬЗОВАТЕЛЯ/////////////////////////
        ///////////////////////////////////////////////////////////////////////////

        VBox menu4 = new VBox(50);

        // Создание кнопок и полей
        Button back3_button = new Button("НАЗАД");
            back3_button.setStyle("-fx-background-color: #ff0000");
        Button print_full_button = new Button("Печать полной информации");
            person_agree_button.setStyle("-fx-background-color: #33FF00");
        Button open_new_account_button = new Button("Открыть новый счет");
            person_agree_button.setStyle("-fx-background-color: #33FF00");
        Button edit_account_button = new Button("Управлять счётом");
            person_agree_button.setStyle("-fx-background-color: #33FF00");



        // Добавдение кнопок и полей на экран
        menu4.getChildren().add(currentClientInfo);
        menu4.getChildren().add(print_full_button);
        menu4.getChildren().add(open_new_account_button);
        menu4.getChildren().add(edit_account_button);
        menu4.getChildren().add(back3_button);


        // Присваивание действий кнопкам
        back3_button.setOnAction(e -> window.setScene(scene3));
        open_new_account_button.setOnAction(e -> window.setScene(scene5));
        print_full_button.addEventHandler(ActionEvent.ACTION, (e)-> {
            alert.setContentText(client.get(clientNumT).toTextFull());
            alert.show();
        });
        edit_account_button.setOnAction(e -> window.setScene(scene6));

        scene4 = new Scene(menu4, 750, 750, Color.web("#006699"));
        menu4.setBackground(Background.EMPTY);

        ///////////////////////////////////////////////////////////////////////////
        //////////////////////////СОЗДАНИЕ СЧЁТА///////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////

        VBox menu5 = new VBox(50);

        // Создание кнопок и полей
        Button back4_button = new Button("НАЗАД");
            back4_button.setStyle("-fx-background-color: #ff0000");
        Button create_new_button = new Button("OK");
            create_new_button.setStyle("-fx-background-color: #33FF00");

        TextField amount = new TextField();
        Label amountL = new Label("Сколько внести?");
        amountL.setLabelFor(amount);
        amount.setMaxSize(250,40);

        ObservableList<String> langs = FXCollections.observableArrayList("Рубли", "Доллары", "Евро", "Кроны");
        ComboBox<String> langsComboBox = new ComboBox<String>(langs);
        langsComboBox.setValue("Рубли");

        // Добавдение кнопок и полей на экран
        menu5.getChildren().add(amountL);
        menu5.getChildren().add(amount);
        menu5.getChildren().add(langsComboBox);
        menu5.getChildren().add(create_new_button);
        menu5.getChildren().add(back4_button);


        // Присваивание действий кнопкам
        back4_button.setOnAction(e -> window.setScene(scene4));
        create_new_button.addEventHandler(ActionEvent.ACTION, (e)-> {
            if (langsComboBox.getValue() == "Рубли"){client.get(clientNumT).NewAccount(Integer.parseInt(amount.getText()),Currency.ruble);};
            if (langsComboBox.getValue() == "Доллары"){client.get(clientNumT).NewAccount(Integer.parseInt(amount.getText()),Currency.dollar);};
            if (langsComboBox.getValue() == "Евро"){client.get(clientNumT).NewAccount(Integer.parseInt(amount.getText()),Currency.euro);};
            if (langsComboBox.getValue() == "Кроны"){client.get(clientNumT).NewAccount(Integer.parseInt(amount.getText()),Currency.czk);};
            fullInfo.setText(client.get(clientNumT).toTextFull());
            clientInfo.setText(ClientInfo());
            currentClientInfo.setText(client.get(clientNumT).toText());
            all_accounts.setText(client.get(clientNumT).toTextFull());
            window.setScene(scene4);

        });

        scene5 = new Scene(menu5, 750, 750, Color.web("#006699"));
        menu5.setBackground(Background.EMPTY);


        ///////////////////////////////////////////////////////////////////////////
        //////////////////////////ВЫБОР СЧЁТА НА РЕДАКТИРОВАНИЕ////////////////////
        ///////////////////////////////////////////////////////////////////////////

        VBox menu6 = new VBox(50);

        // Создание кнопок и полей
        Button back5_button = new Button("НАЗАД");
            back5_button.setStyle("-fx-background-color: #ff0000");
        Button choose_account_button = new Button("OK");
            choose_account_button.setStyle("-fx-background-color: #33FF00");

        TextField accountNum = new TextField();
        Label accountNumL = new Label("Какой счёт?");
        accountNumL.setLabelFor(accountNum);
        accountNum.setMaxSize(250,40);



        // Добавдение кнопок и полей на экран
        menu6.getChildren().add(fullInfo);
        menu6.getChildren().add(accountNumL);
        menu6.getChildren().add(accountNum);
        menu6.getChildren().add(choose_account_button);
        menu6.getChildren().add(back5_button);


        // Присваивание действий кнопкам
        back5_button.setOnAction(e -> window.setScene(scene4));
        choose_account_button.addEventHandler(ActionEvent.ACTION, (e)-> {
            accountNumT = Integer.parseInt(accountNum.getText());
            window.setScene(scene7);
        });


        scene6 = new Scene(menu6, 750, 750, Color.web("#006699"));
        menu6.setBackground(Background.EMPTY);

        ///////////////////////////////////////////////////////////////////////////
        //////////////////////////УПРАВЛЕНИЕ СЧЁТОМ////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////

        VBox menu7 = new VBox(50);

        // Создание кнопок и полей
        Button back6_button = new Button("НАЗАД");
            back6_button.setStyle("-fx-background-color: #ff0000");
        Button delete_button = new Button("УДАЛИТЬ СЧЁТ");
            delete_button.setStyle("-fx-background-color: #ff0000");

        Button add_money_button = new Button("ПОЛОЖИТЬ ДЕНЬГИ");
            add_money_button.setStyle("-fx-background-color: #33FF00");
        Button get_money_button = new Button("CНЯТЬ ДЕНЬГИ");
            get_money_button.setStyle("-fx-background-color: #FFFF00");
        Button history_button = new Button("ИСТОРИЯ СЧЁТА");
        Button share_button = new Button("ПЕРЕВЕСТИ НА ДРУГОЙ СЧЁТ");


        // Добавдение кнопок и полей на экран
        menu7.getChildren().add(add_money_button);
        menu7.getChildren().add(get_money_button);
        menu7.getChildren().add(history_button);
        menu7.getChildren().add(share_button);

        menu7.getChildren().add(delete_button);
        menu7.getChildren().add(back6_button);


        Alert alert_history = new Alert(Alert.AlertType.INFORMATION);
        alert_history.setTitle("ИСТОРИЯ СЧЁТА");
        alert_history.setHeaderText("Все операции:");

        // Присваивание действий кнопкам
        add_money_button.setOnAction(e -> window.setScene(scene8));
        get_money_button.setOnAction(e -> window.setScene(scene9));
        history_button.addEventHandler(ActionEvent.ACTION, (e)-> {
            alert_history.setContentText(client.get(clientNumT).getHistory(accountNumT));
            alert_history.show();
        });
        share_button.setOnAction(e -> window.setScene(scene10));

        back6_button.setOnAction(e -> window.setScene(scene4));
        delete_button.addEventHandler(ActionEvent.ACTION, (e)-> {
            client.get(clientNumT).deleteAccount(accountNumT);
            fullInfo.setText(client.get(clientNumT).toTextFull());
            all_accounts.setText(client.get(clientNumT).toTextFull());
            currentClientInfo.setText(client.get(clientNumT).toText());
            window.setScene(scene4);

        });


        scene7 = new Scene(menu7, 750, 750, Color.web("#006699"));
        menu7.setBackground(Background.EMPTY);

        ///////////////////////////////////////////////////////////////////////////
        //////////////////////////ПОЛОЖИТЬ ДЕНЬГИ НА СЧЁТ//////////////////////////
        ///////////////////////////////////////////////////////////////////////////

        VBox menu8 = new VBox(50);

        // Создание кнопок и полей
        Button back7_button = new Button("НАЗАД");
            back7_button.setStyle("-fx-background-color: #ff0000");
        Button add_money_ok_button = new Button("OK");
            add_money_ok_button.setStyle("-fx-background-color: #33FF00");

        TextField amount_add = new TextField();
        Label amountL_add = new Label("Сколько внести?");
        amountL_add.setLabelFor(amount_add);
        amount_add.setMaxSize(250,40);

        ObservableList<String> langs_add = FXCollections.observableArrayList("Рубли", "Доллары", "Евро", "Кроны");
        ComboBox<String> langsComboBox_add = new ComboBox<String>(langs);
        langsComboBox_add.setValue("Рубли");

        // Добавдение кнопок и полей на экран
        menu8.getChildren().add(amountL_add);
        menu8.getChildren().add(amount_add);
        menu8.getChildren().add(langsComboBox_add);
        menu8.getChildren().add(add_money_ok_button);
        menu8.getChildren().add(back7_button);


        // Присваивание действий кнопкам
        back7_button.setOnAction(e -> window.setScene(scene6));
        add_money_ok_button.addEventHandler(ActionEvent.ACTION, (e)-> {
            window.setScene(scene7);
            if (langsComboBox_add.getValue() == "Рубли"){client.get(clientNumT).addMoney(accountNumT,Currency.ruble,Double.parseDouble(amount_add.getText()));};
            if (langsComboBox_add.getValue() == "Доллары"){client.get(clientNumT).addMoney(accountNumT,Currency.dollar,Double.parseDouble(amount_add.getText()));};
            if (langsComboBox_add.getValue() == "Евро"){client.get(clientNumT).addMoney(accountNumT,Currency.euro,Double.parseDouble(amount_add.getText()));};
            if (langsComboBox_add.getValue() == "Кроны"){client.get(clientNumT).addMoney(accountNumT,Currency.czk,Double.parseDouble(amount_add.getText()));};
            fullInfo.setText(client.get(clientNumT).toTextFull());
            all_accounts.setText(client.get(clientNumT).toTextFull());
            currentClientInfo.setText(client.get(clientNumT).toText());

        });

        scene8 = new Scene(menu8, 750, 750, Color.web("#006699"));
        menu8.setBackground(Background.EMPTY);

        ///////////////////////////////////////////////////////////////////////////
        //////////////////////////СНЯТЬ ДЕНЬГИ СО СЧЁТА////////////////////////////
        ///////////////////////////////////////////////////////////////////////////

        VBox menu9 = new VBox(50);

        // Создание кнопок и полей
        Button back8_button = new Button("НАЗАД");
            back8_button.setStyle("-fx-background-color: #ff0000");
        Button get_money_ok_button = new Button("OK");
            get_money_ok_button.setStyle("-fx-background-color: #33FF00");

        TextField amount_get = new TextField();
        Label amountL_get = new Label("Сколько снять?");
        amountL_get.setLabelFor(amount_get);
        amount_get.setMaxSize(250,40);

        ObservableList<String> langs_get = FXCollections.observableArrayList("Рубли", "Доллары", "Евро", "Кроны");
        ComboBox<String> langsComboBox_get = new ComboBox<String>(langs);
        langsComboBox_get.setValue("Рубли");

        // Добавдение кнопок и полей на экран
        menu9.getChildren().add(amountL_get);
        menu9.getChildren().add(amount_get);
        menu9.getChildren().add(langsComboBox_get);
        menu9.getChildren().add(get_money_ok_button);
        menu9.getChildren().add(back8_button);


        // Присваивание действий кнопкам
        back8_button.setOnAction(e -> window.setScene(scene6));
        get_money_ok_button.addEventHandler(ActionEvent.ACTION, (e)-> {
            window.setScene(scene7);
            if (langsComboBox_get.getValue() == "Рубли"){client.get(clientNumT).getMoney(accountNumT,Currency.ruble,Double.parseDouble(amount_get.getText()));};
            if (langsComboBox_get.getValue() == "Доллары"){client.get(clientNumT).getMoney(accountNumT,Currency.dollar,Double.parseDouble(amount_get.getText()));};
            if (langsComboBox_get.getValue() == "Евро"){client.get(clientNumT).getMoney(accountNumT,Currency.euro,Double.parseDouble(amount_get.getText()));};
            if (langsComboBox_get.getValue() == "Кроны"){client.get(clientNumT).getMoney(accountNumT,Currency.czk,Double.parseDouble(amount_get.getText()));};
            fullInfo.setText(client.get(clientNumT).toTextFull());
            all_accounts.setText(client.get(clientNumT).toTextFull());
            currentClientInfo.setText(client.get(clientNumT).toText());

        });

        scene9 = new Scene(menu9, 750, 750, Color.web("#006699"));
        menu9.setBackground(Background.EMPTY);


        ///////////////////////////////////////////////////////////////////////////
        //////////////////////////ПЕРЕВЕСТИ ДЕНЬГИ НА СЧЁТ/////////////////////////
        ///////////////////////////////////////////////////////////////////////////

        VBox menu10 = new VBox(50);

        // Создание кнопок и полей
        Button back9_button = new Button("НАЗАД");
            back9_button.setStyle("-fx-background-color: #ff0000");
        Button share_money_ok_button = new Button("OK");
            share_money_ok_button.setStyle("-fx-background-color: #33FF00");

        TextField amount_share = new TextField();
        Label amountL_share = new Label("Сколько перевести?");
        amountL_share.setLabelFor(amount_add);
        amount_share.setMaxSize(250,40);

        TextField account_share = new TextField();
        Label accountL_share = new Label("Куда перевести?");
        accountL_share.setLabelFor(account_share);
        account_share.setMaxSize(250,40);


        // Добавдение кнопок и полей на экран
        menu10.getChildren().add(amountL_share);
        menu10.getChildren().add(amount_share);
        menu10.getChildren().add(accountL_share);
        menu10.getChildren().add(all_accounts);
        menu10.getChildren().add(account_share);
        menu10.getChildren().add(share_money_ok_button);
        menu10.getChildren().add(back9_button);


        // Присваивание действий кнопкам
        back9_button.setOnAction(e -> window.setScene(scene6));
        share_money_ok_button.addEventHandler(ActionEvent.ACTION, (e)-> {
            window.setScene(scene7);
            client.get(clientNumT).shareMoney(accountNumT,Integer.parseInt(account_share.getText()),Double.parseDouble(amount_share.getText()));
            fullInfo.setText(client.get(clientNumT).toTextFull());
            all_accounts.setText(client.get(clientNumT).toTextFull());
            currentClientInfo.setText(client.get(clientNumT).toText());

        });

        scene10 = new Scene(menu10, 750, 750, Color.web("#006699"));
        menu10.setBackground(Background.EMPTY);

        ///////////////////////////////////////////////////////////////////////////
        //////////////////////////НАЧАЛО///////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////

        window.setScene(scene1);
        window.show();
    }

    public static String ClientInfo(){
        String s = "";
        for (int ci = 0; ci < client.size(); ci ++){
            s += String.format("(%d) ",ci); // Вывод номеров пользователей
            s += client.get(ci).toText();} // Вывод краткой информации по счетам
        return s;
    }

    public static void main(String[] args) throws IOException {


        // Чтение данных клиентов из файла
        Singleton saveLoad = Singleton.getInstance();
        client = saveLoad.loadData(client);
        for (Person person : client) {
            allAccount += person.getAccountNum();
        }

        launch(args);

        // Запись данных клиентов в файл
        saveLoad.saveData(client);

    }
}
