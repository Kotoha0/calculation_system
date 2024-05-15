//Kotoha Takezaki(23069639)
package containers;

//Create Container class
public abstract class Container {
	
	private double height;
    private double width;
    private double length;
    
    
    
 //Generate constructors 
    public Container( double height, double width, double length) {
		super();
		this.height = height;
		this.width = width;
		this.length = length;
	}
    
    public double getHeight() {
		return height;
	}


	public void setHeight(double height) {
		this.height = height;
	}


	public double getWidth() {
		return width;
	}


	public void setWidth(double width) {
		this.width = width;
	}


	public double getLength() {
		return length;
	}


	public void setLength(double length) {
		this.length = length;
	}

	public abstract String getSize();

	public abstract double calculateVolume();

	public abstract double getWeightCapacity();

	public abstract void ContainerInfo();

}