package matrix_path;

import java.util.*;

public class MatrixPath {

    public String getPath(boolean[][] matrix, int start, int end){
        Queue<Integer> queue = new LinkedList<>();
        Queue<String> pathQueue = new LinkedList<>();
        queue.offer(start);
        pathQueue.offer("" + start);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            String curPath = pathQueue.poll();
            for (int i = 0; i<matrix[cur].length; i++){
                if (matrix[cur][i]) {
                    if (i==end) {
                        return curPath + "->"+ end;
                    } else {
                        queue.offer(i);
                        pathQueue.offer(curPath + "->"+ i);
                    }
                }
            }
        }
        return "";
    }

}
