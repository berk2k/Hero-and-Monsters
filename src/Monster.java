package homework4;


import java.util.ArrayList;


class Monster extends Info implements MonsterSkill, Simulatable {

    String name;
    int damage;
    int row;
    int col;
    ArrayList<Monster> monsters;

    public Monster(String name, int row, int col, int damage) {
        this.name = name;
        this.row = row;
        this.col = col;
        this.damage = damage;
        monsters = new ArrayList<>();
    }

   /* void addMonster(Monster monster) {
        monsters.add(monster);
    }*/

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }




    @Override
    public void hit(Heroes heroes) {
        if (heroes.getRow() == getRow() && heroes.getCol() == getCol()) {
            System.out.println("["+heroes.getName()+" and "+ getName()+ " are fighting]");
            heroes.health -= getDamage();
            System.out.println("["+heroes.getName()+" health decreased to: " + heroes.health+"]");
        }
    }

    @Override
    public void info() {
        System.out.println("[Row:" + getRow() + " Col:" + getCol() + " Name:" + getName() + " Damage:" + getDamage()+"]");
    }
}
