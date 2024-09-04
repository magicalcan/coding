package transpose_square_matrix;

public class TransposeSquareMatrix {

    public int[][] transpose(int[][] matrix) {

        int n = matrix.length;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        return matrix;

    }

    public static void main(String[] args){
        int[][] test = {{1,2,3},
            {4,5,6},
            {7,8,9}};
        TransposeSquareMatrix tester = new TransposeSquareMatrix();
        int[][] res = tester.transpose(test);
        for(int[] row : res){
            for(int n : row){
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

}
