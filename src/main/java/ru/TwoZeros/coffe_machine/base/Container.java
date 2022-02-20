package ru.TwoZeros.coffe_machine.base;

public interface Container {
    void add(int count);
    int getMaxSize();
    int getCount();
    void expenditure(int count);
}
