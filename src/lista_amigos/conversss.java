/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista_amigos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author alexi
 */
public class conversss extends JFrame implements ActionListener {

    public conversss(String var) {
    conver(var);
    
    }
public void conver(String res){
    JTextArea chat = new JTextArea();
    JTextField mensaje = new JTextField();
    JButton enviar = new JButton("Enivar");
     setDefaultCloseOperation(HIDE_ON_CLOSE);    
        //setSize(450, 330);
        setLayout(null);
        setTitle(res);
        setVisible(false);
               GroupLayout orden = new GroupLayout(this.getContentPane());
        
        orden.setAutoCreateContainerGaps(true);
        orden.setAutoCreateGaps(true);
        orden.setHorizontalGroup(
       orden.createParallelGroup()
        .addComponent(chat,350,350,350)
               .addGroup
        (
                orden.createSequentialGroup()
                .addComponent(mensaje,250,250,250)
                .addComponent(enviar,100,100,100)
        )     
        );
        orden.setVerticalGroup(
                orden.createSequentialGroup()
                .addComponent(chat,300,300,300)
                .addGroup
        (
                orden.createParallelGroup()
                .addComponent(mensaje)
                .addComponent(enviar)
        )
                
        );
            setLayout(orden);
        this.pack();
        enviar.addActionListener(this);
}
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
