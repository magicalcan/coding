package k_way_merge_file;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


class Node {
    String filename;
    int val;

    public Node(String fn, int v){
        filename = fn;
        val = v;
    }
}

public class KWayMergeFile {
    public void mergeFile(String[] filenames){

        Map<String, Scanner> fileMap = new HashMap<>();
        PriorityQueue<Node> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(String file : filenames){
            try{
                File f = new File(file);
                Scanner fReader = new Scanner(f);
                fileMap.put(file, fReader);
                if (fReader.hasNextLine()) {
                    String line = fReader.nextLine();
                    int v = Integer.parseInt(line);
                    heap.offer(new Node(file, v));
                }
            } catch (FileNotFoundException e){
                System.out.println("FileNotFoundException");
                e.printStackTrace();
            }
        }
        try {
            FileWriter fw = new FileWriter("src/k_way_merge_file/output.txt");
            while(!heap.isEmpty()){
                Node n = heap.poll();
                fw.write("" + n.val + "\n");
                Scanner fr = fileMap.get(n.filename);
                if (fr != null){
                    if (fr.hasNextLine()){
                        // System.out.println("Create new node");
                        String line = fr.nextLine();
                        int v = Integer.parseInt(line);
                        heap.offer(new Node(n.filename, v));
                    } else {
                        fr.close();
                    }
                }
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }

    public static void main(String[] args){
        KWayMergeFile tester = new KWayMergeFile();
        tester.mergeFile(new String[]{"src/k_way_merge_file/1.txt","src/k_way_merge_file/2.txt","src/k_way_merge_file/3.txt"});
    }
}
