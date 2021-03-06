/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panels;

import java.awt.BorderLayout;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author moniruzzaman.rony
 */
public class DeshboardPanel extends javax.swing.JPanel {

    /**
     * Creates new form DeshboardPanel
     */
    public DeshboardPanel() {
        initComponents();
        createPieChatProducts();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        sellPiChat = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();

        jPanel1.setBackground(new java.awt.Color(137, 180, 223));
        jPanel1.setLayout(new java.awt.GridLayout());

        sellPiChat.setBackground(new java.awt.Color(175, 200, 225));

        javax.swing.GroupLayout sellPiChatLayout = new javax.swing.GroupLayout(sellPiChat);
        sellPiChat.setLayout(sellPiChatLayout);
        sellPiChatLayout.setHorizontalGroup(
            sellPiChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 534, Short.MAX_VALUE)
        );
        sellPiChatLayout.setVerticalGroup(
            sellPiChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 341, Short.MAX_VALUE)
        );

        jPanel1.add(sellPiChat);

        jPanel4.setBackground(new java.awt.Color(170, 202, 235));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 534, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 341, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4);

        jPanel2.setBackground(new java.awt.Color(135, 145, 5));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel sellPiChat;
    // End of variables declaration//GEN-END:variables

    private void createPieChatProducts() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("IPhone 5s", new Double(20));
        dataset.setValue("SamSung Grand", new Double(20));
        dataset.setValue("MotoG", new Double(40));
        dataset.setValue("Nokia Lumia1", new Double(10));
        dataset.setValue("Nokia Lumia2", new Double(10));
        dataset.setValue("Nokia Lumia3", new Double(10));
        dataset.setValue("Nokia Lumia4", new Double(10));
        dataset.setValue("Nokia Lumia5", new Double(10));
        dataset.setValue("Nokia Lumia6", new Double(10));

        JFreeChart chart = ChartFactory.createPieChart(
                "Mobile Sales", // chart title 
                dataset, // data    
                true, // include legend   
                true,
                false);

        ChartPanel myChart = new ChartPanel(chart);
        myChart.setMouseWheelEnabled(true);
        sellPiChat.setLayout(new java.awt.BorderLayout());
        sellPiChat.add(myChart, BorderLayout.CENTER);
        sellPiChat.validate();

    }
}
