package queueProject;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

public class Simulation {
    private Queue line1 = new Queue(30);
    private Queue line2 = new Queue(30);
    private Queue line3 = new Queue(30);;
    private Map<Long, Buyer> buyers = new HashMap<>();
    private int countOfBuyers = (int) (Math.random() * 31);

    public Map<Long, Buyer> getBuyers() {
        return buyers;
    }

    public int getCountOfBuyers() {
        return countOfBuyers;
    }

    public Queue getLine1() {
        return line1;
    }

    public Queue getLine2() {
        return line2;
    }

    public Queue getLine3() {
        return line3;
    }

    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        Map<Long, Buyer> buyers = simulation.getBuyers();
        Queue line1 = simulation.getLine1();
        Queue line2 = simulation.getLine2();
        Queue line3 = simulation.getLine3();
        int countOfBuyers = simulation.getCountOfBuyers();
        for (int i = 0; i<countOfBuyers; i++) {
            Buyer buyer = new Buyer();
            int randQue = (int) (Math.random() * 3);

            if(randQue==0 && !line1.isFull()) {
                line1.insert(buyer.getId());
                buyers.put(buyer.getId(), buyer);
            } else if(randQue==1 && !line2.isFull()) {
                line2.insert(buyer.getId());
                buyers.put(buyer.getId(), buyer);
            } else if(randQue==2 && !line3.isFull()){
                line3.insert(buyer.getId());
                buyers.put(buyer.getId(), buyer);
            } else{
                try {
                    Thread.sleep(3000);
                    if(!line1.isFull()) {
                        line1.insert(buyer.getId());
                        buyers.put(buyer.getId(), buyer);
                    } else if(!line2.isFull()) {
                        line2.insert(buyer.getId());
                        buyers.put(buyer.getId(), buyer);
                    } else if(!line3.isFull()){
                        line3.insert(buyer.getId());
                        buyers.put(buyer.getId(), buyer);
                    }
                } catch (InterruptedException e) {
                    System.out.println("Internal error");
                }
            }
        }
        System.out.println("Displaying a first line");
        line1.display();
        System.out.println();
        System.out.println("Displaying a second line");
        line2.display();
        System.out.println();
        System.out.println("Displaying a third line");
        line3.display();
        System.out.println();
        System.out.println("Сustomer service line 1");
        if(line1.size() > 0){
            while(!line1.isEmpty()) {
                System.out.println("Customer at the checkout");
                long tempId = line1.remove();
                Buyer tempBuyer = buyers.get(tempId);
                try {
                    Thread.sleep(tempBuyer.getServiceTime() * 100);
                    System.out.println("Client"+ tempBuyer.toString() +" served");
                } catch (InterruptedException e) {
                    System.out.println("Internal error");
                }
            }
        }
        System.out.println("Сustomer service line 2");
        if(line2.size() > 0){
            while(!line2.isEmpty()) {
                System.out.println("Customer at the checkout");
                long tempId = line2.remove();
                Buyer tempBuyer = buyers.get(tempId);
                try {
                    Thread.sleep(tempBuyer.getServiceTime() * 100);
                    System.out.println("Client"+ tempBuyer.toString() +" served");
                } catch (InterruptedException e) {
                    System.out.println("Internal error");
                }
            }
        }

        System.out.println("Сustomer service line 3");
        if(line3.size() > 0){
            while(!line3.isEmpty()) {
                System.out.println("Customer at the checkout");
                long tempId = line3.remove();
                Buyer tempBuyer = buyers.get(tempId);
                try {
                    Thread.sleep(tempBuyer.getServiceTime() * 100);
                    System.out.println("Client"+ tempBuyer.toString() +" served");
                } catch (InterruptedException e) {
                    System.out.println("Internal error");
                }
            }
        }

    }

}
