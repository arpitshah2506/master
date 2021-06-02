package tree;

public class MinHeap {
    public static void main(String[] args) {
        MinHeapUtil minHeap = new MinHeapUtil(10);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(2);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);

        minHeap.print();
    }
}

class MinHeapUtil {
    Integer[] minHeap;
    int position = 0;
    MinHeapUtil(int size) {
        minHeap = new Integer[size];
        minHeap[0] = Integer.MIN_VALUE;
    }

    public void insert(int element) {
        ++position;
        minHeap[position] = element;
        while (this.minHeap[position] < minHeap[parent(position)]) { // -21834020, 5, 3
            swap(position, parent(position)); //2,1

        }
    }

    private void swap(int position, Integer parentElement) { //2,1
        int temp = minHeap[position]; //3
        minHeap[position] = minHeap[parent(position)]; //5
        minHeap[parent(position)] = temp; //3
    }

    private Integer parent(Integer pos) {
        return pos / 2;
    }

    public void print()
    {
        for (int i = 1; i < minHeap.length / 2; i++) {
            System.out.print(" PARENT : " + minHeap[i]
                    + " LEFT CHILD : " + minHeap[2 * i]
                    + " RIGHT CHILD :" + minHeap[2 * i + 1]);
            System.out.println();
        }
    }
}