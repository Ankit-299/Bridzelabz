public class MatrixAdvancedOps {

    public static int[][] transpose(int[][] A){
        int r=A.length,c=A[0].length;
        int[][] T=new int[c][r];
        for(int i=0;i<r;i++) for(int j=0;j<c;j++) T[j][i]=A[i][j];
        return T;
    }

    public static int det2x2(int[][] M){
        return M[0][0]*M[1][1]-M[0][1]*M[1][0];
    }

    public static int det3x3(int[][] M){
        int a=M[0][0]*(M[1][1]*M[2][2]-M[1][2]*M[2][1]);
        int b=M[0][1]*(M[1][0]*M[2][2]-M[1][2]*M[2][0]);
        int c=M[0][2]*(M[1][0]*M[2][1]-M[1][1]*M[2][0]);
        return a-b+c;
    }

    public static double[][] inverse2x2(int[][] M){
        double det=det2x2(M);
        if(det==0) return null;
        double[][] inv={{M[1][1]/det, -M[0][1]/det},{-M[1][0]/det,M[0][0]/det}};
        return inv;
    }

    public static void printMatrix(double[][] M){
        for(double[] row:M){
            for(double v:row) System.out.printf("%.2f ",v);
            System.out.println();
        }
    }

    public static void printMatrix(int[][] M){
        for(int[] row:M){
            for(int v:row) System.out.print(v+" ");
            System.out.println();
        }
    }

    public static void run(){
        int[][] A={{1,2},{3,4}};
        int[][] B={{2,0,1},{3,0,0},{5,1,1}};
        System.out.println("Matrix A (2x2):"); printMatrix(A);
        System.out.println("Transpose:"); printMatrix(transpose(A));
        System.out.println("Determinant 2x2: "+det2x2(A));
        System.out.println("Inverse 2x2:");
        printMatrix(inverse2x2(A));

        System.out.println("Matrix B (3x3):"); printMatrix(B);
        System.out.println("Determinant 3x3: "+det3x3(B));
    }
}
