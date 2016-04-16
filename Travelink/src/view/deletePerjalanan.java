/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;

/**
 *
 * @author 8.1
 */
public class deletePerjalanan extends javax.swing.JFrame {

    /**
     * Creates new form deletePerjalanan
     */
    public deletePerjalanan() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        baground = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDataPerjalanan = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txKeterangan = new javax.swing.JTextArea();
        btnDelete = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        baground.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("DELETE PERJALANAN");

        jLabel2.setText("Daftar Data Perjalanan");

        tbDataPerjalanan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id Perjalanan", "Paket Wisata"
            }
        ));
        jScrollPane1.setViewportView(tbDataPerjalanan);

        jLabel3.setText("Keterangan");

        txKeterangan.setColumns(20);
        txKeterangan.setRows(5);
        jScrollPane2.setViewportView(txKeterangan);

        btnDelete.setText("Delete");

        btnBack.setText("Back");

        javax.swing.GroupLayout bagroundLayout = new javax.swing.GroupLayout(baground);
        baground.setLayout(bagroundLayout);
        bagroundLayout.setHorizontalGroup(
            bagroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bagroundLayout.createSequentialGroup()
                .addGroup(bagroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bagroundLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(bagroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addGroup(bagroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnDelete))))
                    .addGroup(bagroundLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack)))
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(bagroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bagroundLayout.createSequentialGroup()
                    .addGap(162, 162, 162)
                    .addComponent(jLabel1)
                    .addContainerGap(205, Short.MAX_VALUE)))
        );
        bagroundLayout.setVerticalGroup(
            bagroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bagroundLayout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDelete)
                .addGap(18, 18, 18)
                .addComponent(btnBack)
                .addGap(14, 14, 14))
            .addGroup(bagroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(bagroundLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addContainerGap(296, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(baground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(baground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel baground;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbDataPerjalanan;
    private javax.swing.JTextArea txKeterangan;
    // End of variables declaration//GEN-END:variables
    public JPanel getBaground(){
        return baground;
    }
    public JButton getBtnDelete(){
        return btnDelete;
    }
    public JButton getBtnBack(){
        return btnBack;
    }
    public JTable getTableDataPerjalanan(){
        return tbDataPerjalanan;
    }
    public void setTextAreaKeterangan(String keterangan){
        txKeterangan.setText(keterangan);
    }
    public void addListener(ActionListener e){
        btnDelete.addActionListener(e);
        btnBack.addActionListener(e);
    }
    @Override
    public void addKeyListener(KeyListener e){
        btnDelete.addKeyListener(e);
        btnBack.addKeyListener(e);
    }
    public void showMessage(String message){
        JOptionPane.showMessageDialog(null, message);
    }
    
    
}
