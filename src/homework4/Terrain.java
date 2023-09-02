package homework4;

import java.security.SecureRandom;



class Terrain extends Info implements Simulatable{
    SecureRandom secureRandom = new SecureRandom();

    int row;
    int col;
    int terrain[][];
    int goldNumber;

    Terrain(int row, int col) {
        this.row = row;
        this.col = col;
        terrain = new int[row * col][row * col];
    }

    // copy constructor
    Terrain(Terrain other) {
        row = other.row;
        col = other.col;
        terrain = new int[row * col][row * col];

        for (int r = 0; r < terrain.length; r++) {
            for (int c = 0; c < terrain.length; c++) {
                terrain[r][c] = other.terrain[r][c];

            }
        }
    }

    void putGold() {

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                goldNumber = secureRandom.nextInt(4);
                terrain[i][j] = goldNumber;
            }
        }
    }


    void printTerrain() {
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                System.out.print(" ");
                System.out.print(terrain[r][c]);
            }
            System.out.println();
        }
    }


    @Override
    public void info() {
        System.out.println("Terrain info");
        System.out.println("-------------");
        System.out.println("M: "+row);
        System.out.println("N: "+col);
    }
}
