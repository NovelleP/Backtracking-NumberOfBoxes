package numberOfBoxes;

import java.util.HashSet;
import java.util.Set;

public class NumberOfBoxes {
	
	public int[] getNumberOfBoxes(int[] itemSizes, int boxSize) {
		int[] boxes = new int[itemSizes.length]; //used capacity
		IntWrapper minBoxes = new IntWrapper(itemSizes.length+1);
		int[] itemBoxes = new int[itemSizes.length];
		int[] bestItemBoxes = new int[itemSizes.length];
		
		calculateBoxOfEachItem(0, itemSizes, itemBoxes, boxes,  minBoxes, boxSize, bestItemBoxes);
		return bestItemBoxes;
	}
	

	private void calculateBoxOfEachItem(int n, int[] itemSizes, int[] itemBoxes, int[] boxes, IntWrapper minBoxes, int boxSize, int[] bestItemBoxes) {
		if(n == itemBoxes.length) {
			int c = countBoxes(itemBoxes); //need optimization. Try save number of box used
			if(c < minBoxes.getValue()) {
				minBoxes.setValue(c);
				copyArray(itemBoxes, bestItemBoxes);
			}
		}		
		else {
			for(int i=0; i<=n; i++) {
				if((boxes[i] + itemSizes[n]) <= boxSize) {
					boxes[i] += itemSizes[n];
					itemBoxes[n] = i;
					calculateBoxOfEachItem(n+1, itemSizes, itemBoxes, boxes, minBoxes, boxSize, bestItemBoxes);
					boxes[i] -= itemSizes[n];
				}
			}
		}
	}
	
	
	private int countBoxes(int[] itemBoxes) {
		Set<Integer> set = new HashSet<>();
		int count = 0;
		for(int n: itemBoxes)
			if(set.add(n))
				count++;
		return count;
	}


	private void copyArray(int[] itemBoxes, int[] bestItemBoxes) {
		for(int i=0; i<itemBoxes.length; i++)
			bestItemBoxes[i] = itemBoxes[i];		
	}

}
