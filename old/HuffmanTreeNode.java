public class HuffmanTreeNode {
	private HuffmanCharacter character;
	private HuffmanTreeNode left;
	private HuffmanTreeNode right;
	
	public HuffmanTreeNode(HuffmanCharacter character, HuffmanTreeNode left,
			HuffmanTreeNode right) {
		this.character = character;
		this.left = left;
		this.right = right;
	}

	public HuffmanCharacter getCharacter() {
		return character;
	}

	public HuffmanTreeNode getLeft() {
		return left;
	}

	public HuffmanTreeNode getRight() {
		return right;
	}

	public void setCharacter(HuffmanCharacter character) {
		this.character = character;
	}

	public void setLeft(HuffmanTreeNode left) {
		this.left = left;
	}

	public void setRight(HuffmanTreeNode right) {
		this.right = right;
	}
	
}
