package numberOfBoxes;

public class NumberOfBoxes {
	
	public int[] getNumberOfBoxes(int[] itemSizes, int boxSize) {
		int[] boxes = new int[itemSizes.length]; //used capacity
		IntWrapper lastBox = new IntWrapper(0);
		IntWrapper minBoxes = new IntWrapper(itemSizes.length);
		int[] itemBoxes = new int[itemSizes.length];
		
		calculateBoxOfEachItem(0, itemSizes, itemBoxes, boxes,  lastBox, minBoxes, boxSize);
		return itemBoxes;
	}
	

	private void calculateBoxOfEachItem(int n, int[] itemSizes, int[] itemBoxes, int[] boxes, IntWrapper lastBox, IntWrapper minBoxes, int boxSize) {
		if(n == itemBoxes.length) {
			if((lastBox.getValue()+1) < minBoxes.getValue()) {
				minBoxes.setValue(lastBox.getValue()+1);
			}
		}
		
		else {
			int aux = lastBox.getValue();
			for(int i=0; i<=aux && i<boxes.length; i++) {
				if((boxes[i] + itemSizes[n]) <= boxSize) {
					boxes[i] += itemSizes[n];
					itemBoxes[n] = i;
					calculateBoxOfEachItem(n+1, itemSizes, itemBoxes, boxes, lastBox, minBoxes, boxSize);
				}
				else if(i == lastBox.getValue()){
					lastBox.setValue(i+1);
					calculateBoxOfEachItem(n, itemSizes, itemBoxes, boxes, lastBox, minBoxes, boxSize);
				}
			}
		}
	}

}
