package queueProject;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Buyer {
    private int countOfProducts;
    private int serviceTime;
    private long id;
    private static AtomicLong IDhelper = new AtomicLong();
    public Buyer() {
        countOfProducts = (int) (Math.random() * 101);
        serviceTime = countOfProducts / 2;
        id = IDhelper.getAndIncrement();
        //(long) (Math.random() * 2001);
    }

    public int getCountOfProducts() {
        return countOfProducts;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "countOfProducts=" + countOfProducts +
                ", serviceTime=" + serviceTime +
                ", id=" + id +
                '}';
    }
}
