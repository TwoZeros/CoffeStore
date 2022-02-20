package ru.TwoZeros.coffe_machine;

import ru.TwoZeros.coffe_machine.base.Coffe;
import ru.TwoZeros.coffe_machine.base.CoffeMachine;
import ru.TwoZeros.coffe_machine.base.Container;

public class TaganrogCoffeMachine extends CoffeMachine {

    public TaganrogCoffeMachine(Container coffeContainer, Container waterContainer, Container milkContainer) {
        super(coffeContainer, waterContainer, milkContainer);
        isTurnOn = true;
    }

    public TaganrogCoffeMachine() {

    }

    @Override
    public Coffe createCoffe(String name, int count) {
        switch (name) {
            case "latte":
                return new Coffe(10,30,60,10,count);
            case "ristretto":
                return new Coffe(50,50,0,10,count);
            case "cappuccino":
                return new Coffe(15,40,45,10,count);
            case "lungo":
                return new Coffe(15,85,0,10,count);
            case "espresso":
                return new Coffe(30,70,0,10,count);
        }
        return null;
    }
}
