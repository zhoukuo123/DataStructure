package com.zk;

import com.zk.graph.Graph;
import com.zk.graph.ListGraph;

public class Main {
    public static void main(String[] args) {
        test();
    }

    static void test() {
        // 用有向图表示无向图(在两个顶点之间添加两条有方向的边)
        ListGraph<String, Integer> graph = new ListGraph<>();
//        graph.addEdge("V0", "V1");
//        graph.addEdge("V1", "V0");
//
//        graph.addEdge("V0", "V2");
//        graph.addEdge("V2", "V0");
//
//        graph.addEdge("V0", "V3");
//        graph.addEdge("V3", "V0");
//
//        graph.addEdge("V1", "V2");
//        graph.addEdge("V2", "V1");
//
//        graph.addEdge("V2", "V3");
//        graph.addEdge("V3", "V2");
//
//        graph.print();

        graph.addEdge("V1", "V0", 9);
        graph.addEdge("V1", "V2", 3);
        graph.addEdge("V2", "V0", 2);
        graph.addEdge("V2", "V3", 5);
        graph.addEdge("V3", "V4", 1);
        graph.addEdge("V0", "V4", 6);

        graph.bfs("V1");

////        graph.removeEdge("V0", "V4");
//        graph.removeVertex("V0");
//
//        graph.print();
    }

    /**
     * 有向图
     */
    private static Graph<Object, Double> directedGraph(Object[][] data) {
        Graph<Object, Double> graph = new ListGraph<>();
        for (Object[] edge : data) {
            if (edge.length == 1) {
                graph.addVertex(edge[0]);
            } else if (edge.length == 2) {
                graph.addEdge(edge[0], edge[1]);
            } else if (edge.length == 3) {
                double weight = Double.parseDouble(edge[2].toString());
                graph.addEdge(edge[0], edge[1], weight);
            }
        }
        return graph;
    }

    /**
     * 无向图
     */
    private static Graph<Object, Double> undirectedGraph(Object[][] data) {
        Graph<Object, Double> graph = new ListGraph<>();
        for (Object[] edge : data) {
            if (edge.length == 1) {
                graph.addVertex(edge[0]);
            } else if (edge.length == 2) {
                graph.addEdge(edge[0], edge[1]);
                graph.addEdge(edge[1], edge[0]);
            } else if (edge.length == 3) {
                double weight = Double.parseDouble(edge[2].toString());
                graph.addEdge(edge[0], edge[1], weight);
                graph.addEdge(edge[1], edge[0], weight);
            }
        }
        return graph;
    }
}
