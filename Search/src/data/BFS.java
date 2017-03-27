package data;

import java.util.*;

/**
 * Created by Ololo on 20.03.2017.
 */
public class BFS {

    static int BFS (Graph g, Graph.Vertex start, Graph.Vertex finish){
        List<Graph.Vertex> explored = new ArrayList<Graph.Vertex>();
        List<Graph.Vertex> way = new ArrayList<Graph.Vertex>();
        bfs(g,start,finish,explored);
        buildWay(g,start,finish,explored,way);
        for(int i=way.size()-1;i>=0;i--){
            System.out.println(way.get(i).getName());
        }
        return way.size()-1;
    }

    private static boolean bfs (Graph g, Graph.Vertex start, Graph.Vertex finish, List<Graph.Vertex> explored){
        Queue<Graph.Vertex> queue= new LinkedList<Graph.Vertex>();
        explored.clear();
        queue.add(start);
        explored.add(start);
        while (!queue.isEmpty()) {
            start = queue.poll();
            /*if (start.equals(finish)) {
                return true;
            }*/
            Set<Graph.Vertex> neighbors = g.getNeighbors(start);
            for (Graph.Vertex neighbor : neighbors) {
                if (explored.contains(neighbor)) {
                    continue;
                }
                if(neighbor.equals(finish)) {
                    return true;
                }
                queue.add(neighbor);
                explored.add(neighbor);
            }
        }
        return false;

    }

    private static boolean buildWay(Graph g,Graph.Vertex start, Graph.Vertex finish,List<Graph.Vertex> explored ,List<Graph.Vertex> way){
        Set<Graph.Vertex> neighbors;
        way.clear();
        way.add(finish);
        while(!explored.isEmpty()){
                neighbors = g.getNeighbors(way.get(way.size()-1));
                for (Graph.Vertex prevVertex:neighbors){
                    if(explored.contains(prevVertex)){
                        way.add(prevVertex);
                        explored.remove(prevVertex);
                        if (prevVertex.equals(start)){
                            return true;
                        }
                        break;
                    }
                }
        }
        return false;
    }

}


