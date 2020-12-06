package com.zk.graph;

import java.util.List;
import java.util.Set;

public abstract class Graph<V, E> {
    public abstract int edgesSize(); // 边的个数

    public abstract int verticesSize(); // 顶点的个数

    public abstract void addVertex(V v); // 添加顶点

    public abstract void addEdge(V from, V to); // 添加边

    public abstract void addEdge(V from, V to, E weight); // 添加带有权值的边

    public abstract void removeVertex(V v); // 删除顶点

    public abstract void removeEdge(V from, V to); // 删除边

    public abstract void bfs(V begin, VertexVisitor<V> visitor);

    public abstract void dfs(V begin, VertexVisitor<V> visitor);

    public abstract Set<EdgeInfo<V, E>> mst();

    public abstract List<V> topologicalSort();

    public interface weightManager {

    }

    public interface VertexVisitor<V> {
        boolean visit(V v);
    }

    public static class EdgeInfo<V, E> {
        private V form;
        private V to;
        private E weight;

        protected EdgeInfo(V form, V to, E weight) {
            this.form = form;
            this.to = to;
            this.weight = weight;
        }

        public V getForm() {
            return form;
        }

        public void setForm(V form) {
            this.form = form;
        }

        public V getTo() {
            return to;
        }

        public void setTo(V to) {
            this.to = to;
        }

        public E getWeight() {
            return weight;
        }

        public void setWeight(E weight) {
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "EdgeInfo{" +
                    "form=" + form +
                    ", to=" + to +
                    ", weight=" + weight +
                    '}';
        }
    }
}
