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
	  
		/* GRAPHICS */
	    val series = Array(Array(1., 2.), Array(3., 4.))
	    
	    var dataset = new DefaultXYDataset();
	    dataset.addSeries("facebook", series)
	    
	    
	    val chart = ChartFactory.createXYLineChart(
	           "Hello World",
	           "Time",
	           "Subscribers",
	            dataset,
	            PlotOrientation.VERTICAL,
	            true,
	            true,
	            false);
 
        val frame = new JFrame("Hello Pie World")
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE )
 
        frame.setSize(640,420)
        frame.add( new ChartPanel(chart) )
        frame.pack()
        frame.setVisible(true)
	}
}