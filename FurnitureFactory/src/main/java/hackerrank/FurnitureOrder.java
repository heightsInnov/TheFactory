package hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FurnitureOrder implements FurnitureOrderInterface {
	/**
	 * TODO: Create a map of Furniture items to order quantities
	 */
	private final HashMap<Furniture, Integer> furnituresItems;
	/**
	 * Initialize a new mapping of Furniture types to order quantities.
	 */

	FurnitureOrder() {
		// TODO: Complete the constructor
		furnituresItems = new HashMap<Furniture, Integer>();

	}

	public void addToOrder(final Furniture type, final int furnitureCount) {
		// TODO: Complete the method
		int count = 0;
        if(furnituresItems.containsKey(type)) {
            count = furnituresItems.get(type);
        }
        furnituresItems.put(type, count + furnitureCount);
	}

	public HashMap<Furniture, Integer> getOrderedFurniture() {
		// TODO: Complete the method
		return new HashMap<Furniture, Integer>(furnituresItems);
	}

	public float getTotalOrderCost() {
		// TODO: Complete the method\
		if(!furnituresItems.isEmpty()) {
        	return furnituresItems.entrySet().stream()
        			.map(f -> f.getKey().cost() * f.getValue())
        			.collect(Collectors.toList())
        			.stream()
        			.reduce(Float::sum)
        			.get();
        }
        return 0.0f;
	}

	public int getTypeCount(Furniture type) {
		// TODO: Complete the method
		if(furnituresItems.containsKey(type)) {
        	return furnituresItems.get(type);
        }
        return 0;
	}

	public float getTypeCost(Furniture type) {
		// TODO: Complete the method
		if(furnituresItems.containsKey(type)) {
			return furnituresItems.get(type).floatValue();
//        	return furnituresItems.get(type) * type.cost();
        }
        return 0.0f;
	}

	public int getTotalOrderQuantity() {
		// TODO: Complete the method
		if(!furnituresItems.isEmpty()) {
        	return furnituresItems.values().stream()
        			.reduce(Integer::sum)
        			.get();
        }
        return 0;
	}
}