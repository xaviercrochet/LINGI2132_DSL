package sim

import org.jfree.chart.ChartFactory
import org.jfree.chart.ChartUtilities
import org.jfree.chart.JFreeChart
import org.jfree.data.general._
import org.jfree.data._
import org.jfree.chart.ChartPanel
import org.jfree.chart.plot.PiePlot
import javax.swing.JFrame
import javax.swing.JPanel
import org.jfree.data.xy.DefaultXYDataset
import org.jfree.chart.plot.PlotOrientation;

object Show {
  
	def chart {
	  
	    val stats = Stats.records
	    var dataset = new DefaultXYDataset();
	    
	    // Facebook
	    var xFb = Array[Double]()
	    var yFb = Array[Double]()
	    
	    stats.foreach{ stat =>
	    	
	   		xFb = xFb :+ stat._1 // Get the time
	   		yFb = yFb :+ stat._2(1) // Get the value
	    }
	    
	    val fbValues = Array(xFb, yFb)
	    dataset.addSeries("facebook", fbValues)
	    
	    // Twitter
	    var xTwi = Array[Double]()
	    var yTwi = Array[Double]()
	    
	    stats.foreach{ stat =>
	    	
	   		xTwi = xTwi :+ stat._1 // Get the time
	   		yTwi = yTwi :+ stat._2(2) // Get the value
	    }
	    
	    val twiValues = Array(xTwi, yTwi)
	    dataset.addSeries("Twitter", twiValues)
	    
	    // Youtube
	    var xYt = Array[Double]()
	    var yYt = Array[Double]()
	    
	    stats.foreach{ stat =>
	    	
	   		xYt = xYt :+ stat._1 // Get the time
	   		yYt = yYt :+ stat._2(0) // Get the value
	    }
	    
	    val ytValues = Array(xYt, yYt)
	    dataset.addSeries("Youtube", ytValues)
	    
	    val chart = ChartFactory.createXYLineChart(
	           "Simulation statistics",
	           "Time",
	           "Subscribers",
	            dataset,
	            PlotOrientation.VERTICAL,
	            true,
	            true,
	            false);
 
        val frame = new JFrame("Simulation statistics")
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE )
 
        frame.setSize(640,420)
        frame.add( new ChartPanel(chart) )
        frame.pack()
        frame.setVisible(true)
	}
}