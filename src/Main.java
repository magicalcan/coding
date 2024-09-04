import java.util.*;

public class Main {
    public static void main(String[] args){
        Camera tester = new Camera();
        List<Item> outputs = new ArrayList<>();
        // [2, 0.5), (7, 0.8), (10, 0.9), (11, 0.9), (16, 0.4)]
        outputs.add(new Item(2, 0.5));
        outputs.add(new Item(7, 0.8));
        outputs.add(new Item(10, 0.9));
        outputs.add(new Item(11, 0.9));
        outputs.add(new Item(16, 0.4));
        List<MotionPeriod> res = tester.motionPeriodsForCamera(outputs, 0.8);

        for(MotionPeriod mp : res) {
            System.out.println(mp.start + ", " + mp.end);
        }

        double[][][] rawData = {
            {{2, 0.5}, {7, 0.8}, {10, 0.9}, {11, 0.9}, {16, 0.4}},
            {{5, 0.8}, {8, 0.9}, {9, 0.8}, {13, 0.5}, {20, 0.5}},
            {{6, 0.1}, {7, 0.8}, {8, 0.9}, {17, 0.8}}
        };

        // Create list of Item objects
        List<List<Item>> itemList = new ArrayList<>();

        for (double[][] cameraData : rawData) {
            List<Item> cameraItems = new ArrayList<>();
            for (double[] itemData : cameraData) {
                Item item = new Item((int)itemData[0], itemData[1]);
                cameraItems.add(item);
            }
            itemList.add(cameraItems);
        }
        List<MotionPeriod> res2 = tester.motionPeriodsForAllCameras(itemList, 0.8);
        for(MotionPeriod mp : res2) {
            System.out.println(mp.start + ", " + mp.end);
        }

        double[][][] rawData2 = {
            {{2, 0.9}, {7, 0.9}, {10, 0.5}, {11, 0.9}, {14, 0.9}},
            {{5, 0.9}, {11, 0.9}},
            {{1, 0.8}, {8, 0.9}, {11, 0.9}, {21, 0.9}}
        };

        itemList = new ArrayList<>();

        for (double[][] cameraData : rawData2) {
            List<Item> cameraItems = new ArrayList<>();
            for (double[] itemData : cameraData) {
                Item item = new Item((int)itemData[0], itemData[1]);
                cameraItems.add(item);
            }
            itemList.add(cameraItems);
        }
        List<MotionPeriod> res3 = tester.motionPeriodsForAllCameras(itemList, 0.8);
        for(MotionPeriod mp : res3) {
            System.out.println(mp.start + ", " + mp.end);
        }
    }

}


