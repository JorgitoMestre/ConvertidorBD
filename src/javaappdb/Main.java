

package javaappdb;

import java.util.*;
import org.jdom.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//import Exceptions.*;

public class Main {

   
    public static void main(String[] args) {

         NewJFrame obj1=new NewJFrame();
        obj1.setVisible(true);

      /* String s="";
       String bd="";
       String user="";
        String con="";
        String serv="";
       int puerto=0;


        BufferedReader datos=new BufferedReader(new InputStreamReader(System.in ));
       /* try{
           /* System.out.println("Nombre BD");
            //s=datos.readLine();
            bd=datos.readLine();

             System.out.println("Nombre U");
             user=datos.readLine();

             System.out.println("Cont");
             con=datos.readLine();

             System.out.println("Serv");
             serv=datos.readLine();

             System.out.println("Puerto");
             s=datos.readLine();
             puerto=Integer.parseInt(s);*/

             /*-------------CConexion
              obj = new CConexion("proycyj","root","localhost","usbw",3307);

             obj.Conectar();
             Element  d =obj.BD();
             List q=d.getChildren();
             //for(int k=1;k<=q.size()+2;k++)
             Iterator i=q.iterator();
             while(i.hasNext())
             {
                 Element w=(Element)i.next();

                 System.out.print("< "+w.getName()+" name "+w.getAttributeValue("name")+" >");

                 List q1=w.getChildren();
                   Iterator k=q1.iterator();
                   while(k.hasNext())
                   {
                      //strusct
                       Element ps=(Element)k.next();
                       List q3=ps.getChildren();
                        Iterator j=q3.iterator();
                         while(j.hasNext())
                         {System.out.print("<estruct>");
                          System.out.print("");
                          Element aa=(Element)j.next();
                          List at=aa.getAttributes();
                              Iterator x=at.iterator();
                              String dd =" ";
                              while(x.hasNext())
                              {
                                Attribute hh=(Attribute)x.next();

                               // String nom=hh.getName();
                                //String val=hh.getValue();
                                
                                dd+="<field";
                                dd+=" ";
                                dd+=hh.getName();
                                dd+=" ";
                                dd+=hh.getValue();
                                dd+=" ";
                                dd+="/>/n ";
                               
                              // System.out.print(dd);
                              }
                              System.out.print(dd);
                              System.out.print("");
                           System.out.print("<estruct/>");
                         }

                   }
                   System.out.print("<table/>");
             }
       /* }catch(IOException e)
        {System.out.println("Error en la entrada de datos");}*/
      /* obj.NombreBaseDatos("Transtur");
       Element estruct = obj.crearEstructura("idFac", "0", "yes","yes", "int","idfac","facultad");
       Element estruct2 = obj.crearEstructura("Nombre", "0", "yes","yes", "int","null","null");
       Element estruct3 = obj.crearEstructura("Pena", "0", "yes","yes", "int","null","null");
       try{
       obj.crearTabla("tabla1");
       obj.crearTabla("tabla2");
       }catch(Exception e){
        System.out.println(e.getMessage());
      }
       Element fila1 = new Element("fila1");
       fila1.setAttribute("idFac","1");
       fila1.setAttribute("Nombre","FacInd");
       fila1.setAttribute("iniciales","FI");
       Element fila2 = new Element("fila2");
       fila2.setAttribute("idFac","2");
       fila2.setAttribute("Nombre","FacMec");
       fila2.setAttribute("iniciales","FM");
       obj.contenidoDatos("tabla1", fila1);
        obj.contenidoDatos("tabla1", fila2);
        try{
       obj.contenidoEstrcutura("tabla2", estruct2); 
       obj.contenidoEstrcutura("tabla2", estruct2);
        }catch(Exception e){
         System.out.println(e.getMessage());
        }
//      obj.eliminarCampo("tabla1", "algo");
      // obj.eliminarFila("tabla1", "fila1");
     //  obj.modificarFila("tabla1","fila2", "Nombre", "FacMecanica");
      // obj.modificarCampo("tabla1", "idFac" ,"null", "1");
    
      List a =  obj.get_root().getChildren();
       Iterator i = a.iterator();
       while(i.hasNext()){
       Element m = (Element) i.next();
       List b = m.getChild("estructura").getChildren();//cambiar por estructura para ver sus datos
       Iterator j = b.iterator();
       while(j.hasNext()){
       Element g = (Element)j.next();
       List r = g.getAttributes();
       Iterator w = r.iterator();
       while(w.hasNext()){
       Attribute c = (Attribute) w.next();    
       System.out.println(c.getValue());
       }
       }
    }*/
    }//todo funciona solo terminar el visual(OJO)
}
