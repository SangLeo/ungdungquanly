/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.BorrowBookController;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Book;
import model.Copy;
import model.ItemStatus;
import model.OrderBook;
import model.OrderBookItem;
import model.OrderStatus;

/**
 *
 * @author Quang
 */
public class OrderBookManagementInterface extends javax.swing.JFrame {
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    Calendar c = Calendar.getInstance(); 
    BorrowBookController borrowBookController = new BorrowBookController();
    /**
     * Creates new form OrderBookManagementInterface
     */
    public OrderBookManagementInterface() {
        initComponents();
        showWindow();
        loadTableMuonTra(borrowBookController.getAllOrderBook(OrderStatus.ordering));
        loadTableMuonTra1(borrowBookController.getAllOrderBook(OrderStatus.borrowing));
        loadTableMuonTra2(borrowBookController.getAllOrderBook(OrderStatus.complete));
    }
    
    private void loadTableMuonTra( ArrayList<OrderBook> orderList) {
        DefaultTableModel model = (DefaultTableModel) muontra_table.getModel();
        for(OrderBook order : orderList){
            try {
                if(order.getDate() == null){
                       model.addRow(new Object[]{order.getId(),order.getIdBorrower(),"","",order.getDeposits(),order.getStatus().name()});
                }else if(order.getDate().equals("")){
                    model.addRow(new Object[]{order.getId(),order.getIdBorrower(),order.getDate(),"",order.getDeposits(),order.getStatus().name()});
                }else{
                    c.setTime(dateFormat.parse(order.getDate()));
                    c.add(Calendar.MONTH,2);
                     model.addRow(new Object[]{order.getId(),order.getIdBorrower(),order.getDate(),dateFormat.format(c.getTime()),order.getDeposits(),order.getStatus().name()});
                }
                
            } catch (ParseException ex) {
                Logger.getLogger(OrderBookManagementInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }
    
    private void loadTableMuonTra1( ArrayList<OrderBook> orderList) {
        DefaultTableModel model = (DefaultTableModel) muontra_table1.getModel();
        for(OrderBook order : orderList){
            try {
                if(order.getDate() == null){
                       model.addRow(new Object[]{order.getId(),order.getIdBorrower(),"","",order.getDeposits(),order.getStatus().name()});
                }else if(order.getDate().equals("")){
                    model.addRow(new Object[]{order.getId(),order.getIdBorrower(),order.getDate(),"",order.getDeposits(),order.getStatus().name()});
                }else{
                    c.setTime(dateFormat.parse(order.getDate()));
                    c.add(Calendar.MONTH,2);
                     model.addRow(new Object[]{order.getId(),order.getIdBorrower(),order.getDate(),dateFormat.format(c.getTime()),order.getDeposits(),order.getStatus().name()});
                }
                
            } catch (ParseException ex) {
                Logger.getLogger(OrderBookManagementInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }
    
    private void loadTableMuonTra2( ArrayList<OrderBook> orderList) {
        DefaultTableModel model = (DefaultTableModel) muontra_table2.getModel();
        for(OrderBook order : orderList){
            if(order.getDate() == null){
                model.addRow(new Object[]{order.getId(),order.getIdBorrower(),"",order.getDeposits(),order.getStatus().name()});
            }else{
                model.addRow(new Object[]{order.getId(),order.getIdBorrower(),order.getDate(),order.getDeposits(),order.getStatus().name()});
            }
        } 
    }
    
    private void loadTableMuonTraCT(ArrayList<OrderBookItem> itemList) {
        DefaultTableModel model = (DefaultTableModel) muontract_table.getModel();
        model.setRowCount(0);
        for(OrderBookItem item : itemList){
            model.addRow(new Object[]{item.getId(),item.getIdBook(),item.getIdCopy(),item.getDateOrder(),item.getDateReturn(),item.getStatus().name()});
        }     
    }
    
    private void loadTableMuonTraCT1(ArrayList<OrderBookItem> itemList) {
        DefaultTableModel model = (DefaultTableModel) muontract_table1.getModel();
        model.setRowCount(0);
        for(OrderBookItem item : itemList){
            model.addRow(new Object[]{item.getId(),item.getIdBook(),item.getIdCopy(),item.getDateOrder(),item.getDateReturn(),item.getStatus().name()});
        }     
    }
    
    private void loadTableMuonTraCT2(ArrayList<OrderBookItem> itemList) {
        DefaultTableModel model = (DefaultTableModel) muontract_table2.getModel();
        model.setRowCount(0);
        for(OrderBookItem item : itemList){
            model.addRow(new Object[]{item.getId(),item.getIdBook(),item.getIdCopy(),item.getDateOrder(),item.getDateReturn(),item.getStatus().name()});
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        muontra_table = new javax.swing.JTable();
        timkiem_button = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        textBorrowerCardID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        textTienNop = new javax.swing.JTextField();
        btnUpdateOrder = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        muontract_table = new javax.swing.JTable();
        textCopyId = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnMuon = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        btnKhoiPhuc = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        back_btn = new javax.swing.JButton();
        dangxuat_btn = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        muontra_table1 = new javax.swing.JTable();
        timkiem_button1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        textBorrowerCardID1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        textTienNop1 = new javax.swing.JTextField();
        btnUpdateOrder1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        muontract_table1 = new javax.swing.JTable();
        btnTra = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        muontra_table2 = new javax.swing.JTable();
        timkiem_button2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        textBorrowerCardID2 = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        muontract_table2 = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Trang quản lý mượn ");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(340, 10, 258, 42);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Danh sách mượn trả", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 20), new java.awt.Color(204, 0, 0))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(204, 0, 0));
        jPanel2.setOpaque(false);

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseReleased(evt);
            }
        });

        muontra_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã mượn trả", "Mã độc giả", "Ngày đặt", "Ngày hẹn trả", "Tiền cọc", "Trạng thái"
            }
        ));
        muontra_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                muontra_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(muontra_table);

        timkiem_button.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        timkiem_button.setText("Tìm kiếm ");
        timkiem_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                timkiem_buttonMouseReleased(evt);
            }
        });
        timkiem_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timkiem_buttonActionPerformed(evt);
            }
        });

        jLabel2.setText("Nhập mã thẻ người mượn:");

        jLabel4.setText("Tiền cọc");

        btnUpdateOrder.setText("Xác nhận mượn");
        btnUpdateOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateOrderMouseClicked(evt);
            }
        });
        btnUpdateOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateOrderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(textBorrowerCardID, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(timkiem_button)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUpdateOrder)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(33, 33, 33)
                        .addComponent(textTienNop, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(434, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textBorrowerCardID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timkiem_button))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textTienNop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(btnUpdateOrder)
                .addGap(55, 55, 55))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(12, 82, 690, 500);
        jPanel2.getAccessibleContext().setAccessibleName("Danh sách mượn ");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Mượn trả chi tiết", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 20), new java.awt.Color(255, 102, 102))); // NOI18N
        jPanel3.setOpaque(false);

        muontract_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Mã sách", "Mã copy", "Ngày mượn", "Ngày trả", "Trạng thái"
            }
        ));
        muontract_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                muontract_tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(muontract_table);

        jLabel6.setText("Mã copy");

        btnMuon.setText("Xác nhận mượn");
        btnMuon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMuonMouseClicked(evt);
            }
        });

        btnHuy.setText("Hủy item");
        btnHuy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHuyMouseClicked(evt);
            }
        });

        btnKhoiPhuc.setText("Khôi phục item");
        btnKhoiPhuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnKhoiPhucMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnMuon)
                                .addGap(39, 39, 39)
                                .addComponent(btnHuy)
                                .addGap(33, 33, 33)
                                .addComponent(btnKhoiPhuc))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textCopyId, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 178, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textCopyId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMuon)
                    .addComponent(btnHuy)
                    .addComponent(btnKhoiPhuc))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(710, 140, 570, 440);
        jPanel1.add(jLabel14);
        jLabel14.setBounds(0, 0, 0, 0);

        back_btn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        back_btn.setText("Back");
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });
        jPanel1.add(back_btn);
        back_btn.setBounds(0, 0, 77, 31);

        dangxuat_btn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        dangxuat_btn.setText("Đăng xuất");
        dangxuat_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dangxuat_btnActionPerformed(evt);
            }
        });
        jPanel1.add(dangxuat_btn);
        dangxuat_btn.setBounds(1160, 0, 127, 31);

        jTabbedPane1.addTab("Quản lý mượn", jPanel1);

        jPanel4.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 51, 51));
        jLabel7.setText("Trang quản lý trả");
        jPanel4.add(jLabel7);
        jLabel7.setBounds(340, 10, 215, 42);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Danh sách mượn trả", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 20), new java.awt.Color(204, 0, 0))); // NOI18N
        jPanel5.setForeground(new java.awt.Color(204, 0, 0));
        jPanel5.setOpaque(false);

        jScrollPane3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jScrollPane3MouseReleased(evt);
            }
        });

        muontra_table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã mượn trả", "Mã độc giả", "Ngày mượn", "Ngày hẹn trả", "Tiền cọc", "Trạng thái"
            }
        ));
        muontra_table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                muontra_table1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(muontra_table1);

        timkiem_button1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        timkiem_button1.setText("Tìm kiếm ");
        timkiem_button1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                timkiem_button1MouseReleased(evt);
            }
        });

        jLabel8.setText("Nhập mã thẻ người mượn:");

        jLabel10.setText("Tiền phạt");

        btnUpdateOrder1.setText("Xác nhận đã trả");
        btnUpdateOrder1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateOrder1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(textBorrowerCardID1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(timkiem_button1)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUpdateOrder1)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(27, 27, 27)
                        .addComponent(textTienNop1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(76, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textBorrowerCardID1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timkiem_button1))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(textTienNop1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnUpdateOrder1)
                .addGap(55, 55, 55))
        );

        jPanel4.add(jPanel5);
        jPanel5.setBounds(12, 82, 690, 500);
        jPanel5.getAccessibleContext().setAccessibleName("Danh sách  trả");

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Mượn trả chi tiết", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 20), new java.awt.Color(255, 102, 102))); // NOI18N
        jPanel6.setOpaque(false);

        muontract_table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Mã sách", "Mã copy", "Ngày mượn", "Ngày trả", "Trạng thái"
            }
        ));
        muontract_table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                muontract_table1MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(muontract_table1);

        btnTra.setText("Xác nhận trả");
        btnTra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTraMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnTra)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(btnTra)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel6);
        jPanel6.setBounds(710, 140, 570, 440);
        jPanel4.add(jLabel15);
        jLabel15.setBounds(0, 0, 0, 0);

        jTabbedPane1.addTab("Quản lý trả", jPanel4);

        jPanel7.setLayout(null);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 51, 51));
        jLabel9.setText("Lịch sử mượn trả");
        jPanel7.add(jLabel9);
        jLabel9.setBounds(340, 10, 210, 42);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Danh sách mượn trả", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 20), new java.awt.Color(204, 0, 0))); // NOI18N
        jPanel8.setForeground(new java.awt.Color(204, 0, 0));
        jPanel8.setOpaque(false);

        jScrollPane5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jScrollPane5MouseReleased(evt);
            }
        });

        muontra_table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã mượn trả", "Mã độc giả", "Ngày mượn", "Tiền phạt", "Trạng thái"
            }
        ));
        muontra_table2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                muontra_table2MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(muontra_table2);

        timkiem_button2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        timkiem_button2.setText("Tìm kiếm ");
        timkiem_button2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                timkiem_button2MouseReleased(evt);
            }
        });

        jLabel11.setText("Nhập mã thẻ người mượn:");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(textBorrowerCardID2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(timkiem_button2)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(76, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textBorrowerCardID2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timkiem_button2))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(158, 158, 158))
        );

        jPanel7.add(jPanel8);
        jPanel8.setBounds(12, 82, 690, 500);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Mượn trả chi tiết", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 20), new java.awt.Color(255, 102, 102))); // NOI18N
        jPanel9.setOpaque(false);

        muontract_table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Mã sách", "Mã copy", "Ngày mượn", "Ngày trả", "Trạng thái"
            }
        ));
        muontract_table2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                muontract_table2MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(muontract_table2);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(158, Short.MAX_VALUE))
        );

        jPanel7.add(jPanel9);
        jPanel9.setBounds(710, 140, 570, 440);
        jPanel7.add(jLabel16);
        jLabel16.setBounds(0, 0, 0, 0);

        jTabbedPane1.addTab("Lịch sử mượn trả", jPanel7);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1290, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE)
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Quản lý mượn");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTraMouseClicked
        if(item == null){
            JOptionPane.showMessageDialog(null, "Chọn item bạn muốn thao tác");
        }else{
            if(item.getStatus() == ItemStatus.returned){
                JOptionPane.showMessageDialog(null, "Không thể thực hiện yêu cầu với item đã được trả");
            }else{
                DefaultTableModel modelMTCT = (DefaultTableModel) muontract_table1.getModel();
                borrowBookController.confirmReturnItem(item);
                JOptionPane.showMessageDialog(null, "Xác nhận trả item thành công");
                modelMTCT.setRowCount(0);
                OrderBook order = new OrderBook();
                order.setId(item.getIdOrder());
                loadTableMuonTraCT1(borrowBookController.getAllItemOfOrder(order));
                item = null;
            }
        }
    }//GEN-LAST:event_btnTraMouseClicked

    private void muontract_table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_muontract_table1MouseClicked
        DefaultTableModel modelMuonTra = (DefaultTableModel) muontra_table1.getModel();
        int m = muontra_table1.getSelectedRow();
        if(!(m>=0)){
            JOptionPane.showMessageDialog(null, "Chưa lựa chọn order");
        }else{
            DefaultTableModel modelMTCT = (DefaultTableModel) muontract_table1.getModel();
            int n = muontract_table1.getSelectedRow();
            item = new OrderBookItem();
            item.setId(Integer.parseInt(modelMTCT.getValueAt(n,0).toString()));
            item.setIdOrder(Integer.parseInt(modelMuonTra.getValueAt(m,0).toString()));
            item.setIdBook(modelMTCT.getValueAt(n, 1).toString());
            item.setStatus(ItemStatus.valueOf(modelMTCT.getValueAt(n, 5).toString()));
            if(modelMTCT.getValueAt(n, 2) != null){
                item.setIdCopy(modelMTCT.getValueAt(n, 2).toString());
            }

            if(modelMTCT.getValueAt(n, 3) != null){
                item.setDateOrder(modelMTCT.getValueAt(n, 3).toString());
            }

            if(modelMTCT.getValueAt(n, 4) != null){
                item.setDateReturn(modelMTCT.getValueAt(n, 4).toString());
            }
        }
    }//GEN-LAST:event_muontract_table1MouseClicked

    private void btnUpdateOrder1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateOrder1MouseClicked
        DefaultTableModel model = (DefaultTableModel) muontra_table1.getModel();
        int i = muontra_table1.getSelectedRow();
        if(i >= 0){
            OrderBook order = new OrderBook(Integer.parseInt(model.getValueAt(i,0).toString()),Integer.parseInt(model.getValueAt(i,1).toString()) , model.getValueAt(i,2).toString(),Integer.parseInt(model.getValueAt(i,4).toString()), OrderStatus.valueOf(model.getValueAt(i,5).toString()));
            if(textTienNop1.getText().equals("")){
                order.setDeposits(0);
            }else{
                order.setDeposits(Integer.parseInt(textTienNop1.getText()));
            }
            Date date = new Date();
            order.setDate(dateFormat.format(date));
            JOptionPane.showMessageDialog(null,borrowBookController.confirmOrderToComplete(order) );
            if(textBorrowerCardID.getText().equals("")){
                model.setRowCount(0);
                loadTableMuonTra1(borrowBookController.getAllOrderBook(OrderStatus.borrowing));
            }else{
                model.setRowCount(0);
                loadTableMuonTra1(borrowBookController.getOrderByCardNumber(Integer.parseInt(textBorrowerCardID.getText()),OrderStatus.borrowing));
            }
            DefaultTableModel model1 = (DefaultTableModel) muontract_table1.getModel();
            model1.setRowCount(0);
            DefaultTableModel model2 = (DefaultTableModel) muontra_table2.getModel();
            model2.setRowCount(0);
            loadTableMuonTra2(borrowBookController.getAllOrderBook(OrderStatus.complete));
        }else{
            JOptionPane.showMessageDialog(null, "Lựa chọn order bạn muốn xác nhận hoàn thành");

        }
    }//GEN-LAST:event_btnUpdateOrder1MouseClicked

    private void timkiem_button1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_timkiem_button1MouseReleased
        DefaultTableModel model = (DefaultTableModel) muontra_table1.getModel();
        model.setRowCount(0);
        if(textBorrowerCardID1.getText().equals("")){
            loadTableMuonTra1(borrowBookController.getAllOrderBook(OrderStatus.borrowing));
        }else{
            try {
                int idCard = Integer.parseInt(textBorrowerCardID1.getText());
                System.out.println(idCard);
                ArrayList<OrderBook>orderList = borrowBookController.getOrderByCardNumber(idCard,OrderStatus.borrowing);
                loadTableMuonTra1(orderList);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Mã người mượn chỉ gồm các ký tự số");
            }
        }
    }//GEN-LAST:event_timkiem_button1MouseReleased

    private void jScrollPane3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane3MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane3MouseReleased

    private void muontra_table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_muontra_table1MouseClicked

        DefaultTableModel model = (DefaultTableModel) muontra_table1.getModel();
        int i = muontra_table1.getSelectedRow();
        OrderBook order = new OrderBook(Integer.parseInt(model.getValueAt(i,0).toString()),Integer.parseInt(model.getValueAt(i,1).toString()) , model.getValueAt(i,2).toString(),Integer.parseInt(model.getValueAt(i,4).toString()), OrderStatus.valueOf(model.getValueAt(i,5).toString()));
        loadTableMuonTraCT1(borrowBookController.getAllItemOfOrder(order));
    }//GEN-LAST:event_muontra_table1MouseClicked

    private void btnKhoiPhucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKhoiPhucMouseClicked
        if(item == null){
            JOptionPane.showMessageDialog(null, "Chọn item bạn muốn thao tác");
        }else{
            if(item.getStatus() != ItemStatus.cancel){
                JOptionPane.showMessageDialog(null, "Chỉ có thể khôi phục các item đã bị hủy");
            }else{
                DefaultTableModel modelMTCT = (DefaultTableModel) muontract_table.getModel();
                item.setStatus(ItemStatus.ordered);
                item.updateOrderItem(item);
                modelMTCT.setRowCount(0);
                OrderBook order = new OrderBook();
                order.setId(item.getIdOrder());
                loadTableMuonTraCT(borrowBookController.getAllItemOfOrder(order));
                item= null;
            }
        }
    }//GEN-LAST:event_btnKhoiPhucMouseClicked

    private void btnHuyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHuyMouseClicked
        if(item == null){
            JOptionPane.showMessageDialog(null, "Chọn item bạn muốn thao tác");
        }else{
            if(item.getStatus() != ItemStatus.ordered){
                JOptionPane.showMessageDialog(null, "Không thể hủy item đã cho mượn");
            }else{
                DefaultTableModel modelMTCT = (DefaultTableModel) muontract_table.getModel();
                item.setStatus(ItemStatus.cancel);
                item.updateOrderItem(item);
                modelMTCT.setRowCount(0);
                OrderBook order = new OrderBook();
                order.setId(item.getIdOrder());
                loadTableMuonTraCT(borrowBookController.getAllItemOfOrder(order));
                item = null;
            }
        }
    }//GEN-LAST:event_btnHuyMouseClicked

    private void btnMuonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMuonMouseClicked
        if(item == null){
            JOptionPane.showMessageDialog(null, "Chọn item bạn muốn thao tác");
        }else{
            if(item.getStatus() == ItemStatus.borrowed){
                JOptionPane.showMessageDialog(null, "Không thể thực hiện thao tác với item đã cho mượn");
            }else{
                if(textCopyId.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Nhập vào mã copy cho mượn");
                }else{
                    DefaultTableModel modelMTCT = (DefaultTableModel) muontract_table.getModel();
                    JOptionPane.showMessageDialog(null, borrowBookController.confirmBorrowItem(item, textCopyId.getText()));
                    modelMTCT.setRowCount(0);
                    OrderBook order = new OrderBook();
                    order.setId(item.getIdOrder());
                    loadTableMuonTraCT(borrowBookController.getAllItemOfOrder(order));
                    item = null;
                }
            }
        }
    }//GEN-LAST:event_btnMuonMouseClicked

    private void muontract_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_muontract_tableMouseClicked
        DefaultTableModel modelMuonTra = (DefaultTableModel) muontra_table.getModel();
        int m = muontra_table.getSelectedRow();
        if(!(m>=0)){
            JOptionPane.showMessageDialog(null, "Chưa lựa chọn order");
        }else{
            DefaultTableModel modelMTCT = (DefaultTableModel) muontract_table.getModel();
            int n = muontract_table.getSelectedRow();
            item = new OrderBookItem();
            item.setId(Integer.parseInt(modelMTCT.getValueAt(n,0).toString()));
            item.setIdOrder(Integer.parseInt(modelMuonTra.getValueAt(m,0).toString()));
            item.setIdBook(modelMTCT.getValueAt(n, 1).toString());
            item.setStatus(ItemStatus.valueOf(modelMTCT.getValueAt(n, 5).toString()));
            if(modelMTCT.getValueAt(n, 2) != null){
                item.setIdCopy(modelMTCT.getValueAt(n, 2).toString());
            }

            if(modelMTCT.getValueAt(n, 3) != null){
                item.setDateOrder(modelMTCT.getValueAt(n, 3).toString());
            }

            if(modelMTCT.getValueAt(n, 4) != null){
                item.setDateReturn(modelMTCT.getValueAt(n, 4).toString());
            }

        }

    }//GEN-LAST:event_muontract_tableMouseClicked

    private void btnUpdateOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateOrderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateOrderActionPerformed

    private void btnUpdateOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateOrderMouseClicked
        DefaultTableModel model = (DefaultTableModel) muontra_table.getModel();
        int i = muontra_table.getSelectedRow();
        if(i >= 0){
            OrderBook order = new OrderBook(Integer.parseInt(model.getValueAt(i,0).toString()),Integer.parseInt(model.getValueAt(i,1).toString()) , model.getValueAt(i,2).toString(),Integer.parseInt(model.getValueAt(i,4).toString()), OrderStatus.valueOf(model.getValueAt(i,5).toString()));
            order.setDeposits(Integer.parseInt(textTienNop.getText()));
            Date date = new Date();
            order.setDate(dateFormat.format(date));
            JOptionPane.showMessageDialog(null,borrowBookController.confirmOrderToBorrowed(order) );
            if(textBorrowerCardID.getText().equals("")){
                model.setRowCount(0);
                loadTableMuonTra(borrowBookController.getAllOrderBook(OrderStatus.ordering));
            }else{
                model.setRowCount(0);
                loadTableMuonTra(borrowBookController.getOrderByCardNumber(Integer.parseInt(textBorrowerCardID.getText()),OrderStatus.ordering));
            }
            DefaultTableModel model1 = (DefaultTableModel) muontract_table.getModel();
            model1.setRowCount(0);
            DefaultTableModel model2 = (DefaultTableModel) muontra_table1.getModel();
            model2.setRowCount(0);
            loadTableMuonTra1(borrowBookController.getAllOrderBook(OrderStatus.borrowing));
        }else{
            JOptionPane.showMessageDialog(null, "Lựa chọn order bạn muốn xác nhận cho mượn");

        }

    }//GEN-LAST:event_btnUpdateOrderMouseClicked

    private void timkiem_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timkiem_buttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_timkiem_buttonActionPerformed

    private void timkiem_buttonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_timkiem_buttonMouseReleased
        DefaultTableModel model = (DefaultTableModel) muontra_table.getModel();
        model.setRowCount(0);
        if(textBorrowerCardID.getText().equals("")){
            loadTableMuonTra(borrowBookController.getAllOrderBook(OrderStatus.ordering));
        }else{
            try {
                int idCard = Integer.parseInt(textBorrowerCardID.getText());
                System.out.println(idCard);
                ArrayList<OrderBook>orderList = borrowBookController.getOrderByCardNumber(idCard,OrderStatus.ordering);
                loadTableMuonTra(orderList);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Mã người mượn chỉ gồm các ký tự số");
            }
        }

    }//GEN-LAST:event_timkiem_buttonMouseReleased

    private void jScrollPane1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1MouseReleased

    private void muontra_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_muontra_tableMouseClicked

        DefaultTableModel model = (DefaultTableModel) muontra_table.getModel();
        int i = muontra_table.getSelectedRow();
        System.out.println(i);
        OrderBook order = new OrderBook(Integer.parseInt(model.getValueAt(i,0).toString()),Integer.parseInt(model.getValueAt(i,1).toString()) , model.getValueAt(i,2).toString(),Integer.parseInt(model.getValueAt(i,4).toString()), OrderStatus.valueOf(model.getValueAt(i,5).toString()));
        textTienNop.setText(String.valueOf(order.getDeposits()));
        loadTableMuonTraCT(borrowBookController.getAllItemOfOrder(order));
    }//GEN-LAST:event_muontra_tableMouseClicked

    private void muontra_table2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_muontra_table2MouseClicked
        DefaultTableModel model = (DefaultTableModel) muontra_table2.getModel();
        int i = muontra_table2.getSelectedRow();
        OrderBook order = new OrderBook(Integer.parseInt(model.getValueAt(i,0).toString()),Integer.parseInt(model.getValueAt(i,1).toString()) , model.getValueAt(i,2).toString(),Integer.parseInt(model.getValueAt(i,3).toString()), OrderStatus.valueOf(model.getValueAt(i,4).toString()));   
        loadTableMuonTraCT2(borrowBookController.getAllItemOfOrder(order));
    }//GEN-LAST:event_muontra_table2MouseClicked

    private void jScrollPane5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane5MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane5MouseReleased

    private void timkiem_button2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_timkiem_button2MouseReleased
        DefaultTableModel model = (DefaultTableModel) muontra_table2.getModel();
        model.setRowCount(0);
        if(textBorrowerCardID2.getText().equals("")){
            loadTableMuonTra2(borrowBookController.getAllOrderBook(OrderStatus.complete));
        }else{
            try {
                int idCard = Integer.parseInt(textBorrowerCardID2.getText());
                ArrayList<OrderBook>orderList = borrowBookController.getOrderByCardNumber(idCard,OrderStatus.complete);
                loadTableMuonTra2(orderList);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Mã người mượn chỉ gồm các ký tự số");
            }
        }
    }//GEN-LAST:event_timkiem_button2MouseReleased

    private void muontract_table2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_muontract_table2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_muontract_table2MouseClicked

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
        LibrarianMenuInterface view = new LibrarianMenuInterface(LibrarianMenuInterface.LibrarianId);
        this.dispose();
    }//GEN-LAST:event_back_btnActionPerformed

    private void dangxuat_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dangxuat_btnActionPerformed
        LoginForm form = new LoginForm();
        this.dispose();
    }//GEN-LAST:event_dangxuat_btnActionPerformed
    private OrderBookItem item;
    /**
     * @param args the command line arguments
     */
    void showWindow(){
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }
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
            java.util.logging.Logger.getLogger(OrderBookManagementInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderBookManagementInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderBookManagementInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderBookManagementInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderBookManagementInterface().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_btn;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnKhoiPhuc;
    private javax.swing.JButton btnMuon;
    private javax.swing.JButton btnTra;
    private javax.swing.JButton btnUpdateOrder;
    private javax.swing.JButton btnUpdateOrder1;
    private javax.swing.JButton dangxuat_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable muontra_table;
    private javax.swing.JTable muontra_table1;
    private javax.swing.JTable muontra_table2;
    private javax.swing.JTable muontract_table;
    private javax.swing.JTable muontract_table1;
    private javax.swing.JTable muontract_table2;
    private javax.swing.JTextField textBorrowerCardID;
    private javax.swing.JTextField textBorrowerCardID1;
    private javax.swing.JTextField textBorrowerCardID2;
    private javax.swing.JTextField textCopyId;
    private javax.swing.JTextField textTienNop;
    private javax.swing.JTextField textTienNop1;
    private javax.swing.JButton timkiem_button;
    private javax.swing.JButton timkiem_button1;
    private javax.swing.JButton timkiem_button2;
    // End of variables declaration//GEN-END:variables
}
