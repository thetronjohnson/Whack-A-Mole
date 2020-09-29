import java.util.*;
public class WhackAMole {
	int score = 0;
	int molesLeft = 0;
	int attemptsLeft;
	char[][] moleGrid;
	
	WhackAMole(int numAttempts, int gridDimension){
		this.attemptsLeft = numAttempts;
		this.moleGrid = new char[gridDimension][gridDimension];
		for(int i=0;i<gridDimension;i++) {
			for(int j=0;j<gridDimension;j++) {
				this.moleGrid[i][j]='*';
			}
		}
	}
	boolean place(int x, int y) {
		if(this.moleGrid[x][y] != 'M') {
			this.moleGrid[x][y] = 'M';
			this.molesLeft++;
			return true;
		}
		return false;
	}
	void whack(int x, int y) {
		if(this.moleGrid[x][y]=='M') {
			this.score++;
			this.molesLeft--;
			this.attemptsLeft--;
			this.moleGrid[x][y]='W';
		}
		else {
			this.attemptsLeft--;
		}
	}
	void printGridToUser() {
		for(int i = 0; i < this.moleGrid.length; i++) {
			for(int j = 0; j < this.moleGrid.length; j++) {
				if(moleGrid[i][j]=='M') {
					System.out.print("* ");
				}
				else {
					System.out.print(this.moleGrid[i][j]+" ");
				}
			}
			System.out.println();
		}
	}
	void printGrid() {
		for(int i=0;i<this.moleGrid.length;i++) {
			for(int j=0;j<this.moleGrid.length;j++) {
				System.out.print(this.moleGrid[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		String inputLine;
		String[] inputVector;
		WhackAMole game = new WhackAMole(50,10);
		Random rand = new Random();
		for(int i = 0; i<11; i++) {
			int a,b;
			a = rand.nextInt(10);
			b = rand.nextInt(10);
			game.place(a,b);
		}
		
		while(game.attemptsLeft!=0 && game.molesLeft!=0) {
			int x,y;
			Scanner coordinates = new Scanner(System.in);
			System.out.println("Enter the coordinates: ");
			inputLine = coordinates.nextLine();
			inputVector = inputLine.split(",");
			x = Integer.parseInt(inputVector[0]);
			y = Integer.parseInt(inputVector[1]);
			if(x==-1 || y==-1) {
				game.printGrid();
				System.out.println("Game Over!!");
				System.exit(0);
			}
			game.whack(x,y);
			System.out.println("Moles Left: "+ game.molesLeft);
			System.out.println("Attempts Left: " + game.attemptsLeft);
			game.printGridToUser();
		}
		System.out.println("Game Over!!");
		System.out.println("Score: "+game.score);
		
	}
}
