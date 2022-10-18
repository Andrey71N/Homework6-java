package lesson6;

import java.util.Random;

public abstract class Animal {
    String name;
    String color;
    float age;

    public abstract boolean run(float distance);
    public abstract boolean swim(float distance);
    public abstract boolean jump(float height);

}



class Cat extends Animal {
    private final float RUN_DISTANCE = 200.0f;
    private final float SWIM_DISTANCE = 0.0f;
    private final float JUMP_HEIGHT = 2.0f;
    private float runDistance;
    private float swimDistance;
    private float jumpHeight;

    public Cat(String name, String color, float age) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.runDistance = new Random().nextInt(2) == 1 ? RUN_DISTANCE + new Random().nextInt(51) : RUN_DISTANCE - new Random().nextInt(51); //ограничение на бег 200±50 м
        this.swimDistance = SWIM_DISTANCE; //не проплывёт и метра
        this.jumpHeight = new Random().nextInt(2) == 1 ? JUMP_HEIGHT + new Random().nextFloat() / 2 : JUMP_HEIGHT - new Random().nextFloat() / 2; //ограничение на прыжок 2±0,45 м
    }

    public float getRunDistance() {
        return runDistance;
    }

    public void setRunDistance(float runDistance) {
        this.runDistance = runDistance;
    }

    public float getJumpHeight() {
        return jumpHeight;
    }

    public void setJumpHeight(float jumpHeight) {
        this.jumpHeight = jumpHeight;
    }

    public float getSwimDistance() {
        return swimDistance;
    }



    public String toString() {
        return "Кот {" +
                "кличка = '" + this.name + '\'' +
                ", окрас = '" + this.color + '\'' +
                ", возраст = " + this.age + " лет" +
                ", может пробежать " + this.runDistance + " м" +
                ", не может плавать" +
                ", может подпрыгнуть на " + String.format("%.2f", this.jumpHeight) + " м" +
                '}';
    }


    public boolean swim(float distance) {
        return false;
    }


    public boolean run(float distance) {
        return !(distance > this.runDistance && distance > 0);
    }


    public boolean jump(float height) {
        return !(height > this.jumpHeight && height > 0);
    }
}



class Dog extends Animal {
    private final float RUN_DISTANCE = 500.0f;
    private final float SWIM_DISTANCE = 10.0f;
    private final float JUMP_HEIGHT = 0.5f;
    private float runDistance;
    private float swimDistance;
    private float jumpHeight;

    public Dog(String name, String color, float age) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.runDistance = new Random().nextInt(2) == 1 ? RUN_DISTANCE + new Random().nextInt(101) : RUN_DISTANCE - new Random().nextInt(101); //ограничение на бег 500±100 м
        this.swimDistance = new Random().nextInt(2) == 1 ? SWIM_DISTANCE + new Random().nextInt(3) : SWIM_DISTANCE - new Random().nextInt(3); //ограничение на плавание 10±2 м
        this.jumpHeight = new Random().nextInt(2) == 1 ? JUMP_HEIGHT + new Random().nextFloat() / 10 : JUMP_HEIGHT - new Random().nextFloat() / 10; //ограничение на прыжок 0,5±0,09 м
    }


    public String toString() {
        return "Собака {" +
                "кличка = '" + this.name + '\'' +
                ", окрас = '" + this.color + '\'' +
                ", возраст = " + this.age + " лет" +
                ", может пробежать " + this.runDistance + " м" +
                ", может проплыть " + this.swimDistance + " м" +
                ", может подпрыгнуть на " + String.format("%.2f", this.jumpHeight) + " м" +
                '}';
    }


    public boolean run(float distance) {
        return !(distance > this.runDistance && distance > 0);
    }


    public boolean swim(float distance) {
        return !(distance > this.swimDistance && distance > 0);
    }


    public boolean jump(float height) {
        return !(height > this.jumpHeight && height > 0);
    }


}

class MainClass {
    public static void main(String[] args) {
        Animal[] pets = {
                new Dog("Буля", "бело-чёрный", 2),
                new Cat("Тимоша", "серый", 1.5f),
                new Dog("Белла", "белый", 1),
                new Dog("Тима", "рыжий", 2.3f),
                new Dog("Серый", "чёрный", 2),
                new Dog("Пино", "пепельный", 2),
                new Cat("Скай", "чёрный-серый-белый", 1.3f),
                new Cat("Дуся", "рыжий", 1.5f),
                new Cat("Ласка", "дымчатый", 1.5f),
        };

        for (Animal a :
                pets) {
            System.out.println(a);
        }

        int runDistance = 456;
        for (Animal a :
                pets) {
            if (a instanceof Dog) {
                System.out.println(a.name + " пробежал " + runDistance + " м: " + a.run(runDistance));
            }
        }

        float jumpHeight = 1.6f;
        for (Animal a :
                pets) {
            if (a instanceof Cat) {
                System.out.println(a.name + " подпрыгнул на " + jumpHeight + " м: " + a.jump(1.6f));
            }
        }

    }
}





