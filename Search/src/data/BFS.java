package data;

import java.util.*;

/**
 * Created by Ololo on 20.03.2017.
 */
public class BFS {

    static int BFS (Graph g, Graph.Vertex start, Graph.Vertex finish){
        Map<Graph.Vertex,Graph.Vertex> explored = new HashMap<Graph.Vertex,Graph.Vertex>();
        List<Graph.Vertex> way = new ArrayList<Graph.Vertex>();
        bfs(g,start,finish,explored);
        buildWay(g,start,finish,explored,way);
        for(int i=way.size()-1;i>=0;i--){
            System.out.println(way.get(i).getName());
        }
        return way.size()-1;
    }

    private static boolean bfs (Graph g, Graph.Vertex start, Graph.Vertex finish, Map<Graph.Vertex,Graph.Vertex> explored){
        Queue<Graph.Vertex> queue= new LinkedList<Graph.Vertex>();
        explored.clear();
        queue.add(start);
        explored.put(start,null);
        while (!queue.isEmpty()) {
            start = queue.poll();
            Set<Graph.Vertex> neighbors = g.getNeighbors(start);
            for (Graph.Vertex neighbor : neighbors) {
                if (explored.keySet().contains(neighbor)) {
                    continue;
                }
                queue.add(neighbor);
                explored.put(neighbor,start);
                if(neighbor.equals(finish)) {
                    return true;
                }
            }
        }
        return false;

    }

    private static boolean buildWay(Graph g,Graph.Vertex start, Graph.Vertex finish,Map<Graph.Vertex,Graph.Vertex> explored ,List<Graph.Vertex> way){
        way.clear();
        way.add(finish);
        while(!explored.isEmpty()){
                for (Graph.Vertex prevVertex:explored.keySet()){
                    if(prevVertex.equals(way.get(way.size()-1))){
                        way.add(explored.get(prevVertex));
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


