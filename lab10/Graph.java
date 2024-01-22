package lab10;

import java.util.*;

public class Graph<T> {
    private Map<T, Vertex<T>> vertices;
    private List<Edge<T>> edges;
    private Map<Vertex<T>, List<Edge<T>>> adjacencyList;
    private Map<Vertex<T>, Map<Vertex<T>, Edge<T>>> adjacencyMap;
    List<List<Edge<T>>> adjacencyMatrix;

    public Graph() {
        vertices = new HashMap<>();
        edges = new ArrayList<>();
        adjacencyList = new HashMap<>();
        adjacencyMap = new HashMap<>();
        adjacencyMatrix = new ArrayList<>();
    }

    // Public methods to access vertices and adjacencyMap
    public Map<T, Vertex<T>> getVertices() {
        return vertices;
    }

    public Map<Vertex<T>, Map<Vertex<T>, Edge<T>>> getAdjacencyMap() {
        return adjacencyMap;
    }

    public int numVertices() {
        return vertices.size();
    }

    public Iterable<Vertex<T>> vertices() {
        return vertices.values();
    }

    public int numEdges() {
        return edges.size();

    }

    public Iterable<Edge<T>> edges() {
        return edges;
    }

    public Edge<T> getEdge(Vertex<T> u, Vertex<T> v) {
        for (Edge<T> edge : adjacencyList.get(u)) {
            if (edge.v == v) {
                return edge;
            }
        }
        return null;
    }

    public Vertex<T>[] endVertices(Edge<T> e) {
        return new Vertex[] { e.u, e.v };
    }

    public Vertex<T> opposite(Vertex<T> v, Edge<T> e) {
        return v == e.u ? e.v : e.u;
    }

    public int outDegree(Vertex<T> v) {
        return adjacencyList.get(v).size();
    }

    public int inDegree(Vertex<T> v) {
        int count = 0;
        for (List<Edge<T>> vertexEdges : adjacencyList.values()) {
            for (Edge<T> edge : vertexEdges) {
                if (edge.v == v) {
                    count++;
                }
            }
        }
        return count;
    }

    public Iterable<Edge<T>> outGoingEdges(Vertex<T> v) {
        return adjacencyList.get(v);
    }

    public Iterable<Edge<T>> inComingEdges(Vertex<T> v) {
        List<Edge<T>> incomingEdges = new ArrayList<>();

        for (List<Edge<T>> vertexEdges : adjacencyList.values()) {
            for (Edge<T> edge : vertexEdges) {
                if (edge.v == v) {
                    incomingEdges.add(edge);
                }
            }
        }
        return incomingEdges;
    }

    public Vertex<T> insertVertex(T x) {
        Vertex<T> vertex = new Vertex<>(x);
        vertices.put(x, vertex);
        adjacencyList.put(vertex, new ArrayList<>());
        adjacencyMap.put(vertex, new HashMap<>());
        for (List<Edge<T>> row : adjacencyMatrix) {
            row.add(null);
        }
        List<Edge<T>> newRow = new ArrayList<>(Collections.nCopies(vertices.size(), null));
        adjacencyMatrix.add(newRow);
        return vertex;
    }

    public Edge<T> insertEdge(Vertex<T> u, Vertex<T> v, T edgeValue) {
        Edge<T> edge = new Edge<>(u, v, edgeValue);
        edges.add(edge);
        adjacencyList.get(u).add(edge);
        adjacencyMap.get(u).put(v, edge);
        // Corrected: Use vertices as keys directly
        int uIndex = getIndex(u);
        int vIndex = getIndex(v);
        adjacencyMatrix.get(uIndex).set(vIndex, edge);
        return edge;
    }

    // Helper method to get index from vertices map
    private int getIndex(Vertex<T> vertex) {
        int index = 0;
        for (Vertex<T> v : vertices.values()) {
            if (v == vertex) {
                return index;
            }
            index++;
        }
        return -1; // Vertex not found, handle accordingly

    }
}