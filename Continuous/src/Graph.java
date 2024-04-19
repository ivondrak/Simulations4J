/**
 * Graph class. Draw the execution of the simulation .<p>
 *
 * @version 1.0, Feb 06, 2011
 * @author Ivo Vondrak
 */
public class Graph {
	/**
	 * Defines size of the drawing
	 */
	protected int maxXCoord, maxYCoord;
	/**
	 * Shifts drawing coordinates
	 */
	protected int moveX, moveY;
	/**
	 * Ration for X and Y coordinates
	 */
	protected float xCoordUnit, yCoordUnit;
	/**
	 * Size of real coordinates
	 */
	float minXValue, maxXValue, minYValue, maxYValue;
	/**
	 * Matrix for the drawing 50x50
	 */
	protected char grid[][] = new char[105][105];
	
	/**
	 * Constructor
	 */
	public Graph(float minXValue, float maxXValue, float minYValue, float maxYValue, int maxXCoord, int maxYCoord) {
		char space = ' ';
		int rows, columns;
		
		this.minXValue = minXValue;
		this.maxXValue = maxXValue;
		this.minYValue = minYValue;
		this.maxYValue = maxYValue;
		this.maxXCoord = (maxXCoord > 100 ? 100 : maxXCoord) ;
		this.maxYCoord = (maxYCoord > 100 ? 100 : maxYCoord);
		this.xCoordUnit = (maxXValue-minXValue)/(float) maxXCoord;
		this.yCoordUnit = (maxYValue-minYValue)/(float) maxYCoord;
		this.moveX = (int) (minXValue/(float) xCoordUnit + (minXValue < 0 ? -0.5 : 0.5)) * (-1);
		this.moveY = (int) (minYValue/(float) yCoordUnit + (minYValue < 0 ? -0.5 : 0.5)) * (-1);
		for (rows = 0; rows < maxYCoord; rows++)
			for (columns = 0; columns < maxXCoord; columns++)
				grid[columns][rows] = space;
	}
	
	/**
	 * Update Graph with a new value
	 */
	public void update(float xValue, float yValue, char symbol) {
		char overPrintSymbol = '#';
		char space = ' ';
		int x,y;
		if (xValue < minXValue || xValue > maxXValue)
			System.out.println("X = "+(new Float(xValue)).toString()+" out of the range for this graph!");
		else
			if (yValue < minYValue || yValue > maxYValue)
				System.out.println("Y = "+(new Float(yValue)).toString()+" out of the range for this graph!");
			else {
				x = (int) (xValue/(float) xCoordUnit+(xValue < 0 ? -0.5 : 0.5)) + moveX;
				y = (int) (yValue/(float) yCoordUnit+(yValue < 0 ? -0.5 : 0.5)) + moveY;
				if (grid[x][y] != space && grid[x][y] != symbol)
					grid[x][y] = overPrintSymbol;
				else
					grid[x][y] = symbol;
			}
	}
	
	/**
	 * Show drawing
	 */
	public void show() {
		char space = ' ';
		char origin = '+';
		char xAxis = '-';
		char yAxis = '|';
		int rows, columns;
		float yLabel;
		
		System.out.println();
		for (int i=0; i < 10; i++)
			System.out.print(space);
		System.out.print(minXValue);
		for (int i=0; i < (maxXCoord-((new Float(maxXValue)).toString().length())); i++)
			System.out.print(space);
		System.out.print(maxXValue);
		System.out.println();
		for (int i=0; i < 10; i++)
			System.out.print(space);
		System.out.print(origin);
		for (int i=0; i < maxXCoord; i++)
			System.out.print(xAxis);
		System.out.println();
		yLabel = minYValue;
		String label = (new Float(yLabel)).toString();
		int length = label.length();
		for (rows = 0; rows < maxYCoord; rows++) {
			if (rows%5 == 0) {
				for (int i=0; i < 10-length-1; i++)
					System.out.print(space);
				System.out.print(label);
				System.out.print(space);
				System.out.print(yAxis);
			}
			else {
				for (int i=0; i < 10; i++)
					System.out.print(space);
				System.out.print(yAxis);
			}
			for (columns = 0; columns < maxXCoord; columns++)	
				System.out.print(grid[columns][rows]);
			System.out.println();
			yLabel += yCoordUnit;
			yLabel = Math.round(yLabel*100f)/100f;
			label = (new Float(yLabel)).toString();
			length = label.length();
		}
	System.out.println();	
	}

}
