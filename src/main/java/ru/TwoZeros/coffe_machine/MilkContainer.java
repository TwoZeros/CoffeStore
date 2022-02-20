package ru.TwoZeros.coffe_machine;

import ru.TwoZeros.coffe_machine.base.Container;

public class MilkContainer implements Container {

    private int currCount;
    private int maxSize;
    @Override
    public void add(int count) {
        currCount += count;
        if(currCount > maxSize) {
            currCount = maxSize;
        }
    }

    @Override
    public int getMaxSize() {
        return maxSize;
    }

    @Override
    public int getCount() {
        return currCount;
    }

    @Override
    public void expenditure(int count) {
        currCount -=count;
    }
    public MilkContainer(int maxSize) {
        this.maxSize = maxSize;
    }

    public MilkContainer(int maxSize, int currCount ) {
        this.currCount = currCount;
        this.maxSize = maxSize;
    }
}
