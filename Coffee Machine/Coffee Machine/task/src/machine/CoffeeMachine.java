package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private static Scanner scanner = new Scanner(System.in);
    private  int water = 400;
    private  int milk = 540;
    private  int beans = 120;
    private  int dispCups = 9;
    private  int moneyIn = 550;
    private State coffeeMachineState;


    public void printState (){
        System.out.println("The coffee machine has:");
        System.out.println(this.water + " of water\n" +
                this.milk + " of milk\n" +
                this.beans + " of coffee beans\n" +
                this.dispCups + " of disposable cups\n" +
                "$" + this.moneyIn + " of money");
    }

    public void setCoffeeMachineState (String state){
        if(state.equals("buy") || state.equals("fill") || state.equals("take") || state.equals("remaining") || state.equals("exit")) {
            System.out.println(State.CHOOSING_AN_ACTION);
        }
    }



    public void makeCoffee(){
        /*
        For the espresso, the coffee machine needs 250 ml of water and 16 g of coffee beans. It costs $4.
        For the latte, the coffee machine needs 350 ml of water, 75 ml of milk, and 20 g of coffee beans. It costs $7.
        And for the cappuccino, the coffee machine needs 200 ml of water, 100 ml of milk, and 12 g of coffee. It costs $6.
        */
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String whichCoffee = scanner.next();
        switch (whichCoffee){
            case "1": // espresso

                if(this.water < 250) {
                    System.out.println("Sorry, not enough water!");
                    break;
                }else if(this.beans < 16){
                    System.out.println("Sorry, not enough coffee beans!");
                    break;
                }else {
                    System.out.println("I have enough resources, making you a coffee!");
                    this.water -= 250;
                    this.beans -= 16;
                    this.moneyIn += 4;
                    this.dispCups -= 1;
                    break;
                }
            case "2": //latte

                if(this.water < 350) {
                    System.out.println("Sorry, not enough water!");
                    break;
                }else if(this.milk < 75) {
                    System.out.println("Sorry, not enough milk!");
                    break;
                }else if(this.beans < 20){
                    System.out.println("Sorry, not enough coffee beans!");
                    break;

                }else {
                    System.out.println("I have enough resources, making you a coffee!");
                    this.water -= 350;
                    this.milk -= 75;
                    this.beans -= 20;
                    this.moneyIn += 7;
                    this.dispCups -= 1;
                    break;
                }

            case "3": // cappuccino
                if(this.water < 200) {
                    System.out.println("Sorry, not enough water!");
                    break;
                }else if(this.milk < 100) {
                    System.out.println("Sorry, not enough milk!");
                    break;
                }else if(this.beans < 12){
                    System.out.println("Sorry, not enough coffee beans!");
                    break;

                }else {
                    System.out.println("I have enough resources, making you a coffee!");
                    this.water -= 200;
                    this.milk -= 100;
                    this.beans -= 12;
                    this.moneyIn += 6;
                    this.dispCups -= 1;
                    break;
                }

            case "back":
                break;
        }
    }

    public void fillMachine(){
        System.out.println("Write how many ml of water do you want to add: ");
        int fillWater = scanner.nextInt();
        this.water += fillWater;
        System.out.println("Write how many ml of milk do you want to add: ");
        int fillMilk = scanner.nextInt();
        this.milk += fillMilk;
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        int fillBeans = scanner.nextInt();
        this.beans += fillBeans;
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        int fillCups = scanner.nextInt();
        this.dispCups += fillCups;
    }

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        State state;
        boolean quit = false;
        while(!quit) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String in = scanner.next();
            coffeeMachine.setCoffeeMachineState(in);

            switch (in) {
                case "buy":
                    coffeeMachine.makeCoffee();
                    break;
                case "fill":
                    coffeeMachine.fillMachine();
                    break;
                case "take":
                    System.out.println("I gave you $" + coffeeMachine.moneyIn);
                    System.out.println();
                    coffeeMachine.moneyIn = 0;
                    break;
                case "remaining":
                    coffeeMachine.printState();
                    break;
                case "exit":
                    quit = true;
                    break;
            }


        }
    }

    public static int findMin (int [] numbers){
        int minValue = numbers[0];
        for (int i=0; i < numbers.length; i++){
            if(numbers[i] < minValue){
                minValue = numbers[i];
            }
        }
        return minValue;
    }
}
