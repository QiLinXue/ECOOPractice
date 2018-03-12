import java.util.*;
import java.io.*;
class Problem4{
	public static void main(String[] args) throws IOException {

		File temp = new File("DATA41.txt");
        Scanner file = new Scanner(temp);
		for(int j=0;j<5;j++){
	        String trees = file.nextLine();
			int numberOfTrees = Integer.parseInt(trees);
			int[][] grove = new int[numberOfTrees][2];

			for(int h=0;h<numberOfTrees;h++){
				String treePosition = file.nextLine();
				grove[h] = seperate(treePosition);
			}
			System.out.println("There are " + countPerimeterTrees(grove) + " perimeter trees in this grove of " + numberOfTrees + " trees.");
		}
		file.close();
	}

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

	static boolean isOnPerimeter(int[] tree, int[][] grove){
		boolean bottomRightExists = false;
		boolean topLeftExists = false;
		boolean bottomLeftExists = false;
		boolean topRightExists = false;
		boolean rightTaken = false;
		boolean leftTaken = false;
		boolean topTaken = false;
		boolean bottomTaken = false;

		for(int i=0;i<grove.length;i++){
			if(grove[i][0] > tree[0] && grove[i][1] < tree[1]) bottomRightExists = true;
			if(grove[i][0] < tree[0] && grove[i][1] > tree[1]) topLeftExists = true;
			if(grove[i][0] < tree[0] && grove[i][1] < tree[1]) bottomLeftExists = true;
			if(grove[i][0] > tree[0] && grove[i][1] > tree[1]) topRightExists = true;
			if(grove[i][0] > tree[0]) rightTaken = true;
			if(grove[i][0] < tree[0]) leftTaken = true;
			if(grove[i][1] > tree[1]) topTaken = true;
			if(grove[i][1] < tree[1]) bottomTaken = true;

		}

		for(int i=0;i<grove.length;i++){
			for(int j=0;j<grove.length;j++){
				double slopeOne = 0.0;
				double slopeTwo = 0.0;
				if(tree != grove[i] && tree != grove[j]){
					slopeOne = ((tree[1]-grove[i][1])*1.0)/((tree[0]-grove[i][0])*1.0);
					slopeTwo = ((tree[1]-grove[j][1])*1.0)/((tree[0]-grove[j][0])*1.0);
					if((tree[0]-grove[i][0])*1.0 == 0 || (tree[0]-grove[j][0])*1.0 == 0){
						if(rightTaken && leftTaken && topTaken && bottomTaken) return false;
					}

				}

				if(slopeOne*slopeTwo > 0 && slopeOne < slopeTwo){
					if(grove[i][0] < tree[0] && grove[j][0] > tree[0] && slopeOne>0 && bottomRightExists){
						return false;
					}
					if(grove[i][0] < tree[0] && grove[j][0] > tree[0] && slopeOne<0 && bottomLeftExists){
						return false;
					}
				}
				if(slopeOne*slopeTwo > 0 && slopeOne > slopeTwo){
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
