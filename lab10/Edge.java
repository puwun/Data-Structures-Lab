package lab10;

public class Edge<T> {
    Vertex<T> u, v;
    T key;

    Edge(Vertex<T> u, Vertex<T> v, T key) {
        this.u = u;
        this.v = v;
        this.key = key;
    }

}