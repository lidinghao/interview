/**
 * Created by mandy on 2016/1/18.
 */
public class UnionFind {
    int[] id;
    int count;

    public UnionFind(int N) {
        id = new int[N];
        //reflective
        for (int i = 0; i < N; i++) {
            id[i] = i;

        }
        count = N;
    }

    public void union(int p, int q) {
        if (connected(p, q)) {
            return;
        } else {
            for (int i = 0; i < id.length; i++) {
                if (id[i] == p) {
                    id[i] = q;

                }
            }
            count--;
        }

    }

    public int find(int p) {
        return id[p];


    }

    boolean connected(int p, int q) {
        return find(p) == find(q);

    }

    int count() {
        return count;

    }
}
