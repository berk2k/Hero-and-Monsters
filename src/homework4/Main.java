package homework4;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws RowColException {

       /* Simulatable simulatable = new Terrain();
        Simulator simulator = new Simulator(simulatable);
        simulator.simulate();*/
        Scanner scanner = new Scanner(System.in);
        ArrayList<Monster> monsters = new ArrayList<>();
        ArrayList<Heroes> heroes = new ArrayList<>();
        System.out.println("Enter turn: ");
        int iteration = scanner.nextInt();
        int iterationCnt = 0;


        try {
            File textFile = new File("C:\\java_demos\\homework4-berkpolat\\src\\homework4\\hw4input.txt");
            Scanner scan = new Scanner(textFile);
            String tmp;
            while (scan.hasNextLine()) {
                tmp = scan.nextLine();
                System.out.println(tmp);
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("Could not find the file");
        }

        Terrain terrain = new Terrain(5, 4);
        terrain.putGold();
        Heroes heroes1 = new Heroes("Ghost of Sparta", 1, 2, 100);
        Heroes heroes2 = new Heroes("Geralt of Rivia", 2, 3, 100);
        heroes.add(heroes1);
        heroes.add(heroes2);
        Monster monster1 = new Monster("Monster1", 4, 2, 50);
        Monster monster2 = new Monster("Monster2", 3, 1, 25);
        monsters.add(monster1);
        monsters.add(monster2);
        terrain.info();
        terrain.printTerrain();
        System.out.println("Monster Info");
        System.out.println("------------------");
        System.out.println("Number of Monster: " + monsters.size());

        for (int i = 0; i < monsters.size(); i++) {
            monsters.get(i).info();
        }
        System.out.println("<------------------------->");
        System.out.println("Hero Info");
        System.out.println("------------------");
        System.out.println("Number of Hero: " + heroes.size());
        for (int i = 0; i < heroes.size(); i++) {
            heroes.get(i).info();
            //crash the program if inputs are wrong
            heroes.get(i).checkValid(terrain);
            heroes.get(i).collectGold(terrain);
        }
        while (iterationCnt < iteration) {
            iterationCnt++;
            for (int i = 0; i < heroes.size(); i++) {

                heroes.get(i).move(terrain);
                System.out.println("[" + heroes.get(i).getName() + " Row:" + heroes.get(i).row + " Column:" + heroes.get(i).col + "]");
                heroes.get(i).checkHeroFight();
                heroes.get(i).collectGold(terrain);
                System.out.println(heroes.get(i).getName() + " HP: " + heroes.get(i).health);
                for (int j = 0; j < monsters.size(); j++) {
                    monsters.get(j).hit(heroes.get(i));
                    if (!heroes.get(i).isHeroAlive()) {
                        System.out.println(heroes.get(i).getName() + " and " + monsters.get(j).getName() + " died!");
                        monsters.remove(j);
                    }
                }
                System.out.println(heroes.get(i).getName() + " has " + heroes.get(i).wallet + " gold");
                if (!heroes.get(i).isHeroAlive()) {
                    heroes.remove(i);
                }
            }
            terrain.printTerrain();

        }
        System.out.println("------------GAMEOVER----------");

    }
}


















