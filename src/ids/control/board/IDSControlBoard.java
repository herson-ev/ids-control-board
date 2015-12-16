package ids.control.board;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author herson
 */
public class IDSControlBoard extends Application {
    static final int OLDEST = 30;

    static ArrayList<Double> memData = new ArrayList();
    static ArrayList<Double> CPUData = new ArrayList();

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);

        stage.setTitle("IDS Control Board");
        stage.setScene(scene);
        stage.show();
        


        ////////////////////////////////////////////////////////////////////////
        
        VBox vb = (VBox) root.getChildrenUnmodifiable().get(2);
        LineChart<String, Number> chart = (LineChart<String, Number>) vb.getChildrenUnmodifiable().get(0);

        //Initial data in zeros
        for (int i = OLDEST; 0 < i; i--) {
            memData.add(0.0);
            CPUData.add(0.0);
        }
        
        
        Timeline bucle;
        bucle = new Timeline(new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                chart.getData().clear();
                XYChart.Series memSerie = new XYChart.Series();
                memSerie.setName("% Mem");
                XYChart.Series CPUSerie = new XYChart.Series();
                CPUSerie.setName("% CPU");
                
                String p;
                p = returnProcess ();
                String valmem;
                valmem = returnMemory (p);
                Double vm = Double.parseDouble(valmem);
                
                String valcpu;
                valcpu = returnCPU (p);
                Double vc = Double.parseDouble(valcpu);
                //Updates data
                memData.remove(0); // Remove the oldest
                //memData.add(new Random().nextInt(100) * 1.0);
                memData.add(vm);
                CPUData.remove(0);
                //CPUData.add(new Random().nextInt(100) * 1.0);
                CPUData.add(vc);
                

                //Updates graph
                for (int i = OLDEST; 0 < i; i--) {
                    memSerie.getData().add(new XYChart.Data(String.valueOf(i), memData.get(OLDEST - i)));
                    CPUSerie.getData().add(new XYChart.Data(String.valueOf(i), CPUData.get(OLDEST - i)));
                }

                chart.getData().add(memSerie);
                chart.getData().add(CPUSerie);
            }
        }));
        bucle.setCycleCount(Timeline.INDEFINITE);
        bucle.play();
    }
    
        public static String returnProcess ()
    {
        String proc = "";
        try 
        {
            Runtime rt = Runtime.getRuntime();
            String[] arg = { "/bin/sh", "-c", "pgrep 'firefox'" };
            Process pr = rt.exec(arg);
            BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            proc=input.readLine();
            //int exitVal = pr.waitFor();
            //System.out.println("Exited with error code "+exitVal);
        } 
           
        catch(Exception e) 
        {
            System.out.println(e.toString());
            e.printStackTrace();
        }
       return proc;
    }
    
    public static String returnMemory (String np)
    {
        String line = "";
        try 
        {
            Runtime rt = Runtime.getRuntime();
            String[] arg = { "/bin/sh", "-c", "top -b -p".concat(np).concat("-n 1 | tail -n 1 | awk {'print $10'}")};
            Process pr = rt.exec(arg);
            BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            line=input.readLine();
            //int exitVal = pr.waitFor();
            //System.out.println("Exited with error code "+exitVal);  
        } 
           
        catch(Exception e) 
        {
            System.out.println(e.toString());
            e.printStackTrace();
        }
        String replace = line.replace(",", ".");
        System.out.println("valor memoria "+replace);
        return replace;
    }
    
    public static String returnCPU (String np)
    {
        String line = "";
        try 
        {
            Runtime rt = Runtime.getRuntime();
            String[] arg = { "/bin/sh", "-c", "top -b -p".concat(np).concat("-n 1 | tail -n 1 | awk {'print $9'}")};
            Process pr = rt.exec(arg);
            BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            line=input.readLine();
            //int exitVal = pr.waitFor();
            //System.out.println("Exited with error code "+exitVal);  
        } 
           
        catch(Exception e) 
        {
            System.out.println(e.toString());
            e.printStackTrace();
        }
        String replace = line.replace(",", ".");
        System.out.println("valor CPU "+replace);
        return replace;
    }
    
    
    
    
    
    
    
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

          }

}
