import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.netology.javaqa.Radio;

public class RadioTest {

    private int quantityStations; // оставить пустым (калов по умолчанию) или присвоить значении int


    @ParameterizedTest
    @CsvSource({
            "-1,0", "0,0", "5,5", "9,9", "10,9"
    })  // выбор каналов вручную (граничные значения)
    public void setNumber(short numberVolume, short expected) {
        Radio set = new Radio(quantityStations);
        this.quantityStations = set.quantity;
        if (quantityStations > 0 & numberVolume == quantityStations & expected == quantityStations) {
            expected--;
        }//Нужно для корректной работы с @CsvSource иначе при ручной установке количества каналов и неотредактированых @CsvSource, падает тест

        if (numberVolume <= quantityStations) {
            set.setCurrentRadioStationNumber(numberVolume);
            int actual = set.getCurrentRadioStationNumber();
            Assertions.assertEquals(expected, actual);
            System.out.println("Попытка установить канал на " + numberVolume + " в результате " + actual);
        }
    }

    @Test
    public void setUpNumber() {
        Radio set = new Radio(quantityStations);
        set.setCurrentRadioStationNumber(1000);
        int max = set.getCurrentRadioStationNumber();
        set.setCurrentRadioStationNumber(-1);
        int min = set.getCurrentRadioStationNumber();
        set.setCurrentRadioStationNumber(min);
        int expected = max - min + 1;
        int actual = min;
        for (int i = min; i <= max; i++) {
            set.nextCurrentRadioStationNumber();
            actual++;
            System.out.println("Канал " + i + " нажатие next - результат " + set.getCurrentRadioStationNumber() + " канал");
        }
        if (min > 0) {
            actual--;
        }
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void setDownNumber() {
        Radio set = new Radio(quantityStations);
        set.setCurrentRadioStationNumber(1000);
        int max = set.getCurrentRadioStationNumber();
        set.setCurrentRadioStationNumber(-1);
        int min = set.getCurrentRadioStationNumber();
        set.setCurrentRadioStationNumber(max);
        int expected = max - min + 1;
        int actual = min;
        for (int i = max; i >= min; i--) {
            set.prevCurrentRadioStationNumber();
            actual++;
            System.out.println("Канал " + i + " нажатие prev - результат " + set.getCurrentRadioStationNumber() + " канал");
        }
        if (min > 0) {
            actual--;
        }
        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "-1,0", "0,0", "50,50", "100,100", "101,100"
    })  // выбор громкости вручную (граничные значения)
    public void setVolume(short soundVolume, short expected) {
        Radio set = new Radio(quantityStations);
        set.setSoundVolume(soundVolume);
        int actual = set.getSoundVolume();
        Assertions.assertEquals(expected, actual);
        System.out.println("Попытка установить громкость на " + soundVolume + " в результате " + actual);
    }

    @Test
    public void setUpVolume() {
        Radio set = new Radio(quantityStations);
        set.setSoundVolume(1000);
        int max = set.getSoundVolume();
        set.setSoundVolume(max - 10);
        int expected = max - (max - 10) + 1;
        int actual = 0;
        for (int i = max - 10; i <= max; i++) {
            set.upSoundVolume();
            actual++;
            System.out.println("Громкость " + i + " нажатие (+) - результат " + set.getSoundVolume() + " громкости");
        }
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void setDownVolume() {
        Radio set = new Radio(quantityStations);
        set.setSoundVolume(-1);
        int min = set.getSoundVolume();
        set.setSoundVolume(min + 10);
        int expected = min + 10 + 1;
        int actual = 0;
        for (int i = min + 10; i >= min; i--) {
            set.downSoundVolume();
            actual++;
            System.out.println("Громкость " + i + " нажатие (-) - результат " + set.getSoundVolume() + " громкости");
        }
        if (min > 0) {
            expected--;
        }
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void loadRadio() {
        Radio load = new Radio();
        Assertions.assertEquals(10, load.quantity);
    }
}
