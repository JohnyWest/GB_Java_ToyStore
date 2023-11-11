package org.toystore;

import java.util.ArrayList;
import java.util.List;

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

}
