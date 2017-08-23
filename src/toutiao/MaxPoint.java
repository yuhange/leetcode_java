package toutiao;

import java.util.*;

/**
 * Created by lenovo on 2017/8/22.
 */
public class MaxPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Point[] ps = new Point[n];
        for(int i = 0; i<n; i++) {
            ps[i] = new Point(scanner.nextInt(), scanner.nextInt());
        }
        ArrayList<Point> list = new ArrayList<Point>();
        for(int i = 0; i<n; i++) {
            Point p = ps[i];
            boolean isMax = true;
            for(int j = i + 1; j<n; j++) {
                if(ps[j].x >= p.x && ps[j].y >= p.y) {
                    isMax = false;
                    break;
                }
            }
            if(isMax) list.add(p);
        }

        Point[] res = new Point[list.size()];
        for(int i = 0; i<list.size(); i++) res[i] = list.get(i);
        Arrays.sort(res, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.x > o2.x ? 1 : 0;
            }
        });
        for(Point x: res) {
            System.out.println(x.x+" "+x.y);
        }

    }
}

class Point {
    public int x;
    public int y;
    public Point(int x, int y){this.x = x; this.y = y;}
}
