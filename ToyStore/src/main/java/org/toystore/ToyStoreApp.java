package org.toystore;

public class ToyStoreApp {
    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();

        //Добавление игрушек в магазин
        Toy toy1 = new Toy(1, "Кукла", 10, 30);
        Toy toy2 = new Toy(2, "Конструктор", 20, 40);
        Toy toy3 = new Toy(3, "Робот", 15, 30);
        toyStore.addToy(toy1);
        toyStore.addToy(toy2);
        toyStore.addToy(toy3);

        //Изменение веса игрушки
        toyStore.updateWeight(2,45);

        //Розыгрыш игрушек
        Toy selectedToy = toyStore.selectToy();
        if (selectedToy != null) {
            toyStore.saveToyToFile(selectedToy, "YourPrize.txt");
            System.out.println("Поздравляем, вы выиграли " + selectedToy.getName());
        }
        else {
            System.out.println("Нет доступных игрушек");
        }
    }
}
