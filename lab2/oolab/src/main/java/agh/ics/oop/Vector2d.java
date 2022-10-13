package agh.ics.oop;

public class Vector2d {
    private final int x; //final -> nie ma możliwości zmiany danych
    private final int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vector2d add(Vector2d other){

        return new Vector2d(x + other.x, y + other.y);
    }

    public Vector2d subtract(Vector2d other){

        return new Vector2d(x - other.x, y - other.y);
    }

    public Vector2d upperRight(Vector2d other){
        int a;
        int b;

        if (x > other.x){
            a = x;
        }else{
            a = other.x;
        }


        if (y > other.y){
            b = y;
        }else{
            b = other.y;
        }

        return new Vector2d(a, b);

    }



    public Vector2d lowerLeft(Vector2d other){
        int a;
        int b;

        if (x < other.x){
            a = x;
        }else{
            a = other.x;
        }


        if (y < other.y){
            b = y;
        }else{
            b = other.y;
        }

        return new Vector2d(a, b);
    }



    public Vector2d opposite(){

        return new Vector2d(-this.x, -this.y);
    }




    public boolean equals(Object other){ //dostaję Object other i zwraca mi bool
        if (this == other){  //jeśli mój wektor i other mają ten sam adres
            return true;
        }
        if (!(other instanceof Vector2d)){ //jeśli other nie jest zgodny z typem Vector2d
            return false;
        }

        Vector2d newVector = (Vector2d) other; //zamieniam object other na wektor typu vector2d

        if (newVector.x == this.x && newVector.y == this.y){
            return true;
        }else{
            return false;
        }


    }


    @Override //odziedziczona metoda z klasy typu object
    public String toString() {
        return "(%d, %d)".formatted(x, y);  //%d -> int
    }



    boolean precedes(Vector2d other){

        return x <= other.x && y <= other.y;
    }
    boolean follows(Vector2d other){

        return x >= other.x && y >= other.y;
    }


}