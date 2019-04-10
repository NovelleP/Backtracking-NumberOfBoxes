package numberOfBoxes;

public class NumberOfBoxes {
	
	public int[] getNumberOfBoxes(int[] itemSizes, int boxSize) {
		int[] boxes = new int[itemSizes.length]; //used capacity
		IntWrapper minBoxes = new IntWrapper(itemSizes.length+1);
		IntWrapper lastBox = new IntWrapper(-1); //last box used in current configuration
		int[] itemBoxes = new int[itemSizes.length];
		int[] bestItemBoxes = new int[itemSizes.length];
		
		calculateBoxOfEachItem(0, itemSizes, itemBoxes, boxes, lastBox, minBoxes, boxSize, bestItemBoxes);
		return bestItemBoxes;
	}
	

	private void calculateBoxOfEachItem(int n, int[] itemSizes, int[] itemBoxes, int[] boxes, IntWrapper lastBox, IntWrapper minBoxes, int boxSize, int[] bestItemBoxes) {
		if(n == itemBoxes.length) {				
			if((lastBox.getValue()+1) < minBoxes.getValue()) {
				minBoxes.setValue(lastBox.getValue()+1);
				copyArray(itemBoxes, bestItemBoxes);				
			}
		}		
		else {
			for(int i=0; i<=n; i++) {
				if((boxes[i] + itemSizes[n]) <= boxSize) {
					if(boxes[i] == 0)
						lastBox.setValue(i);
					boxes[i] += itemSizes[n];
					itemBoxes[n] = i;
					calculateBoxOfEachItem(n+1, itemSizes, itemBoxes, boxes, lastBox, minBoxes, boxSize, bestItemBoxes);
					boxes[i] -= itemSizes[n];
					if(boxes[i] == 0) //when current box is used for the first time, the loop ends
						break;
				}
			}
		}
	}

	private void copyArray(int[] itemBoxes, int[] bestItemBoxes) {
		for(int i=0; i<itemBoxes.length; i++)
			bestItemBoxes[i] = itemBoxes[i];		
	}

}
