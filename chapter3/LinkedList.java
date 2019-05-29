package chapter3;

public class LinkedList
{
  Node head;
  
  public LinkedList()
  {
    head = null;
  }
  
  public LinkedList(Node paramNode) {
    head = paramNode;
  }
  
  public Node getHead() {
    return head;
  }
  
  public Node search(int paramInt) {
    Node temp = head;
    
    while (temp != null) {
      if (temp.data == paramInt) {
        return temp;
      }
      temp = temp.next;
    }
    
    return temp;
  }
  
  public void insertToHead(int paramInt) {
    if (head == null) {
      head = new Node(paramInt);
      return;
    }
    
    Node temp = new Node(paramInt);
    temp.next = head;
    head = temp;
  }
  
  public void deleteNode(int paramInt) {
    Node temp1 = search(paramInt);
    Node temp2 = head;
    
    if (temp1 != null) {
      while ((temp2 != null) && (temp2.next != null) && (temp2.next.data != paramInt)) {
        temp2 = temp2.next;
      }
      
      if (temp2 == head) {
        head = null;
      } else {
        temp2.next = temp1.next;
      }
    }
  }
}
