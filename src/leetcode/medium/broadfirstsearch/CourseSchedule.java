package leetcode.medium.broadfirstsearch;

import java.util.LinkedList;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.

 Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

 Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

 For example:

 2, [[1,0]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

 2, [[1,0],[0,1]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

 Note:
 The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 You may assume that there are no duplicate edges in the input prerequisites.
 */
public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null) return false; // 边界条件
        int len = prerequisites.length;
        if(numCourses <= 0 || len == 0) return true; // 边界条件

        // 记录每个课程的前导课程个数
        int[] preCourseNum = new int[numCourses];
        for(int i = 0; i<len; i++) {
            preCourseNum[prerequisites[i][0]] ++;
        }

        // 用队列记录可以直接上的课程（没有前导课程的课程）
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i<numCourses; i++) {
            if(preCourseNum[i] == 0) {
                queue.offer(i);
            }
        }

        // 拓扑排序
        int numNoPre = queue.size();
        while(!queue.isEmpty()) {
            int course = queue.poll();
            for(int i = 0; i<len; i++) {
                // 如果该课程是某门课程的前导课程
                if(prerequisites[i][1] == course) {
                    preCourseNum[prerequisites[i][0]] --;
                    if(preCourseNum[prerequisites[i][0]] == 0) {
                        numNoPre ++;
                        queue.offer(prerequisites[i][0]);
                    }
                }
            }
        }

        return numNoPre == numCourses;
    }
}