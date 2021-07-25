/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import Enums.InvoiceType;
import java.util.List;

/**
 *
 * @author moniruzzaman.rony
 */
public class InvoiceDTO {
    private int invoiceId;
    private String supplierId;
    private double subTotal;
    private int vet;
    private double transportCost;
    private int  discount;
    private double total;
    private double paid;
    private double due;
    private InvoiceType invoiceType;
    private String createBy;
    private String createDate;
    private String issueDateAndTime;
    
    private List<InvoiceDetailsDTO> detailsDTOs;

    public List<InvoiceDetailsDTO> getDetailsDTOs() {
        return detailsDTOs;
    }

    public void setDetailsDTOs(List<InvoiceDetailsDTO> detailsDTOs) {
        this.detailsDTOs = detailsDTOs;
    }
    

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public int getVet() {
        return vet;
    }

    public void setVet(int vet) {
        this.vet = vet;
    }

    public double getTransportCost() {
        return transportCost;
    }

    public void setTransportCost(double transportCost) {
        this.transportCost = transportCost;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getPaid() {
        return paid;
    }

    public void setPaid(double paid) {
        this.paid = paid;
    }

    public double getDue() {
        return due;
    }

    public void setDue(double due) {
        this.due = due;
    }

    public InvoiceType getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(InvoiceType invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getIssueDateAndTime() {
        return issueDateAndTime;
    }

    public void setIssueDateAndTime(String issueDateAndTime) {
        this.issueDateAndTime = issueDateAndTime;
    }

    @Override
    public String toString() {
        return "InvoiceDTO{" + "invoiceId=" + invoiceId + ", supplierId=" + supplierId + ", subTotal=" + subTotal + ", vet=" + vet + ", transportCost=" + transportCost + ", discount=" + discount + ", total=" + total + ", paid=" + paid + ", due=" + due + ", invoiceType=" + invoiceType + ", createBy=" + createBy + ", createDate=" + createDate + ", issueDateAndTime=" + issueDateAndTime + ", detailsDTOs=" + detailsDTOs + '}';
    }
    
    
    
}
