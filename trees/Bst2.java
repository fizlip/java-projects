class Bst2{

    Node root;

    public Bst2(int root){
        this.root = new Node(root);
    }

    private class Node{
        Integer value = null;
        Node right = null;
        Node left = null;

        public Node(Integer value){
            this.value = value;
            this.right = null;
            this.left = null;
        }
    }

    public Node addRecursive(Node current, int i){
        if(current == null){
            return new Node(i);
        }

        if(current.value > i){
            current.left = addRecursive(current.left, i);
        }
        if(current.value < i){
            current.right = addRecursive(current.right, i);
        }

        return current;
    }

    public void add(int i){
        root = addRecursive(root, i);
    }

    public String printString(Node n){
        String result = ""; 
        result += n.value;
        if(n.left != null && n.right != null){
            return result + "\n/  \\\n" + printString(n.left) + "  " + printString(n.right);
        }
        if(n.left == null && n.right != null){
            return result + "\n/  \\\n" +  "  " + printString(n.right);
        }
        if(n.left != null && n.right == null){
            return result + "\n/  \\\n" + printString(n.left);
        }
        return result;
    }

    public static void main(String[] args){
        Bst2 b = new Bst2(10);
        b.add(4);
        b.add(7);
        b.add(2);
        b.add(10);
        b.add(20);
        Node x = b.root;
        // while(x.right != null && x.left != null){
        //     System.out.println(x.right);
        //     System.out.println(x.left);
        // }
        System.out.println(b.printString(b.root));

    }

}