package ui;

import model.*;
import java.util.Scanner;

public class Main{
    private Game game;

    public Main(){
        game = new Game();
    }
    public Game getGame(){
        return this.game;
    }

    public static void main(String[] args){
        Main main = new Main();
        Game game = main.getGame();
        Scanner scan = new Scanner(System.in);
        main.printMatrix();
        boolean flag = true;

        while(flag){
            System.out.println("Elija Cordenada Y: ");
            int x;
            int y;
            x = scan.nextInt();
            System.out.println("Elija Cordenada X: ");
            y = scan.nextInt();

            if((x > 10 || x <= 0) || (y > 10 || y <= 0)){
                System.out.println("Cordenada Invalida. Intentelo de Nuevo.");
                continue;
            }

            boolean damage = game.hit(x-1, y-1);

            if(damage){
                System.out.println("-------------------------------------------------------");
                System.out.println("Has undido un barco!");
                System.out.println("-------------------------------------------------------");
            }else{
                System.out.println("-------------------------------------------------------");
            }

            main.printMatrix();

            System.out.println("-------------------------------------------------------");
            System.out.println("Intento Numero: " + game.getCounterPlayer());
            System.out.println("-------------------------------------------------------");

            if(game.playerLose()){
                System.out.println("Lo siento. Tu has PERDIDO");
                flag = false;
            } 

            if(game.programLose()){
                System.out.println("Has GANADO <3");
                flag = false;
            }

        }

    }

    public void printMatrix(){
        String[][] matrix = game.getInterface();
        for(int i = 0; i < 11; i++){
            for(int j = 0; j < 11; j++){
                System.out.print(matrix[i][j] + " ");
                if(j == 10) System.out.println("");
            }
        }
    }
}
