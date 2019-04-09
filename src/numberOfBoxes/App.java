package numberOfBoxes;

public class App {

	public static void main(String[] args) {
		NumberOfBoxes b = new NumberOfBoxes();
		int[] itemSizes = {7,10,4,2,15,7,15};
		int boxSize = 15;
		int[] boxes = b.getNumberOfBoxes(itemSizes, boxSize);
		
		for(int n: boxes)
			System.out.print(n + " ");
		System.out.println();

	}

}
