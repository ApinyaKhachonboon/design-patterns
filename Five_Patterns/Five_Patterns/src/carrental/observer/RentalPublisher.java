package carrental.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Observer: Publisher เก็บรายชื่อผู้รับแจ้งเตือนและกระจายข่าว
 */
public class RentalPublisher {

    private List<RentalObserver> observers = new ArrayList<>();

    public void subscribe(RentalObserver s) {
        observers.add(s);
    }

    public void unsubscribe(RentalObserver s) {
        observers.remove(s);
    }

    // overload ของ Object.notify() ได้ เพราะพารามิเตอร์ต่างกัน
    public void notify(String message) {
        for (RentalObserver s : observers) {
            s.update(message);
        }
    }
}
