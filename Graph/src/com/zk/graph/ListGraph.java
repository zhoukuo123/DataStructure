package com.zk.graph;

import java.util.*;

@SuppressWarnings("unchecked")
public class ListGraph<V, E> implements Graph<V, E> {
    private Map<V, Vertex<V, E>> vertices = new HashMap<>();

    @Override
    public int edgesSize() {
        return 0;
    }

    @Override
    public int verticesSize() {
        return vertices.size();
    }

    @Override
    public void addVertex(V v) {
        if (vertices.containsKey(v)) return;
        vertices.put(v, new Vertex<>(v));
    }

    @Override
    public void addEdge(V from, V to) {
        addEdge(from, to, null);
    }

    @Override
    public void addEdge(V from, V to, E weight) {
        Vertex<V, E> fromVertex = vertices.get(from);
        if (fromVertex == null) {
            fromVertex = new Vertex<>(from);
            vertices.put(from, fromVertex);
        }

        Vertex<V, E> toVertex = vertices.get(to);
        if (toVertex == null) {
            toVertex = new Vertex<>(to);
            vertices.put(to, toVertex);
        }

        Edge<V, E> edge = new Edge<>(fromVertex, toVertex);
        if (fromVertex.outEdges.contains(edge)) {

        }
    }

    @Override
    public void removeVertex(V v) {

    }

    @Override
    public void removeEdge(V from, V to) {

    }

    private static class Vertex<V, E> {
        V value;
        Set<Edge<V, E>> inEdges = new HashSet<>();
        Set<Edge<V, E>> outEdges = new HashSet<>();

        Vertex(V value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            Vertex<V, E> vertex = (Vertex<V, E>) o;
            return Objects.equals(value, vertex.value);
        }

        @Override
        public int hashCode() {
            return value == null ? 0 : value.hashCode();
        }
    }

    private static class Edge<V, E> {
        Vertex<V, E> form;
        Vertex<V, E> to;
        E weight;

        public Edge(Vertex<V, E> form, Vertex<V, E> to) {
            this.form = form;
            this.to = to;
        }

        public Edge(Vertex<V, E> form, Vertex<V, E> to, E weight) {
            this.form = form;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public boolean equals(Object o) {
            Edge<V, E> edge = (Edge<V, E>) o;
            return Objects.equals(form, edge.form) &&
                    Objects.equals(to, edge.to);
        }

        @Override
        public int hashCode() {
            return form.hashCode() * 31 + to.hashCode();
        }
    }
}
