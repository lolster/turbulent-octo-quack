package huffmancoding;

import huffmancoding.HuffmanQueueNode;
import huffmancoding.HuffmanTreeNode;

public class HuffmanQueueNode {
	private HuffmanTreeNode node;
	private HuffmanQueueNode next;
	
	public HuffmanQueueNode(HuffmanTreeNode node, HuffmanQueueNode next) {
		this.node = node;
		this.next = next;
	}
	
	public HuffmanTreeNode getNode() {
		return node;
	}

	public void setNode(HuffmanTreeNode node) {
		this.node = node;
	}

	public HuffmanQueueNode getNext() {
		return next;
	}
	
	public void setNext(HuffmanQueueNode next) {
		this.next = next;
	}
}
