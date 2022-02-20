package ru.TwoZeros.coffe_machine.base;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.Locale;
import java.util.Objects;

public abstract class CoffeMachine {
    //    protected int countCoffe;
//    protected int countMilk;
//    protected int countWater;
    private Container coffeContainer;
    private Container waterContainer;
    private Container milkContainer;
    protected boolean isTurnOn;

    public CoffeMachine(Container coffeContainer, Container waterContainer, Container milkContainer) {
        this.coffeContainer = coffeContainer;
        this.waterContainer = waterContainer;
        this.milkContainer = milkContainer;
    }

    public CoffeMachine() {

    }

    public void runOperation(String operation) {
        operation = operation.toLowerCase(Locale.ROOT);
        if (operationStatus(operation)) return;
        if (operationFilling(operation)) return;
        if (orderCoffe(operation)) return;
        System.out.println("Недопустимая команда");

    }

    private void addWater(int count) {
        waterContainer.add(count);
    }

    private void addCoffe(int count) {
        coffeContainer.add(count);
    }

    private void addMilk(int count) {
        milkContainer.add(count);
    }

    public boolean operationStatus(String operation) {
        if (operation.equals("turn off")) {
            isTurnOn = false;
            System.out.println("Кофе машина была выключена");
            return true;
        }
        if (operation.equals("turn on")) {
            isTurnOn = true;
            System.out.println("Кофе машина включена");
            return true;
        }
        return false;
    }

    public boolean operationFilling(String operation) {
        String[] args = operation.split(" ");
        int count = 0;
        if (!NumberUtils.isDigits(args[1])) {
            throw new IllegalArgumentException("Неверный синтаксис команды.");
        }
        count = Integer.parseInt(args[1]);

        switch (args[0]) {
            case "milk":
                addMilk(count);
                showBalance();
                return true;
            case "water":
                addWater(count);
                showBalance();
                return true;
            case "coffe":
                addCoffe(count);
                showBalance();
                return true;
        }
        return false;
    }

    public boolean orderCoffe(String operation) {
        String[] args = operation.split(" ");
        int count = 0;
        if (isTurnOn == false) {
            System.out.println("Для приготовления напитка необходимо включить машину. Выполните turn on");
            return true;
        }
        if (!NumberUtils.isDigits(args[1])) {
            throw new IllegalArgumentException("Неверный синтаксис команды");
        }
        count = Integer.parseInt(args[1]);
        Coffe coffe;
        coffe = createCoffe(args[0], count);
        if (Objects.isNull(coffe)) {
            return false;
        }
        if (!coffe.isValidWolume()) {
            System.out.println("Не верный объем напитка. Минимальный объем: " + coffe.getMinVolume() + " мл.");
            showBalance();
            return true;
        }
        //Проверяем достаточно ли в кофе машине ингридиентов для его приготовления
        // Если достаточно готовим кофе
        if (isHasRequiredIngridient(coffe)) {
            cookingCoffe(coffe);
            showBalance();
        } else {
            hasNotIngridient();
            showBalance();
        }

        return true;

    }

    protected boolean isHasRequiredIngridient(Coffe coffe) {
        return coffe.getRequiredCoffe() <= coffeContainer.getCount() && coffe.getRequiredMilk() <= milkContainer.getCount()
                && coffe.getRequiredWather() <= waterContainer.getCount();
    }

    protected void hasNotIngridient() {
        System.out.println("Недостаточно ингридиентов в кофе машине");
    }

    protected void cookingCoffe(Coffe coffe) {
        waterContainer.expenditure(coffe.getRequiredWather());
        milkContainer.expenditure(coffe.getRequiredMilk());
        coffeContainer.expenditure(coffe.getRequiredCoffe());
    }

    private void showBalance() {
        System.out.println(coffeContainer.getCount() + " " + waterContainer.getCount() + " " + milkContainer.getCount());
    }

    public abstract Coffe createCoffe(String name, int count);


    public void setTurnOn(boolean turnOn) {
        isTurnOn = turnOn;
    }
}
