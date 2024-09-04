import java.util.*;

class Item {
    int time;
    double intensity;

    public Item(int t, double i){
        time = t;
        intensity = i;
    }
};

class MotionPeriod {
    int start;
    int end;

    public MotionPeriod(){}

    public MotionPeriod(int s, int e){
        start = s;
        end = e;
    }
};

public class Camera {

    public List<MotionPeriod> motionPeriodsForCamera(List<Item> cameraOutput, double threshold) {
        List<MotionPeriod> res = new ArrayList<>();
        MotionPeriod mp = null;  
        for(Item i : cameraOutput){
            if (i.intensity >= threshold){
                if (mp == null){
                    mp = new MotionPeriod();
                    mp.start = i.time;
                }
                mp.end = i.time;
            } else {
                if (mp != null){
                    res.add(mp);
                    mp = null;
                }
            }
        }
        if (mp != null) res.add(mp);
        return res;
    }

    public List<MotionPeriod> motionPeriodsForAllCameras(List<List<Item>> cameraOutputs, double threshold) {
        List<List<MotionPeriod>> mpList = new ArrayList<>();
        for(List<Item> co : cameraOutputs) {
            mpList.add(motionPeriodsForCamera(co, threshold));
        }
        List<MotionPeriod> cur = mpList.get(0);
        for (int i=1; i<cameraOutputs.size(); i++){
            cur = findIntersect(cur, mpList.get(i));
        }
        return cur;
    }

    public List<MotionPeriod> findIntersect(List<MotionPeriod> a, List<MotionPeriod> b){
        List<MotionPeriod> res = new ArrayList<>();
        for(int i=0, j=0; i<a.size() && j < b.size();){
            int start = Math.max(a.get(i).start, b.get(j).start);
            int end = Math.min(a.get(i).end, b.get(j).end);
            if (start <= end) {
                res.add(new MotionPeriod(start, end));
            }
            if (a.get(i).end < b.get(j).end) {
                i++;
            } else {
                j++;
            }
        }
        return res;
    }

}

