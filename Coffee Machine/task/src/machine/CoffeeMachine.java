package machine;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import static java.lang.Math.min;
import java.util.Collections;
public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] ingredients = new int[] {400,540,120,550,9}; //water,milk,beans,money,cups
        aa:
        while(true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String act = scanner.next();
            Menu actions = Menu.valueOf(act);
            switch (actions) {
                case buy:
                    System.out.println();
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back -to main menu:");
                    String coffee = scanner.next();
                    buy(ingredients, coffee);
                    break;
                case fill:
                    fill(ingredients);
                    break;
                case take:
                    take(ingredients);
                    break;
                case remaining:
                    info(ingredients);
                    break;
                case exit:
                    break aa;
            }
        }
    }
    public static void fill(int[]ingredients) {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("Write how many ml of water you want to add:");
        ingredients[0] += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        ingredients[1] += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        ingredients[2] += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        ingredients[4] += scanner.nextInt();
        System.out.println();
    }
    public static void info(int[] ingredients) {
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.println(ingredients[0] + " ml of water");
        System.out.println(ingredients[1] + " ml of milk");
        System.out.println(ingredients[2] + " g of coffee beans");
        System.out.println(ingredients[4] + " disposable cups");
        System.out.println("$" + ingredients[3] + " of money");
        System.out.println();
    }
    public static void take(int[] ingredients) {
        System.out.println();
        System.out.println("I gave you $" + ingredients[3]);
        System.out.println();
        ingredients[3] = 0;
    }
    public static void buy(int[] ingredients, String coffee) {
        switch (coffee) {
            case "1":
                espresso(ingredients);
                break;
            case "2":
                latte(ingredients);
                break;
            case "3":
                cappuccino(ingredients);
                break;
            case "back":
                break;
        }
    }
    public static void espresso(int[] ingredients) {
        List<Integer> espresso = Arrays.asList(ingredients[0] / 250, ingredients[2] / 16 ,ingredients[4]);
        int min = Collections.min(espresso);
        int minIndex = espresso.indexOf(min);
        if (min < 1) {
            notEnough(minIndex);
        } else {
            ingredients[0] -= 250;
            ingredients[2] -= 16;
            ingredients[3] += 4;
            ingredients[4]--;
            enough();
        }

    }
    public static void latte(int[] ingredients) {
        List<Integer> latte  = Arrays.asList(ingredients[0] / 350, ingredients[1] / 100, ingredients[2] / 20 ,ingredients[4]);
        int min = Collections.min(latte);
        int minIndex = latte.indexOf(min);
        if (min < 1) {
            notEnough(minIndex);
        } else {
            ingredients[0] -= 350;
            ingredients[1] -= 75;
            ingredients[2] -= 20;
            ingredients[3] += 7;
            ingredients[4]--;
            enough();
        }
    }
    public static void cappuccino(int[] ingredients) {
        List<Integer> cappuccino = Arrays.asList(ingredients[0] / 200, ingredients[1] / 100, ingredients[2] / 12 ,ingredients[4]);
        int min = Collections.min(cappuccino);
        int minIndex = cappuccino.indexOf(min);
        if (min < 1) {
            notEnough(minIndex);
        } else {
            ingredients[0] -= 200;
            ingredients[1] -= 100;
            ingredients[2] -= 12;
            ingredients[3] += 6;
            ingredients[4]--;
            enough();
        }
    }
    public static void enough() {
        System.out.println("I have enough resources, making you a coffee!");
        System.out.println();
    }
    public static void notEnough(int min) {
        List<String> ingredientsName = Arrays.asList("water", "milk", "bean", "time", "cups");
        System.out.println("Sorry, not enough " + ingredientsName.get(min) + "!");
    }
    enum Menu {
        buy, fill, take, remaining, exit
    }
}
