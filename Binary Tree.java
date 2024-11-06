package PracticePack1;

public class Practice15 {
    public static void main(String[] args) {

        NodeListTree root=new NodeListTree("A","hello");

        root.left=new NodeListTree("B","Everyone");

        root.left.left=new NodeListTree("D","To");

        root.left.right=new NodeListTree("E","This");

        root.right=new NodeListTree("C","Welcome");

        root.right.right=new NodeListTree("F","Course");

        System.out.println(printFirst(root));
        System.out.println(printSecond(root));
        System.out.println(returnAns(root,'c'));

    }



    public static String printFirst(NodeListTree root) {

        String ans="";
        if(root!=null) {

            ans+=root.val.value;

            if (root.left!=null) {
                ans+=printFirst(root.left);
            }

            if (root.right!=null) {
                ans+=printFirst(root.right);
            }
        }
        return ans;
    }

    public static String printSecond(NodeListTree root) {
        String ans="";
        if(root!=null) {

            if (root.left!=null) {
                ans+=printSecond(root.left);
            }

            ans+=root.val.next.value;

            if (root.right!=null) {
                ans+=printSecond(root.right);
            }
        }
        return ans;
    }


    public static int returnAns(NodeListTree root,char aim) {

        int count=0;

        String str1=printFirst(root);

        String str2=printSecond(root);

        String str=str1+str2;

        int len=str.length();

        if (aim>='a'&& aim<='z') {
            str=str.toLowerCase();
        } else if (aim>='A'&& aim<='Z') {
            str=str.toUpperCase();
        }

        for (int i = 0; i < len; i++) {
            if (str.charAt(i)==aim) {
                count++;
            }
        }
        return count;
    }


    public static class NodeList {

        public String value;

        public NodeList next;


        public NodeList(String _value,NodeList _next) {
            value= _value;
            next= _next;
        }

        public NodeList(String _value) {
            value=_value;
            next=null;
        }
    }

    public static class NodeListTree {

        public NodeList val;
        public NodeListTree right;
        public NodeListTree left;

        NodeListTree(String l,String r) {

            this.val=new NodeList(l,new NodeList(r));
        }
        NodeListTree(NodeList val, NodeListTree left, NodeListTree right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
