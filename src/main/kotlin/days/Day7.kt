package days

import org.jgrapht.alg.shortestpath.DijkstraShortestPath
import org.jgrapht.graph.DefaultWeightedEdge
import org.jgrapht.graph.SimpleDirectedWeightedGraph

object Day7 : Day {
    override fun run() {
        val lines = Helpers.getInput(7)
        val graph = SimpleDirectedWeightedGraph<String, DefaultWeightedEdge>(DefaultWeightedEdge::class.java)

        lines.forEach { line ->
            val (vertex, _) = line.split(" bags contain ")
            graph.addVertex(vertex)
        }

        lines.forEach { line ->
            val (vertex, edgesUnrefined) = line.split(" bags contain ")
            edgesUnrefined.removeSuffix(".")
                .trim()
                .split(", ")
                .forEach { edge ->
                    if(edge != "no other bags") {
                        val (edgeValue, edgeName) = edge.removeSuffix(" bag").removeSuffix(" bags").split(" ", limit = 2)

                        val edg = graph.addEdge(vertex, edgeName)
                        graph.setEdgeWeight(edg,edgeValue.toDouble())
                    }
                }
        }

        val count = graph.vertexSet().filter { vertex ->
            vertex != "shiny gold" && DijkstraShortestPath.findPathBetween(graph, vertex, "shiny gold") != null
        }.size

        println(count)
        println(treeTraversal(graph, "shiny gold"))
    }


    private fun treeTraversal(graph: SimpleDirectedWeightedGraph<String, DefaultWeightedEdge>, bag: String) : Double {
        return graph.outgoingEdgesOf(bag).map { edge ->
            graph.getEdgeWeight(edge) + (graph.getEdgeWeight(edge) * treeTraversal(graph, graph.getEdgeTarget(edge)))
        }.sum()
    }
}