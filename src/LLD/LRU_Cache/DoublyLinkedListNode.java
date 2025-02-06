package LLD.LRU_Cache;

public class DoublyLinkedListNode<Key> {
    DoublyLinkedListNode<Key> prev;
    DoublyLinkedListNode<Key> next;
    Key element;

    public DoublyLinkedListNode(Key key) {
        this.prev = null;
        this.next = null;
        this.element = key;
    }
}
