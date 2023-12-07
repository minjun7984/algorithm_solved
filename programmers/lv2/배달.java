import java.util.*;
class Edge implements Comparable<Edge> {
    public int vex; //간선
    public int cost; //배달시간
    Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge ob) {
        return this.cost - ob.cost;
    }
}

class Solution {
    static ArrayList<ArrayList<Edge>> graph;
    static int[] dis;
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        graph = new ArrayList<ArrayList<Edge>>();
        dis = new int[N+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Edge>()); 
        }
    
        for(int i = 0; i < road.length; i++) {
            graph.get(road[i][0]).add(new Edge(road[i][1], road[i][2]));
            graph.get(road[i][1]).add(new Edge(road[i][0], road[i][2]));
        }
        
        pq.offer(new Edge(1, 0));
        dis[1] = 0;
        
        while(!pq.isEmpty()) { 
            Edge tmp = pq.poll();
            int now = tmp.vex;
            int nowCost = tmp.cost;
            
            if(nowCost > dis[now]) continue;
          
            for(Edge e : graph.get(now)) {
                if(dis[e.vex] > nowCost + e.cost) {
                    dis[e.vex] = nowCost + e.cost;
                    pq.offer(new Edge(e.vex, nowCost + e.cost));
                }
            }
        }
        for (int i = 1; i <= N; i++) {
            if(dis[i] <= K) answer++;
        }
        
        return answer;
    }
}
