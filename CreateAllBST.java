public class CreateAllBST{
  public List<LovyNode<Integer>> generateTrees(int n) {

        return genTrees(1,n);
    }

    public List<LovyNode<Integer>> genTrees (int start, int end)
    {

        List<LovyNode<Integer>> list = new ArrayList<>();

        if(start>end)
        {
            list.add(null);
            return list;
        }

        if(start == end){
            list.add(new LovyNode<>(start));
            return list;
        }

        List<LovyNode<Integer>> left,right;
        for(int i=start;i<=end;i++)
        {

            left = genTrees(start, i-1);
            right = genTrees(i+1,end);

            for(LovyNode<Integer> lnode: left)
            {
                for(LovyNode<Integer> rnode: right)
                {
                    LovyNode<Integer> root = new LovyNode<Integer>(i);
                    root.left = lnode;
                    root.right = rnode;
                    list.add(root);
                }
            }

        }

        return list;
    }
 }
