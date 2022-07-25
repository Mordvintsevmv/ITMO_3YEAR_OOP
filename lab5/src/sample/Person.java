package sample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Person implements Serializable {

    private final String name;
    private final String surname;
    private final String passport;
    private int accountNum;
    private static final long serialVersionUID = 1L;
    ArrayList<BankAccount> accounts = new ArrayList<>();


    // Конструктор (регистрация) пользователя
    public Person(String nameIn,String surnameIn,String passportIn){
        name = nameIn;
        surname = surnameIn;
        passport = passportIn;
    }

    // Конструктор (регистрация) пользователя.
    // Пользователю предлгается ввести свои данные.
    public Person(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nВаше имя: ");
        String nameIn = scanner.next();

        System.out.print("\nВаша фамилия: ");
        String surnameIn = scanner.next();

        System.out.print("\nНомер пасорта: ");
        String passportIn = scanner.next();

        name = nameIn;
        surname = surnameIn;
        passport = passportIn;
    }

    // Функция для создания нового счёта в любой валюте у пользователя
    public void NewAccount(double amountIn, Main.Currency currencyIn){
        accounts.add(new BankAccount(amountIn,currencyIn));
        accountNum++;
    }

    public int getAccountNum(){
        return accountNum;
    }

    // Функция для вывода всех доступных средств по счетам.
    // Итоговая сумма для удобства переводится в рубли
    public double getTotalRub(){
        double totalRub = 0;
        for (int i = 0; i < accountNum; i++){
            totalRub += accounts.get(i).convertMoney(accounts.get(i).getCurrency(), accounts.get(i).getAmount(), Main.Currency.ruble);
        }
        return totalRub;
    }

    public void deleteAccount(int accountIn){
        accounts.get(accountIn).closeAccount();
    }

    public void addMoney(int accountIn, Main.Currency currencyIn, double amountIn){
        accounts.get(accountIn).addMoney(amountIn,currencyIn);
    }

    public void getMoney(int accountIn, Main.Currency currencyIn, double amountIn){
        accounts.get(accountIn).getMoney(amountIn,currencyIn);
    }

    public String getHistory(int accountIn){
        return accounts.get(accountIn).getHistory();
    }

    public void shareMoney(int accountIn, int accountTo, double amountIn){
        accounts.get(accountIn).shareMoney(accounts.get(accountTo),accounts.get(accountIn).getCurrency(),amountIn, true);
    }

    // Функция для вывода короткой информации по счетам
    public String toText(){
        return String.format(name + " " + surname + "\nСчетов: %d\nСумма: %.2f\n\n",accountNum, getTotalRub());
    }

    // Функция для вывода полной информации по счетам
    public String toTextFull(){
        String s = "";
        for (int i = 0; i < accountNum; i++){
            s += String.format("(%d) ",i);
            s += accounts.get(i).textInfo();
        }
        s += String.format("\nВсего средств(₽): %.2f", getTotalRub());
        return s;
    }
}
