package LLD.LRU_Cache;

public class DoubleLinkedList<Key> {
//we are keeping recently used keys at tail.
    DoublyLinkedListNode<Key> headDummy;
    DoublyLinkedListNode<Key> tailDummy;
    public DoubleLinkedList() {
        headDummy=new DoublyLinkedListNode<>(null);
        tailDummy=new DoublyLinkedListNode<>(null);
        headDummy.next=tailDummy;
        tailDummy.prev=headDummy;
    }
    public void removeNode(DoublyLinkedListNode<Key> node){
       node.prev.next=node.next;
       node.next.prev=node.prev;
    }
    public DoublyLinkedListNode<Key> addAtLast(Key key){   //this will be most recently used key
        DoublyLinkedListNode<Key> node=new DoublyLinkedListNode<>(key);
        node.prev=tailDummy.prev;
        node.next=tailDummy;
        node.prev.next=node;
        node.next.prev=node;
        return node;
    }
    public Key removeFromFirst(){ //this will be least recently used
        Key key=headDummy.next.element;
        headDummy.next=headDummy.next.next;
        headDummy.next.prev=headDummy;
        return key;
    }



}
