package lru;

/**
 * Node  节点，用于实现 LRU
 */
class Node1 {
    int key;
    Node1 next;

    public Node1(int key ) {
        this.key = key;
    }

    @Override
    public String toString() {
        return this.key + "-"  + " ";
    }
}