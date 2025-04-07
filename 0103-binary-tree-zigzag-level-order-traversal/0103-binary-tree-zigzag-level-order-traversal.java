
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        if(root == null){
            return result;
        }
        que.add(root);
        while(!que.isEmpty()){
            int level = que.size();
            List<Integer> arr = new ArrayList<>();
            for(int i = 0;i< level;i++){
                if(que.peek().left != null){
                    que.add(que.peek().left);
                }
                if(que.peek().right != null){
                    que.add(que.peek().right);
                }
                arr.add(que.peek().val);
                que.remove(que.peek());
            }
            result.add(arr);
        }
        int count = 0;
        for(List<Integer> list : result){
            count++;
            if(count%2 == 1)continue;
            int i = 0;
            int j = list.size()-1;
            while(i<j){
                int temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
                i++;
                j--;
            }
        }
        return result; 
    }
}