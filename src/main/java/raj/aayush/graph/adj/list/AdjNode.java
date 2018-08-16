package raj.aayush.graph.adj.list;
public class AdjNode {
		private int source;
		private int destination;
		private int cost;
		private AdjNode next;

		public AdjNode(int src, int dst, int cst) {
			source = src;
			destination = dst;
			cost = cst;
			next = null;
		}

		public AdjNode(int src, int dst) {
			this(src, dst, 1);
		}

		public int getSource() {
			return source;
		}

		public void setSource(int source) {
			this.source = source;
		}

		public int getDestination() {
			return destination;
		}

		public void setDestination(int destination) {
			this.destination = destination;
		}

		public int getCost() {
			return cost;
		}

		public void setCost(int cost) {
			this.cost = cost;
		}

		public AdjNode getNext() {
			return next;
		}

		public void setNext(AdjNode next) {
			this.next = next;
		}
	}
