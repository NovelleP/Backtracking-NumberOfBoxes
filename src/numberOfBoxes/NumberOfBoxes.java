package numberOfBoxes;

public class NumberOfBoxes {
	
	public int getNumberOfBoxes(int[] itemSizes, int boxSize) {
		int[] boxes = new int[itemSizes.length]; //used capacity
		IntWrapper lastBox = new IntWrapper(0);
		IntWrapper minBoxes = new IntWrapper(itemSizes.length);
		
		calculateNumberOfBoxes(0, itemSizes, boxes,  lastBox, minBoxes, boxSize);
		
//		int[] itemBoxes = new int[itemSizes.length];
//		calculateBoxOfEachItem(0, itemSizes, itemBoxes, boxes,  lastBox, minBoxes, boxSize);
//		
		return minBoxes.getValue();
	}
	
	private void calculateNumberOfBoxes(int n, int[] itemSizes, int[] boxes, IntWrapper lastBox, IntWrapper minBoxes, int boxSize) {
		if(n == itemSizes.length) {
			if(lastBox.getValue() < minBoxes.getValue())
				minBoxes.setValue(lastBox.getValue());
		}
		
		else {
			int aux = lastBox.getValue(); //actual lastBox 
			for(int i=0; i<=aux; i++) {
				if(boxes[i] + itemSizes[n] <= boxSize) {
					boxes[i] += itemSizes[n];
					if(i+1 > lastBox.getValue())
						lastBox.setValue(i+1);
					calculateNumberOfBoxes(n+1, itemSizes, boxes, lastBox, minBoxes, boxSize);
				}
			}
		}
	}
	
	
	/*this method also gets the box that stores each item*/
	private void calculateBoxOfEachItem(int n, int[] itemSizes, int[] itemBoxes, int[] boxes, IntWrapper lastBox, IntWrapper minBoxes, int boxSize) {
		if(n == itemBoxes.length) {
			if(lastBox.getValue() < minBoxes.getValue())
				minBoxes.setValue(lastBox.getValue());
		}
		
		else {
			int aux = lastBox.getValue();
			for(int i=0; i<=aux && i<boxes.length; i++) {
				if(boxes[i] + itemSizes[n] <= boxSize) {
					boxes[i] += itemSizes[n];
					itemBoxes[n] = i+1;
					if(i+1 > lastBox.getValue())
						lastBox.setValue(i+1);
					calculateBoxOfEachItem(n+1, itemSizes, itemBoxes, boxes, lastBox, minBoxes, boxSize);
				}
			}
		}
	}

}
