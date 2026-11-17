/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import models.CarAsset;
import models.FactoryAsset;
import models.HouseAsset;

/**
 *
 * @author macbook
 */
public interface InsuranceVisitor {

    void visit(CarAsset car);

    void visit(HouseAsset house);

    void visit(FactoryAsset factory);
}
