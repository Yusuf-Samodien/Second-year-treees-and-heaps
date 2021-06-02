/*In Order to run this programs predefined test output, run the static method, 'BinaryTreeProcedure()' in the Main class"*/
class BinaryTree {
    Node root;
    public BinaryTree(Node root){ this.root = root;}
    public BinaryTree(){root = null;}


    void PreOrderTraversal(Node n){
        if (n == null){return;}
        System.out.println(n.value);
        PreOrderTraversal(n.leftChild);
        PreOrderTraversal(n.rightChild);
    }


    void InOrderTraversal(Node n){
        if (n== null){return;}
        InOrderTraversal(n.leftChild);
        System.out.println(n.value);
        InOrderTraversal(n.rightChild);
    }

    void PostOrderTraversal(Node n){
        if (n == null){return;}
        PostOrderTraversal(n.leftChild);
        PostOrderTraversal(n.rightChild);
        System.out.println(n.value);
    }

    void printDetails(){
        System.out.println("Name: Samodien, Yusuf\nStudent Number: 3970279\nCourse Code: CSC211_Term Project 2020\n");
    }
}