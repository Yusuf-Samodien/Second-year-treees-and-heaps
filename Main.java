import java.util.Scanner;
class Main {
    public static void main(String[] args) {
       int n;
        Scanner keyb= new Scanner(System.in);
          BinaryTree details = new BinaryTree();details.printDetails();
          System.out.println("Predefined test runs have been programmed. In order to view the Binary Tree test case, enter 1. For the BinarySearchTree test case, enter 2. For the Binary Heap Test case, enter 3:\nEnter 1,2 or 3:");
          n = keyb.nextInt();
          keyb.close();
          switch(n){
              case 1: BinaryTreeProcedure();break;
              case 2: BinarySearchTreeProcedure();break;
              case 3: BinaryHeapProcedure();break;
              default: System.out.println("Please enter a valid Integer and re-run the program.\n");break;
          }
        System.exit(0);
      }

    static void BinaryHeapProcedure(){
        BinaryHeap h = new BinaryHeap(10);
        BinaryTree t = h.TreeMaker();
        h.heapify();
        System.out.println("\nRunning test case output for Part 3: Binary heap:");
        System.out.println("Heap before insertions: ");
        System.out.println("PreOrder: ");
        t.PreOrderTraversal(t.root);
        System.out.println("InOrder: ");
        t.InOrderTraversal(t.root);
        System.out.println("PostOrder: ");
        t.PostOrderTraversal(t.root);

        h.insertNode(110);
        h.insertNode(120);
        System.out.println("\nHeap after adding 110 and 120:");
        System.out.println("PreOrder:");
        h.preOrderFromHeap(0);
        System.out.println("\nInOrder:");
        h.inOrderFromHeap(0);
        System.out.println("PostOrder:");
        h.postOrderFromHeap(0);

        h.deleteNode(30);
        System.out.println("\nHeap after deletion of 30:");
        System.out.println("PreOrder:");
        h.preOrderFromHeap(0);
        System.out.println("\nInOrder:");
        h.inOrderFromHeap(0);
        System.out.println("PostOrder:");
        h.postOrderFromHeap(0);

    }
    static void BinarySearchTreeProcedure(){
        BinarySearchTree bst = new BinarySearchTree();
        bst.root = new Node(14);
        bst.root.leftChild = new Node(3);
        bst.root.leftChild.rightChild = new Node(4);
        bst.root.leftChild.rightChild = new Node(12);
        bst.root.leftChild.rightChild.rightChild = new Node(13);
        bst.root.rightChild = new Node(15);
        bst.root.leftChild.rightChild.leftChild = new Node(10);
        System.out.println("Printing test case output for part 2: Binary Search Tree:\n");
        System.out.println("PreOrder:");
        bst.PreOrderTraversal(bst.root);
        System.out.println("\nInOrder:");
        bst.InOrderTraversal(bst.root);
        System.out.println("PostOrder:");
        bst.PostOrderTraversal(bst.root);

        bst.add(5);bst.add(1);bst.add(2);bst.add(0);
        System.out.println("\nTraversals for the BST after adding 5,1,2 and 0:\n");
        System.out.println("PreOrder:");
        bst.PreOrderTraversal(bst.root);
        System.out.println("\nInOrder:");
        bst.InOrderTraversal(bst.root);
        System.out.println("PostOrder:");
        bst.PostOrderTraversal(bst.root);

        System.out.println("\nTraversals after deleting 0 and 15");
        bst.delete(0);bst.delete(15);
        System.out.println("PreOrder:");
        bst.PreOrderTraversal(bst.root);
        System.out.println("\nInOrder:");
        bst.InOrderTraversal(bst.root);
        System.out.println("PostOrder:");
        bst.PostOrderTraversal(bst.root);

        Scanner keyb= new Scanner(System.in);
        System.out.println("Enter an Integer to be searched for: ");
        int i = keyb.nextInt();
        keyb.close();
        bst.findElement(i);
    }


    static void BinaryTreeProcedure(){
        System.out.println("Printing test case output for part 1: Binary Tree: \n");
        BinaryTree tree = new BinaryTree(new Node(10));
        tree.root.leftChild = new Node(20);
        tree.root.rightChild = new Node(30);
        tree.root.leftChild.leftChild = new Node( 40);
        tree.root.leftChild.rightChild = new Node( 50);
        tree.root.rightChild.leftChild = new Node( 60);
        tree.root.rightChild.rightChild = new Node( 70);
        tree.root.leftChild.leftChild.leftChild = new Node( 80);
        tree.root.leftChild.leftChild.rightChild = new Node( 90);
        tree.root.leftChild.rightChild.leftChild = new Node( 100);

        System.out.println("Pre Order Traversal: ");
        tree.PreOrderTraversal(tree.root);
        System.out.println("\nIn Order Traversal: ");
        tree.InOrderTraversal(tree.root);
        System.out.println("\nPost Order Traversal: ");
        tree.PostOrderTraversal(tree.root);
    }

}



