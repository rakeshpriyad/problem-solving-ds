package raj.aayush.graph.adj.list.shortest.path;

import raj.aayush.graph.adj.list.AdjNode;
import raj.aayush.graph.adj.list.Graph;

public class BellmanFordShortestPathDemo {
	public void BellmanFordShortestPath(Graph gph, int source) {
		int count = gph.getCount();
		int[] distance = new int[count];
		int[] path = new int[count];
		for (int i = 0; i < count; i++)
			distance[i] = Integer.MAX_VALUE;
		distance[source] = 0;
		for (int i = 0; i < count - 1; i++) {
			for (int j = 0; j < count; j++) {
				AdjNode head = gph.getArray()[j].getHead();
				while (head != null) {
					int newDistance = distance[j] + head.getCost();
					if (distance[head.getDestination()] > newDistance) {
						distance[head.getDestination()] = newDistance;
						path[head.getDestination()] = j;
					}
					head = head.getNext();
				}
			}
		}
		for (int i = 0; i < count; i++)
			System.out.println(path[i] + " to " + i + " weight " + distance[i]);
	}

}
