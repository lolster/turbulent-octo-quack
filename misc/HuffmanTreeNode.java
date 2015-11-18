./*
	Interface:
		public HuffmanTreeNode(String character, int frequency, HuffmanTreeNode left, HuffmanTreeNode right)
		public void setLeft(HuffmanTreeNode left)
		public void setRight(HuffmanTreeNode right)
		public HuffmanTreeNode getLeft()
		public HuffmanTreeNode getRight()
		public String getCharacter()
		public int getFrequency()
*/

public class HuffmanTreeNode {
	private HuffmanCharacter character;
	private HuffmanTreeNode left;
	private HuffmanTreeNode right;

	public HuffmanTreeNode(String character, int frequency, HuffmanTreeNode left, HuffmanTreeNode right) {
		this.left = left;
		this.right = right;
		this.character = new HuffmanCharacter(character, frequency);
	}

	public void setLeft(HuffmanTreeNode left) {
		this.left = left;
	}

	public void setRight(HuffmanTreeNode right) {
		this.right = right;
	}

	public HuffmanTreeNode getLeft() {
		return this.left;
	}

	public HuffmanTreeNode getRight() {
		return this.right;
	}

	public String getCharacter() {
		return character.getCharacter();
	}

	public int getFrequency() {
		return character.getFrequency();
	}
}