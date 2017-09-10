package leetcode.medium.dfs;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.

 Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

 Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

 For example:

 2, [[1,0]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

 2, [[1,0],[0,1]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 */
public class CourseSchedule {
    int n;
    int[][] edges;
    boolean[] v;
    int count;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0) return true;
        n = numCourses;
        edges = new int[n][n];
        v = new boolean[n];
        for(int i = 0; i<prerequisites.length; i++) {
            edges[prerequisites[i][0]][prerequisites[i][1]] = 1;
        }
//        for(int i = 0; i<n; i++) {
//            for(int j = 0; j<n; j++) {
//                System.out.print(edges[i][j] + " ");
//            }
//            System.out.println();
//        }
        boolean ok = false;
        for(int i = 0; i<n; i++) {
            v = new boolean[n];
            count = 1;
            dfs(i);
//            System.out.println(count);
            if(count == n) {
                ok = true;
                break;
            }
        }
        return ok;
    }

    private void dfs(int start) {
//        System.out.println(start);
//        if(start == n - 1) return;
//        if(count == n) return;
        for(int i = 0; i<n; i++) {
            if(i != start && v[i] != true && edges[start][i] == 1) {
//                System.out.println("he");
                v[i] = true;
                count ++;
                dfs(i);
                v[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        CourseSchedule c = new CourseSchedule();
        int n = 3;
        int[][] p = {{1,0},{1,2}};
        System.out.print(c.canFinish(n, p));
    }
}
