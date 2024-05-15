//Kotoha Takezaki(23069639)

package items;

public class Item {
	
	//Create class of Item
		private String name;
		private double height;
		private double width;
		private double length;
		private double weight;
		private int quantity;
		
		//Generate Constructor
		public Item(String name, double width, double height, double length, double weight, int quantity) {
			super();
			this.name = name;
			this.height = height;
			this.width = width;
			this.length = length;
			this.weight = weight;
			this.quantity =quantity;
		}
		
		//Generate Getter and Setters
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
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

		public double getWeight() {
			return weight;
		}

		public void setWeight(double weight) {
			this.weight = weight;
		}
		public double getQuantity() {
			
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public double calculateVolume() {
			return length * width * height;
			
			}
		
		public void ItemInfo() {
			System.out.println("Item: " + name);
			System.out.println("Dimentions: " + height + "x" + width + "x" + length + "cm");
			System.out.println("weight: " + weight + "kg");
			
		}

		
	
}
