package main;

import java.awt.Point;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class ReversiSolver {

	private Point bestMove;

	public ReversiSolver(String input) {
		validateInput(input);

		Board board = initialiseBoard(input);
		bestMove = board.findBestMove();
	}

	public Point getBestMove() {
		return bestMove;
	}

	private Board initialiseBoard(String input) {
		Board board = new Board();
		String[] lines = input.split("\n");

		for (int row = 0; row < lines.length; row++) {
			String line = lines[row];
			char[] charArray = line.toCharArray();

			for (int col = 0; col < charArray.length; col++) {
				char ch = charArray[col];
				TokenType type = TokenType.convert(ch);

				board.addToken(row, col, type);
			}
		}

		return board;
	}

	private void validateInput(String input) {
		if (input == null || "".equals(input)) {
			throw new IllegalArgumentException("Input was empty");
		}

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
	}

	public static void main(String[] args) {
		StringJoiner input = new StringJoiner("\n");
		input.add(".w......");
		input.add("........");
		input.add("........");
		input.add("........");
		input.add("........");
		input.add("........");
		input.add("........");
		input.add("........");

		ReversiSolver solver = new ReversiSolver(input.toString());
		Point bestMove = solver.getBestMove();
		String result = MessageFormat.format("The best move was row: {0}, column: {1}", bestMove.getX(), bestMove.getY());
		System.out.println(result);
	}

}
