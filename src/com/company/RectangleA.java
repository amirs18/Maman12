package com.company;
// class creation
public class RectangleA {

    //variable creation
    private int int_width,int_height;
    private Point point_SW;

    // First Constructor for h,w while sw=(0,0)
    public RectangleA (int w,int h){
        // checking if the values are valid if not 1 will replace the invalid values
        if(w>0)
            this.int_width=w;
        else
            this.int_width=1;
        if (h>0)
            this.int_height=h;
        else
            this.int_height=1;
        // setting the SW point to (0,0) by default
        this.point_SW=new Point(0,0);
    }
    //second constructor height width and a point
    public RectangleA (Point point,int w,int h) {
        // checking if the values are valid if not 1 will replace the invalid values
        if (w > 0)
            this.int_width= w;
        else
            this.int_width = 1;
        if (h > 0)
            this.int_height = h;
        else
            this.int_height = 1;
        //setting the SW point to the given point
        this.point_SW = new Point(point);
    }
    //third constructor two points
    public RectangleA (Point sw,Point ne){
        //setting the SW point to the given point
        this.point_SW=new Point(sw);
        //setting the height and width by calculating the difference between the SW point and the NE point
        this.int_height=ne.getY()- sw.getY();
        this.int_width=ne.getX()- sw.getX();
    }
    // forth constructor copy constructor
    public RectangleA(RectangleA r){
        // setting the values by the values of the given rectangle
        this.point_SW=new Point(r.point_SW);
        this.int_height= r.int_height;
        this.int_width= r.int_width;
    }

    //Returns the width of the rectangle
    public int getWidth() {
        return this.int_width;
    }

    //Returns the height of the rectangle
    public int getHeight() {
        return this.int_height;
    }

    //Returns the SW point of the rectangle
    public Point getPointSW() {
        return this.point_SW;
    }

    //Sets the width of the rectangle
    public void setWidth(int width) {
        this.int_width = width;
    }

    //Sets the height of the rectangle
    public void setHeight(int height) {
        this.int_height = height;
    }

    //Sets the SW Point of the rectangle
    public void setPointSW(Point point_SW) {
        this.point_SW = new Point(point_SW);
    }

    //Returns the NE point of the rectangle
    public Point getPointNE(){
        return new Point(this.point_SW.getX()+ this.int_width, this.point_SW.getY()+ this.int_height);
    }
    //Returns a string representation of the rectangle
    @Override
    public String toString() {
        return "Width=" + int_width + " Height=" + int_height + " PointSW=" + point_SW;
    }

    //Calculates the perimeter of the rectangle and returns it
    public int getPerimeter(){
        return (int_height+int_width)*2;
    }

    //Calculates the area of the rectangle and returns it
    public int getArea(){
        return int_height*int_width;
    }

    //Moves the rectangle by deltaX in x direction and deltaY in y direction
    public void move(int deltaX,int deltaY){
        this.setPointSW(new Point(this.point_SW.getX()+deltaX,this.point_SW.getY()+deltaY));
    }

    //Returns true if the given rectangle is equal to this rectangle
    public boolean equals (RectangleA other){
        return (this.int_height==other.int_height)&&(this.int_width==other.int_width)&&(this.point_SW.equals(other.point_SW));
    }

    //Returns the length of the rectangle diagonal
    public double getDiagonalLength (){
        // the length is calculated by the function of distance between two points
        return point_SW.distance(this.getPointNE());
    }

    //Returns true if the current rectangle is larger than the parameter rectangle
    public boolean isLarger(RectangleA other){
        // calculated using the get area function
        return this.getArea()>other.getArea();
    }



    // Changes the width to height and vice versa
    public void changeSides(){
        // creating temporary variables in order to switch between the height and width
        int h,w;
        h=this.int_height;
        w=this.int_width;
        this.int_height=w;
        this.int_width=h;
    }

    //Returns true if the current rectangle is in the parameter rectangle
    public boolean isIn (RectangleA r){
        //we won't be using the is left is right is above is under functions because they don't check if the parameters are equal
        return r.getPointSW().getX() <= this.getPointSW().getX() && r.getPointSW().getY() <= this.getPointSW().getY() && r.getPointNE().getX() >= this.getPointNE().getX() && r.getPointNE().getY() >= this.getPointNE().getY();
    }

    //Returns true if the current rectangle overlaps with the parameter rectangle
    public boolean overlap(RectangleA r){
        //we will check if the rectangle doesn't overlap using the is above is under is left is right functions and reverse the output
        return !((r.getPointNE().isUnder(this.getPointSW()))||(r.getPointNE().isLeft(this.getPointSW()))||(r.getPointSW().isRight(this.getPointNE()))||(r.getPointSW().isAbove(this.getPointNE())));
    }
}
