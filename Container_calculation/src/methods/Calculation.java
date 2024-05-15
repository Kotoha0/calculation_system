//Kotoha Takezaki(23069639)
package methods;

import items.Item;
import containers.Container;
import java.util.List;


//Create Calculation class
public class Calculation {
	private List<Item> items;
	private Container bigContainer;
	private Container smallContainer;
	private boolean smallCount;
	

    public Calculation(List<Item> items, Container bigContainer, Container smallContainer) {
        this.items = items;
        this.bigContainer = bigContainer;
        this.smallContainer = smallContainer;
        this.smallCount = false;
    }

    

	// Add an item to the list
    public void addItem(Item item) {
        items.add(item);
    }
    
    // Calculate the total volume of all items
    public double totalVolume() {
        double totalVolume = 0;
        for (Item item : this.items) {
            totalVolume += item.calculateVolume()*item.getQuantity();
        }
        return totalVolume;
    }

    // Calculate the total weight of all items
    public double totalWeight() {
        double totalWeight = 0;
        for (Item item : this.items) {
            totalWeight += item.getWeight()*item.getQuantity();
        }
        return totalWeight;
    }

    // Calculate the best shipping method
    public int bestShipping() {
        double totalVolume = totalVolume();
        

        // Count the number of big and small containers needed
        int bigContainerCount = 0;
        do {
	        if (totalVolume > smallContainer.calculateVolume()) {
	        	if (totalVolume > bigContainer.calculateVolume()) {
	        		bigContainerCount ++;
	        		totalVolume -= bigContainer.calculateVolume();
	        	}else {
	        		bigContainerCount ++;
	        		totalVolume = 0;
	        	}
	        }else if(totalVolume !=0){
	        	this.smallCount = true;
	            totalVolume = 0;
	        }
        }while(totalVolume > 0);

        
        return bigContainerCount;
    }

    // Calculate the shipping price based on the container
    public double shippingPrice() {
        double cost = this.bestShipping() * 1800;
        if (this.smallCount == true) {
        	if (this.totalWeight() > 500) {
        		cost += 1200;
        	} else {
        		cost += 1000;
        	}
        }
        
        return cost;
    }



	public boolean isSmallCount() {
		return smallCount;
	}



	public void setSmallCount(boolean smallCount) {
		this.smallCount = smallCount;
	}

   
}
