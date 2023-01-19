package homework4;

import java.util.Scanner;

class Simulator {
    Scanner scanner = new Scanner(System.in);
    int iteration;
    int iterationCount=0;
    boolean simulationFinished=false;

    Simulatable system;

    public Simulator(Simulatable system) {
        this.system = system;
    }

    void simulate(){

       while (iteration>=iterationCount){
           iterationCount++;
           if(iterationCount>iteration){
               return;
           }
       }


    }




}
