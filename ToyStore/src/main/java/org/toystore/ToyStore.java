package org.toystore;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyStore {
    private List<Toy> toys;
    public ToyStore() {
        toys = new ArrayList<>();
    }
    public void addToy(Toy toy) {
        toys.add(toy);
    }
    public void updateWeight(int toyID, int weight){
        for (Toy toy : toys) {
            if (toy.getId() == toyID) {
                toy.setWeight(weight);
                break;
            }
        }
    }
    public Toy selectToy() {
        int totalWeight = 0;
        for (Toy toy : toys) {
            totalWeight += toy.getWeight();
        }
        Random random = new Random();
        int randomNumber = random.nextInt(totalWeight) + 1;
        int cumulativeWeight = 0;
        for (Toy toy : toys) {
            cumulativeWeight += toy.getWeight();
            if (randomNumber <= cumulativeWeight) {
                toy.setQuantity(toy.getQuantity() -1);
                return toy;
            }
        }
        return null;
    }
    public void saveToyToFile(Toy toy, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write("Toy ID: " + toy.getId() + ", Toy Name: " + toy.getName());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
