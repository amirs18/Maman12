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
            this.int_height=w;
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
            this.int_height = w;
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
    public void move(int DeltaX,int DeltaY){

    }
}
