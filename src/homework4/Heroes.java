package homework4;

import java.security.SecureRandom;
import java.util.ArrayList;


class Heroes extends Info implements Simulatable   {
    SecureRandom secureRandom = new SecureRandom();

    String name;
    int row;
    int col;
    int health;
    int wallet = 0;
    ArrayList<Heroes> heroes;


    public Heroes(String name, int row, int col, int health) {

        this.name = name;
        this.health = health;
        this.row = row;
        this.col = col;
       heroes = new ArrayList<Heroes>();
    }

    public String getName() {
        return name;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getHealth() {
        return health;
    }

    public int getWallet() {
        return wallet;
    }


    void checkValid(Terrain terrain) throws RowColException {

        if ((getRow() > terrain.row && getCol() > terrain.col) || (getRow() < 0 && getCol() < 0) || (getRow() > terrain.row && getCol() < 0) || (getRow() < 0 && getCol() > terrain.col)) {
            System.out.println("[Row must be between 0 - " + (terrain.row) + "]");
            System.out.println("[Column must be between 0 - " + (terrain.col) + "]");
            throw new RowColException("Invalid Row and Column");


        } else if (getRow() > terrain.row || getRow() < 0) {
            System.out.println("[Row must be between 0 - " + (terrain.row) + "]");
            throw new RowColException("Invalid Row");

        } else if (getCol() > terrain.col || getCol() < 0) {
            System.out.println("[Column must be between 0 - " + (terrain.col) + "]");
            throw new RowColException("Invalid Column");

        }
    }
    void addHero(Heroes heroes){
        heroes.addHero(heroes);
    }

    @Override
    public void info() {
        System.out.println("[Row:" + getRow() + " Col:" + getCol() + " Name:" + getName() + " Health:" + getHealth()+"]");
    }


    void move(Terrain t) {
        int maxRow = t.row;
        int maxCol = t.col;
        int tmp = secureRandom.nextInt(5);
        if (tmp == 0) {
            System.out.println("["+getName()+" is moving]");
            row--;

            if (row < 0) {
                System.out.println("["+getName() + " violated the boundaries! "+ getName()+"'s"+ " turn passed. Returning to last position]");
                row++;
            }
        } else if (tmp == 1) {
            System.out.println("["+getName()+" is moving]");
            col++;
            if (col > maxCol-1) {
                System.out.println("["+getName() + " violated the boundaries! "+ getName()+"'s"+ " turn passed. Returning to last position]");
                col--;
            }
        } else if (tmp == 2) {
            System.out.println("["+getName()+" is moving]");
            col--;
            if (col < 0) {
                System.out.println("["+getName() + " violated the boundaries! "+ getName()+"'s"+ " turn passed. Returning to last position]");
                col++;
            }
        } else if (tmp == 3) {
            System.out.println("["+getName()+" is moving]");
            row++;
            if (row > maxRow-1) {
                System.out.println("["+getName() + " violated the boundaries! "+ getName()+"'s"+ " turn passed. Returning to last position]");
                row--;
            }
        } else{
            System.out.println("["+getName() + " decided not to move]");
        }
    }
    void collectGold(Terrain t) {
        if(t.terrain[row][col]!=0) {
            wallet += t.terrain[row][col];
        }
        t.terrain[row][col] = 0;
    }

    void checkHeroFight(){
        for (int i = 0; i < heroes.size() ; i++) {
            for (int j = heroes.size(); j > 0; j--) {
                if(heroes.get(i).row == heroes.get(j).row && heroes.get(i).col == heroes.get(j).col){
                    System.out.println("Heroes fighting");
                    if(heroes.get(i).health > heroes.get(j).health){
                        heroes.get(i).wallet+=heroes.get(j).wallet;
                    }else if(heroes.get(i).health < heroes.get(j).health){
                        heroes.get(j).wallet+=heroes.get(i).wallet;
                    }
                }
            }
        }
    }

    public boolean isHeroAlive() {
        if (health < 1) {
            wallet = 0;
            return false;
        }
        return true;
    }


}
