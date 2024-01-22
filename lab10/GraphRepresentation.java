package lab10;

import java.util.Scanner;

public class GraphRepresentation {
    public static void main(String[] args) {
        Graph<String> graph = new Graph<>();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("1. Insert Vertex");
                System.out.println("2. Insert Edge");
                System.out.println("3. Display Edge List");
                System.out.println("4. Display Adjacency List");
                System.out.println("5. Display Adjacency Map");
                System.out.println("6. Display Adjacency Matrix");

                System.out.println("7. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Enter the vertex value: ");
                        String vertexValue = scanner.next();
                        graph.insertVertex(vertexValue);
                        System.out.println("Vertex inserted successfully!");
                        break;
                    case 2:
                        System.out.print("Enter the source vertex value: ");
                        String sourceValue = scanner.next();
                        System.out.print("Enter the destination vertex value: ");
                        String destValue = scanner.next();
                        System.out.print("Enter the edge value: ");
                        String edgeValue = scanner.next();
                        Vertex<String> sourceVertex = graph.getVertices().get(sourceValue);
                        Vertex<String> destVertex = graph.getVertices().get(destValue);
                        if (sourceVertex != null && destVertex != null) {
                            graph.insertEdge(sourceVertex, destVertex, edgeValue);
                            System.out.println("Edge inserted successfully!");
                        } else {
                            System.out.println("Invalid vertices. Please insert vertices first.");
                        }
                        break;
                    case 3:
                        System.out.println();
                        System.out.println("Edge List:");
                        System.out.println();
                        for (Edge<String> edge : graph.edges()) {
                            System.out.println(edge.u.key + " -> " + edge.v.key + ": " +
                                    edge.key);
                        }
                        System.out.println();
                        break;
                    case 4:
                        System.out.println();
                        System.out.println("Adjacency List:");
                        System.out.println();
                        for (Vertex<String> vertex : graph.vertices()) {
                            System.out.print(vertex.key + ": ");
                            for (Edge<String> edge : graph.outGoingEdges(vertex)) {
                                System.out.print(edge.v.key + "(" + edge.key + ") ");
                            }

                            System.out.println();
                        }
                        System.out.println();
                        break;
                    case 5:
                        System.out.println();
                        System.out.println("Adjacency Map:");
                        System.out.println();
                        for (Vertex<String> vertex : graph.getVertices().values()) {
                            System.out.print(vertex.key + ": ");
                            for (Vertex<String> adjacentVertex : graph.getAdjacencyMap().get(vertex).keySet()) {

                                Edge<String> edge = graph.getAdjacencyMap().get(vertex).get(adjacentVertex);
                                System.out.print(adjacentVertex.key + "(" + edge.key + ") ");
                            }
                            System.out.println();
                        }
                        break;
                    case 6:
                        System.out.println();
                        System.out.println("Adjacency Matrix:");
                        System.out.println();
                        for (int i = 0; i < graph.numVertices(); i++) {
                            for (int j = 0; j < graph.numVertices(); j++) {
                                Edge<String> edge = graph.adjacencyMatrix.get(i).get(j);
                                if (edge != null) {
                                    System.out.print(edge.key + " ");
                                } else {
                                    System.out.print("0 ");
                                }
                            }
                            System.out.println();
                        }
                        System.out.println();
                        break;
                    case 7:
                        System.out.println("Exiting...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }
        }

    }
}