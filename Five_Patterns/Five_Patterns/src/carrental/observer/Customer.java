package carrental.observer;

import java.time.LocalDate;

public class Customer implements RentalObserver {

    private String customerId;
    private String name;
    private String phone;
    private String email;
    private String licenseNo;
    private LocalDate licenseExpiry;

    public Customer(
            String customerId,
            String name,
            String phone,
            String email,
            String licenseNo,
            LocalDate licenseExpiry
    ) {
        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.licenseNo = licenseNo;
        this.licenseExpiry = licenseExpiry;
    }

    public boolean isLicenseValid() {
        return licenseExpiry.isAfter(LocalDate.now());
    }

    // รับเฉพาะการแจ้งเตือนที่เกี่ยวกับการเช่าของตัวเอง
    @Override
    public void update(String message) {
        System.out.println("  [SMS ถึง " + phone + "] คุณ" + name + ": " + message);
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public LocalDate getLicenseExpiry() {
        return licenseExpiry;
    }
}
