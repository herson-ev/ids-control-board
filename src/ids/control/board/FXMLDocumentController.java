package ids.control.board;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author herson
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private VBox middleBox;
    @FXML
    private CheckBox DNS, FTP, HTTP, IRC, NFS, POP3, SMB, SMTP, SNMP, SSH, SSL;
   
    @FXML
    private void handleButtonActionDNS (ActionEvent event){     
        
        if (DNS.isSelected()) {
        //System.out.println("+1 DNS");
            modify("DNS 0", "DNS 1");
        }
        else
            modify("DNS 1", "DNS 0");
    }
    
    @FXML
    private void handleButtonActionFTP (ActionEvent event) {  
      if (FTP.isSelected()) {
        modify("FTP 0", "FTP 1");
        }
        else
        modify("FTP 1", "FTP 0");
    }
     
    @FXML
    private void handleButtonActionHTTP (ActionEvent event) {  
        if (HTTP.isSelected()) {
        modify("HTTP 0", "HTTP 1");
        }
        else
            modify("HTTP 1", "HTTP 0");
    }
        
    @FXML
    private void handleButtonActionIRC (ActionEvent event) {   
        if (IRC.isSelected()) {
        modify("IRC 0", "IRC 1");
        }
        else
            modify("IRC 1", "IRC 0");
    }
     
    @FXML
    private void handleButtonActionNFS (ActionEvent event) {  
        if (NFS.isSelected()) {
        modify("NFS 0", "NFS 1");
        }
        else
            modify("NFS 1", "NFS 0");
    }
     
    @FXML
    private void handleButtonActionPOP3 (ActionEvent event) {  
        if (POP3.isSelected()) {
        modify("POP3 0", "POP3 1");
        }
        else
            modify("POP3 1", "POP3 0");
    }
     
    @FXML
    private void handleButtonActionSMTP (ActionEvent event) {  
        if (SMTP.isSelected()) {
        modify("SMTP 0", "SMTP 1");
        }
        else
            modify("SMTP 1", "SMTP 0");
    }
    
    @FXML
    private void handleButtonActionSNMP (ActionEvent event) {   
    if (SNMP.isSelected()) {
         modify("SNMP 0", "SNMP 1");
        }
        else
            modify("SNMP 1", "SNMP 0");
    }
        
    @FXML
    private void handleButtonActionSSH (ActionEvent event) {  
        if (SSH.isSelected()) {
        modify("SSH 0", "SSH 1");
        }
        else
            modify("SSH 1", "SSH 0");
    }
    
    @FXML
    private void handleButtonActionSSL (ActionEvent event) {  
        if (SSL.isSelected()) {
        modify("SSL 0", "SSL 1");
        }
        else
            modify("SSL 1", "SSL 0");
    }
    
    @FXML
    private void handleButtonActionSMB (ActionEvent event) {   
    if (SMB.isSelected()) {
        modify("SMB 0", "SMB 1");
        }
        else
            modify("SMB 1", "SMB 0");
    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {        

        File orifile = new File("/home/lis/Analyzers.txt");   
        writeFile(orifile, "DNS 0");
        writeFile(orifile, "FTP 0");
        writeFile(orifile, "HTTP 0");
        writeFile(orifile, "IRC 0");
        writeFile(orifile, "NFS 0");
        writeFile(orifile, "POP3 0");
        writeFile(orifile, "SMB 0");
        writeFile(orifile, "SMTP 0");
        writeFile(orifile, "SNMP 0");
        writeFile(orifile, "SSH 0");
        writeFile(orifile, "SSL 0");

        //defining the axes
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        //creating the chart
        LineChart<String, Number> chart = new LineChart(xAxis, yAxis);

        chart.setTitle("IDS Performance");
        chart.setCreateSymbols(false);
        chart.setAnimated(false);

        middleBox.getChildren().add(chart);

        
        //defining a CPUSerie
//        XYChart.Series CPUSerie = new XYChart.Series();
//        CPUSerie.setName("% CPU");
//        //populating the CPUSerie with data
//        CPUSerie.getData().add(new XYChart.Data("12", 23));
//        CPUSerie.getData().add(new XYChart.Data("11", 14));
//        CPUSerie.getData().add(new XYChart.Data("10", 15));
//        CPUSerie.getData().add(new XYChart.Data("9", 24));
//        CPUSerie.getData().add(new XYChart.Data("8", 34));
//        CPUSerie.getData().add(new XYChart.Data("7", 36));
//        CPUSerie.getData().add(new XYChart.Data("6", 22));
//        CPUSerie.getData().add(new XYChart.Data("5", 45));
//        CPUSerie.getData().add(new XYChart.Data("4", 43));
//        CPUSerie.getData().add(new XYChart.Data("3", 17));
//        CPUSerie.getData().add(new XYChart.Data("2", 29));
//        CPUSerie.getData().add(new XYChart.Data("1", 25));
//        chart.getData().add(CPUSerie);
        
//        //defining a memSerie
//        XYChart.Series memSerie = new XYChart.Series();
//        memSerie.setName("% Mem");
//        //populating the memSerie with data
//        memSerie.getData().add(new XYChart.Data("12", 10));
//        memSerie.getData().add(new XYChart.Data("11", 8));
//        memSerie.getData().add(new XYChart.Data("10", 10));
//        memSerie.getData().add(new XYChart.Data("9", 15));
//        memSerie.getData().add(new XYChart.Data("8", 11));
//        memSerie.getData().add(new XYChart.Data("7", 4));
//        memSerie.getData().add(new XYChart.Data("6", 5));
//        memSerie.getData().add(new XYChart.Data("5", 6));
//        memSerie.getData().add(new XYChart.Data("4", 7));
//        memSerie.getData().add(new XYChart.Data("3", 8));
//        memSerie.getData().add(new XYChart.Data("2", 11));
//        memSerie.getData().add(new XYChart.Data("1", 15));
//        chart.getData().add(memSerie);        
    }
    
   
    
    @FXML
    public static void writeFile(File file,String line)
    {
     try 
     {
       if(!file.exists())
       {
       file.createNewFile();
       }

       BufferedWriter wfile=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,true), "utf-8"));
       wfile.write(line + "\r\n");
       //System.out.println("entro aca");
       wfile.close();
     } 
     catch (Exception ex) 
     {
       System.out.println(ex.getMessage());
      } 
   }

   @FXML 
   public static  void eraseFile(File file)
   {
     try 
     {
       if(file.exists())
       {
           file.delete(); 
           System.out.println("Borrado");
       }
     } 
     catch (Exception ex) 
     {
       System.out.println(ex.getMessage());
     }
   } 

    public static  void modify(String oldline,String newline)
    {        

        File orifile = new File("/home/lis/Analyzers.txt");     
        String tempname=orifile.getParent()+"/temp"+".txt";
        File newfile=new File(tempname);
        try 
        {
            if(orifile.exists())
            {
                BufferedReader rfile= new BufferedReader(new FileReader(orifile));
                String currentline;
                
                while((currentline=rfile.readLine())!=null) 
                    {
                        if(currentline.equals(oldline)){
                            writeFile(newfile,newline);
                        }
                        else{
                            writeFile(newfile,currentline);
                        }             
                    }
                /*asignar al archivo temporal el nombre del archivo original*/
                String oldfile=orifile.getName();
                eraseFile(orifile);
                newfile.renameTo(orifile);
                rfile.close();
            }
            
            else{
                System.out.println("No hay archivo");
            }
        }
        catch (Exception ex) {
             System.out.println(ex.getMessage());
        }
    }

}
