import java.util.Map.Entry;
public class Solution {
     class obj{
        int hd;
        TreeNode node;
        obj(int hd,TreeNode node){
            this.hd = hd;
            this.node =node;
        }
    }
   
     public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root)
    {
          ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
          Queue<obj> q = new LinkedList<obj>();
    TreeMap<Integer,ArrayList<TreeNode>> map = new TreeMap<Integer,ArrayList<TreeNode>>();
        if(root == null)
        return res;
        q.add(new obj(0,root));
        while(q.isEmpty() == false){
            obj temp = q.peek();
            q.remove();
        
            if(!map.containsKey(temp.hd)){
                ArrayList<TreeNode> a = new ArrayList<TreeNode>();
                a.add(temp.node);
                map.put(temp.hd,a);
            }
            else{
                ArrayList<TreeNode>a= map.get(temp.hd);
                a.add(temp.node);
                map.put(temp.hd, a);
            }
            
            if(temp.node.left!=null){
                q.add(new obj((temp.hd)-1,temp.node.left));
            }
            
            if(temp.node.right!=null){
                q.add(new obj((temp.hd)+1,temp.node.right));
            }
        }
      
      for (Entry<Integer, ArrayList<TreeNode>> entry : map.entrySet()) 
        { 
          ArrayList<Integer> a = new ArrayList<Integer>(); 
            for(int i=0;i<entry.getValue().size();i++){
                a.add(entry.getValue().get(i).val);
            }
            res.add(a);
        } 
     return res;
    }
}
