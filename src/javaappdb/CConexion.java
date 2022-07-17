

package javaappdb;
import org.jdom.*;
import java.io.*; 
import java.util.*; 
import org.jdom.input.*; 
import org.jdom.output.*; 
import com.mysql.jdbc.*;
import java.sql.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
//import java.sql.RowId;


public class CConexion
{
    private String nomBD;
    private String nomU;
    private String serv;
    private String cont;
    private int puerto;
    private static Connection con;
    private java.sql.Statement st;
    private MysqlDataSource ds;
    private java.sql.ResultSet rs;
    private java.sql.ResultSetMetaData rsmd;
    private Document doc;
    private Element raiz;

    private void doXML()
    {
        this.doc = new Document();
        this.raiz=new Element("raiz");
        this.raiz.setAttribute("name",nomBD);
        this.doc.setRootElement(raiz);
    }

    public CConexion(String nomBD,String nomU,String serv,String cont,int puerto)
    {
        this.nomBD=nomBD;
        this.nomU=nomU;
        this.cont=cont;
        this.serv=serv;
        this.puerto=puerto;
        this.ds=new MysqlDataSource();
        this.con = null;
        doXML();
    }


     public CConexion()
    {
        this.nomBD="";
        this.nomU="";
        this.cont="";
        this.serv="";
        this.puerto=0;
        this.ds=new MysqlDataSource();
        this.doc=new Document();
        doXML();
    }

     public void setnomBD(String ob)
     {
        this.nomBD=ob;
     }
     public String getNBD()
     {
         return this.nomBD;
     }

     public void setnomU(String ob)
     {
        this.nomU=ob;
     }

     public void setcont(String ob)
     {
        this.cont=ob;
     }

     public void setServ(String ob)
     {
        this.serv=ob;
     }

     public void setPuer(int ob)
     {
        this.puerto=ob;
     }

     public Connection getCon()
     {
         return this.con;
     }

     

    public void Conectar()throws Exception
    {
        
            ds.setServerName(serv);
           // ds.setDatabaseName(nomBD);
            ds.setPort(puerto);
            ds.setUser(nomU);
            ds.setPassword(cont);
            con = ds.getConnection();
            //st = con.createStatement();
           
          

    }
     public void Conectar2()throws Exception
    {        
            ds.setServerName(serv);
            ds.setDatabaseName(nomBD);
            ds.setPort(puerto);
            ds.setUser(nomU);
            ds.setPassword(cont);
            con = ds.getConnection();
            //st = con.createStatement();
            doXML();
    }

     public void setConBD()
     {
         ds.setDatabaseName(this.nomBD);
     }

     public void EBlanco(String x, String y, String z,String t,String c)throws EspaciosBlancos
    {
        String x1=x;
        String y1=y;
        String z1=z;
        String t1=t;
        String c1=c;
        if((x1.length()==0)||(y1.length()==0)||(z1.length()==0)||(t1.length()==0)||(c1.length()==0))
            throw new EspaciosBlancos();
        x1=y1;
    }


    public LinkedList CrearEst(int numf)
    {
        numf++;
        LinkedList obj=new LinkedList();
        for(int i=1 ; i<=numf; i++)
        {
            Element row=new Element("row");
            obj.addLast(row);
        }
            return obj;
    }


    public LinkedList CrearDat(int numf)
    {
        numf++;
        LinkedList obj=new LinkedList();
        for(int i=1 ; i<=numf; i++)
        {
            Element row=new Element("row1");
            obj.addLast(row);
        }
            return obj;
    }


     public java.sql.ResultSetMetaData NomBD()throws Exception
  {
    
    
    java.sql.Statement st11 = con.createStatement();
    java.sql.ResultSet rs11 = st11.executeQuery("Show Databases ");
    java.sql.ResultSetMetaData rsmd11=rs11.getMetaData();
       
       return rsmd11;
       

    
    

  }

    public Element BD()throws Exception
    {
       // try{
            st = con.createStatement();
            rs = st.executeQuery("Show Tables");
            rsmd=rs.getMetaData();
            String nom="";
            
        if(rs.first()==true)
        {
           int i=1;
           while(i<=rsmd.getColumnCount())
           {nom=rsmd.getColumnName(i);
              do{
               
                 String nomT="";
              
               //int i=1;
                 //if(rs.first()==true)
                   //while(i<=rsmd.getColumnCount())
                   //{
                      
                      nomT=rs.getString(nom);

                       Element table=new Element("table");
                       table.setAttribute("name", nomT);
                       Element struct=new Element("struruct");
                        Element struct1=new Element("struct");
                       Element datos=new Element("data");
                       Element datos1=new Element("data");

                       java.sql.Statement st1 = con.createStatement();
                       java.sql.ResultSet rs1 = st1.executeQuery("Desc "+nomT);
                       java.sql.ResultSetMetaData rsmd1 = rs1.getMetaData();

                       int l=0;
                                java.sql.ResultSet rs2=rs1;
                                while(rs2.next()==true)
                                       l++;
                                LinkedList obj=CrearEst(l);
                          
                       for(int j=1 ; j<=rsmd1.getColumnCount(); j++)
                       {int a=1;
                        
                        String nomC=rsmd1.getColumnName(j);
                            if(rs1.first()==true)
                            {  

                             do{
                                String camp=(String)(rs1.getString(nomC));
                                if(camp==null||camp.isEmpty() )
                                {a++;}
                                  else{
                                       ((Element)obj.get(a)).setAttribute(nomC,camp);
                                        a++;
                                       }
                               }while(rs1.next()==true);
                            
                            }
                       }
                        for(int p=1;p<obj.size();p++)
                        struct1.addContent((Element)obj.get(p));
                        table.addContent(struct1);
                       
                       java.sql.ResultSet rs3 = st1.executeQuery("SELECT * FROM "+nomT);
                       java.sql.ResultSetMetaData rsmd2 = rs3.getMetaData();
                       int l1=0;
                                java.sql.ResultSet rs4=rs3;
                                while(rs4.next()==true)
                                       l1++;
                                LinkedList obj1=CrearDat(l1);

                                for(int m=1; m<=rsmd2.getColumnCount(); m++)
                                {int a=1;
                                   String nomC=rsmd2.getColumnName(m);
                                   if(rs3.first()==true)
                                   {
                                    do{
                                        String valC=rs3.getString(nomC);
                                        if(valC==null)
                                            valC="nulo";
                                        ((Element)obj1.get(a)).setAttribute(nomC,valC);
                                         a++;
                                       }while(rs3.next()==true);
                                   }
                                }
                                for(int z=1;z<obj1.size();z++)
                                datos1.addContent((Element)obj1.get(z));
                                table.addContent(datos1);
                                raiz.addContent(table);

                   //}
               }while(rs.next()==true);
            return raiz;
        }
     }
          else{ return null;}
/*}catch(Exception e)
    {System.out.println("Error: " + e.getMessage());}*/
    return null;
}


}
