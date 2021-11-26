package com.company;

public class Point {
    private int int_x, int_y;
    public Point(int int_x, int int_y){
        this.int_x=int_x;
        this.int_y=int_y;
    }
    public Point(Point other){
        this.int_x=other.int_x;
        this.int_y=other.int_y;
    }
    public int getX(){
        return this.int_x;
    }
    public int getY (){
        return this.int_y;
    }
    public  void setY (int int_y){
        this.int_y=int_y;
    }
    public  void setX (int int_x){
        this.int_x=int_x;
    }

    @Override
    public String toString() {
        return "("+int_x+","+int_y+")";
    }
    public boolean equals (Point other) {
        return (this.int_x==other.int_x&&this.int_y==other.int_y);
    }
    public  boolean isAbove (Point other){
        return (this.int_y>other.int_y);
    }
    public boolean isUnder (Point other){
        return other.isAbove(this);
    }
    public boolean isLeft (Point other){
        return (this.int_x<other.int_x);
    }
    public boolean isRight (Point other){
        return other.isLeft(this);
    }
    public void move (int deltaX,int deltaY){
        this.setX(this.getX()+deltaX);
        this.setY(this.getY()+deltaY);
    }
    public double distance (Point point){
        return Math.sqrt(Math.pow(this.int_x-point.int_x,2)+Math.pow(this.int_y- point.int_y,2));
    }
}
