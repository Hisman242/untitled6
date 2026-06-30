package DequeProject;

public class DequeOnTheList {
    private DoublyLinkedList list;
    public DequeOnTheList() {
        list = new DoublyLinkedList();
    }
    public void insertLeft(long j){
        list.insertFirst(j);
    }
    public long peekLeft(){
        return   list.peekFirst();
    }
    public long peekRight(){
        return   list.peekLast();
    }
    public long removeLeft(){
        if(list.isEmpty()){
            System.out.println("List is empty");
            return -1;
        }
        Link temp = list.deleteFirst();
        return temp.dData;
    }
    public long removeRight(){
        if(list.isEmpty()){
            System.out.println("List is empty");
            return -1;
        } else{
            Link temp =  list.deleteLast();
            return temp.dData;
        }

    }
    public void insertRight(long j){
        list.insertLast(j);
    }
    public boolean isEmpty(){
        return list.isEmpty();
    }
    public void display(){
        list.displayForward();
    }
}
