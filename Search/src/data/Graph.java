package data;

import java.util.Set;

/**
 * Created by Ololo on 20.03.2017.
 */
public interface Graph {

    interface Vertex {

        String getName();
    }

    Set<Vertex> getVertices();
    Set<Vertex> getNeighbors(Vertex v);

}
