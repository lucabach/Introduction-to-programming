
public class UnionFind {
	
	public int totalSize;
	public int numComponents;

	public int[] size;
	public int[] parent;
	
	
	public UnionFind(int size) {
		this.totalSize = this.numComponents = size;
		
		this.size = new int[size];
		this.parent = new int[size];
		
		for(int i=0; i<size; i++) {
			parent[i]=i;
			this.size[i]=-1;
		}
	}
	
	public int find(int p) {
		int root = p;
		
		while(root != parent[root]) {
			root = parent[root];
		}
		
		while(p != root) {
			int next = parent[p];
			parent[p] = root;
			p = next;
		}
		return root;
	}
	
	public boolean connected(int p, int q) {
		return find(p)==find(q);
	}
	
	public int componentSize(int p) {
		return size[find(p)];
	}
	
	public int getSize() {
		return totalSize;
	}
	
	public int getComponents() {
		return numComponents;
	}
	
	public void unify(int p, int q) {
		
		int root1 = find(p);
		int root2 = find(q);
		
		if(root1==root2) {
			return;
		}
		
		else if(size[root1]<size[root2]) {
			size[root2]+=size[root1];
			parent[root1]=root2;
		}
		else {
			size[root1]+=size[root2];
			parent[root2]=root1;
		}
	}
}
