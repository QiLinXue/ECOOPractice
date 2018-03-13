import java.util.*;
import java.io.*;
class Problem4{

	//Main
	public static void main(String[] args) throws IOException {

		//Gets Text File
		File temp = new File("DATA41.txt");
        Scanner file = new Scanner(temp);

		//Iterates for the 5 groves
		for(int j=0;j<5;j++){
	        String trees = file.nextLine();
			int numberOfTrees = Integer.parseInt(trees);
			int[][] grove = new int[numberOfTrees][2];

			//Reads the tree data for each grove
			for(int h=0;h<numberOfTrees;h++){
				String treePosition = file.nextLine();
				grove[h] = seperate(treePosition);
			}

			//Final Message
			System.out.println("There are " + countPerimeterTrees(grove) + " perimeter trees in this grove of " + numberOfTrees + " trees.");
		}

		//End
		file.close();
	}

	//Seperates the data give like as x y and returns it as an array (x,y)
	static int[] seperate(String trees){
		int spaceLocation = 0;
		for(int i=0;i<trees.length();i++){
			if(trees.charAt(i) == ' '){
				spaceLocation = i;
			}
		}
		int xposition = Integer.parseInt(trees.substring(0,spaceLocation));
		int yposition = Integer.parseInt(trees.substring(spaceLocation+1,trees.length()));
		int[] finalTree = {xposition, yposition};
		return finalTree;
	}

	//Takes a single tree and tests if it
	static boolean isOnPerimeter(int[] tree, int[][] grove){

		//Default
		boolean bottomRightExists = false;
		boolean topLeftExists = false;
		boolean bottomLeftExists = false;
		boolean topRightExists = false;
		boolean rightTaken = false;
		boolean leftTaken = false;
		boolean topTaken = false;
		boolean bottomTaken = false;

		//Compares the inputted tree against all other trees
		for(int i=0;i<grove.length;i++){
			//Basic booleans about general location of a single tree
			if(grove[i][0] > tree[0] && grove[i][1] < tree[1]) bottomRightExists = true;
			if(grove[i][0] < tree[0] && grove[i][1] > tree[1]) topLeftExists = true;
			if(grove[i][0] < tree[0] && grove[i][1] < tree[1]) bottomLeftExists = true;
			if(grove[i][0] > tree[0] && grove[i][1] > tree[1]) topRightExists = true;
			if(grove[i][0] > tree[0]) rightTaken = true;
			if(grove[i][0] < tree[0]) leftTaken = true;
			if(grove[i][1] > tree[1]) topTaken = true;
			if(grove[i][1] < tree[1]) bottomTaken = true;
		}

		// Using previously generated boolean data, compares inputted tree against all other trees
		for(int i=0;i<grove.length;i++) // loops through all possible first trees
		{
			for(int j=0;j<grove.length;j++) // loops through all possible second trees
			{
				double slopeOne = 0.0;
				double slopeTwo = 0.0;

				if(tree != grove[i] && tree != grove[j]) //if the trees are not identical
				{
					//Gets the slopes
					slopeOne = ((tree[1]-grove[i][1])*1.0)/((tree[0]-grove[i][0])*1.0);
					slopeTwo = ((tree[1]-grove[j][1])*1.0)/((tree[0]-grove[j][0])*1.0);

					//If the slope is infinity
					if((tree[0]-grove[i][0])*1.0 == 0 || (tree[0]-grove[j][0])*1.0 == 0){
						if(rightTaken && leftTaken && topTaken && bottomTaken) return false;
					}
				}

				boolean slopePositive = slopeOneOne*slopeTwo > 0;
				if(slopePositive && slopeOne < slopeTwo)
				{
					if(grove[i][0] < tree[0] && grove[j][0] > tree[0] && slopeOne>0 && bottomRightExists){
						return false;
					}
					if(grove[i][0] < tree[0] && grove[j][0] > tree[0] && slopeOne<0 && bottomLeftExists){
						return false;
					}
				}
				if(slopePositive && slopeOne > slopeTwo){
					if(grove[i][0] < tree[0] && grove[j][0] > tree[0] && slopeOne>0 && topLeftExists){
						return false;
					}
					if(grove[i][0] < tree[0] && grove[j][0] > tree[0] && slopeOne<0 && topRightExists){
						return false;
					}
				}

			}
		}

		return true;
	}

	static int countPerimeterTrees(int[][] grove){
		int counter = 0;
		for(int i=0;i<grove.length;i++){
			if(isOnPerimeter(grove[i],grove)){
				counter++;
			}
		}
		return counter;
	}

}
