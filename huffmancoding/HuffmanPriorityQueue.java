package huffmancoding;

import huffmancoding.HuffmanTreeNode;
import huffmancoding.HuffmanQueueNode;

public class HuffmanPriorityQueue {
	private HuffmanQueueNode head;
	private int size;
	
	public void queue(HuffmanTreeNode node) {
		if(head == null) {
			head = new HuffmanQueueNode(node, null);
		}
		else {
			HuffmanQueueNode current = head;
			HuffmanQueueNode previous = null;
			
			while(current != null && current.getNode().getCharacter().getFrequency() < node.getCharacter().getFrequency()) {
				previous = current;
				current = current.getNext();
			}
			
			if(previous == null) {
				head = new HuffmanQueueNode(node, head);
			}
			else if(current == null) {
				previous.setNext(new HuffmanQueueNode(node, null));
			}
			else {
				previous.setNext(new HuffmanQueueNode(node, current));
			}
		}
		size++;
	}
	
	public HuffmanTreeNode dequeue() {
		HuffmanTreeNode node = null;
		if(head != null) {
			node = head.getNode();
			head = head.getNext();
			size--;
		}
		return node;
	}
	
	public int getSize() {
		return size;
	}
}
