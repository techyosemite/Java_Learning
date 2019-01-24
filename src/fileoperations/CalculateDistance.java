package fileoperations;

public class CalculateDistance {

	public static int rowCount = 3;

	public static int columnCount = 3;

	public static int[][] lookupTable = new int[3][3];

	public static int calculate(int x, int y, int[][] inputArray) {

		return 1 + Math.max(
				Math.max(getDistance(x, y, x, y - 1, inputArray),
						getDistance(x, y, x - 1, y, inputArray)),
				Math.max(getDistance(x, y, x, y + 1, inputArray),
						getDistance(x, y, x + 1, y + 1, inputArray)));
	}

	public static int getDistance(int x, int y, int dx, int dy,
			int[][] inputArray) {

		if (x > rowCount - 1 || y > columnCount - 1 || dx > rowCount - 1
				|| dy > columnCount - 1 || x < 0 || y < 0 || dx < 0 || dy < 0)
			return 0;

		if (inputArray[x][y] >= inputArray[dx][dy])
			return 1
					+ lookupTable[dx][dy]
					+ Math.max(Math.max(
							getDistance(dx, dy, dx, dy - 1, inputArray),
							getDistance(dx, dy, dx - 1, dy, inputArray)), Math
							.max(getDistance(dx, dy, dx, dy + 1, inputArray),
									getDistance(dx, dy, dx + 1, dy + 1,
											inputArray)));
		else
			return 0;

	}

	public static void main(String[] args) {

		// int[][] inputArray = { { 7, 6 }, { 4, 5 } };

		int[][] inputArray = { { 7, 6, 3 }, { 2, 1, 2 }, { -1, 0, 20 } };

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				lookupTable[i][j] = calculate(i, j, inputArray);
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.println(lookupTable[i][j] + "\n");
			}
		}
	}
}
