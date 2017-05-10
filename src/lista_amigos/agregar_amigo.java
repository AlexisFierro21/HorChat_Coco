/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista_amigos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;

/**
 *
 * @author alexi
 */
public class agregar_amigo extends JFrame implements ActionListener {
    String userr;
    JTextField usuario = new JTextField();
    JButton agregarr = new JButton("Agregar");
    public agregar_amigo(String user) {
    conver(user);
    
    }
public void conver(String user){
   // JTextArea chat = new JTextArea();
   userr=user;
     setDefaultCloseOperation(HIDE_ON_CLOSE);    
        setSize(350, 250);
        setLayout(null);
        setTitle("Agregar Amigo");
        setVisible(false);
               GroupLayout orden = new GroupLayout(this.getContentPane());
        
        orden.setAutoCreateContainerGaps(true);
        orden.setAutoCreateGaps(true);
        orden.setHorizontalGroup(
       orden.createParallelGroup()
              
                .addComponent(usuario,200,200,200)
                .addComponent(agregarr,100,100,100)
        
        );
        orden.setVerticalGroup(
                orden.createSequentialGroup()
         
                .addComponent(usuario)
                .addComponent(agregarr)
        
                
        );
            setLayout(orden);
        this.pack();
        agregarr.addActionListener(this);
    
}
@Override
    public void actionPerformed(ActionEvent e) {
   if( e.getSource()==agregarr)
   {
    Principal x = new Principal(userr);
    x.setVisible(true);
    dispose();
   }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}