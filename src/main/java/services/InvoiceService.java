/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import configrations.DbConnector;
import configrations.NonReturnMySqlResponse;
import configrations.ReturnMySqlResponse;
import dto.InvoiceDTO;
import dto.InvoiceDetailsDTO;
import enums.InvoiceType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import panels.InvoicesReportPanel;
import utils.AlertUtils;
import utils.ApplicationUtils;

/**
 *
 * @author monieuzzaman
 */
public class InvoiceService extends DbConnector {

    private boolean isSave = false;
    private Logger log = Logger.getLogger(InvoiceService.class.getName());
    private InvoiceDetailsDTO invoiceDetailsDTO;

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

        for (InvoiceDetailsDTO invoice : invoiceDTO.getDetailsDTOs()) {
            String invoiceDetails = "UPDATE product_cetagory SET stock = stock + " + invoice.getQty() + " WHERE id =" + invoice.getProduct_id();
            log.info("Query:" + invoiceDetails);
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

    public List<InvoiceDTO> getInvoiceList() {
        List<InvoiceDTO> invoiceDTOs = new ArrayList<>();
        String query = "SELECT * FROM `invoice`";

        getQueryExecutor(query, new ReturnMySqlResponse() {
            @Override
            public void onGetResponse(ResultSet resultSet) {
                try {
                    while (resultSet.next()) {

                        InvoiceDTO invoiceDTO = new InvoiceDTO();
                        invoiceDTO.setInvoiceId(resultSet.getInt("invoice_no"));
                        invoiceDTO.setSupplierId(resultSet.getString("supplier_id"));
                        invoiceDTO.setSubTotal(Double.valueOf(resultSet.getInt("sub_total")));
                        invoiceDTO.setVet(Integer.valueOf(resultSet.getInt("vat_in_perchance")));
                        invoiceDTO.setTransportCost(Double.valueOf(resultSet.getInt("transport_cost")));
                        invoiceDTO.setDiscount(Integer.valueOf(resultSet.getInt("discount_in_perchance")));
                        invoiceDTO.setTotal(Double.valueOf(resultSet.getInt("total")));
                        invoiceDTO.setPaid(Double.valueOf(resultSet.getInt("paid")));
                        invoiceDTO.setDue(Double.valueOf(resultSet.getInt("due")));
                        invoiceDTO.setCreateBy(resultSet.getString("created_by"));
                        invoiceDTO.setCreateDate(resultSet.getString("creation_date_time"));
                        invoiceDTO.setIssueDateAndTime(resultSet.getString("issue_date_time"));
                        invoiceDTO.setInvoiceType(InvoiceType.valueOf(resultSet.getString("invoice_type")));

                        invoiceDTOs.add(invoiceDTO);

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(InvoiceService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void onError(String error) {
                AlertUtils.error(error);
            }
        });
        return invoiceDTOs;
    }

    public List<InvoiceDTO> getInvoiceListBySupplierId(int supplierId) {
        log.info("Invoice getting by " + supplierId);
        List<InvoiceDTO> invoiceDTOs = new ArrayList<>();
        String query = "SELECT * FROM `invoice` where `supplier_id` = '" + supplierId + "'";

        getQueryExecutor(query, new ReturnMySqlResponse() {
            @Override
            public void onGetResponse(ResultSet resultSet) {
                try {
                    while (resultSet.next()) {

                        InvoiceDTO invoiceDTO = new InvoiceDTO();
                        invoiceDTO.setInvoiceId(resultSet.getInt("invoice_no"));
                        invoiceDTO.setSupplierId(resultSet.getString("supplier_id"));
                        invoiceDTO.setSubTotal(Double.valueOf(resultSet.getInt("sub_total")));
                        invoiceDTO.setVet(Integer.valueOf(resultSet.getInt("vat_in_perchance")));
                        invoiceDTO.setTransportCost(Double.valueOf(resultSet.getInt("transport_cost")));
                        invoiceDTO.setDiscount(Integer.valueOf(resultSet.getInt("discount_in_perchance")));
                        invoiceDTO.setTotal(Double.valueOf(resultSet.getInt("total")));
                        invoiceDTO.setPaid(Double.valueOf(resultSet.getInt("paid")));
                        invoiceDTO.setDue(Double.valueOf(resultSet.getInt("due")));
                        invoiceDTO.setCreateBy(resultSet.getString("created_by"));
                        invoiceDTO.setCreateDate(resultSet.getString("creation_date_time"));
                        invoiceDTO.setIssueDateAndTime(resultSet.getString("issue_date_time"));
                        invoiceDTO.setInvoiceType(InvoiceType.valueOf(resultSet.getString("invoice_type")));

                        invoiceDTOs.add(invoiceDTO);

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(InvoiceService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void onError(String error) {
                AlertUtils.error(error);
            }
        });
        return invoiceDTOs;
    }

    public InvoiceDTO getInvoiceListByInvoiceNo(String invoiceNo) {
        log.info("Invoice getting by " + invoiceNo);
        InvoiceDTO invoiceDTO = new InvoiceDTO();
        String query = "SELECT * FROM `invoice` where `invoice_no` = '" + invoiceNo + "'";

        getQueryExecutor(query, new ReturnMySqlResponse() {
            @Override
            public void onGetResponse(ResultSet resultSet) {
                try {
                    while (resultSet.next()) {

                        invoiceDTO.setInvoiceId(resultSet.getInt("invoice_no"));
                        invoiceDTO.setSupplierId(resultSet.getString("supplier_id"));
                        invoiceDTO.setSubTotal(Double.valueOf(resultSet.getInt("sub_total")));
                        invoiceDTO.setVet(Integer.valueOf(resultSet.getInt("vat_in_perchance")));
                        invoiceDTO.setTransportCost(Double.valueOf(resultSet.getInt("transport_cost")));
                        invoiceDTO.setDiscount(Integer.valueOf(resultSet.getInt("discount_in_perchance")));
                        invoiceDTO.setTotal(Double.valueOf(resultSet.getInt("total")));
                        invoiceDTO.setPaid(Double.valueOf(resultSet.getInt("paid")));
                        invoiceDTO.setDue(Double.valueOf(resultSet.getInt("due")));
                        invoiceDTO.setCreateBy(resultSet.getString("created_by"));
                        invoiceDTO.setCreateDate(resultSet.getString("creation_date_time"));
                        invoiceDTO.setIssueDateAndTime(resultSet.getString("issue_date_time"));
                        invoiceDTO.setInvoiceType(InvoiceType.valueOf(resultSet.getString("invoice_type")));

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(InvoiceService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void onError(String error) {
                AlertUtils.error(error);
            }
        });
        return invoiceDTO;
    }

    public List<InvoiceDetailsDTO> getProductsListByInvoice(String invoiceNo) {
        log.info("Product List getting by invoice " + invoiceNo);
        List<InvoiceDetailsDTO> invoiceDetailsDTOs = new ArrayList<>();

        String query = "SELECT * FROM `invoice_details` WHERE `invoice_id`='" + invoiceNo + "'";

        getQueryExecutor(query, new ReturnMySqlResponse() {
            @Override
            public void onGetResponse(ResultSet resultSet) {
                try {
                    while (resultSet.next()) {

                        invoiceDetailsDTOs.add(new InvoiceDetailsDTO(
                                resultSet.getInt("id"),
                                resultSet.getDouble("price"),
                                resultSet.getInt("product_id"),
                                resultSet.getInt("qty"),
                                resultSet.getDouble("total"),
                                resultSet.getString("expire_date"),
                                resultSet.getString("product_location"),
                                resultSet.getInt("sell_discount_in_perchance"),
                                resultSet.getInt("invoice_id")
                        ));

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(InvoiceService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void onError(String error) {
                AlertUtils.error(error);
            }
        });

        log.info("Product List get from server " + invoiceDetailsDTOs);
        return invoiceDetailsDTOs;
    }

    public InvoiceDetailsDTO getProductById(String id) {
        
        log.info("Product List getting by details id " + id);
        String query = "SELECT * FROM `invoice_details` WHERE `id`='" + id + "'";

        getQueryExecutor(query, new ReturnMySqlResponse() {
            @Override
            public void onGetResponse(ResultSet resultSet) {
                try {
                    while (resultSet.next()) {

                        invoiceDetailsDTO = new InvoiceDetailsDTO(
                                resultSet.getInt("id"),
                                resultSet.getDouble("price"),
                                resultSet.getInt("product_id"),
                                resultSet.getInt("qty"),
                                resultSet.getDouble("total"),
                                resultSet.getString("expire_date"),
                                resultSet.getString("product_location"),
                                resultSet.getInt("sell_discount_in_perchance"),
                                resultSet.getInt("invoice_id")
                        );

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(InvoiceService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void onError(String error) {
                AlertUtils.error(error);
            }
        });

        log.info("Product List get from server " + invoiceDetailsDTO);
        return invoiceDetailsDTO;
    }
}
