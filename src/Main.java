
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static void menu() {
        System.out.println("""
                \n
                Welcome to the currency converter \n
                Please choose an option: \n
                1) Dollar -> Argentine peso
                2) Argentine peso -> Dollar
                3) Dollar -> Mexican peso
                4) Mexican peso -> Dollar
                5) Dollar -> Colombian peso
                6) Colombian peso -> Dollar
                7) Exit \n
                Please choose an option:""");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        MoneyConvertor_API convertorApi = new MoneyConvertor_API();
        JsonRecordGenerator jsonRecordGenerator = new JsonRecordGenerator();

        int userOption = 0;
        double quantityToConvert = 0;

        while (userOption != 7) {
            menu();

            try {
                userOption = scanner.nextInt();
                if (userOption == 7) {
                    break;
                }

                System.out.println("Enter the amount to convert:");
                quantityToConvert = scanner.nextDouble();

                if (quantityToConvert <= 0) {
                    System.out.println("Please enter a valid amount");
                    continue;
                }

                performConversion(userOption, quantityToConvert, convertorApi, jsonRecordGenerator);

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                break;
            }
        }

        System.out.println("Thank you for using the currency converter!");
        scanner.close();
    }

    private static void performConversion(int option, double amount, MoneyConvertor_API convertorApi, JsonRecordGenerator jsonRecordGenerator) throws IOException {
        CoinData coinData = null;

        switch (option) {
            case 1 -> coinData = convertorApi.convertCoin("USD", "ARS", amount);
            case 2 -> coinData = convertorApi.convertCoin("ARS", "USD", amount);
            case 3 -> coinData = convertorApi.convertCoin("USD", "MXN", amount);
            case 4 -> coinData = convertorApi.convertCoin("MXN", "USD", amount);
            case 5 -> coinData = convertorApi.convertCoin("USD", "COP", amount);
            case 6 -> coinData = convertorApi.convertCoin("COP", "USD", amount);
            default -> System.out.println("Invalid option. Please choose a valid option.");
        }

        if (coinData != null) {
            System.out.println(coinData);
            jsonRecordGenerator.saveJson(coinData);
        }
    }
}
