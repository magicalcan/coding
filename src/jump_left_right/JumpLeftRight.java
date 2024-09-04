package jump_left_right;

public class JumpLeftRight {
    public int game(int[] a, int X, int S) {
        int n = a.length;
        boolean[][] visited = new boolean[n][2];
        // Arrays.fill(visited, false);

        int direction = 0;
        while (!visited[S][direction]) {
            visited[S][direction] = true;
            int nextIdx = -1;

            if (direction == 0) {
                for (int i = S - 1; i >= 0; i--) {
                    if (a[i] == a[S] + 1) {
                        nextIdx = i;
                        break;
                    }
                }
            } else {
                for (int i = S + 1; i < n; i++) {
                    if (a[i] == a[S] + 1) {
                        nextIdx = i;
                        break;
                    }
                }
            }

            if (nextIdx == -1) return S;

            a[S] += X;
            direction = 1 - direction;
            S = nextIdx;
        }

        return -1;
    }

}
