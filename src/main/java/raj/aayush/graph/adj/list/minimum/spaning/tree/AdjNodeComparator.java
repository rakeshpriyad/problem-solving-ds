package raj.aayush.graph.adj.list.minimum.spaning.tree;

import java.util.Comparator;

import raj.aayush.graph.adj.list.AdjNode;

class AdjNodeComparator implements Comparator<AdjNode> {
	public int compare(AdjNode x, AdjNode y) {
		if (x.getCost() < y.getCost())
			return -1;
		if (x.getCost() > y.getCost())
			return 1;
		return 0;
	}
}