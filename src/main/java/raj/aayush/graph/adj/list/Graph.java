package raj.aayush.graph.adj.list;

import java.util.LinkedList;
import java.util.Stack;

public class Graph {
	
	

	private int count;
	private AdjList[] array;

	public Graph(int cnt) {
		count = cnt;
		array = new AdjList[cnt];
		for (int i = 0; i < cnt; i++) {
			array[i] = new AdjList();
			array[i].setHead(null);
		}
	}

	public void AddEdge(int source, int destination, int cost) {
		AdjNode node = new AdjNode(source, destination, cost);
		node.setNext(array[source].getHead());
		array[source].setHead(node);
	}

	public void AddEdge(int source, int destination) {
		AddEdge(source, destination, 1);
	}

	// bi directional edge
	public void AddBiEdge(int source, int destination, int cost) {
		AddEdge(source, destination, cost);
		AddEdge(destination, source, cost);
	}

	public void AddBiEdge(int source, int destination)// bi directional edge
	{
		AddBiEdge(source, destination, 1);
	}

	public void Print() {
		AdjNode ad;
		for (int i = 0; i < count; i++) {
			ad = array[i].getHead();
			if (ad != null) {
				System.out.print("Vertex " + i + " is connected to:");
				while (ad != null) {
					System.out.print(ad.getDestination() + " ");
					ad = ad.getNext();
				}
				System.out.println("");
			}
		}
	}

	public void dFSStack(Graph gph, int start) {
		int count = gph.count;
		int[] visited = new int[count];
		int curr;
		Stack<Integer> stk = new Stack<Integer>();
		for (int i = 0; i < count; i++)
			visited[i] = 0;
		visited[start] = 1;
		stk.push(start);
		while (stk.isEmpty() == false) {
			curr = stk.pop();
			AdjNode head = gph.array[curr].getHead();
			while (head != null) {
				if (visited[head.getDestination()] == 0) {
					visited[head.getDestination()] = 1;
					stk.push(head.getDestination());
				}
				head = head.getNext();
			}
		}
	}

	public static void dFSRec(Graph gph, int start, int[] visited) {
		AdjNode head = gph.array[start].getHead();
		while (head != null) {
			if (visited[head.getDestination()] == 0) {
				visited[head.getDestination()] = 1;
				dFSRec(gph, head.getDestination(), visited);
			}
			head = head.getNext();
		}
	}

	public void bFSQueue(Graph gph, int start, int[] visited) {
		int curr;
		LinkedList<Integer> que = new LinkedList<Integer>();
		visited[start] = 1;
		que.add(start);
		while (que.isEmpty() == false) {
			curr = que.remove();
			AdjNode head = gph.array[curr].getHead();
			while (head != null) {
				if (visited[head.getDestination()] == 0) {
					visited[head.getDestination()] = 1;
					que.add(head.getDestination());
				}
				head = head.getNext();
			}
		}
	}

	public static int PathExist(Graph gph, int source, int destination) {
		int count = gph.count;
		int[] visited = new int[count];
		for (int i = 0; i < count; i++)
			visited[i] = 0;
		visited[source] = 1;
		dFSRec(gph, source, visited);
		return visited[destination];
	}

	public boolean isConnected(Graph gph) {
		int count = gph.count;
		int[] visited = new int[count];
		for (int i = 0; i < count; i++)
			visited[i] = 0;
		visited[0] = 1;
		dFSRec(gph, 0, visited);
		for (int i = 0; i < count; i++)
			if (visited[i] == 0)
				return false;
		return true;
	}

	/**
	 * Topological Sort A topological sort is a method of ordering the nodes of a
	 * directed graph in which nodes represent activities and the edges represent
	 * dependency among those tasks. For topological sorting to work it is required
	 * that the graph should be a DAG which means it should not have any cycle. Just
	 * use DFS to get topological sorting.
	 * 
	 * @param gph
	 */
	public static void TopologicalSort(Graph gph) {
		Stack<Integer> stk = new Stack<Integer>();
		int count = gph.count;
		int[] visited = new int[count];
		for (int i = 0; i < count; i++)
			visited[i] = 0;
		for (int i = 0; i < count; i++) {
			if (visited[i] == 0) {
				visited[i] = 1;
				TopologicalSortDFS(gph, i, visited, stk);
			}
		}
		while (stk.isEmpty() != true)
			System.out.print(" " + stk.pop());
	}

	private static void TopologicalSortDFS(Graph gph, int index, int[] visited, Stack<Integer> stk) {
		AdjNode head = gph.array[index].getHead();
		while (head != null) {
			if (visited[head.getDestination()] == 0) {
				visited[head.getDestination()] = 1;
				TopologicalSortDFS(gph, head.getDestination(), visited, stk);
			}
			head = head.getNext();
		}
		stk.push(index);
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public AdjList[] getArray() {
		return array;
	}

	public void setArray(AdjList[] array) {
		this.array = array;
	}

}