package com.zk.graph;

public interface Graph<V, E> {
    int edgesSize(); // 边的个数

    int verticesSize(); // 顶点的个数

    void addVertex(V v); // 添加顶点

    void addEdge(V from, V to); // 添加边

    void addEdge(V from, V to, E weight); // 添加带有权值的边

    void removeVertex(V v); // 删除顶点

    void removeEdge(V from, V to); // 删除边

    void bfs(V begin);

    void dfs(V begin);
}
