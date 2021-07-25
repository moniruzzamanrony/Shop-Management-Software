/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dto.InvoiceDTO;

/**
 *
 * @author moniruzzaman.rony
 */
public interface InvoiceService {
   boolean saveInvoice(InvoiceDTO invoiceDTO);
}
