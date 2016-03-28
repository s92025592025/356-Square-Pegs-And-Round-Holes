#include <iostream>
using namespace std;

void count(bool checked[1000][1000], int x, int y, int n, int sum[]);
bool inCircle(int x, int y, int n);

int main(){
	int n;
	bool flag =false;
	while(cin >> n){
		bool checked[1000][1000] = {false};
		int sum[2] = {0};
		count(checked, 0, 0, n, sum);
		if(flag){
			cout << endl;
		}
		cout << "In the case n = " << n << ", " << sum[1] << " cells contain segments of the circle." << endl;
		cout << "There are " << sum[0] << " cells completely contained in the circle." << endl;
		flag = true;
	}
	return 0;
}

void count(bool checked[1000][1000], int x, int y, int n, int sum[]){
	if(x < 2 * n && y < 2 * n && !checked[x][y]){
		checked[x][y] = true;
		if(inCircle(x, y, n) && inCircle(x + 1, y, n) && inCircle(x,  y + 1, n) && inCircle(x + 1, y + 1, n)){
			sum[0]++;
		}else if(inCircle(x, y, n) || inCircle(x + 1, y, n) || inCircle(x,  y + 1, n) || inCircle(x + 1, y + 1, n)){
			sum[1]++;
		}
		
		count(checked, x + 1, y, n, sum);
		count(checked, x, y + 1, n, sum);
	}
}

bool inCircle(int x, int y, int n){
	return (x - n) * (x - n) + (y - n) * (y - n) <= (2 * n - 1) * (2 * n - 1) / 4;
}
