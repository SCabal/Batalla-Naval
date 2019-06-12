package model;

public class Player{

    public static final int ATTEMPTS = 50;

    int counter;

    public Player(){
        this.counter = 0;
    }

    public int getCounter(){
        return this.counter;
    }

    public void addToCounter(){
        counter += 1;
    }

    public void substractToCounter(){
        if(counter - 6 >= 0) counter -= 6;
        else counter = 0;
    }

    public boolean isLoser(){
        return counter == ATTEMPTS;
    }
}
