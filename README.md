### ReversiSolver ###

# The aim
Determine the next best move in a game of 'Reversi'.

# The game
The game of Reversi is played on a board with 64 squares arranged in an 8 by 8 grid. One player is white, the other black. They take it in turns to place tokens on the board.

A player can convert a line of the other player’s tokens to their own colour by putting one of
their tokens at both ends of the line (either a horizontal line, a vertical line, or a diagonal line).

For this program, the Reversi board is represented in ASCII, with black as “b”, white as “w”, an empty square as
a period, and newlines between each row.

```
.b....w.
....x...
..x.w...
...ww...
....w...
....bb..
........
........
```

For instance, in this first board black has two opportunities to take white’s tokens, by playing at either of the marked locations (x).

So the results of black playing at either spot are these:
```
.b....w.        .b....w.
........        ....b...
..b.w...        ....b...
...bw...        ...wb...
....b...        ....b...
....bb..        ....bb..
........        ........
........        ........
```
# The challenge
Write a program that accepts such a board representation, either from STDIN or by reading a file, and outputs the single move by black that takes the most white pieces. In the case of a tie-break, it does not matter which move is output.

For instance, for the example above, it would output (1,4) indicating row 1 and column 4 (starting at the top left of the board as (0, 0)) as this would take 3 white tokens, whereas (2, 2) takes only 2 white tokens, and there are no other black moves that take tokens.
