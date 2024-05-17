

public class BlockIntList {
	private static final int MAX_BLOCKS = 50;
	private static final int FIRST_BLOCK_SIZE = 2;

	private int[][] blocks;
	private int lastBlock;
	private int elemsInLast;
	private int size;

	public BlockIntList() {
		blocks = new int[MAX_BLOCKS][];
		blocks[0] = new int[FIRST_BLOCK_SIZE];
		lastBlock = elemsInLast = size = 0;
	}

	public void add(int value) {
		ensureSpaceAdd();
		blocks[lastBlock][elemsInLast] = value;
		elemsInLast++;
		size++;
	}

	private void ensureSpaceAdd() {
		if (elemsInLast == blocks[lastBlock].length) {
			// add a new block
			int newSize = 2 * blocks[lastBlock].length;
			lastBlock++;
			blocks[lastBlock] = new int[newSize];
			elemsInLast = 0;
		}
	}

	public int size() {
		return size;
	}

	public String toString() {
		String result = "";
		for (int b = 0; b < lastBlock; b++) {
			for (int i = 0; i < blocks[b].length; i++) {
				result += blocks[b][i] + ", ";
			}
		}
		for (int i = 0; i < elemsInLast; i++) {
			result += blocks[lastBlock][i] + ", ";
		}
		if (!result.isEmpty()) {
			result = result.substring(0, result.length()-2);
		}
		return "[" + result + "]";
	}

	public int get(int index) {
		  if (index >= this.size || index < 0) throw new IndexOutOfBoundsException();
		  int[] blockIndex = counter(index);
		  return this.blocks[blockIndex[0]][blockIndex[1]];
		}
	
	private int[] counter(int index) {
		  int c = 2;
		  int block = 0;
		  while (c <= index) {
		    index -= c;
		    c *= 2;
		    block++;
		  }
		  return new int[] {block, index};
		}

	public void addFirst(int value) {
		// TODO
		BlockIntList list = new BlockIntList();
		list.add(value);
		for(int i=0; i<this.size; i++) {
			list.add(this.get(i));
		}
		this.blocks = list.blocks;
		this.lastBlock = list.lastBlock;
		this.elemsInLast= list.elemsInLast;
		this.size = list.size;
	}
}
