/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.PaketWisata;
import model.Pelanggan;

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
        btnBack = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbPelanggan = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel1.setText("REGISTRASI PERJALANAN");

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        jLabel2.setText("Pilih paket wisata");

        cbPaketWisata.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        cbPaketWisata.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbPaketWisataItemStateChanged(evt);
            }
        });

        btnBack.setText("Back");

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        jLabel3.setText("Pilih pelanggan");

        tbPelanggan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "null", "ID", "Nama"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbPelanggan);
        if (tbPelanggan.getColumnModel().getColumnCount() > 0) {
            tbPelanggan.getColumnModel().getColumn(0).setPreferredWidth(25);
            tbPelanggan.getColumnModel().getColumn(0).setMaxWidth(25);
            tbPelanggan.getColumnModel().getColumn(1).setPreferredWidth(100);
            tbPelanggan.getColumnModel().getColumn(1).setMaxWidth(100);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnBack)
                            .addGap(268, 268, 268)
                            .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbPaketWisata, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(113, 113, 113))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addGap(0, 57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbPaketWisata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnSubmit))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbPaketWisataItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbPaketWisataItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbPaketWisataItemStateChanged

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSubmitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JComboBox<PaketWisata> cbPaketWisata;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbPelanggan;
    // End of variables declaration//GEN-END:variables
    public Object getComboBoxPaketWisata(){
        return cbPaketWisata;
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
    
    public void setCbPaketWisata(ArrayList<PaketWisata> listPaketWisata) {
        for (int i=0; i < listPaketWisata.size(); i++) {
            cbPaketWisata.addItem(listPaketWisata.get(i));
        }
    }
    
    public int getSelectedPaketWisata() {
        if (cbPaketWisata.getSelectedIndex() == -1) {
            throw new IllegalStateException("Pilih salah satu paket wisata");
        } else {
            return cbPaketWisata.getSelectedIndex();
        }
    }
    
    public void setTbPelanggan(ArrayList<Pelanggan> listPelanggan) {
        DefaultTableModel model = (DefaultTableModel) tbPelanggan.getModel();
        for(int i = 0; i < listPelanggan.size(); i++) {
            Pelanggan p = listPelanggan.get(i);
            model.addRow(new Object[]{false, p.getIdPelanggan(), p.getNama()});
        }
    }
        
    public boolean[] getListSelected() {
        boolean[] listSelected = new boolean[tbPelanggan.getModel().getRowCount()];
        for (int i = 0; i < tbPelanggan.getModel().getRowCount(); i++) {
            listSelected[i] = (boolean) tbPelanggan.getModel().getValueAt(i, 0);
        }
        return listSelected;
    }
}
