package CTCI.Stacks;

import java.util.LinkedList;

class AnimalShelter {
    private LinkedList<Dog> dogs = new LinkedList<>();
    private LinkedList<Cat> cats = new LinkedList<>();
    private int order = 0; // acts like timestamp

    public void enqueue(Animal animal) {
        animal.setOrder(order++);
        if (animal instanceof Dog) {
            dogs.addLast((Dog) animal);
        } else if (animal instanceof Cat) {
            cats.addLast((Cat) animal);
        }
    }

    public Animal dequeueAny() {
        if (dogs.isEmpty()) return dequeueCat();
        if (cats.isEmpty()) return dequeueDog();

        Dog dog = dogs.peek();
        Cat cat = cats.peek();

        if (dog.isOlderThan(cat)) {
            return dequeueDog();
        } else {
            return dequeueCat();
        }
    }

    public Dog dequeueDog() {
        return dogs.poll();
    }

    public Cat dequeueCat() {
        return cats.poll();
    }
}

