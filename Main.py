def main():
	n = int(input())
	global total
	global check
	flag = False
	while isinstance(n, int):
		total = [0, 0]
		check = [[False for x in range(2 * n)] for y in range(n * 2)]
		count(0, 0, n)
		if flag:
			print()
		print("In the case n = " + str(n) + ", " + str(total[1]) + " cells contain segments of the circle.")
		print("There are " + str(total[0]) + " cells completely contained in the circle.")
		flag = True
		n = int(input())

def count(x, y, n):
	if x < 2 * n and y < 2 * n and not check[x][y]:
		check[x][y] = True
		if inCircle(x, y, n) and inCircle(x + 1, y, n) and inCircle(x + 1, y + 1, n) and inCircle(x, y + 1, n):
			total[0] += 1
		elif inCircle(x, y, n) or inCircle(x + 1, y, n) or inCircle(x + 1, y + 1, n) or inCircle(x, y + 1, n):
			total[1] += 1

		count(x + 1, y, n)
		count(x, y + 1, n)


def inCircle(x, y, n):
	return (x - n)**2 + (y - n)**2 <= (2*n - 1)**2/4

if __name__ == "__main__":
	main()