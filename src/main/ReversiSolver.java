package main;

import java.awt.Point;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class ReversiSolver {

	private Point bestMove;

	public ReversiSolver(String input) {
		if (!validateInput(input)) {
			throw new IllegalArgumentException("Input not provided");
		}

		List<String> board = initialiseBoard(input);
		bestMove = findBestMove(board);
	}

	public Point getBestMove() {
		return this.bestMove;
	}

	private Point findBestMove(List<String> board) {
		int currentSet = 0;
		int bestSet = 0;
		boolean foundBlack = false;
		Point bestMove = new Point();

		for (int row = 0; row < board.size(); row++) {
			String line = board.get(row);

			char[] charArray = line.toCharArray();
			for (int col = 0; col < charArray.length; col++) {
				char token = charArray[col];

				switch (token) {
					case 'b':
						if (foundBlack) {
							if (currentSet > bestSet) {
								bestSet = currentSet;
								bestMove.setLocation(row, col);
							}
							currentSet = 0;
							foundBlack = false;
						} else {
							foundBlack = true;
						}
						break;
					case 'w':
						if (foundBlack) {
							currentSet++;
						}
						break;
					case '.':
						if (foundBlack) {
							currentSet = 0;
							foundBlack = false;
						}
						break;
					default:
						throw new IllegalArgumentException("Invalid token found on line:" + line + ", token:" + token);
				}
			}

			// Reset
			foundBlack = false;
			currentSet = 0;
		}

		return bestMove;
	}

	private List<String> initialiseBoard(String input) {
		List<String> lines = Arrays.asList(input.split("\n"));

		if (lines.size() < 8) {
			throw new IllegalArgumentException("Expected 8 rows");
		}

		for (int i = 0; i < lines.size(); i++) {
			String line = lines.get(i);
			if (line.length() < 8) {
				String errorMessage = MessageFormat.format("Line {0} has {1} characters, should have 8", i, line.length());
				throw new IllegalArgumentException(errorMessage);
			}
		}

		return lines;
	}

	private boolean validateInput(String input) {
		return input != null && !"".equals(input);
	}

	public static void main(String[] args) {
		StringJoiner input = new StringJoiner("\n");
		input.add("........");
		input.add("........");
		input.add("........");
		input.add("........");
		input.add("........");
		input.add("........");
		input.add("........");
		input.add("........");

		ReversiSolver solver = new ReversiSolver(input.toString());
		System.out.println("The best move was: " + solver.getBestMove());

	}

}
