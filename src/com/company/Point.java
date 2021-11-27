package com.company;

// create class Point
public class Point {

    //createing local privete veribels
    private int int_x, int_y;

    //first Constructor a new point with the specified x y coordinates
    public Point(int int_x, int int_y){
        this.int_x=int_x;
        this.int_y=int_y;
    }
    //second Constructor copy Constructor
    public Point(Point other){

        // setting the values by the values of the given point
        this.int_x=other.int_x;
        this.int_y=other.int_y;
    }

    //Returns the x coordinate of the point.
    public int getX(){
        return this.int_x;
    }

    //Returns the y coordinate of the point.
    public int getY (){
        return this.int_y;
    }

    //Sets the x coordinate of the point
    public  void setY (int int_y){
        this.int_y=int_y;
    }

    //Sets the y coordinate of the point
    public  void setX (int int_x){
        this.int_x=int_x;
    }

    //Representation of the object in String
    @Override
    public String toString() {
        return "("+int_x+","+int_y+")";
    }

   //Checks if two points are equal.
    public boolean equals (Point other) {
        return (this.int_x==other.int_x&&this.int_y==other.int_y);
    }

    //Checks if the current point is above the point it is to be compared with.
    public boolean isAbove (Point other){
        return (this.int_y>other.int_y);
    }

    //Checks if the current point is under the point it is to be compared with.
    public boolean isUnder (Point other){

        //using the isAbove function and switching the verbals in order to determine if the point is under
        return other.isAbove(this);
    }

    //Checks if the current point is left to the point it is to be compared with.
    public boolean isLeft (Point other){
        return (this.int_x<other.int_x);
    }

    //Checks if the current point is left to the point it is to be compared with.
    public boolean isRight (Point other){

        //using the isLeft function and switching the verbals in order to determine if the point is right
        return other.isLeft(this);
    }

    //Moves the current point , at location (x,y) to a new location. This new location is determined by deltaX which changes X's position along the X axis and deltaY which changes Y's position along the Y axis.
    public void move (int deltaX,int deltaY){
        this.setX(this.getX()+deltaX);
        this.setY(this.getY()+deltaY);
    }
    //Calculates the distance between two points.
    public double distance (Point point){

        // the length is calculated by the math function of distance between two points
        return Math.sqrt(Math.pow(this.int_x-point.int_x,2)+Math.pow(this.int_y- point.int_y,2));
    }
}
