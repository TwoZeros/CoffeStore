package ru.TwoZeros.coffe_machine;

import ru.TwoZeros.coffe_machine.base.CoffeMachine;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CoffeMachine machine = new TaganrogCoffeMachine(
                new CoffeContainer(100,100),
                new WaterContainer(100,100),
                new MilkContainer(100,100)
        );
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите команду кофе машине, для выхода введите end");
        while (true) {
            String operation = scanner.nextLine();
            if (operation.toLowerCase(Locale.ROOT).equals("end")) {
                break;
            }
            try {
                machine.runOperation(operation);
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
            //machine.runOperation(operation);
    }
}
