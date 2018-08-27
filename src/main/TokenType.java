package main;

public enum TokenType {
	WHITE,
	BLACK,
	EMPTY;

	public static TokenType convert(char ch) {
		switch (ch) {
			case 'w':
				return WHITE;
			case 'b':
				return BLACK;
			case '.':
				return EMPTY;
			default:
				return null;
		}
	}

}
