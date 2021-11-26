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
            if (w > 0)
                point_NE.setX(w);
            else
                point_NE.setX(1);
            if (h > 0)
                point_NE.setY(h);
            else
                point_NE.setY(1);
        }

    //
    public RectangleB (Point sw,int w,int h){

        //
        this.point_SW=sw;

        //
        if(w>0)
            point_NE.setX(w);
        else
            point_NE.setX(1);
        if (h>0)
            point_NE.setY(h);
        else
            point_NE.setY(1);
    }
    public RectangleB (Point sw,Point ne){

        //
        this.point_SW=sw;

        //
        this.point_NE=ne;
    }

    public RectangleB(RectangleB r) {
        //
        this.point_SW=r.point_SW;

        //
        this.point_NE=r.point_NE;
    }
    public int getInt_width() {
        return point_NE.getX()-point_SW.getX();
    }

    public int getInt_height() {
        return point_SW.getY()-point_NE.getY();
    }

    public Point getPoint_SW() {
        return point_SW;
    }

    public void setPoint_SW(Point SW) {
        this.point_NE.setY(SW.getY()+this.getInt_height());
        this.point_NE.setX(SW.getX()+this.getInt_width());
        this.point_SW = SW;
    }
    public Point getPoint_NE() {
        return point_NE;
    }

    //
    @Override
    public String toString() {
        return "width=" + this.getInt_width() + " height=" + this.getInt_height() + " pointSW=" + point_SW;
    }

    //
    public int getPerimeter(){
        //
        return (this.getInt_height()+this.getInt_width())*2;
    }
    public int getArea(){
        return (this.getInt_height()*this.getInt_width()) ;
    }
    //
    public void move(int deltaX,int deltaY){

        this.setPoint_SW(new Point(this.point_SW.getX()+deltaX,this.point_SW.getY()+deltaY));
    }
    //
    public boolean equals (RectangleB other){
        //
        return (this.getInt_height()==other.getInt_height())&&(this.getInt_width()==other.getInt_width())&&(this.point_SW.equals(other.point_SW));
    }
    //
    public double getDiagonalLength (){
        //
        return Math.sqrt(Math.pow(this.getInt_height(),2)+Math.pow(this.getInt_width(),2));
    }
    //
    public boolean isLarger(RectangleB other){
        //
        return this.getArea()>other.getArea();
    }
    //
    public Point getPointNE(){
        //
        return new Point(this.point_SW.getX()+ this.getInt_width(), this.point_SW.getY()+ this.getInt_height());
    }
    //
    public void changeSides(){
        this.point_NE.setY(this.point_SW.getY()+this.getInt_width());
        this.point_NE.setX(this.point_SW.getX()+this.getInt_height());
    }
    //
    public boolean isIn (RectangleB r){
        //
        return r.point_SW.isRight(this.point_SW)&&r.point_SW.isAbove(this.point_SW)
                &&r.getPointNE().isLeft(this.getPointNE())&&r.getPointNE().isUnder(this.getPointNE());
    }
    //
    public boolean overlap(RectangleB r){
        if (this.point_SW.isRight(r.getPointNE())||this.getPointNE().isLeft(r.point_SW)) {
            return this.getPointNE().isUnder(r.point_SW) || this.point_SW.isAbove(r.getPointNE());
        }
        return false;
    }
}

