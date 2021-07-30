/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panels;

import dto.CardProductDTO;
import dto.InvoiceDetailsDTO;
import dto.ProductCetagoryDTO;
import frames.AddNewSupplierFormFrame;
import frames.ProductDetailsFrame;
import java.awt.Font;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import services.CustomerService;
import services.InvoiceService;
import services.ProductCetagotyService;
import services.ProductsService;

/**
 *
 * @author monieuzzaman
 */
public class MyProductsPanel extends javax.swing.JPanel {

    private CustomerService customerService;
    private ProductCetagotyService cetagotyService;
    private ProductsService productsService;
    private InvoiceService invoiceService;
    private Logger log = Logger.getLogger(MyProductsPanel.class.getName());

    public MyProductsPanel() {
        initComponents();

        // Object Create
        customerService = new CustomerService();
        cetagotyService = new ProductCetagotyService();
        invoiceService = new InvoiceService();
        productsService = new ProductsService();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        actionTypeComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        productsTable = new javax.swing.JTable();

        actionTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "My Stock", "Today Expired Products", "Few Stocks ", "Product Location" }));
        actionTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionTypeComboBoxActionPerformed(evt);
            }
        });

        productsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        productsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productsTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(productsTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(actionTypeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 987, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(actionTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void actionTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionTypeComboBoxActionPerformed
        switch (actionTypeComboBox.getSelectedIndex()) {
            case 0:
                getAllProductsList();
                break;
            case 1:
                getTodayExpiredProductsList();
                break;
            case 2:
                getFewStockProductsList();
                break;
            case 3:
                getProductsLocationList();
                break;
        }
    }//GEN-LAST:event_actionTypeComboBoxActionPerformed

    private void productsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productsTableMouseClicked
        JTable source = (JTable) evt.getSource();
        int row = source.rowAtPoint(evt.getPoint());
        int column = 0;
        String productId = source.getModel().getValueAt(row, column) + "";

        log.info(productId + "Clicked");
        JFrame frame = new ProductDetailsFrame(productId);
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        frame.show();
    }//GEN-LAST:event_productsTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> actionTypeComboBox;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable productsTable;
    // End of variables declaration//GEN-END:variables

    private void getAllProductsList() {
        DefaultTableModel mobileRechargeDetailsInMobileRechargePanel = new DefaultTableModel(new String[]{"Id", "Product Name", "Cetagory", "Brand", "Stock"}, 0);

        for (ProductCetagoryDTO cetagoryDTO : cetagotyService.getAll()) {
            mobileRechargeDetailsInMobileRechargePanel.addRow(new Object[]{
                cetagoryDTO.getId(),
                cetagoryDTO.getName(),
                cetagoryDTO.getCetagoty(),
                cetagoryDTO.getBrand(),
                cetagoryDTO.getStock(),});
        }

        productsTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        productsTable.getTableHeader().setOpaque(false);

        //For jTable contant in center
        DefaultTableCellRenderer stringRenderer = (DefaultTableCellRenderer) productsTable.getDefaultRenderer(String.class);
        stringRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        productsTable.setEnabled(false);
        productsTable.setRowHeight(35);
        productsTable.setModel(mobileRechargeDetailsInMobileRechargePanel);

    }

    private void getTodayExpiredProductsList() {
        List<InvoiceDetailsDTO> invoiceDetailsDTOs = invoiceService.getTodayExpiredProductsList("12-12-12");

        DefaultTableModel invoiceTableModel = new DefaultTableModel(new String[]{"Product Code", "Cetagory", "Product Name", "Price", "Exp Date", "Product Location"}, 0);

        for (InvoiceDetailsDTO invoiceDetailsDTO : invoiceDetailsDTOs) {
            ProductCetagoryDTO productCetagoryDTO = cetagotyService.getByProductId(invoiceDetailsDTO.getProduct_id());

            invoiceTableModel.addRow(new Object[]{
                invoiceDetailsDTO.getId(),
                productCetagoryDTO.getCetagoty(),
                productCetagoryDTO.getName(),
                invoiceDetailsDTO.getPrice(),
                invoiceDetailsDTO.getExpireDate(),
                invoiceDetailsDTO.getProductLocation()

            });
        }

        productsTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        productsTable.getTableHeader().setOpaque(false);

        //For jTable contant in center
        DefaultTableCellRenderer stringRenderer = (DefaultTableCellRenderer) productsTable.getDefaultRenderer(String.class);
        stringRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        productsTable.setEnabled(false);
        productsTable.setRowHeight(35);
        productsTable.setModel(invoiceTableModel);
    }

    private void getFewStockProductsList() {
        DefaultTableModel mobileRechargeDetailsInMobileRechargePanel = new DefaultTableModel(new String[]{"Id", "Product Name", "Cetagory", "Brand", "Stock"}, 0);

        for (ProductCetagoryDTO cetagoryDTO : cetagotyService.getAllUbderByStock(5)) {
            mobileRechargeDetailsInMobileRechargePanel.addRow(new Object[]{
                cetagoryDTO.getId(),
                cetagoryDTO.getName(),
                cetagoryDTO.getCetagoty(),
                cetagoryDTO.getBrand(),
                cetagoryDTO.getStock(),});
        }

        productsTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        productsTable.getTableHeader().setOpaque(false);

        //For jTable contant in center
        DefaultTableCellRenderer stringRenderer = (DefaultTableCellRenderer) productsTable.getDefaultRenderer(String.class);
        stringRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        productsTable.setEnabled(false);
        productsTable.setRowHeight(35);
        productsTable.setModel(mobileRechargeDetailsInMobileRechargePanel);
    }


    private void getProductsLocationList() {
      List<InvoiceDetailsDTO> invoiceDetailsDTOs = invoiceService.getAllProductDetails();

        DefaultTableModel invoiceTableModel = new DefaultTableModel(new String[]{"Product Code", "Product Name", "Price", "Product Location"}, 0);

        for (InvoiceDetailsDTO invoiceDetailsDTO : invoiceDetailsDTOs) {
            ProductCetagoryDTO productCetagoryDTO = cetagotyService.getByProductId(invoiceDetailsDTO.getProduct_id());

            invoiceTableModel.addRow(new Object[]{
                invoiceDetailsDTO.getId(),
                productCetagoryDTO.getName(),
                invoiceDetailsDTO.getPrice(),
                invoiceDetailsDTO.getProductLocation()

            });
        }

        productsTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        productsTable.getTableHeader().setOpaque(false);

        //For jTable contant in center
        DefaultTableCellRenderer stringRenderer = (DefaultTableCellRenderer) productsTable.getDefaultRenderer(String.class);
        stringRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        productsTable.setEnabled(false);
        productsTable.setRowHeight(35);
        productsTable.setModel(invoiceTableModel);   
    }
}
