import java.util.Random;

public class MatrixBasicOps {

    public static int[][] createMatrix(int r,int c){
        Random rand=new Random();
        int[][] m=new int[r][c];
        for(int i=0;i<r;i++) for(int j=0;j<c;j++) m[i][j]=rand.nextInt(10);
        return m;
    }

    public static int[][] add(int[][] A,int[][] B){
        int r=A.length,c=A[0].length;
        int[][] res=new int[r][c];
        for(int i=0;i<r;i++) for(int j=0;j<c;j++) res[i][j]=A[i][j]+B[i][j];
        return res;
    }

    public static int[][] subtract(int[][] A,int[][] B){
        int r=A.length,c=A[0].length;
        int[][] res=new int[r][c];
        for(int i=0;i<r;i++) for(int j=0;j<c;j++) res[i][j]=A[i][j]-B[i][j];
        return res;
    }

    public static int[][] multiply(int[][] A,int[][] B){
        int r=A.length, c=B[0].length;
        int[][] res=new int[r][c];
        for(int i=0;i<A.length;i++)
            for(int j=0;j<B[0].length;j++)
                for(int k=0;k<A[0].length;k++)
                    res[i][j]+=A[i][k]*B[k][j];
        return res;
    }

    public static void printMatrix(int[][] M){
        for(int[] row:M){
            for(int val:row) System.out.print(val+" ")
