class Solution {
    public List<List<Integer>> generate(int numRows) {
        return v1(numRows);
    }

    //v1
    //Runtime:0ms,100%,Memory:36.6MB,83.92%
    //没想出什么好办法，杨辉三角只能从顶向下一层层构建，2重循环应该是免不了吧
    public List<List<Integer>> v1(int numRows) {
        ArrayList<Integer> pre = new ArrayList<Integer>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; ++i) {
            ArrayList<Integer> cur = new ArrayList<Integer>();
            for (int j = 0; j < i + 1; ++j) {
                if (0 == j || i == j) {
                    cur.add(1);
                } else {
                    cur.add(pre.get(j - 1) + pre.get(j));
                }
            }
            pre = cur;
            res.add(cur);
        }
        return res;
    }
}