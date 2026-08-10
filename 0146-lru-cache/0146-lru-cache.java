class ListNode {

    int val,key;
    ListNode next,prev;

    ListNode(){
        key = val = -1;
        next = prev = null;
    }

    ListNode(int k,int v){
        key = k;
        val = v;
        next = prev = null;
    }
}

class LRUCache {

    int size;
    ListNode head;
    ListNode tail;
    Map<Integer,ListNode> map;

    public LRUCache(int capacity) {

        head = new ListNode();
        tail = new ListNode();
        map = new HashMap<>();
        size = capacity;
        head.next = tail;
        tail.prev = head;

        
    }
    
    public int get(int key) {

        if (!map.containsKey(key)){
            return -1;
        }

        ListNode node = map.get(key);
        int val = node.val;
        delNode(node);
        InsHead(node);
        return val;
    }
    
    public void put(int key, int value) {


        if(map.containsKey(key)){
            ListNode node = map.get(key);
            node.val = value;
            delNode(node);
            InsHead(node);
            return;
        }
        
        if(map.size() == size){
            ListNode node = tail.prev;
            map.remove(node.key);
            delNode(node);
        }

        ListNode node = new ListNode(key,value);
        map.put(key,node);
        InsHead(node);

    }

    public void InsHead(ListNode node){

        ListNode nextNode = head.next;
        head.next = node;
        nextNode.prev = node;
        node.next = nextNode;
        node.prev = head;
    }

    public void delNode(ListNode node){

        ListNode prevNode = node.prev;
        ListNode nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */