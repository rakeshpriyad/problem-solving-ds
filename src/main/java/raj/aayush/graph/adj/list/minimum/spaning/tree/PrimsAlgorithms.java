package raj.aayush.graph.adj.list.minimum.spaning.tree;

import java.util.PriorityQueue;

import raj.aayush.graph.adj.list.AdjList;
import raj.aayush.graph.adj.list.AdjNode;
import raj.aayush.graph.adj.list.Graph;

public class PrimsAlgorithms {
	public static void Prims(Graph gph) {
		int[] previous = new int[gph.getCount()];
		int[] dist = new int[gph.getCount()];
		int source = 1;
		for (int i = 0; i < gph.getCount(); i++) {
			previous[i] = -1;
			dist[i] = Integer.MAX_VALUE;
		}
		dist[source] = 0;
		previous[source] = -1;
		AdjNodeComparator comp = new AdjNodeComparator();
		PriorityQueue<AdjNode> queue = new PriorityQueue<AdjNode>(comp);
		AdjNode node = new AdjNode(source, source, 0);
		queue.add(node);
		while (queue.isEmpty() != true) {
			node = queue.peek();
			queue.remove();
			if (dist[node.getDestination()] < node.getCost())
				continue;
			dist[node.getDestination()] = node.getCost();
			previous[node.getDestination()] = node.getSource();
			AdjList adl = gph.getArray()[node.getDestination()];
			AdjNode adn = adl.getHead();
			while (adn != null) {
				if (previous[adn.getDestination()] == -1) {
					node = new AdjNode(adn.getSource(), adn.getDestination(), adn.getCost());
					queue.add(node);
				}
				adn = adn.getNext();
			}
		}
		
		// Printing result.
		int count = gph.getCount();
		for (int i = 0; i < count; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				System.out.println(" node id " + i + " prev " + previous[i] + " distance : Unreachable");
			} else {
				System.out.println(" node id " + i + " prev " + previous[i] + " distance : " + dist[i]);
			}
		}
	}

	public static void main(String[] args) {
		Graph gph = new Graph(9);
		gph.AddBiEdge(0, 2, 1);
		gph.AddBiEdge(1, 2, 5);
		gph.AddBiEdge(1, 3, 7);
		gph.AddBiEdge(1, 4, 9);
		gph.AddBiEdge(3, 2, 2);
		gph.AddBiEdge(3, 5, 4);
		gph.AddBiEdge(4, 5, 6);
		gph.AddBiEdge(4, 6, 3);
		gph.AddBiEdge(5, 7, 5);
		gph.AddBiEdge(6, 7, 7);
		gph.AddBiEdge(7, 8, 17);
		// Dijkstra(gph,1);
		Prims(gph);
	}

}
