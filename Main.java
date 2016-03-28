import java.util.Scanner;

class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()){
			int n = sc.nextInt();
			boolean checked[][] = new boolean[2 * n][2 * n];
			int count[] = {0, 0};
			count(checked, 0, 0, n, count);
			System.out.println("In the case n = " + n + ", " + count[1] + " cells contain segments of the circle.");
			System.out.println("There are " + count[0] + " cells completely contained in the circle.");
			System.out.println();
		}
	}

	public static void count(boolean checked[][], int x, int y, int n, int count[]){
		if(x < 2 * n && y < 2 * n && !checked[x][y]){
			checked[x][y] = true;
			if(inClrcle(x, y, n) && inClrcle(x + 1, y, n) && inClrcle(x, y + 1, n) && inClrcle(x + 1,y + 1, n)){
				count[0]++;
				count(checked, x + 1, y, n, count);
				count(checked, x, y + 1, n, count);
			}else if(inClrcle(x, y, n) || inClrcle(x + 1, y, n) || inClrcle(x, y + 1, n) || inClrcle(x + 1,y + 1, n)){
				count[1]++;
				count(checked, x + 1, y, n, count);
				count(checked, x, y + 1, n, count);
			}else{
				count(checked, x + 1, y, n, count);
				count(checked, x, y + 1, n, count);
			}
		}
	}

	public static boolean inClrcle(int x, int y, int n){
		return (x - n) * (x - n) + (y - n) * (y - n) <= (2 * n - 1) * (2 * n - 1) / 4 ;
	}
}