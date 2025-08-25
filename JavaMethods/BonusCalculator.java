import java.util.Random;

public class BonusCalculator {

    public static double[][] generateEmployees(int n){
        Random r = new Random();
        double[][] data = new double[n][2]; // salary, years
        for(int i=0;i<n;i++){
            data[i][0] = 10000 + r.nextInt(90000); // salary
            data[i][1] = r.nextInt(11); // years 0-10
        }
        return data;
    }

    public static double[][] calculateNew(double[][] old){
        double[][] res = new double[old.length][3]; // old, bonus, new
        for(int i=0;i<old.length;i++){
            double salary=old[i][0], years=old[i][1];
            double bonus = (years>5?0.05:0.02)*salary;
            double newSal = salary+bonus;
            res[i][0]=salary; res[i][1]=bonus; res[i][2]=newSal;
        }
        return res;
    }

    public static void run(){
        double[][] emp = generateEmployees(10);
        double[][] calc = calculateNew(emp);
        double sumOld=0,sumNew=0,sumBonus=0;
        System.out.println("Emp\tSalary\tYears\tBonus\tNewSalary");
        for(int i=0;i<emp.length;i++){
            System.out.printf("%d\t%.0f\t%.0f\t%.0f\t%.0f\n",i+1,emp[i][0],emp[i][1],calc[i][1],calc[i][2]);
            sumOld+=emp[i][0];
            sumNew+=calc[i][2];
            sumBonus+=calc[i][1];
        }
        System.out.println("Total Old="+sumOld+" New="+sumNew+" Bonus="+sumBonus);
    }
}
