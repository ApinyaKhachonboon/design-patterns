/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package memento;

import models.Caretaker;
import models.CropRotate;
import models.Photo;

/**
 *
 * @author macbook
 */
public class Main {

    public static void client() {
        // 1. สร้าง Originator ทั้ง 2 ตัว
        Photo photo = new Photo(0, 0, "Normal");
        CropRotate crop = new CropRotate(0, 0, 0, 1920, 1080);

        // 2. สร้าง Caretaker แยกตาม Originator
        Caretaker photoCaretaker = new Caretaker(photo);
        Caretaker cropCaretaker = new Caretaker(crop);

        // ทดสอบระบบสี
        photoCaretaker.addHistory();
        photo.setAdjustments(20, 10, "Vintage");
        photo.show();

        photoCaretaker.addHistory();
        photo.setAdjustments(30, 20, "Modern");
        photo.show();

        photoCaretaker.addHistory();
        photo.setAdjustments(50, 50, "Fantasy");
        photo.show();

        photoCaretaker.undo(); // คืนค่าเฉพาะสี
        photo.show();

        photoCaretaker.undo(); // คืนค่าเฉพาะสี
        photo.show();

        // ทดสอบระบบ Crop
        cropCaretaker.addHistory();
        crop.setAdjustments(90, 10, 10, 800, 600);
        crop.show();

        cropCaretaker.addHistory();
        crop.setAdjustments(180, 0, 50, 500, 400);
        crop.show();

        cropCaretaker.addHistory();
        crop.setAdjustments(70, 50, 400, 1920, 800);
        crop.show();

        cropCaretaker.undo(); // คืนค่าเฉพาะ Crop
        crop.show();

        cropCaretaker.undo(); // คืนค่าเฉพาะ Crop
        crop.show();
    }

    public static void main(String[] args) {
        client();
    }
}
