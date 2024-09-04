package jump_left_right;

public class Main {

    public static void main(String[] args) {

        int[] A = { 3, 4, 2, 2, 7 };
        int X = 4;
        int S = 2;
        JumpLeftRight tester = new JumpLeftRight();
        System.out.println(tester.game(A, X, S));

        int[] A2 = { 2, 1 };
        X = 2;
        S = 1;
        System.out.println(tester.game(A2, X, S));

        int[] A3 = { 2, 6, 1, 5, 3 };
        X = 3;
        S = 2;
        System.out.println(tester.game(A3, X, S));
    }

}
