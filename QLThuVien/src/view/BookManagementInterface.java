/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.BooksController;
import controller.DataTable;
import dao.BookDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Book;

/**
 *
 * @author sanglv
 */
public class BookManagementInterface extends javax.swing.JFrame {
    BookDao daoBook = new BookDao();
    /**
     * Creates new form BookManagementInterface
     */
    public BookManagementInterface() {
        initComponents();
        showBooks();
        showWindow();
    }
    public void showBooks(){
        
        ((DefaultTableModel)listBooks.getModel()).setNumRows(0);
        ArrayList<Book> list = daoBook.getListBook();
        DefaultTableModel model = (DefaultTableModel) listBooks.getModel();
        Object[] row = new Object[8];
        for(int i = 0;i < list.size();i ++){
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getAuthor();
            row[3] = list.get(i).getPublishingCompany();
            row[4] = list.get(i).getPublishingDate();
            row[5] = list.get(i).getISBN();
            row[6] = list.get(i).getTotalQuantity();
            row[7] = list.get(i).getCurrentQuantity();
            model.addRow(row);
        } 
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        timkiemnangcao_btn = new javax.swing.JButton();
        themsach_btn = new javax.swing.JButton();
        xoacopy_btn = new javax.swing.JButton();
        themcopy_btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listBooks = new javax.swing.JTable();
        suattsach_btn = new javax.swing.JButton();
        suabansao_btn = new javax.swing.JButton();
        timkiem_btn = new javax.swing.JButton();
        timkiem_text = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        back_btn = new javax.swing.JButton();
        dangxuat_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setLocationByPlatform(true);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(51, 0, 0), null));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.setFocusable(false);
        jPanel2.setOpaque(false);

        timkiemnangcao_btn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        timkiemnangcao_btn.setText("Tìm kiếm nâng cao");
        timkiemnangcao_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timkiemnangcao_btnActionPerformed(evt);
            }
        });

        themsach_btn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        themsach_btn.setText("Thêm sách");
        themsach_btn.setToolTipText("");
        themsach_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        themsach_btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        themsach_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themsach_btnActionPerformed(evt);
            }
        });

        xoacopy_btn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        xoacopy_btn.setText("Xóa bản sao");
        xoacopy_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoacopy_btnActionPerformed(evt);
            }
        });

        themcopy_btn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        themcopy_btn.setText("Thêm bản sao");
        themcopy_btn.setFocusCycleRoot(true);
        themcopy_btn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        themcopy_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themcopy_btnActionPerformed(evt);
            }
        });

        listBooks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sách", "Tên", "Tác giả", "NXB", "Ngày xuất bản", "ISBN", "Tổng SL", "SL hiện tại"
            }
        ));
        jScrollPane1.setViewportView(listBooks);

        suattsach_btn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        suattsach_btn.setText("Sửa TT Sách");
        suattsach_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                suattsach_btnMouseClicked(evt);
            }
        });
        suattsach_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suattsach_btnActionPerformed(evt);
            }
        });

        suabansao_btn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        suabansao_btn.setText("Sửa bản sao");
        suabansao_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                suabansao_btnMouseClicked(evt);
            }
        });
        suabansao_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suabansao_btnActionPerformed(evt);
            }
        });

        timkiem_btn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        timkiem_btn.setText("Tìm kiếm");
        timkiem_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timkiem_btnActionPerformed(evt);
            }
        });

        timkiem_text.setEditable(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(themsach_btn)
                                .addGap(18, 18, 18)
                                .addComponent(suattsach_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(themcopy_btn)
                                .addGap(18, 18, 18)
                                .addComponent(xoacopy_btn)
                                .addGap(18, 18, 18)
                                .addComponent(suabansao_btn))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(timkiem_text, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(timkiem_btn)
                                .addGap(38, 38, 38)
                                .addComponent(timkiemnangcao_btn)))
                        .addGap(0, 441, Short.MAX_VALUE)))
                .addGap(43, 43, 43))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(timkiem_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(timkiemnangcao_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(timkiem_text, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(suattsach_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(themsach_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(xoacopy_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(themcopy_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(suabansao_btn)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Trang Quản Lý Sách & Copy");

        back_btn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        back_btn.setText("Back");
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });

        dangxuat_btn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        dangxuat_btn.setText("Đăng xuất");
        dangxuat_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dangxuat_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(back_btn)
                        .addGap(304, 304, 304)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dangxuat_btn))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(back_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dangxuat_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void timkiem_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timkiem_btnActionPerformed
        DataTable dt = new DataTable();
        dt.findBook(listBooks, timkiem_text.getText());
    }//GEN-LAST:event_timkiem_btnActionPerformed

    private void suabansao_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suabansao_btnActionPerformed
        EditCopyForm editCopy = new EditCopyForm();
        editCopy.setVisible(true);

    }//GEN-LAST:event_suabansao_btnActionPerformed

    private void suabansao_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suabansao_btnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_suabansao_btnMouseClicked

    private void suattsach_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suattsach_btnActionPerformed
        EditBookForm editBook = new EditBookForm();
        editBook.setVisible(true);
    }//GEN-LAST:event_suattsach_btnActionPerformed

    private void suattsach_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suattsach_btnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_suattsach_btnMouseClicked

    private void themcopy_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themcopy_btnActionPerformed
        AddCopyForm addCopy = new AddCopyForm();
        addCopy.setVisible(true);
    }//GEN-LAST:event_themcopy_btnActionPerformed

    private void xoacopy_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoacopy_btnActionPerformed
        DeleteCopyForm deleteCopy =  new DeleteCopyForm();
        deleteCopy.setVisible(true);
    }//GEN-LAST:event_xoacopy_btnActionPerformed

    private void themsach_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themsach_btnActionPerformed
       AddBookForm addBook = new AddBookForm();
       addBook.setVisible(true);

    }//GEN-LAST:event_themsach_btnActionPerformed

    private void timkiemnangcao_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timkiemnangcao_btnActionPerformed
        SearchBookAdvancedForm searchBookAdvaced =new SearchBookAdvancedForm();
        searchBookAdvaced.setVisible(true);
    }//GEN-LAST:event_timkiemnangcao_btnActionPerformed

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
        LibrarianMenuInterface view = new LibrarianMenuInterface(LibrarianMenuInterface.LibrarianId);
        this.dispose();
    }//GEN-LAST:event_back_btnActionPerformed

    private void dangxuat_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dangxuat_btnActionPerformed
        LoginForm form = new LoginForm();
        this.dispose();
    }//GEN-LAST:event_dangxuat_btnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BookManagementInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookManagementInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookManagementInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookManagementInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookManagementInterface().setVisible(true);
            }
        });
    }

    public void showWindow(){
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_btn;
    private javax.swing.JButton dangxuat_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listBooks;
    private javax.swing.JButton suabansao_btn;
    private javax.swing.JButton suattsach_btn;
    private javax.swing.JButton themcopy_btn;
    private javax.swing.JButton themsach_btn;
    private javax.swing.JButton timkiem_btn;
    private javax.swing.JTextField timkiem_text;
    private javax.swing.JButton timkiemnangcao_btn;
    private javax.swing.JButton xoacopy_btn;
    // End of variables declaration//GEN-END:variables
}
