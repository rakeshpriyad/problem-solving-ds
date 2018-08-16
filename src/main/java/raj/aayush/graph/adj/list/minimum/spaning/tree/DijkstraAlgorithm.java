package raj.aayush.graph.adj.list.minimum.spaning.tree;

import java.util.Comparator;
import java.util.PriorityQueue;

import raj.aayush.graph.adj.list.AdjList;
import raj.aayush.graph.adj.list.AdjNode;
import raj.aayush.graph.adj.list.Graph;

public class DijkstraAlgorithm {
	public static void Dijkstra(Graph gph, int source) {
		
		;

		int[] previous = new int[gph.getCount()];
		int[] dist = new int[gph.getCount()];
		for (int i = 0; i < gph.getCount(); i++) {
			previous[i] = -1;
			dist[i] = Integer.MAX_VALUE; // infinite
		}
		dist[source] = 0;
		previous[source] = -1;
		AdjNodeComparator comp = new AdjNodeComparator();
		PriorityQueue<AdjNode> queue = new PriorityQueue<AdjNode>(100, comp);
		AdjNode node = new AdjNode(source, source, 0);
		queue.add(node);
		while (queue.isEmpty() != true) {
			node = queue.peek();
			queue.remove();
			AdjList adl = gph.getArray()[node.getDestination()];
			AdjNode adn = adl.getHead();
			while (adn != null) {
				int alt = adn.getCost() + dist[adn.getSource()];
				if (alt < dist[adn.getDestination()]) {
					dist[adn.getDestination()] = alt;
					previous[adn.getDestination()] = adn.getSource();
					node = new AdjNode(adn.getSource(), adn.getDestination(), alt);
					queue.add(node);
				}
				adn = adn.getNext();
			}
		}
		int count = gph.getCount();
		for (int i = 0; i < count; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				System.out.println(" node id " + i + " prev " + previous[i] + " distance : Unreachable");
			} else {
				System.out.println(" node id " + i + " prev " + previous[i] + " distance : " + dist[i]);
			}
		}
	}
}