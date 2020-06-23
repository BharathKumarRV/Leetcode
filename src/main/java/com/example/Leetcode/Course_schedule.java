package com.example.Leetcode;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;

public class Course_schedule {

	public static void main(String[] args) {
		SpringApplication.run(LeetcodeApplication.class, args);
		int[] nums= {4,1,2,1,2};
		int[][] prerequisites= {{1,0},{0,2}};
		boolean res = canFinish(3,prerequisites);
		System.out.println(res);

	}
	
	  public static boolean canFinish(int numCourses, int[][] prerequisites) {
          ArrayList[] graph = new ArrayList[numCourses];
          for(int i=0;i<numCourses;i++)
              graph[i] = new ArrayList();
              
          boolean[] visited = new boolean[numCourses];
          for(int i=0; i<prerequisites.length;i++){
              graph[prerequisites[i][1]].add(prerequisites[i][0]);
          }

          for(int i=0; i<numCourses; i++){
              if(!dfs(graph,visited,i))
                  return false;
          }
          return true;
      }

      private static boolean dfs(ArrayList[] graph, boolean[] visited, int course){
          if(visited[course])
              return false;
          else
              visited[course] = true;;

          for(int i=0; i<graph[course].size();i++){
              if(!dfs(graph,visited,(int)graph[course].get(i)))
                  return false;
          }
          visited[course] = false;
          return true;
      }
}
