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
        this.point_SW = point;
    }
    //
    public RectangleA (Point sw,Point ne){
        //
        this.point_SW=sw;
        //
        this.int_height=ne.getY()- sw.getY();
        //
        this.int_width=ne.getX()- sw.getX();
    }
    public RectangleA(RectangleA r){
        //
        this.point_SW= r.point_SW;
        //
        this.int_height= r.int_height;
        //
        this.int_width= r.int_width;

    }

    public int getInt_width() {
        return this.int_width;
    }

    public int getInt_height() {
        return this.int_height;
    }

    public Point getPoint_SW() {
        return this.point_SW;
    }

    public void setInt_width(int int_width) {
        this.int_width = int_width;
    }

    public void setInt_height(int int_height) {

        this.int_height = int_height;
    }
    public void setPoint_SW(Point point_SW) {
        this.point_SW = point_SW;
    }
//
    @Override
    public String toString() {
        return "width=" + int_width + " height=" + int_height + " pointSW=" + point_SW;
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
        return r.point_SW.isRight(this.point_SW)&&r.point_SW.isAbove(this.point_SW)
                &&r.getPointNE().isLeft(this.getPointNE())&&r.getPointNE().isUnder(this.getPointNE());
    }
    //
    public boolean overlap(RectangleA r){
        if (this.point_SW.isRight(r.getPointNE())||this.getPointNE().isLeft(r.point_SW)) {
            return this.getPointNE().isUnder(r.point_SW) || this.point_SW.isAbove(r.getPointNE());
        }
        return false;
    }
}
