package circularList;



public class CircularList {
    private Link current;
    public CircularList(){
        current = null;
    }

    public void insert(long value){
        Link newLink = new Link(value);
        if(current == null){
            current = newLink;
            current.next = newLink;
        } else{
            newLink.next = current.next;
            current.next = newLink;
        }
    }
    public long remove(){
        if(current == null){
            System.out.println("List is empty");
            return -1;
        } else  if(current.next == current){
            Link temp = current;
            current = null;
            return temp.dData;
        }else{
            Link temp = current.next;
            current.next = temp.next;
            return temp.dData;
        }
    }
    public long remove(long value){
        Link returnLink;
        Link previousLink;
        Link temp = current;
        if(temp == null){
            System.out.println("List is empty");
            return -1;
        }if(current.next == current && current.dData == value){
            returnLink = current;
            current = null;
            return returnLink.dData;
        } else {
            while(true){
                previousLink = temp;
                temp = temp.next;
                if(temp == current && current.dData == value){
                    returnLink = temp;
                    previousLink.next = temp.next;
                    current = temp.next;
                    return returnLink.dData;
                }if(temp.dData == value){
                    returnLink = temp;
                    previousLink.next = temp.next;
                    return returnLink.dData;
                }if(temp == current){
                    return -1;
                }
            }
        }
    }
    public boolean search(long value){
        Link temp = current;
        if(temp == null){
            System.out.println("List is empty");
            return false;
        }else {
            if(temp.dData == value){
                return true;
            }
            while(true){
                temp = temp.next;
                if(temp == current){
                    break;
                }
                if(temp.dData == value){
                    return true;
                }
            }
        }
        return false;

    }
    public boolean isEmpty(){
        return current == null;
    }
    public void step(){
        current = current.next;
    }
    public void  display(){
        Link temp = current;
        if(temp == null){
            System.out.println("List is empty");
        }else {
            System.out.print(temp.dData + " ");
            while(true){
                temp = temp.next;
                if(temp == current){
                    break;
                }
                System.out.print(temp.dData + " ");
            }
        }
        System.out.println();

    }
    public void  displayStack(){
        Link temp = current;
        if(temp == null){
            System.out.println("List is empty");
        }else {
            temp = current.next;
            System.out.print(temp.dData + " ");
            while(true){
                temp = temp.next;
                if(temp == current.next){
                    break;
                }
                System.out.print(temp.dData + " ");
            }
        }
        System.out.println();

    }
    public long peek(){
        Link temp = current;
        if(temp == null){
            System.out.println("List is empty");
        } else{
            temp = current.next;
            return  temp.dData;
        }
        return 0;
    }
}
