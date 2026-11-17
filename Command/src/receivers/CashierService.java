/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package receivers;

import models.Order;
import models.OrderDetail;

/**
 *
 * @author macbook
 */
import java.util.List;

public class CashierService {

    private KitchenService kitchenService;

    public CashierService(KitchenService kitchenService) {
        this.kitchenService = kitchenService;
    }

    public void generateBill(String tableNo) {
        List<Order> orders = kitchenService.getOrdersByTable(tableNo);

        System.out.println("\n================= ใบแจ้งหนี้ / BILL =================");
        System.out.println(" โต๊ะ: " + tableNo);
        System.out.println("---------------------------------------------------");

        if (orders.isEmpty()) {
            System.out.println(" ไม่มีรายการอาหารที่ค้างชำระ");
            System.out.println("===================================================\n");
            
            return;
        }

        double grandTotal = 0.0;
        
        for (Order order : orders) {
            System.out.printf("[Order: %s] สร้างเมื่อ: %s\n", order.getOrderId(), order.getCreatedAt());
            
            for (OrderDetail detail : order.getDetails()) {
                if (detail.isCancelled()) {
                    System.out.printf("  [X] %s (ยกเลิกแล้ว)\n", detail.getItem().getName());
                } else {
                    System.out.printf("      %s x%d %,10.2f บาท\n",
                            detail.getItem().getName(),
                            detail.getQuantity(),
                            detail.getSubtotal());
                }
            }
            
            grandTotal += order.calculateActiveTotal();
        }

        System.out.println("---------------------------------------------------");
        System.out.printf(" ยอดสุทธิที่ต้องชำระทั้งหมด: %,.2f บาท\n", grandTotal);
        System.out.println("===================================================\n");
    }
}
