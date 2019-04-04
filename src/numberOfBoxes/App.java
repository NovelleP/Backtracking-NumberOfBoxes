package numberOfBoxes;

public class App {

	public static void main(String[] args) {
		NumberOfBoxes b = new NumberOfBoxes();
		int[] itemSizes = {7,10,4,2,15,7,15};
		int boxSize = 18;
		int boxes = b.getNumberOfBoxes(itemSizes, boxSize);
		System.out.println(boxes);
		

	}

}
