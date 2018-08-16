package raj.aayush.graph.adj.list.shortest.path;

import java.util.LinkedList;
import java.util.Queue;

import raj.aayush.graph.adj.list.AdjNode;
import raj.aayush.graph.adj.list.Graph;

public class ShortestPathDemo {
	public void ShortestPath(Graph gph, int source)// unweighted graph
	{
	int curr;
	int count = gph.getCount();
	int[] distance= new int[count];
	int[] path= new int[count];
	Queue<Integer> que= new LinkedList<Integer>();
	for (int i = 0; i < count; i++)
	distance[i] = -1;
	que.add(source);
	distance[source]=0;
	while(que.isEmpty() == false)
	{
	curr=que.remove();
			AdjNode head = gph.getArray()[curr].getHead();
	while(head != null)
	{
	if(distance[head.getDestination()] == -1)
	{
	distance[head.getDestination()] = distance[curr] + 1;
	path[head.getDestination()]=curr;
	que.add(head.getDestination());
	}
	head = head.getNext();
	}
	}
	for(int i=0;i<count;i++)
	System.out.println(path[i] + " to " + i +" weight " + distance[i]);
	}
}

