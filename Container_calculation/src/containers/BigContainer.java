//Kotoha Takezaki(23069639)

package containers;
//Create BigContainer class
public class BigContainer extends Container {
	public BigContainer() {
		super(259, 243, 1201);
    }

	@Override
	public String getSize() {
		return "Big";
	}

	@Override
	public double calculateVolume() {
		return getHeight() * getWidth() * getLength();
	}

	@Override
	public double getWeightCapacity() {
		return Double.POSITIVE_INFINITY;
	}


	@Override
    public void ContainerInfo() {
        System.out.println("Big Container:");
        System.out.println("Height: " + getHeight() + " m");
        System.out.println("Width: " + getWidth() + " m");
        System.out.println("Length: " + getLength() + " m");
    }

}