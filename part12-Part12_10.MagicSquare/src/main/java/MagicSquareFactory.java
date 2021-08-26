public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {

        MagicSquare square = new MagicSquare(size);

        // The Siamese method is a simple method to construct any size of n-odd magic squares.
        // Read more: https://en.wikipedia.org/wiki/Siamese_method

        // Starting row (position y)
        int currentRow = 0;
        // Starting column (position x)
        int currentCol = size / 2;

        // Set number 1 to the center-most column of the top row
        square.placeValue(currentCol, currentRow, 1);

        // Iterating over n * n sized matrix
        for (int i = 2; i <= size * size; i++) {
            // Move one box up
            int nextRow = currentRow - 1;

            // Jump to the bottom edge if the transition would leave us outside the bounds of square
            if (nextRow < 0) {
                nextRow = square.getHeight() - 1;
            }

            // Move one box right
            int nextCol = currentCol + 1;

            // Jump to the left edge if the transition would leave us outside the bounds of square
            if (nextCol >= square.getWidth()) {
                nextCol = 0;
            }

            // Get next box value
            int nextBoxValue = square.readValue(nextCol, nextRow);

            // If the place already contains a number, we don't go up and right. Instead, we take one step downwards.
            if (nextBoxValue != 0) {
                nextRow = currentRow + 1;
                nextCol = currentCol;
            }

            // Place the value (i) into the available place (x, y)
            square.placeValue(nextCol, nextRow, i);

            // Set the positions as to where we left off
            currentRow = nextRow;
            currentCol = nextCol;
        }

        return square;
    }

}
