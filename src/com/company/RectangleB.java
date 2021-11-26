package com.company;

// class creation
public class RectangleB {

    // variable creation
    private Point point_SW,point_NE;

    // Constructor for h,w while sw=(0,0)
        public RectangleB (int w,int h) {

            //
            this.point_SW = new Point(0, 0);

            //
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

    //
    public RectangleB (Point sw,int w,int h){

        //
        this.point_SW=new Point(sw);

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
    public RectangleB (Point sw,Point ne){

        //
        this.point_SW=new Point(sw);

        //
        this.point_NE=new Point(ne);
    }

    public RectangleB(RectangleB r) {
        //
        this.point_SW=new Point(r.point_SW);

        //
        this.point_NE=new Point(r.point_NE);
    }
    //
    public int getWidth() {
        return point_NE.getX()-point_SW.getX();
    }
    //
    public void setWidth(int w) {
            if(w>0) {
                this.point_NE = new Point(this.point_SW.getX() + w, this.point_NE.getY());
            }
    }
    public int getHeight() {
        return point_NE.getY()-point_SW.getY();
    }
    //
    public void setHeight(int h) {
            if (h>0) {
                this.point_NE= new Point(this.point_NE.getX(), this.point_SW.getY() + h);
            }
    }
    //
    public Point getPointSW() {
        return point_SW;
    }
    //
    public void setPointSW(Point SW) {
        this.point_NE.setY(SW.getY()+this.getHeight());
        this.point_NE.setX(SW.getX()+this.getWidth());
        this.point_SW = new Point(SW);
    }
    //
    public Point getPointNE() {
        return point_NE;
    }

    //
    @Override
    public String toString() {
        return "Width=" + this.getWidth() + " Height=" + this.getHeight() + " PointSW=" + point_SW;
    }

    //
    public int getPerimeter(){
        //
        return (this.getHeight()+this.getWidth())*2;
    }
    //
    public int getArea(){
        return (this.getHeight()*this.getWidth()) ;
    }
    //
    public void move(int deltaX,int deltaY){

        this.setPointSW(new Point(this.point_SW.getX()+deltaX,this.point_SW.getY()+deltaY));
    }
    //
    public boolean equals (RectangleB other){
        //
        return (this.getHeight()==other.getHeight())&&(this.getWidth()==other.getWidth())&&(this.point_SW.equals(other.point_SW));
    }
    //
    public double getDiagonalLength (){
        //
        return Math.sqrt(Math.pow(this.getHeight(),2)+Math.pow(this.getWidth(),2));
    }
    //
    public boolean isLarger(RectangleB other){
        //
        return this.getArea()>other.getArea();
    }
    //
    //
    public void changeSides(){
            Point p=new Point(point_NE);
        p.setY(this.point_SW.getY()+this.getWidth());
        p.setX(this.point_SW.getX()+this.getHeight());
        point_NE=p;
    }
    //
    public boolean isIn (RectangleB r){

        return r.getPointSW().getX() <= this.getPointSW().getX() && r.getPointSW().getY() <= this.getPointSW().getY() && r.getPointNE().getX() >= this.getPointNE().getX() && r.getPointNE().getY() >= this.getPointNE().getY();
    }
    //
    public boolean overlap(RectangleB r){
        if (r.getPointNE().isLeft(this.getPointSW()))
            return false;
        if (r.getPointSW().isRight(this.getPointNE()))
            return false;
        if (r.getPointSW().isAbove(this.getPointNE()))
            return false;
        return !r.getPointNE().isUnder(this.getPointSW());
    }


}

