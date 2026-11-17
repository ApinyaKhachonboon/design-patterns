/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package receivers;

import models.Order;
import models.OrderDetail;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author macbook
 */
public class KitchenService {

    private List<Order> activeOrders;

    public KitchenService() {
        this.activeOrders = new ArrayList<>();
    }

    public void processOrder(Order order) {
        this.activeOrders.add(order);
        System.out.println("[Kitchen] รับออเดอร์ " + order.getOrderId() + " (โต๊ะ: " + order.getTableNo() + ")");

        for (OrderDetail detail : order.getDetails()) {
            if (!detail.isCancelled()) {
                // 1. เปลี่ยนสถานะเป็น COOKING (เริ่มปรุง)
                detail.setStatus("COOKING");
                System.out.println("  -> กำลังปรุง: " + detail.getItem().getName()
                        + " x" + detail.getQuantity()
                        + " [สถานะ: " + detail.getStatus() + "]");

                // 2. ปรุงเสร็จแล้วเปลี่ยนสถานะเป็น SERVED (เสิร์ฟแล้ว)
                detail.setStatus("SERVED");
                System.out.println("  -> ปรุงเสร็จเรียบร้อย พร้อมเสิร์ฟ: " + detail.getItem().getName()
                        + " [สถานะ: " + detail.getStatus() + "]");
            }
        }
    }

    public List<Order> getOrdersByTable(String tableNo) {
        List<Order> tableOrders = new ArrayList<>();

        for (Order order : activeOrders) {
            if (order.getTableNo().equalsIgnoreCase(tableNo)) {
                tableOrders.add(order);
            }
        }

        return tableOrders;
    }

    public void cancelDetail(OrderDetail orderDetail, String reason) {
        if (orderDetail == null) {
            return;
        }

        String currentStatus = orderDetail.getStatus();

        if (!"PENDING".equalsIgnoreCase(currentStatus)) {
            System.out.println("[Kitchen] ไม่สามารถยกเลิกเมนู '"
                    + orderDetail.getItem().getName()
                    + "' ได้ เนื่องจากสถานะปัจจุบันคือ: " + currentStatus);

            return;
        }

        orderDetail.cancel();

        System.out.println("[Kitchen] ยกเลิกรายการ: " + orderDetail.getItem().getName()
                + " (เหตุผล: " + reason + ") "
                + "[สถานะ: " + orderDetail.getStatus() + "]");
    }
}
