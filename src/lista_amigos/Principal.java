/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista_amigos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author alexi
 */
public class Principal  extends JFrame implements ActionListener {
    JButton Agregar = new JButton("Agregar");
JButton Cerrar = new JButton("Cerrar Sesion");
JButton Cambiar_Info = new JButton("Editar");
Conversacion con=new Conversacion(null,null);
DefaultListModel modelo;
String userrr;
private Connection cone;
 private ResultSet res;
     PreparedStatement sql=null;
agregar_amigo x = new agregar_amigo(null);
//--------------Constructor
public Principal(String user) {
   
Connectar conn = new Connectar();
cone=conn.con_bd();
        configura(user);  

    }
      //---------------------Vista
      public void configura(String userr){
    int x=0;
         modelo = new DefaultListModel();
     try {
        sql=cone.prepareStatement("SELECT * FROM `friends` LEFT JOIN `users` ON `users`.`id` = `friends`.`slave_id` WHERE `master_id` = 1");
    } catch (SQLException ex) {
        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
    }
     try {
        res = sql.executeQuery();
        while(res.next()){
            modelo.addElement(res.getString("name"));
            }
    } catch (SQLException ex) {
        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
    }
         
        JList Amigos =new JList(); 
         Amigos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    
         Amigos.setModel(modelo);    
        setDefaultCloseOperation(EXIT_ON_CLOSE);    
        //setSize(450, 330);
        setLayout(null);
        setTitle("Que Pedit");
        setVisible(true);
               GroupLayout orden = new GroupLayout(this.getContentPane());
        
        orden.setAutoCreateContainerGaps(true);
        orden.setAutoCreateGaps(true);
        orden.setHorizontalGroup(
        orden.createSequentialGroup()
                .addGroup
        (
                orden.createParallelGroup()
                .addComponent(Agregar,110,110,110)
                .addGap(25)
                .addComponent(Cerrar)
                .addGap(25)
                .addComponent(Cambiar_Info)
        )
                .addGap(50)
                .addComponent(Amigos,200,200,200)
                
                
        );
        orden.setVerticalGroup(
        orden.createParallelGroup()
                .addGroup
                (
                        orden.createSequentialGroup()
                        .addComponent(Agregar)
                        .addGap(25)
                        .addComponent(Cerrar)
                .addGap(25)
                .addComponent(Cambiar_Info)
                
                )
                .addComponent(Amigos)
        );
        Agregar.addActionListener(this);
        Cerrar.addActionListener(this);
            setLayout(orden);
        this.pack();
        Amigos.addListSelectionListener(new ListSelectionListener()
        {
            public void valueChanged(ListSelectionEvent arg0){
            if(!arg0.getValueIsAdjusting())
            {
               String var;
               var =  Amigos.getSelectedValue().toString();
                con= new Conversacion(var,userr);
                userrr=userr;
                //arg0.
                con.setVisible(true);
            
            }
        }
        
      }
                );
      }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Agregar){
           // JOptionPane.showMessageDialog(null,"Hola");
            agregar_amigo x = new agregar_amigo(userrr);
            x.setVisible(true);
            dispose();
        }else{ 
            if(e.getSource()==Cambiar_Info){
                ChageInformation x = new ChageInformation(userrr);
                x.setVisible(true);
                dispose();
            }
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
      
}
