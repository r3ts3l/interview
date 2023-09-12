package com.amex.codereview;

import java.util.ArrayList;
import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
        Zoo myZoo = new Zoo(new Dog("Clifford", "blue", true));
        System.out.println("My animal Description is: " + myZoo.getTheAnimal().getDescription());

        ArrayList<Animal> list = new ArrayList<>();
        list.add(new Dog());
        list.add(new Cat("Garfield", "Green", true));
        list.add(new Eagle("Bold", "Red", false));

        displayAnimals(list);

    }

    public void displayAnimals(List<Dog> theList) {
        theList.stream().forEach(Animal -> {
            if (Animal.getColor() == "Green") {
                System.out.println("Found a Cat with name:" + Animal.getName());
            }
            if (!Animal.isCanFly()) {
                System.out.println("Found an eagle that can't fly:" + Animal.isCanFly());
            }
        });
    }

    static abstract class Animal {
        private String name;
        private String color;
        private boolean canFly;

        public Animal(){
            this.name = "Animal";
            this.color = "Red";
            this.canFly = false;
        }

        public Animal( String name, String color, Boolean canFly) {
            this.name = name;
            color = this.color;
            this.canFly = canFly;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public boolean isCanFly() {
            return canFly;
        }

        public void setCanFly(boolean canFly) {
            this.canFly = canFly;
        }

        private String getDescription () {
            return this.name + this.color + this.canFly;
        }

        protected abstract String getAnimalName();
    }

    static class Dog extends Animal {
        public Dog() {
            super();
        }

        public Dog (String name, String color, Boolean canFly) {
            super(name, color, false);
        }

        @Override
        protected String getAnimalName() {
            return "My name is Super Dog";
        }
    }

    static class Cat extends Animal {
        public Cat() {
            super();
        }

        public Cat(String name, String color, Boolean canFly) {
            super(name, color, canFly);
        }

        @Override
        protected String getAnimalName() {
            return "My name is Super Cat";
        }
    }

    public static class Eagle extends Animal {
        public Eagle() {
            super();
        }

        public Eagle(String name, String color, Boolean canFly) {
            super(name, color, true);
        }

        @Override
        protected String getAnimalName() {
            return "My name is Super Eagle";
        }
    }

    static class Zoo {

        private Animal theAnimal;
        public Zoo (Animal myAnimal) {
            this.theAnimal = myAnimal;
        }


        public Animal getTheAnimal() {
            return theAnimal;
        }

        public void setTheAnimal(Animal theAnimal) {
            this.theAnimal = theAnimal;
        }
    }

}