package main;

import java.awt.Point;
import java.util.Map;

public class Token {

	private final int row;
	private final int col;
	private final TokenType type;
	private final Point location;

	public Token(int row, int col, TokenType type) {
		this.row = row;
		this.col = col;
		this.type = type;
		this.location = new Point(row, col);
	}

	public TokenType getType() {
		return type;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public boolean isWhite() {
		return TokenType.WHITE == type;
	}

	public boolean isEmpty() {
		return TokenType.EMPTY == type;
	}

	public Point getLocation() {
		return location;
	}

	public int getBestCount(Map<String, Token> tokens) {
		int bestCountForToken = 0;

		for (int rowDiff = -1; rowDiff <= 1; rowDiff++) {
			for (int colDiff = -1; colDiff <= 1; colDiff++) {
				// don't compare itself
				if (rowDiff == 0 && colDiff == 0) continue;

				int currentCount = countWhiteTokensInDirection(tokens, row, col, rowDiff, colDiff);

				bestCountForToken = Math.max(bestCountForToken, currentCount);
			}
		}
		return bestCountForToken;
	}

	private int countWhiteTokensInDirection(Map<String, Token> tokens, int row, int col, int rowDiff, int colDiff) {
		int newRow = row + rowDiff;
		int newCol = col + colDiff;
		Token token = tokens.get(newRow + "" + newCol);

		if (token != null) {
			if (token.isWhite()) {
				return 1 + countWhiteTokensInDirection(tokens, newRow, newCol, rowDiff, colDiff);
			} else {
				return 0;
			}
		} else {
			return 0;
		}
	}

}
