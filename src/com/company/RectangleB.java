package com.company;

// class creation
public class RectangleB {

    // variable creation
    private Point point_SW,point_NE;
        // First Constructor for h,w while sw=(0,0)
        public RectangleB (int w,int h) {

            // setting the SW point to (0,0) by default
            this.point_SW = new Point(0, 0);

            // checking if the values are valid if not 1 will replace the invalid values
            if (w>0||h>0){
                if (w > 0)
                    point_NE = new Point(w, 1);
                if (h > 0)
                    point_NE = new Point(1, h);
                if (w>0&&h>0)
                    point_NE = new Point(w, h);
            }
            else
                point_NE=new Point(1,1);

        }

    //second constructor height width and a point
    public RectangleB (Point sw,int w,int h){

        //setting the SW point to the given point
        this.point_SW=new Point(sw);

        // checking if the values are valid if not 1 will replace the invalid values
        if (w>0||h>0){
            if (w > 0)
                point_NE = new Point(point_SW.getX()+w, point_SW.getY()+1);
            if (h > 0)
                point_NE = new Point(point_SW.getX()+1,point_SW.getY()+ h);
            if (w>0&&h>0)
                point_NE = new Point(point_SW.getX()+w,point_SW.getY()+ h);
        }
        else
            point_NE=new Point(point_SW.getX()+1,point_SW.getY()+1);
    }

    //third constructor two points
    public RectangleB (Point sw,Point ne){

        //setting the SW point to the given point
        this.point_SW=new Point(sw);

        //setting the NE point to the given point
        this.point_NE=new Point(ne);
    }

    // forth constructor copy constructor
    public RectangleB(RectangleB r) {
        // setting the values by the values of the given rectangle
        this.point_SW=new Point(r.point_SW);
        this.point_NE=new Point(r.point_NE);
    }

    //Returns the width of the rectangle
    public int getWidth() {
        return point_NE.getX()-point_SW.getX();
    }
    //Sets the width of the rectangle
    public void setWidth(int w) {
            if(w>0) {
                this.point_NE = new Point(this.point_SW.getX() + w, this.point_NE.getY());
            }
    }

    //Returns the height of the rectangle
    public int getHeight() {
        return point_NE.getY()-point_SW.getY();
    }
    //Sets the height of the rectangle
    public void setHeight(int h) {
            if (h>0) {
                this.point_NE= new Point(this.point_NE.getX(), this.point_SW.getY() + h);
            }
    }

    //Returns the SW point of the rectangle
    public Point getPointSW() {
        return point_SW;
    }
    //Sets the SW Point of the rectangle
    public void setPointSW(Point SW) {
        // if we change the SW point we also need to change the NE point
        this.point_NE.setY(SW.getY()+this.getHeight());
        this.point_NE.setX(SW.getX()+this.getWidth());
        this.point_SW = new Point(SW);
    }
    //Returns the NE point of the rectangle
    public Point getPointNE() {
        return point_NE;
    }

    //Returns a string representation of the rectangle
    @Override
    public String toString() {
        return "Width=" + this.getWidth() + " Height=" + this.getHeight() + " PointSW=" + point_SW;
    }

    //Calculates the perimeter of the rectangle and returns it
    public int getPerimeter(){
        return (this.getHeight()+this.getWidth())*2;
    }

    //Calculates the area of the rectangle and returns it
    public int getArea(){
        return (this.getHeight()*this.getWidth()) ;
    }
    //Moves the rectangle by deltaX in x direction and deltaY in y direction
    public void move(int deltaX,int deltaY){
            // moving only the SW point becuse the NE point is dicided by the SW point
            this.setPointSW(new Point(this.point_SW.getX()+deltaX,this.point_SW.getY()+deltaY));
    }

    //Returns true if the given rectangle is equal to this rectangle
    public boolean equals (RectangleB other){
        return (this.getHeight()==other.getHeight())&&(this.getWidth()==other.getWidth())&&(this.point_SW.equals(other.point_SW));
    }

    //Returns the length of the rectangle diagonal
    public double getDiagonalLength (){
        // the length is calculated by the function of distance between two points
        return point_SW.distance(this.getPointNE());
    }

    //Returns true if the current rectangle is larger than the parameter rectangle
    public boolean isLarger(RectangleB other){
        // calculated using the get area function
        return this.getArea()>other.getArea();
    }

    // Changes the width to height and vice versa
    public void changeSides(){

        // creating temporary point in order to switch between the height and width
        Point p=new Point(point_NE);
        p.setY(this.point_SW.getY()+this.getWidth());
        p.setX(this.point_SW.getX()+this.getHeight());
        point_NE=p;
    }

    //Returns true if the current rectangle is in the parameter rectangle
    public boolean isIn (RectangleB r){

            //we won't be using the is left is right is above is under functions because they don't check if the parameters are equal
        return r.getPointSW().getX() <= this.getPointSW().getX() && r.getPointSW().getY() <= this.getPointSW().getY() && r.getPointNE().getX() >= this.getPointNE().getX() && r.getPointNE().getY() >= this.getPointNE().getY();
    }
    //
    //Returns true if the current rectangle overlaps with the parameter rectangle
    public boolean overlap(RectangleB r){
        //we will check if the rectangle doesn't overlap using the is above is under is left is right functions and reverse the output
        return !((r.getPointNE().isUnder(this.getPointSW()))||(r.getPointNE().isLeft(this.getPointSW()))||(r.getPointSW().isRight(this.getPointNE()))||(r.getPointSW().isAbove(this.getPointNE())));
    }


}

