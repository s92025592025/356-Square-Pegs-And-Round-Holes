import java.util.Scanner;

class Main{
	private final static int IN = 2314;
	private final static int UNSURE = 3215;
	private final static int OUT = -4563;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()){
			int n = sc.nextInt();
			int points[][] = new int[(n * 2 + 1)][(n * 2 + 1)];
		}
	}

	public static void initinalizeArray(int[][] array){
		for(int i = 0; i < array.length; i++){
			Arrays.fill(array[i], UNSURE);
		}
	}
}