package carrental.car;

/**
 * Product (Factory Method) และ Component (Decorator)
 */
public interface Car {

    void clean();

    void refuel();

    void inspect();
    
    String getPlateNo();

    String getDescription();

    double getDailyRate();

    boolean isAvailable();

    void setAvailable(boolean available);
}
