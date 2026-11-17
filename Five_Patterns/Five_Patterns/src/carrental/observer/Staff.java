package carrental.observer;

public class Staff implements RentalObserver {

    private String staffId;
    private String name;
    private String branch;

    public Staff(String staffId, String name, String branch) {
        this.staffId = staffId;
        this.name = name;
        this.branch = branch;
    }

    // พนักงานรับทุกการแจ้งเตือน
    @Override
    public void update(String message) {
        System.out.println("  [พนักงาน " + name + " สาขา" + branch + "] " + message);
    }

    public String getStaffId() {
        return staffId;
    }

    public String getName() {
        return name;
    }

    public String getBranch() {
        return branch;
    }
}
