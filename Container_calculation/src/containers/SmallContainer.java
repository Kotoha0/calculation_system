//Kotoha Takezaki(23069639)
package containers;

//Create SmallContainer class
public class SmallContainer extends Container {
	public SmallContainer() {
		super(259, 243, 606);
    }
	@Override
	public String getSize() {
		return "Small";
	}

	@Override
	public double calculateVolume() {
		return getHeight() * getWidth() * getLength();
	}

	@Override
	public double getWeightCapacity() {
		return 500;
	}

    
	@Override
    public void ContainerInfo() {
        System.out.println("Small Container:");
        System.out.println("Height: " + getHeight() + " m");
        System.out.println("Width: " + getWidth() + " m");
        System.out.println("Length: " + getLength() + " m");
    }


}