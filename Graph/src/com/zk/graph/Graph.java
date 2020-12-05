package com.zk.graph;

import java.util.List;
import java.util.Set;

public interface Graph<V, E> {
    int edgesSize(); // 边的个数

    int verticesSize(); // 顶点的个数

    void addVertex(V v); // 添加顶点

    void addEdge(V from, V to); // 添加边

    void addEdge(V from, V to, E weight); // 添加带有权值的边

    void removeVertex(V v); // 删除顶点

    void removeEdge(V from, V to); // 删除边

    void bfs(V begin, VertexVisitor<V> visitor);

    void dfs(V begin, VertexVisitor<V> visitor);

    Set<EdgeInfo<V, E>> mst();

    List<V> topologicalSort();

    interface VertexVisitor<V> {
        boolean visit(V v);
    }

    class EdgeInfo<V, E> {
        V form;
        V to;
        E weight;

        public EdgeInfo(V form, V to, E weight) {
            this.form = form;
            this.to = to;
            this.weight = weight;
        }
    }
}
