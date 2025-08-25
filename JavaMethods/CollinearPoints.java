public class CollinearPoints {

    // Using slope method
    public static boolean isCollinearSlope(int x1,int y1,int x2,int y2,int x3,int y3){
        int lhs = (y2-y1)*(x3-x2);
        int rhs = (y3-y2)*(x2-x1);
        return lhs == rhs;
    }

    // Using area method
    public static boolean isCollinearArea(int x1,int y1,int x2,int y2,int x3,int y3){
        double area = 0.5*(x1*(y2-y3)+x2*(y3-y1)+x3*(y1-y2));
        return area == 0.0;
    }

    public static void run(){
        int x1=2,y1=4,x2=4,y2=6,x3=6,y3=8;
        System.out.println("Points: ("+x1+","+y1+"), ("+x2+","+y2+"), ("+x3+","+y3+")");
        System.out.println("Collinear by slope? "+isCollinearSlope(x1,y1,x2,y2,x3,y3));
        System.out.println("Collinear by area? "+isCollinearArea(x1,y1,x2,y2,x3,y3));
    }
}
