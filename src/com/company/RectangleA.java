package com.company;
//
public class RectangleA {
    //
    private int int_width,int_height;
     private Point point_SW;
    //
    public RectangleA (int w,int h){
        //
        if(w>0)
            this.int_width=w;
        else
            this.int_width=1;
        //
        if (h>0)
            this.int_height=h;
        else
            this.int_height=1;
        //
        this.point_SW=new Point(0,0);
    }
    //
    public RectangleA (Point point,int w,int h) {
        //
        if (w > 0)
            this.int_width= w;
        else
            this.int_width = 1;
        //
        if (h > 0)
            this.int_height = h;
        else
            this.int_height = 1;
        //
        this.point_SW = new Point(point);
    }
    //
    public RectangleA (Point sw,Point ne){
        //
        this.point_SW=new Point(sw);
        //
        this.int_height=ne.getY()- sw.getY();
        //
        this.int_width=ne.getX()- sw.getX();
    }
    public RectangleA(RectangleA r){
        //
        this.point_SW=new Point(r.point_SW);
        //
        this.int_height= r.int_height;
        //
        this.int_width= r.int_width;

    }

    public int getWidth() {
        return this.int_width;
    }

    public int getHeight() {
        return this.int_height;
    }

    public Point getPointSW() {
        return this.point_SW;
    }

    public void setWidth(int width) {
        this.int_width = width;
    }

    public void setHeight(int height) {

        this.int_height = height;
    }
    public void setPointSW(Point point_SW) {
        this.point_SW = new Point(point_SW);
    }
//
    @Override
    public String toString() {
        return "Width=" + int_width + " Height=" + int_height + " PointSW=" + point_SW;
    }
    //
    public int getPerimeter(){
        //
        return (int_height+int_width)*2;
    }
    public int getArea(){
        return int_height*int_width;
    }
    //
    public void move(int deltaX,int deltaY){
        //
        this.int_width+=deltaX;
        this.int_height+=deltaY;
        //
        this.point_SW.setX(this.point_SW.getX()+deltaX);
        this.point_SW.setY(this.point_SW.getY()+deltaY);
    }
    //
    public boolean equals (RectangleA other){
        //
        return (this.int_height==other.int_height)&&(this.int_width==other.int_width)&&(this.point_SW.equals(other.point_SW));
    }
    //
    public double getDiagonalLength (){
        //
        return Math.sqrt(Math.pow(this.int_height,2)+Math.pow(this.int_width,2));
    }
    //
    public boolean isLarger(RectangleA other){
        //
        return this.getArea()>other.getArea();
    }
    //
    public Point getPointNE(){
        //
        return new Point(this.point_SW.getX()+ this.int_width, this.point_SW.getY()+ this.int_height);
    }
    //
    public void changeSides(){
        //
        int h,w;
        h=this.int_height;
        w=this.int_width;
        //
        this.int_height=w;
        this.int_width=h;
    }
    //
    public boolean isIn (RectangleA r){
        //
        return r.getPointSW().getX() <= this.getPointSW().getX() && r.getPointSW().getY() <= this.getPointSW().getY() && r.getPointNE().getX() >= this.getPointNE().getX() && r.getPointNE().getY() >= this.getPointNE().getY();
    }
    //
    public boolean overlap(RectangleA r){
        if (r.getPointNE().isLeft(this.getPointSW()))
            return false;
        if (r.getPointSW().isRight(this.getPointNE()))
            return false;
        if (r.getPointSW().isAbove(this.getPointNE()))
            return false;
        return !r.getPointNE().isUnder(this.getPointSW());
    }
}
