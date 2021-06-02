/*In Order to run this programs predefined test output, run the static method, 'BinaryHeapProcedure()' in the Main class"*/
public class BinaryHeap extends BinaryTree {
    int[] heap;
    int elementCount;
    BinaryTree bt;
    public BinaryHeap(int elementCount){
        heap = new int[elementCount+1];
        this.elementCount = elementCount;
    }

    void preOrderFromHeap(int i){
        if(i>=elementCount){return;}
        System.out.println(heap[i]);
        preOrderFromHeap((2*i)+1);
        preOrderFromHeap((2*i)+2);
    }

    void inOrderFromHeap(int i){
        if(i>=elementCount){return;}
        inOrderFromHeap((2*i)+1);
        System.out.println(heap[i]);
        inOrderFromHeap((2*i)+2);
    }
    void postOrderFromHeap(int i){
        if(i>=elementCount){return;}
        postOrderFromHeap((2*i)+1);
        postOrderFromHeap((2*i)+2);
        System.out.println(heap[i]);
    }

    BinaryTree TreeMaker(){

        BinaryTree bt= new BinaryTree(new Node(10));
        bt.root.leftChild = new Node(20);
        bt.root.rightChild = new Node(30);
        bt.root.leftChild.leftChild = new Node( 40);
        bt.root.leftChild.rightChild = new Node( 50);
        bt.root.rightChild.leftChild = new Node( 60);
        bt.root.rightChild.rightChild = new Node( 70);
        bt.root.leftChild.leftChild.leftChild = new Node( 80);
        bt.root.leftChild.leftChild.rightChild = new Node( 90);
        bt.root.leftChild.rightChild.leftChild = new Node( 100);
        return bt;
    }

    void heapify(){
        heap[0] =10;heap[1] =20;heap[2] =30;heap[3] =40;heap[4] =50;heap[5] =60;heap[6] =70;heap[7] =80;heap[8] =90;heap[9] =100;
    }

    int getParentPosition(int i){
        return (i-1)/2;
    }
    int getLeftChildPosition(int i){return (2*i)+1;}
    int getRightChildPostion(int i){return (2*i)+2;}

    void insertNode(int val){
            int[] newheap = new int[heap.length +1];
            System.arraycopy(heap,0,newheap,0,heap.length);
            heap = newheap;
            ++elementCount;
            heap[heap.length -2] = val;
            bubbleUP(heap.length -2);
        }

    void bubbleUP(int i){
        int parent;
        if(i>0){
            parent = getParentPosition(i);
            if (heap[parent]>heap[i]){
                int temp = heap[parent];
                heap[parent] = heap[i];
                heap[i]= temp;
                bubbleUP(parent);
            }
        }
    }
    void deleteNode(int value){
        if(getIndex(value) >-1){
            int index = getIndex(value);
            heap[index] = heap[elementCount-1];
            heap[elementCount-1] =0;
            --elementCount;
            int[] newheap = new int[heap.length -1];
            System.arraycopy(heap,0,newheap,0,newheap.length);
            heap = newheap;
            bubbledown(index);

        }
        else{System.out.println("Not Found");}
    }
    int getIndex(int value){
        for (int i=0;i<heap.length;i++){
            if(heap[i] == value){return i;}
        }
        return -1;
    }

    void bubbledown(int i){
        while((2*i) +1 <= elementCount-1){
          int leftChild = (2*i)+1;
          int rightChild = (2*i) +2;
          if(rightChild <= elementCount-1){
              int replacerVal = Math.min(heap[leftChild], heap[rightChild]);
              int replacerPos = replacerVal == heap[leftChild] ? leftChild : rightChild;
              if (heap[i] > replacerVal){
                  int temp = heap[i];
                  heap[i] = replacerVal;
                  heap[replacerPos] = temp;
                  i = replacerPos;
              }
          }
          else if (heap[i] > heap[leftChild]){
              int temp = heap[i];
              heap[i] = heap[leftChild];
              heap[leftChild] = temp;
              i = leftChild;
          }
          else{
              break;
          }
        }
    }


}
