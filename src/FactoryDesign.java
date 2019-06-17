import static java.lang.Math.*;





public class FactoryDesign {


    public static void main(String[] args) {
       /* Point point = Point.newCartesianPoint(2,3);
        Point pointPolar=Point.newPolarPoint(2,4);
        System.out.println(point);*/

       Point point = Point.Factory.newCartesianPoint(2,3);
    }
}




enum CoordinateSystem{
    CARTESIN,POINT


        }

class Point{

/*
*
*
*
* */

   /* private Point(double a, double b,CoordinateSystem cs) {


        switch (cs){

            case CARTESIN:
                this.x = a;
                this.y = b;
                break;
            case POINT:
                x = a * Math.cos(b);
                y = a * Math.sin(b);

                break;

        }
        this.x = x;
        this.y = y;
    }*/
   private double x,y;
    private Point(double x, double y) {
        this.x = x;
        this.y = y;
    }



    public static  class  Factory {
        public static Point newCartesianPoint(double x ,double y){
            return new Point(x,y);
        }

        public static Point newPolarPoint(double rho, double theta){
            return new Point(rho*Math.cos(theta),rho*Math.sin(theta));

        }


    }

}


