/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista_amigos;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
/**
 *
 * @author HildaLuz
 */
public class Conversacion extends JFrame implements ActionListener{
    protected JTextArea Conver;
    protected JTextArea NuevoEnvio;
    protected JButton Enviar;
    protected JScrollPane holis;
    String File,nombre;
     public Conversacion(String Nombre,String holi) throws HeadlessException {
         File=Nombre;
         nombre=holi;
         Conver=new JTextArea("");
         NuevoEnvio=new JTextArea("");
         Enviar=new JButton("Enviar");
         holis=new JScrollPane(Conver);
         
         Inicializar();
    }
    protected void Inicializar()
    {
        
        this.setLayout(null);
        this.setSize(500,500);
        
        this.setTitle(File);
        holis.setBounds(0,0,300,250);
        NuevoEnvio.setBounds(0,350,300,50);
        Enviar.setBounds(350,350,100,50);
        Enviar.addActionListener(this);
        Conver.setEditable(false);
        this.add(holis);
        this.add(Enviar);
        this.add(NuevoEnvio);
        //actualizarTextField();
    }
    public void actualizarTextField(JSONObject obj){
        Conver.setText("");
        String json = obj.toString();
  
        JSONParser parser = new JSONParser();

        try {

            Object objt = parser.parse(json);
            JSONObject jsonObject = (JSONObject) objt;
            System.out.println();
            String namee = (String) jsonObject.get("De");
            System.out.println(namee);
            Conver.setText(Conver.getText()+(String) jsonObject.get("De")+ ": ");
            Conver.setText(Conver.getText()+(String) jsonObject.get("Mensaje")+ "\n");
            String cityy = (String) jsonObject.get("Mensaje");
            System.out.println(cityy);
            } catch (ParseException e) {
            System.out.println("Error");
        }
        /*try {
	File fXmlFile = new File("C:/Users/HildaLuz/Downloads/MuestraMensajes/"+File+".xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);

        
	doc.getDocumentElement().normalize();
	System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

	NodeList nList = doc.getElementsByTagName("Numero");

	System.out.println("----------------------------");

	for (int temp = 0; temp < nList.getLength(); temp++) {

		Node nNode = nList.item(temp);

		System.out.println("\nCurrent Element :" + nNode.getNodeName());

		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) nNode;

			System.out.println("Nombre : " + eElement.getElementsByTagName("Nombre").item(0).getTextContent());
                        Conver.setText(Conver.getText()+eElement.getElementsByTagName("Nombre").item(0).getTextContent()+ ": ");
			System.out.println("Mensaje : " + eElement.getElementsByTagName("Mensaje").item(0).getTextContent());
                        Conver.setText(Conver.getText()+eElement.getElementsByTagName("Mensaje").item(0).getTextContent()+ "\n");
                        
		}
	}
        
    } catch (Exception e) {
	e.printStackTrace();
    }*/
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println(NuevoEnvio.getText());
        JSONObject obj = new JSONObject();
        obj.put("De", nombre);
        obj.put("Para", File);
        obj.put("Mensaje",NuevoEnvio.getText());
        //Objeto JSON listo para salir al servidor
        System.out.print(obj + "\n");
        Conver.setText(Conver.getText()+ nombre+": "+NuevoEnvio.getText()+"\n");
        
        NuevoEnvio.setText("");
        
    }
    
}
