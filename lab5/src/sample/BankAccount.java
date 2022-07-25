package sample;
import java.io.Serializable;
import java.util.Date;
import java.util.Scanner;

public class BankAccount implements Serializable {

    private int accountNumber = 0;
    private double amount;
    private Main.Currency currency;
    private History history = new History();
    private static final long serialVersionUID = 1L;



    // Конструктор счёта
    public BankAccount(double amountIn, Main.Currency currencyIn){
            accountNumber = Main.allAccount++;
            amount = amountIn;
            currency = currencyIn;
            history.addOperation("\n" + new Date() + "\nСЧЁТ " + accountNumber + " СОЗДАН\n");
    }

    // Закрытие счёта. Присваивается номер 0, чтобы в дальнейшем счёт не мог работать в функциях
    public void closeAccount(){
        accountNumber = 0;
        amount = 0;
        history.addOperation("\n" + new Date() + "\nСЧЁТ ЗАКРЫТ.\n");

    }

    // Функция доваления денег на счёт в любой валюте
    public void addMoney(double amountIn, Main.Currency currencyIn){
        if (accountNumber == 0) {System.out.print("\nСЧЁТ ЗАКРЫТ. ОПЕРАЦИИ НЕДОСТУПНЫ.\n");}
            else if (amountIn > 0) {
                amount += convertMoney(currencyIn,amountIn, currency);
                history.addOperation("\n" + new Date() +"\nДобавлено: " + amountIn + " " + currencyIn + "\n Итог: " + amount + " " + currency + "\n");
            }
                else System.out.print("Может вы хотите снять деньги?\n");
    }

    // Функция для получения валюты счёта
    public Main.Currency getCurrency(){
        return currency;
    }

    // Функция для получения номера счёта
    public int getNumber(){
        return accountNumber;
    }

    // Функция для получения суммы на счёте
    public double getAmount(){
        return amount;
    }

    // Функция для снятия денег со счёта в любой валюте
    public boolean getMoney(double amountIn, Main.Currency currencyIn){
        if (accountNumber == 0) {System.out.print("\nСЧЁТ ЗАКРЫТ. ОПЕРАЦИИ НЕДОСТУПНЫ.\n"); return false;}
            else if (amountIn < 0 && amount >= -convertMoney(currencyIn,amountIn, currency)) {
                amount += convertMoney(currencyIn,amountIn, currency);
                history.addOperation("\n" + new Date() + "\nСнято: " + amountIn + " " + currencyIn + "\n Итог: " + amount + " " + currency + "\n");
                return true;
            }
                else if (amount >= 0 && amount >= convertMoney(currencyIn,amountIn, currency)){
                    amount -= convertMoney(currencyIn,amountIn, currency);
                    history.addOperation("\n" + new Date() + "\nСнято: " + amountIn + " " + currencyIn + "\n Итог: " + amount + " " + currency + "\n");
                    return true;
                }
                    else {System.out.print("У Вас недостаточно средств!\n\n"); return false;}
    }

    // Функция для обмена денег между счетами пользователя.
    // Деньги конвертируются в валюту конечного счёта.
    public void shareMoney(BankAccount accountIn, Main.Currency currencyIn, double amount, boolean operation){
        if (operation) {
            if (accountNumber == 0 || accountIn.accountNumber == 0) {System.out.print("\nСЧЁТ ЗАКРЫТ. ОПЕРАЦИИ НЕДОСТУПНЫ.\n");}
            else if (getMoney(amount, currency)) {
                accountIn.addMoney(amount, currency);
                history.addOperation("\n" + new Date() + "\nПереведено: " + amount + " " + currencyIn + "\nНа аккаунт: " + accountIn.getNumber() + "\n");
            }
                else System.out.print("НЕДОСТАТОЧНО СРЕДСТВ.\n");
        }
        if (!operation) {
            if (accountNumber == 0 || accountIn.accountNumber == 0) {System.out.print("\nСЧЁТ ЗАКРЫТ. ОПЕРАЦИИ НЕДОСТУПНЫ.\n");}
            else if (accountIn.getMoney(amount, currency)) {
                addMoney(amount, currency);
                history.addOperation("\n" + new Date() + "\nПереведено: " + amount + " " + currencyIn + "\nНа аккаунт: " + getNumber() + "\n");

            }
                else System.out.print("НЕДОСТАТОЧНО СРЕДСТВ.\n");
            }
    }

    // Функция для ковертирования денег из одной валюты в другую.
    // Для удобства деньги сначала конверитруются в доллары, а затем в необходимую валюту.
    public double convertMoney(Main.Currency currencyFrom,double amountFrom, Main.Currency currencyTo){
        if (currencyFrom == currencyTo){return amountFrom;}
        if (currencyFrom == Main.Currency.dollar){
            if (currencyTo == Main.Currency.euro) {return amountFrom/1.19;}
            if (currencyTo == Main.Currency.czk) {return amountFrom/0.045;}
            if (currencyTo == Main.Currency.ruble) {return amountFrom/0.013;}
        }
        else{
            if (currencyFrom == Main.Currency.euro) {return convertMoney(Main.Currency.dollar,amountFrom*1.19,currencyTo);}
            if (currencyFrom == Main.Currency.czk) {return convertMoney(Main.Currency.dollar,amountFrom*0.045,currencyTo);}
            if (currencyFrom == Main.Currency.ruble) {return convertMoney(Main.Currency.dollar,amountFrom*0.013,currencyTo);}
        }
        return 0;
    }

    // Функция для вывода основной информации по конкретному счёту
    public String textInfo(){
        String s = "";
        if (accountNumber == 0) {s = ("\nСЧЁТ ЗАКРЫТ. ОПЕРАЦИИ НЕДОСТУПНЫ.\n");}
        else {
            s += String.format("\nИНФОРМАЦИЯ ПО СЧЁТУ\n");
            s += String.format("\tНомера счёта: %d\n", accountNumber);
            s += String.format("\tВалюта: %s\n", currency);
            s += String.format("\tСумма: %.2f\n", amount);
        }
        return s;
    }

    // Функция для вывода всех операций по счёту
    public String getHistory(){
        String s ="";
        s += String.format("История операций по счёту %d:", accountNumber);
        s += history.getHistory();
        return s;
    }
}
