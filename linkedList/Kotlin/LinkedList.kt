
/**
 * This class represents a single node in a linked list
 */
class Node<T>(value : T){
    // value is data stored in that node
    var value : T = value
    // next points to the next node in linked list
    var next : Node<T>? = null
    // previous points to the previous node in linked list
    var previous : Node<T>? = null
}

/**
 * This class represents a complete linked list
 */
class LinkedList<T> {
    // head pointer of the linked list
    private var head : Node<T>? = null
    var isEmpty:Boolean = head == null 
    // return pointer to the first node of linked list aka head
    fun first() : Node<T>? = head
    // return pointer to the last node of linked list
    fun last() : Node<T>? {
        var node = head
        if(node != null){
            while(node?.next != null)
                node = node?.next
            return node
        }
        else{
            // head pointer is null
            // hence, last node is also null
            return null
        }
    }
    fun count() : Int{
        var node = head
        if(node != null){
            var count = 1
            while(node?.next != null){
                count += 1
                node = node?.next
            }
            return count
        }
        else{
            // list is empty, return size as 0
            return 0
        }
    }
    // add a new node to the end of linked list
    fun append(value : T){
        var newNode = Node(value)
        var lastNode = this.last()
        if(lastNode != null){
            newNode.previous = lastNode
            lastNode.next = newNode
        }
        else{
            // empty list, hence the head becomes new node
            head = newNode
        }
    }
    // finds and returns node at given index
    fun nodeAtIndex(index : Int) : Node<T>?{
        if(index >= 0){
            var node = head
            var i = index
            while(node != null){
                if(i == 0){
                    // reached destination node
                    return node
                }
                // move node by 1 pointer ahead
                i -= 1
                node = node?.next
            }
        }
        // invalid index passed, return null node
        return null
    }
    // delete all nodes of linked list
    fun removeAll(){
        head = null
    }
    override fun toString() : String{
        var s = "["
        var node = head
        while(node != null){
            s += "${node.value}"
            node = node?.next
            if(node != null){
                s += ", "
            }
        }
        return s + "]"
    }
}

fun main(args : Array<String>){
    var ll = LinkedList<String>()
    ll.append("Data One")
    ll.append("Data Two")
    println(ll)
    ll.append("Data Three")
    ll.append("Data Four")
    ll.append("Data Five")
    println(ll)
}