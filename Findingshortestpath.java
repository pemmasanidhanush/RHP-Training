import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        HashMap<Integer,ArrayList<int[]>> g = new HashMap<>();
        while(n-- > 0){
            int city,dest,dist;
            city= sc.nextInt();
            dest = sc.nextInt();
            dist = sc.nextInt();
            ArrayList <int[]> dc = new ArrayList<>();
            dc.add(new int[] {dest,dist});
            g.put(city,dc);
            }
            int start = sc.nextInt();
            int end = sc.nextInt();
            HashSet<Integer> visited=new HashSet<>();

        PriorityQueue<int[]> pq = new PriorityQueue<>
        ((x,y) ->{return x[1] - y[1];}); 
        pq.add(new int[]{start,0});
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int currCity = curr[0],currDist = curr[1];
            if(currCity == end){
                System.out.println(currDist);
                return;
            }
            if(visited.contains(currCity)) continue;
            visited.add(currCity);
            if(g.containsKey(currCity)){
                for(int[] x : g.get(currCity)){
                    pq.add(new int[]{x[0],x[1]+currDist});
                }
            }
                
        }
        System.out.println("City " + end + " cannot be reached from City " + start);
        
    }
     
        

    }
