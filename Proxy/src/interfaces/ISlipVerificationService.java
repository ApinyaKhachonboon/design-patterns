/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import dtos.SlipResult;

/**
 *
 * @author macbook
 */
public interface ISlipVerificationService {
    SlipResult verifySlip(byte[] imageBuffer);
}
