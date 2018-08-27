package main;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class Board {

	private Map<String, Token> tokens = new HashMap<>();

	public Board() {}

	public void addToken(int row, int col, TokenType type) {
		tokens.put(row + "" + col, new Token(row, col, type));
	}

	public Point findBestMove() {
		Point bestMove = new Point();
		int bestCountForBoard = 0;

		for (Token token : tokens.values()) {
			if (!token.isEmpty()) {
				continue;
			}

			int bestCountForToken = token.getBestCount(tokens);

			if (bestCountForToken > bestCountForBoard) {
				bestCountForBoard = bestCountForToken;
				bestMove = token.getLocation();
			}
		}

		return bestMove;
	}

}
