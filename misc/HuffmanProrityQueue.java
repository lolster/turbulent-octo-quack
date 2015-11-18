public class HuffmanPriorityQueue {
	private HuffmanCharacter[] huffmanHeap;
	private int count;

	public HuffmanPriorityQueue(HuffmanCharacter[] huffmanHeap) {
		this.huffmanHeap = huffmanHeap;
		count = this.huffmanHeap.length;
		createHeap();
	}

	public void createHeap() {
		//int i, j ,k;
		for(int k = 1; k < count; k++) {
			int i = k;
			int key = huffmanHeap[i].getFrequency();
			j = (i-1)/2; //parent of i;
			while(i > 0; key > huffmanHeap[j].getFrequency()) {
				huffmanHeap[i] = huffmanHeap[j];
				i = j;
				j = (i-1)/2;
			}
			huffmanHeap[i] = key;
		}
	}

	public HuffmanCharacter remove() {
		HuffmanCharacter res = huffmanHeap[0];
		huffmanHeap[0] = huffmanHeap[--count];
		adjustHeap();
		return res;
	}

	public int adjustHeap() {
		int j = 0;
		int key = huffmanHeap[j].getFrequency());
		HuffmanCharacter keyActual = huffmanHeap[j];
		int i = j * 2 + 1;
		while(i < count) {
			if((i+1) < count) {
				if(huffmanHeap[i].getFrequency() > huffmanHeap[i+1].getFrequency())
					i++;
			}
			if(key > huffmanHeap[i].getFrequency()) {
				huffmanHeap[j] = huffmanHeap[i];
				j = i; //shift parent down
				i = j*2 + 1;
			}
			else {
				break;
			}
		}
		huffmanHeap[j] = keyActual;
	}

	public void insert(HuffmanCharacter value) {
		huffmanHeap[count++] = value;
		int i = count - 1;
		int j = (i-1)/2;
		while(i > 0 && value.getFrequency() < huffmanHeap[j].getFrequency()) {
			huffmanHeap[i] = huffmanHeap[j];
			i = j;
			j = (i-1)/2;
		}
		huffmanHeap[i] = value;
	}

	public int getSize() {
		return count;
	}
}