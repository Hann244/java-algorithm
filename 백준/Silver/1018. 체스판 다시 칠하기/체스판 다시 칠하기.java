import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int N = Integer.parseInt(str.split(" ")[0]);
		int M = Integer.parseInt(str.split(" ")[1]);
		
		// 체스판
		String[] board = new String[N];
				
		for (int i = 0; i < N; i++) {
			board[i] = br.readLine();
		}
		
		// 체스판 자르기
		int sol = Integer.MAX_VALUE;
		// 8 * 8 체스판을 만들기 위해서 - 8을 해줌
		// 체스판을 만들 수 있는 마지막 row와 col index를 각각 i와 j에 담음
		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {
				// 현 체스판의 최소 비용 구하기
				int curSol = getSolution(i, j, board);
				// 전체 최적의 값과 비교하여 갱신하기
				if (sol > curSol) sol = curSol;
			}
		}
		
		System.out.println(sol);
		
		
	}
	
	public static int getSolution(int startRow, int startCol, String[] board) {
		String[] orgBoard = {"WBWBWBWB", "BWBWBWBW"}; // 정답지
		int whiteSol = 0;
		for (int i = 0; i < 8; i++) {
			int row = startRow + i;
			for (int j = 0; j < 8; j++) {
				int col = startCol + j;
				if (board[row].charAt(col) != orgBoard[row % 2].charAt(j)) whiteSol++;
			}
		}
		
		return Math.min(whiteSol, 64 - whiteSol);
	}
}
