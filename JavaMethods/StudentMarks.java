import java.util.Random;

public class StudentMarks {

    public static int[][] generateMarks(int n){
        Random r = new Random();
        int[][] marks = new int[n][3];
        for(int i=0;i<n;i++){
            marks[i][0]=40+r.nextInt(61); // physics
            marks[i][1]=40+r.nextInt(61); // chem
            marks[i][2]=40+r.nextInt(61); // math
        }
        return marks;
    }

    public static double[][] calculateResults(int[][] marks){
        double[][] res = new double[marks.length][3]; // total, avg, %
        for(int i=0;i<marks.length;i++){
            int total = marks[i][0]+marks[i][1]+marks[i][2];
            double avg = total/3.0;
            double perc = (total/300.0)*100;
            res[i][0]=total; res[i][1]=Math.round(avg*100.0)/100.0; res[i][2]=Math.round(perc*100.0)/100.0;
        }
        return res;
    }

    public static void run(){
        int n=5;
        int[][] marks = generateMarks(n);
        double[][] res = calculateResults(marks);
        System.out.println("Stu\tPhy\tChem\tMath\tTotal\tAvg\tPerc");
        for(int i=0;i<n;i++){
            System.out.printf("%d\t%d\t%d\t%d\t%.0f\t%.2f\t%.2f\n",i+1,marks[i][0],marks[i][1],marks[i][2],res[i][0],res[i][1],res[i][2]);
        }
    }
}
