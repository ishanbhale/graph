package com.practice.graph.adjacencylistrep;


public class GraphAdjacencyList {
	public static void main(String args[]) {
		Graph gph = new Graph(5);
		gph.addEdge(0, 1);
		gph.addEdge(0, 2);
		gph.addEdge(0, 3);
		gph.addEdge(1, 2);
		gph.addEdge(2, 4);
		gph.printGraph(gph);
	}
}	

// Create adjacency node
class AdjNode {
	int source;
	int destination;
	AdjNode next;

	public AdjNode(int source, int destination) {	
		this.source = source;
		this.destination = destination;
		next = null;
	}
}

class adjList {
	AdjNode head;
}

class Graph {
	int V;
	adjList array[];

	// constructor of graph, initialize the number of vertex in graph
	// and create those many adjacency lists and initialize all heads to null
	public Graph(int V) {
		this.V = V;
		array = new adjList[V];

		for (int i = 0; i < V; i++) {
			array[i] = new adjList();
			array[i].head = null;
		}
	}

	public void addEdge(int source, int destination) {
		// first create a forward edge source -> destination
		AdjNode adn = new AdjNode(source, destination);

		// add this node to the source adj List
		adn.next = array[source].head;
		array[source].head = adn;

		// now create a reverse edge since its a undirected graph
//		adn = new adjNode(source);
//		adn.next = array[destination].head;
//		array[destination].head = adn;
	}

	public void printGraph(Graph gph) {
		int vertex = gph.V;
		AdjNode ad;
		for (int i = 0; i < vertex; i++) {
			ad = gph.array[i].head;
			if(ad!=null){
				System.out.println("\nNodes connected to Vertex " + ad.source
						+ " are :");
				while (ad != null) {
					System.out.print("  " + ad.destination);
					ad = ad.next;
				}
			}
			
		}
	}
}																
