/*In Order to run this programs predefined test output, run the static method, 'BinarySearchTreeProcedure()' in the Main class"*/
public class BinarySearchTree extends BinaryTree {
    Node root;

    public BinarySearchTree() {
        super();
    }

    void add(Integer val) {
        add(root, val);
    }

    void add(Node curr, Integer val) {
        Node n = new Node(val);
        if (root == null) {
            root = n;
        } else if (n.value < curr.value) {
            if (curr.leftChild == null) {
                curr.leftChild = n;
            } else {
                add(curr.leftChild, val);
            }
        } else if (n.value > curr.value) {
            if (curr.rightChild == null) {
                curr.rightChild = n;
            } else {
                add(curr.rightChild, val);
            }
        }

    }

    void delete(Integer val) {
        root = delete(root, val);
    }

    Node delete(Node curr, Integer val) {
        Node n = new Node(val);
        try {
            if (curr.value.equals(val)) {
                if (curr.leftChild == null && curr.rightChild == null) {
                    return null;
                } else if (curr.leftChild == null) {
                    return curr.rightChild;
                } else if (curr.rightChild == null) {
                    return curr.leftChild;
                } else {
                    curr.value = findSmallest(curr.rightChild);
                    curr.rightChild = delete(curr.rightChild, curr.value);
                }
            }
            else if (n.value < curr.value) {
                if (curr.leftChild == null) {
                    System.out.println("Value not in tree");
                } else {
                    curr.leftChild = delete(curr.leftChild, val);
                }
            } else {
                if (curr.rightChild == null) {
                    System.out.println("Value not found");
                } else {
                    curr.rightChild = delete(curr.rightChild, val);
                }
            }
            return curr;

        } catch (NullPointerException e) {
            System.out.println("Tree is empty");return curr;
        }
    }

    Node findElement(Integer val){return findElement(root,val);}
    Node findElement(Node curr, Integer val){
        if (curr.value == val){
            System.out.println("FOUND");
            return curr;
        }
        else if (val<curr.value && curr.leftChild != null){
            findElement(curr.leftChild, val);
        }
        else if (val>curr.value && curr.rightChild != null){
            findElement(curr.rightChild,val);
        }
        else{System.out.println("NOT FOUND");
        }
        return curr;
    }
    Integer findSmallest(Node curr) {
        while (true) {
            Node smallest = curr;
            if (curr.leftChild == null) {
                return smallest.value;
            }
            curr = curr.leftChild;
        }
    }

    void setSmallestNull(Node curr) {
        if (curr.leftChild==null){curr.value = null;}
        else{
            setSmallestNull(curr.leftChild);
        }
    }


}


