public class Q307 {
    static class NumArray {
        private SegmentTree segmentTree;

        private class SegmentTree{
            private int[] tree;
            private int[] arr;

            public SegmentTree(int[] nums){
                if(nums.length > 0){
                    this.arr = nums;
                    tree = new int[nums.length * 4];
                    buildSegmentTree(0, 0 ,nums.length - 1);
                }
            }

            /**
             *  构建线段树
             * @param index tree 数组索引
             * @param l 数组左边界
             * @param r 数组右边界
             */
            public void buildSegmentTree(int index, int l, int r){
                if(l == r){
                    tree[index] = arr[l];
                    return;
                }

                int mid = l + (r -l)/2;

                buildSegmentTree(index * 2 + 1, l, mid);
                buildSegmentTree(index * 2 + 2, mid + 1, r);

                tree[index] = tree[index * 2 + 1] + tree[index * 2 +2];
            }

            ///更新 arr i 处值，更新线段树
            public void update(int i, int val){
                if(i < 0 || i >= arr.length)
                    throw new IllegalArgumentException("index 不合理");
                this.arr[i] = val;

                update(0, 0 ,arr.length - 1, i, val);
            }

            private void update(int treeIndex, int l, int r, int arrIndex, int date){
                if(l == r){
                    tree[treeIndex] = date;
                    return;
                }

                int mid = l + (r -l)/2;
                if(arrIndex <= mid)
                    update(treeIndex * 2 + 1, l, mid, arrIndex, date);
                else
                    update(treeIndex * 2 + 2, mid + 1, r,arrIndex,date);

                tree[treeIndex] = tree[treeIndex * 2 + 1] + tree[treeIndex * 2 + 2];
            }
            //查询i-j的和
            public int query(int queryL,int queryR){
                if(queryL < 0 || queryL >= arr.length ||
                        queryR < 0 || queryR >= arr.length || queryL > queryR)
                    throw new IllegalArgumentException("Index is illegal.");

                return query(0, 0 ,arr.length - 1, queryL, queryR);
            }
            //以treeIndex为根的线段树中[l...r]的范围里，搜索区间[queryL...queryR]的值
            private int query(int treeIndex, int l, int r, int queryL, int queryR){
                if(l == queryL && r == queryR)
                    return tree[treeIndex];

                int mid = l + (r -l)/2;
                if(queryR <= mid)
                    return query(treeIndex * 2 + 1, l ,mid, queryL, queryR);
                else if(queryL >= mid + 1)
                    return query(treeIndex * 2 + 2, mid + 1, r, queryL, queryR);
                else
                    return query(treeIndex * 2 + 1, l, mid, queryL ,mid) +
                            query(treeIndex * 2 + 2, mid + 1, r, mid + 1, queryR);
            }
        }


        public NumArray(int[] nums) {
            segmentTree = new SegmentTree(nums);
        }

        public void update(int i, int val) {
            if(segmentTree == null)
                throw new IllegalArgumentException("Error");
            segmentTree.update(i, val);
        }

        public int sumRange(int i, int j) {
            if(segmentTree == null)
                throw new IllegalArgumentException("Error");
            return segmentTree.query(i, j);
        }

    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        NumArray segmentTree = new NumArray(nums);
        segmentTree.sumRange(0,2);
        segmentTree.update(1,2);
        segmentTree.sumRange(0,2);
    }
}
