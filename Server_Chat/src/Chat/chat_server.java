
/*
* Mahmoud Abdelazim Mohamed - 12100136 - Class 15
* Mahmoud Shehata Ahmed - 12100490 - Class 15
* Ahmed Kamal Arafat - 12100530 - Class 15
* Youssef Hawary - 12100490 - Class 15
*/

package Chat;

import static Chat.connection.con;
import java.awt.event.KeyEvent;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class chat_server extends javax.swing.JFrame {


    static ServerSocket ss;
    static Socket s;
    static DataInputStream din;
    static DataOutput dout;
    
    int x,y;

    public chat_server() {
        initComponents();
        
    }
    
    static public String getTime(){
        SimpleDateFormat formatter= new SimpleDateFormat("HH:mm");
        Date date = new Date(System.currentTimeMillis());
        
        return formatter.format(date)+" PM";
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        msg_area = new javax.swing.JTextArea();
        msg_txt = new javax.swing.JTextField();
        msg_send = new javax.swing.JButton();
        AppTitle = new javax.swing.JLabel();
        ExitBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Server Window");
        setBackground(new java.awt.Color(0, 204, 153));
        setLocation(new java.awt.Point(55, 55));
        setUndecorated(true);
        setResizable(false);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 204, 153));

        msg_area.setEditable(false);
        msg_area.setBackground(new java.awt.Color(0, 51, 51));
        msg_area.setColumns(20);
        msg_area.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        msg_area.setForeground(new java.awt.Color(0, 204, 153));
        msg_area.setRows(5);
        jScrollPane1.setViewportView(msg_area);

        msg_txt.setBackground(new java.awt.Color(0, 51, 51));
        msg_txt.setFont(new java.awt.Font("Lucida Sans", 0, 24)); // NOI18N
        msg_txt.setForeground(new java.awt.Color(0, 204, 153));
        msg_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                msg_txtActionPerformed(evt);
            }
        });
        msg_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                msg_txtKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                msg_txtKeyTyped(evt);
            }
        });

        msg_send.setBackground(new java.awt.Color(0, 51, 51));
        msg_send.setFont(new java.awt.Font("Lucida Sans", 1, 24)); // NOI18N
        msg_send.setForeground(new java.awt.Color(255, 255, 255));
        msg_send.setText("send");
        msg_send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                msg_sendActionPerformed(evt);
            }
        });

        AppTitle.setBackground(new java.awt.Color(255, 255, 255));
        AppTitle.setFont(new java.awt.Font("Cooper Black", 0, 55)); // NOI18N
        AppTitle.setForeground(new java.awt.Color(0, 51, 51));
        AppTitle.setText("Chat App");

        ExitBtn.setBackground(new java.awt.Color(158, 12, 49));
        ExitBtn.setFont(new java.awt.Font("Arial", 1, 26)); // NOI18N
        ExitBtn.setText("X");
        ExitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 2, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(114, 114, 114));
        jLabel1.setText("Press Enter to send the message");
        jLabel1.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(msg_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(AppTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(ExitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(msg_send, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ExitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(AppTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(msg_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(msg_send, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void msg_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_msg_txtActionPerformed

    }//GEN-LAST:event_msg_txtActionPerformed

    private void msg_txtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_msg_txtKeyPressed
       
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            try {
            // Send the massage to the client
            String msgout="";
            msgout ="\n" +getTime()+ " Server: " + msg_txt.getText().trim();
            msg_area.setText(msg_area.getText().trim() + msgout);
            dout.writeUTF(msgout);

            // Add a code which add the message to the DB
            String sql = "insert into Main(txt) values(?);";
            
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1 , msgout);
            pstm.executeUpdate();
            
            // Clear the Textbox
            msg_txt.setText("");
            
        } catch (Exception e) {
        }

        }
        
    }//GEN-LAST:event_msg_txtKeyPressed

    private void msg_txtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_msg_txtKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_msg_txtKeyTyped

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        int xMouse = evt.getXOnScreen();
        int yMouse = evt.getYOnScreen();
        
        this.setLocation(xMouse - x, yMouse - y);
    }//GEN-LAST:event_formMouseDragged

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
         x = evt.getX();
         y = evt.getY();
         
    }//GEN-LAST:event_formMouseMoved

    private void msg_sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_msg_sendActionPerformed

        try {
            // Send the massage to the client
            String msgout="";
            msgout ="\n" +getTime()+" Server: " + msg_txt.getText().trim();
            msg_area.setText(msg_area.getText().trim() + msgout);
            dout.writeUTF(msgout);

            // Add a code which add the message to the DB
            String sql = "insert into Main(txt) values(?);";
            
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1 , msgout);
            pstm.executeUpdate();
            
            // Clear the Textbox
            msg_txt.setText("");
            
        } catch (Exception e) {
        }

    }//GEN-LAST:event_msg_sendActionPerformed

    private void ExitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitBtnActionPerformed
        System.exit(0);
    }//GEN-LAST:event_ExitBtnActionPerformed


    public static void main(String args[]) throws ClassNotFoundException, SQLException {
       
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(chat_server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new chat_server().setVisible(true); 
            }
        });

        connection.ConnectToSQl();
        
        // The code of downloading the chat and send it to the Client
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery("Select * from Main;");

         String msg = ""; 
         while(rs.next()){
              msg += rs.getString("txt") ;
        }
        
         msg_area.setText(msg);
         
         
         // Send the Database chat to client
         try {
             ss = new ServerSocket(1201);
             s = ss.accept();
            din = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());
            dout.writeUTF(msg);

        } catch (Exception e) {
             System.out.println(e);
        }


        // The main code of sending to client
        String msgin = "";
        try {
            
            while (!msgin.equals("exit")) {
                
                msgin = din.readUTF();
                msg_area.setText(msg_area.getText().trim() + msgin);
                
                // Add a code which add the received messages to the database
                 String sql = " insert into Main(txt) values(?);";
                 PreparedStatement pstm = con.prepareStatement(sql);
                 pstm.setString(1 , msgin);
                 pstm.executeUpdate();
                
            }

        } catch (Exception e) {
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AppTitle;
    private javax.swing.JButton ExitBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTextArea msg_area;
    private javax.swing.JButton msg_send;
    private static javax.swing.JTextField msg_txt;
    // End of variables declaration//GEN-END:variables
}
