package ru.TwoZeros.coffe_machine.base;

public class Coffe {
    private int persentCoffe;
    private int persentWater;
    private int persentMilk;
    private int minVolume;
    private int curVolume;

    public Coffe(int persentCoffe, int persentWater, int persentMilk, int minVolume, int curVolume ) {
        this.persentCoffe = persentCoffe;
        this.persentWater = persentWater;
        this.persentMilk = persentMilk;
        this.minVolume = minVolume;
        this.curVolume = curVolume;
    }
    public int getMinVolume() {
        return minVolume;
    }
    public boolean isValidWolume() {
        return curVolume >= minVolume;
    }
    public int getRequiredMilk() {
        return curVolume * persentMilk / 100;
    }
    public int getRequiredWather() {
        return  curVolume * persentWater / 100;
    }
    public  int getRequiredCoffe() {
        return curVolume * persentCoffe / 100;
    }


}
