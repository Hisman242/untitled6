package sortedLinkedList;

public class PriorityQueSortList {
    private SortedList sortedList;
    public PriorityQueSortList() {
        sortedList = new SortedList();
    }
    public void insert(long item){
        sortedList.insert(item);
    }
    public long remove(){
        Link removeItem = sortedList.remove();
        return removeItem.dData;
    }
    public long peekMin(){
        return sortedList.peekMin();
    }
    public boolean isEmpty(){
        return sortedList.isEmpty();
    }
    public void display(){
        sortedList.displayList();
    }
}
