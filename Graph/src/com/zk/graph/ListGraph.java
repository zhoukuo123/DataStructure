package com.zk.graph;

import com.zk.MinHeap;

import java.util.*;

@SuppressWarnings("unchecked")
public class ListGraph<V, E> extends Graph<V, E> {
    private Map<V, Vertex<V, E>> vertices = new HashMap<>(); // 保存所有的顶点
    private Set<Edge<V, E>> edges = new HashSet<>(); // 保存所有的边
    private Comparator<Edge<V, E>> edgeComparator = (Edge<V, E> e1, Edge<V, E> e2) -> {

        return 0;
    };

    public void print() {
        System.out.println("[顶点]-------------------------");
        vertices.forEach((V v, Vertex<V, E> vertex) -> {
            System.out.println(v);

            System.out.println("out----------------");
            System.out.println(vertex.outEdges);
            System.out.println("in-----------------");
            System.out.println(vertex.inEdges);
        });

        System.out.println("[边]-------------------------");
        edges.forEach((Edge<V, E> edge) -> {
            System.out.println(edge);
        });
    }

    @Override
    public int edgesSize() {
        return edges.size();
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

    /**
     * 添加边, 如果边的顶点不存在, 那就创建顶点, 然后再添加边
     */
    @Override
    public void addEdge(V from, V to, E weight) {
        // 判断边的顶点是否存在, 如果不存在则创建
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

        // 判断边是否存在, 如果存在则删除边, 然后添加具有新权值的边
        Edge<V, E> edge = new Edge<>(fromVertex, toVertex);
        edge.weight = weight;

        if (fromVertex.outEdges.remove(edge)) {
            toVertex.inEdges.remove(edge);
            edges.remove(edge);
        }

        fromVertex.outEdges.add(edge);
        toVertex.inEdges.add(edge);
        edges.add(edge);
    }

    @Override
    public void removeEdge(V from, V to) {
        // 判断顶点是否存在
        Vertex<V, E> fromVertex = vertices.get(from);
        if (fromVertex == null) return;

        Vertex<V, E> toVertex = vertices.get(to);
        if (toVertex == null) return;

        // 判断顶点之间的边是否存在, 如果存在则删除边
        Edge<V, E> edge = new Edge<>(fromVertex, toVertex);
        if (fromVertex.outEdges.remove(edge)) {
            toVertex.inEdges.remove(edge);
            edges.remove(edge);
        }
    }

    @Override
    public void removeVertex(V v) {
        Vertex<V, E> vertex = vertices.remove(v);
        if (vertex == null) return;

        for (Iterator<Edge<V, E>> iterator = vertex.outEdges.iterator(); iterator.hasNext(); ) {
            Edge<V, E> edge = iterator.next();
            edge.to.inEdges.remove(edge);
            // 将当前遍历到的元素edge从集合vertex.outEdges中删掉
            iterator.remove();
            edges.remove(edge);
        }

        for (Iterator<Edge<V, E>> iterator = vertex.inEdges.iterator(); iterator.hasNext(); ) {
            Edge<V, E> edge = iterator.next();
            edge.form.outEdges.remove(edge);
            // 将当前遍历到的元素edge从集合vertex.inEdges中删掉
            iterator.remove();
            edges.remove(edge);
        }
    }

    @Override
    public void bfs(V begin, VertexVisitor<V> visitor) {
        if (visitor == null) return;
        Vertex<V, E> beginVertex = vertices.get(begin);
        if (beginVertex == null) return;

        Set<Vertex<V, E>> visitedVertices = new HashSet<>();
        Queue<Vertex<V, E>> queue = new LinkedList<>();
        queue.offer(beginVertex);
        visitedVertices.add(beginVertex);

        while (!queue.isEmpty()) {
            Vertex<V, E> vertex = queue.poll();
            if (visitor.visit(vertex.value)) return;

            for (Edge<V, E> edge : vertex.outEdges) {
                if (visitedVertices.contains(edge.to)) continue;
                queue.offer(edge.to);
                visitedVertices.add(edge.to);
            }
        }
    }

    @Override
    public void dfs(V begin, VertexVisitor<V> visitor) {
        if (visitor == null) return;
        Vertex<V, E> beginVertex = vertices.get(begin);
        if (beginVertex == null) return;

        Set<Vertex<V, E>> visitedVertices = new HashSet<>();
        Stack<Vertex<V, E>> stack = new Stack<>();

        // 先访问起点
        stack.push(beginVertex);
        visitedVertices.add(beginVertex);
        if (visitor.visit(begin)) return;

        while (!stack.isEmpty()) {
            Vertex<V, E> vertex = stack.pop();

            for (Edge<V, E> edge : vertex.outEdges) {
                if (visitedVertices.contains(edge.to)) continue;

                stack.push(edge.form);
                stack.push(edge.to);

                visitedVertices.add(edge.to);
                if (visitor.visit(edge.to.value)) return;

                break;
            }
        }
    }

    @Override
    public List<V> topologicalSort() {
        List<V> list = new ArrayList<>();
        Queue<Vertex<V, E>> queue = new LinkedList<>();
        Map<Vertex<V, E>, Integer> ins = new HashMap<>();

        // 初始化(将度为0的节点都放入队列)
        vertices.forEach((V v, Vertex<V, E> vertex) -> {
            int in = vertex.inEdges.size();
            if (in == 0) {
                queue.offer(vertex);
            } else {
                ins.put(vertex, in);
            }
        });

        while (!queue.isEmpty()) {
            Vertex<V, E> vertex = queue.poll();
            // 放入返回结果中
            list.add(vertex.value);

            for (Edge<V, E> edge : vertex.outEdges) {
                int toIn = ins.get(edge.to) - 1;
                if (toIn == 0) {
                    queue.offer(edge.to);
                } else {
                    ins.put(edge.to, toIn);
                }
            }
        }

        return list;
    }

    @Override
    public Set<EdgeInfo<V, E>> mst() {
        return prim();
    }

    private Set<EdgeInfo<V, E>> prim() {
        Iterator<Vertex<V, E>> it = vertices.values().iterator();
        if (!it.hasNext()) return null;

        Set<EdgeInfo<V, E>> edgeInfos = new HashSet<>();
        Set<Vertex<V, E>> addedVertices = new HashSet<>();

        Vertex<V, E> vertex = it.next();
        addedVertices.add(vertex);
        MinHeap<Edge<V, E>> heap = new MinHeap<>(vertex.outEdges, edgeComparator);

        int edgeSize = vertices.size() - 1;
        while (!heap.isEmpty() && edgeInfos.size() < edgeSize) {
            Edge<V, E> edge = heap.remove();
            if (addedVertices.contains(edge.to)) continue;

            edgeInfos.add(edge.info());
            addedVertices.add(edge.to);
            heap.addAll(edge.to.outEdges);
        }

        return edgeInfos;
    }

    private Set<EdgeInfo<V, E>> kruskal() {
        return null;
    }

//    @Override
//    public void bfs(V begin) {
//        Vertex<V, E> beginVertex = vertices.get(begin);
//        if (beginVertex == null) return;
//
//        Set<Vertex<V, E>> visitedVertices = new HashSet<>();
//        Queue<Vertex<V, E>> queue = new LinkedList<>();
//        queue.offer(beginVertex);
//        visitedVertices.add(beginVertex);
//
//        while (!queue.isEmpty()) {
//            Vertex<V, E> vertex = queue.poll();
//            System.out.println(vertex.value);
//
//            for (Edge<V, E> edge : vertex.outEdges) {
//                if (visitedVertices.contains(edge.to)) continue;
//                queue.offer(edge.to);
//                visitedVertices.add(edge.to);
//            }
//        }
//    }
//
//    @Override
//    public void dfs(V begin) {
//        Vertex<V, E> beginVertex = vertices.get(begin);
//        if (beginVertex == null) return;
//
//        Set<Vertex<V, E>> visitedVertices = new HashSet<>();
//        Stack<Vertex<V, E>> stack = new Stack<>();
//
//        // 先访问起点
//        stack.push(beginVertex);
//        visitedVertices.add(beginVertex);
//        System.out.println(beginVertex.value);
//
//        while (!stack.isEmpty()) {
//            Vertex<V, E> vertex = stack.pop();
//
//            for (Edge<V, E> edge : vertex.outEdges) {
//                if (visitedVertices.contains(edge.to)) continue;
//
//                stack.push(edge.form);
//                stack.push(edge.to);
//
//                visitedVertices.add(edge.to);
//                System.out.println(edge.to.value);
//
//                break;
//            }
//        }
//    }

//    public void dfs2(V begin) {
//        Vertex<V, E> beginVertex = vertices.get(begin);
//        if (beginVertex == null) return;
//
//        dfs2(beginVertex, new HashSet<>());
//    }
//
//    private void dfs2(Vertex<V, E> vertex, Set<Vertex<V, E>> visitedVertices) {
//        System.out.println(vertex.value);
//        visitedVertices.add(vertex);
//
//        for (Edge<V, E> edge : vertex.outEdges) {
//            if (visitedVertices.contains(edge.to)) continue;
//
//            dfs2(edge.to, visitedVertices);
//        }
//    }

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

        @Override
        public String toString() {
            return "Vertex{" +
                    "value=" + value +
                    '}';
        }
    }

    private static class Edge<V, E> {
        Vertex<V, E> form;
        Vertex<V, E> to;
        E weight;

        Edge(Vertex<V, E> form, Vertex<V, E> to) {
            this.form = form;
            this.to = to;
        }

        EdgeInfo<V, E> info() {
            return new EdgeInfo<>(form.value, to.value, weight);
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

        @Override
        public String toString() {
            return "Edge{" +
                    "form=" + form +
                    ", to=" + to +
                    ", weight=" + weight +
                    '}';
        }
    }
}
