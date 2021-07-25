/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import configrations.DbConnector;
import configrations.NonReturnMySqlResponse;
import dto.InvoiceDTO;
import dto.InvoiceDetailsDTO;
import utils.AlertUtils;
import utils.ApplicationUtils;

/**
 *
 * @author monieuzzaman
 */
public class ProductPurchaseService extends DbConnector implements InvoiceService {
    
    private boolean isSave = false;
    
    @Override
    public boolean saveInvoice(InvoiceDTO invoiceDTO) {
        
        String query = "INSERT INTO `invoice`(`invoice_no`, `supplier_id`, `sub_total`, `vat_in_perchance`, `transport_cost`, `discount_in_perchance`, `total`, `paid`, `due`, `invoice_type`, `created_by`, `creation_date_time`, `issue_date_time`)"
                + " VALUES ('" + invoiceDTO.getInvoiceId() + "','" + invoiceDTO.getSupplierId() + "',"
                + "'" + invoiceDTO.getSubTotal() + "','" + invoiceDTO.getVet() + "','" + invoiceDTO.getTransportCost() + "',"
                + "'" + invoiceDTO.getDiscount() + "','" + invoiceDTO.getTotal() + "','" + invoiceDTO.getPaid() + "',"
                + "'" + invoiceDTO.getDue() + "','" + invoiceDTO.getInvoiceType() + "',"
                + "'" + invoiceDTO.getCreateBy() + "','" + invoiceDTO.getCreateDate() + "','" + invoiceDTO.getIssueDateAndTime() + "')";
        
        nonReturnQueryExecutor(query, new NonReturnMySqlResponse() {
            
            @Override
            public void onUpdateAndDeleteResponse(int result) {
                
            }
            
            @Override
            public void onError(String error) {
                
                AlertUtils.error(error);
            }
        });
        
        for (InvoiceDetailsDTO invoice : invoiceDTO.getDetailsDTOs()) {
            String invoiceDetails = "INSERT INTO `invoice_details`(`id`, `price`, `product_id`, `qty`, `total`, `expire_date`, `product_location`, `sell_discount_in_perchance`, `invoice_id`) "
                    + "VALUES ('" + ApplicationUtils.getRandomInt() + "','" + invoice.getPrice() + "','" + invoice.getProduct_id() + "',"
                    + "'" + invoice.getQty() + "','" + invoice.getTotalPrice() + "','" + invoice.getExpireDate() + "',"
                    + "'" + invoice.getProductLocation() + "','" + invoice.getSellDiscount() + "','" + invoiceDTO.getInvoiceId() + "')";
            nonReturnQueryExecutor(invoiceDetails, new NonReturnMySqlResponse() {
                
                @Override
                public void onUpdateAndDeleteResponse(int result) {
                    isSave = true;
                }
                
                @Override
                public void onError(String error) {
                    AlertUtils.error(error);
                }
            });
            
        }
       return isSave;
    }
    
}
