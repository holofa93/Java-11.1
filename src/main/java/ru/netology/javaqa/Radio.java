package ru.netology.javaqa;

public class Radio {
    private int currentRadioStationNumber;

    int maxNumber;
    int minNumber;
    int soundVolume;
    int maxVolume = 100;
    int minVolume = 0;
    public int quantity;


    public Radio(int quantityStations) {
        this.minNumber = 0;
        if (quantityStations > 0) {
            this.maxNumber = quantityStations - 1;
        } else {
            this.maxNumber = 9;
        }
        this.quantity = maxNumber + 1;
    }





    public Radio() {
        this.minNumber = 0;
        this.maxNumber = 9;
        this.quantity = 10;
    }// бесмысленный, так как с параметром quantityStations и так справляется если тому впихнуть пустую переменную, которая по умолчанию будет 0.

    private int checkCurrentRadioStationNumber(int newRadioStationNumber) {
        if (newRadioStationNumber > maxNumber) {
            return maxNumber;
        }
        if (newRadioStationNumber < minNumber) {
            return minNumber;
        }
        return newRadioStationNumber;
    }

    public int getCurrentRadioStationNumber() {
        return currentRadioStationNumber;
    }

    public void setCurrentRadioStationNumber(int newRadioStationNumber) {
        this.currentRadioStationNumber = checkCurrentRadioStationNumber(newRadioStationNumber);
    }

    public void nextCurrentRadioStationNumber() {
        int number = getCurrentRadioStationNumber();
        if (number == maxNumber) {
            setCurrentRadioStationNumber(minNumber);
        } else {
            number++;
            setCurrentRadioStationNumber(number);
        }
    }

    public void prevCurrentRadioStationNumber() {
        int number = getCurrentRadioStationNumber();
        if (number == minNumber) {
            setCurrentRadioStationNumber(maxNumber);
        } else {
            number--;
            setCurrentRadioStationNumber(number);
        }
    }

    private int checkVolume(int newVolume) {
        if (newVolume > maxVolume) {
            return maxVolume;
        }
        if (newVolume < minVolume) {
            return minVolume;
        }
        return newVolume;
    }

    public int getSoundVolume() {
        return soundVolume;
    }

    public void setSoundVolume(int newSoundVolume) {
        this.soundVolume = checkVolume(newSoundVolume);
    }

    public void upSoundVolume() {
        int number = getSoundVolume();
        if (number == maxVolume) {
            setSoundVolume(number);
        } else {
            number++;
            setSoundVolume(number);
        }
    }

    public void downSoundVolume() {
        int number = getSoundVolume();
        if (number == minVolume) {
            setSoundVolume(number);
        } else {
            number--;
            setSoundVolume(number);
        }
    }
}
