//1. Создать наследника реализованного класса ГорячийНапиток с дополнительным полем int температура.
//2. Создать класс ГорячихНапитковАвтомат реализующий интерфейс ТорговыйАвтомат и реализовать перегруженный метод getProduct(int name, int volume, int temperature) выдающий продукт соответствующий имени, объему и температуре
//3. В main проинициализировать несколько ГорячихНапитков и ГорячихНапитковАвтомат и воспроизвести логику заложенную в программе
//4. Все вышеуказанное создать согласно принципам ООП

import java.util.ArrayList;

public class HotDrink extends Object {
    private String name;
    private int volume;
    private int temperature;

    public HotDrink(String name, int volume, int temperature) {
        this.name = name;
        this.volume = volume;
        this.temperature = temperature;
    }

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    public int getTemperature() {
        return temperature;
    }
}

public class HotDrinkVendingMachine implements TradeAutomat {
    private ArrayList<HotDrink> products = new ArrayList <> ();

    public HotDrinkVendingMachine() {
        products.add(new HotDrink("Кофе", 200, 65));
        products.add(new HotDrink("Чай", 250, 75));
        products.add(new HotDrink("Горячий шоколад", 300, 60));
    }

    @Override
    public Object getProduct(int name, int volume, int temperature) {
        for (HotDrink product : products) {
            if (product.getName().equalsIgnoreCase(String.valueOf(name)) && product.getVolume() == volume && product.getTemperature() == temperature) {
                return product;
            }
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        HotDrinkVendingMachine vendingMachine = new HotDrinkVendingMachine();

        HotDrink tea = (HotDrink) vendingMachine.getProduct(1, 250, 75);
        System.out.println("Продукт: " + tea.getName() + ", Объем: " + tea.getVolume() + ", Температура: " + tea.getTemperature());

        HotDrink coffee = (HotDrink) vendingMachine.getProduct(2, 200, 65);
        System.out.println("Продукт: " + coffee.getName() + ", Объем: " + coffee.getVolume() + ", Температура: " + coffee.getTemperature());

        HotDrink chocolate = (HotDrink) vendingMachine.getProduct(3, 300, 60);
        System.out.println("Продукт: " + chocolate.getName() + ", Объем: " + chocolate.getVolume() + ", Температура: " + chocolate.getTemperature());
    }
}