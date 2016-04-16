/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;

/**
 *
 * @author 8.1
 */
public class RegistrasiPerjalanan extends javax.swing.JFrame implements View {

    /**
     * Creates new form registrasiPerjalanan
     */
    public RegistrasiPerjalanan() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbPaketWisata = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txKeterangan = new javax.swing.JTextArea();
        btnSubmit = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel1.setText("REGISTRASI PERJALANAN");

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jLabel2.setText("Pilih Paket Wisata");

        cbPaketWisata.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        cbPaketWisata.setMaximumRowCount(5);
        cbPaketWisata.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Paket Wisata 1", "Paket Wisata 2", "Paket Wisata 3", "Paket Wisata 4", "Paket Wisata 5", "Paket Wisata 6", "Paket Wisata 7", "Paket Wisata 8", "paket Wisata 9", "Paket Wisata 10" }));
        cbPaketWisata.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbPaketWisataItemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jLabel3.setText("Keterangan");

        txKeterangan.setEditable(false);
        txKeterangan.setColumns(20);
        txKeterangan.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        txKeterangan.setRows(5);
        jScrollPane1.setViewportView(txKeterangan);

        btnSubmit.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        btnSubmit.setText("Next >>");

        btnBack.setText("Back");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(cbPaketWisata, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnSubmit))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jLabel1))
                    .addComponent(btnBack))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbPaketWisata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSubmit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(btnBack))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbPaketWisataItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbPaketWisataItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbPaketWisataItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JComboBox<String> cbPaketWisata;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txKeterangan;
    // End of variables declaration//GEN-END:variables
    public Object getComboBoxPaketWisata(){
        return cbPaketWisata;
    }
    public void setKeterangan(String keterangan){
        txKeterangan.setText(keterangan);
    }
    public Object getBtnSubmit(){
        return btnSubmit;
    }
    public Object getBtnBack() {
        return btnBack;
    }
    @Override
    public void addListener(ActionListener e){
        cbPaketWisata.addActionListener(e);
        btnSubmit.addActionListener(e);
        btnBack.addActionListener(e);
    }
    public void addKeyistener(KeyListener e){
        cbPaketWisata.addKeyListener(e);
        btnSubmit.addKeyListener(e);
        btnBack.addKeyListener(e);
    }
    public void showMessage(String message){
        JOptionPane.showMessageDialog(null, message);
    }
    
}
