import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
 
public class DrawChart extends Application {
	
	static String letters = "ABCDEFGHIJKLMNOPQRSTUVWXZY";
	static char[] lettersArray = letters.toCharArray();
	static double[] count = null;
	static double[] d = new double[26];
	
	static String englFq = "E:12.51,"
			+"T:9.25,"
			+"A:8.04,"
			+"O:7.60,"
			+"I:7.26,"
			+"N:7.09,"
			+"S:6.54,"
			+"R:6.12,"
			+"H:5.49,"
			+"L:4.14,"
			+"D:3.99,"
			+"C:3.06,"
			+"U:2.71,"
			+"M:2.53,"
			+"F:2.30,"
			+"P:2.00,"
			+"G:1.96,"
			+"W:1.92,"
			+"Y:1.73,"
			+"B:1.54,"
			+"V:0.99,"
			+"K:0.67,"
			+"X:0.19,"
			+"J:0.16,"
			+"Q:0.11,"
			+"Z:0.09";
	static String[] s = englFq.split(",");
	
		public void saveData()
		{
			double sum = 0;
			for(int i = 0; i< s.length; i++)
			{
				String[] temp = s[i].trim().split(":");
				char letter =  temp[0].charAt(0);
				double val = Double.parseDouble(temp[1]);
				int idx = letter;
				d[idx - 65] = val;
				
			}
			
			
		}
 
    @SuppressWarnings({ "restriction", "unchecked", "rawtypes"})
	@Override public void start(Stage stage) {
        stage.setTitle("Cipher text letter frequency");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc = 
        new BarChart<String,Number>(xAxis,yAxis);
        bc.setTitle("Letter Frequency");
        xAxis.setLabel("Letters --->");       
        yAxis.setLabel("frequency --->");
        
       
        @SuppressWarnings("rawtypes")
		XYChart.Series series1 = new XYChart.Series();
       series1.setName("Cipher Text Freq");     
        if(count != null)
        for(int i = 0; i < lettersArray.length; i++)
        {
        series1.getData().add(new XYChart.Data("" +lettersArray[i], count[i]));
        }
        
        @SuppressWarnings("rawtypes")
		XYChart.Series series2 = new XYChart.Series();
        series2.setName("Engl letter freq");
        for(int i = 0; i < d.length; i++)
        {
        series2.getData().add(new XYChart.Data("" +lettersArray[i], d[i]));
        }
        
        
        Scene scene  = new Scene(bc,800,600);
        bc.getData().addAll(series1,series2);        
        stage.setScene(scene);
        stage.show();
    }
 
    @SuppressWarnings("restriction")
	public static void main(String[] args) {
    	
    	
        launch(args);
    }
}