package matrix_path;

public class Main {
    public static void main(String[] args){
        boolean[][] matrix = {{false, false, true},{false, false, true},{false, true, true}};
        MatrixPath tester = new MatrixPath();
        System.out.println(tester.getPath(matrix, 0, 1));
    }
}
