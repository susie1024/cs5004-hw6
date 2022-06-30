import org.junit.Assert;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/* JUnit Test for the Pawn Class */

public class PawnTest {

    private Pawn b1, b2, b3, b4;

    @org.junit.Before
    public void setUp(){
        b1 = new Pawn(0, 6, ChessPieceImplementation.TypeOfColor.WHITE);
        b2 = new Pawn(1, 6, ChessPieceImplementation.TypeOfColor.WHITE);
        b3 = new Pawn(0, 1, ChessPieceImplementation.TypeOfColor.BLACK);
        b4 = new Pawn(1, 5, ChessPieceImplementation.TypeOfColor.BLACK);
    }

    @org.junit.Test
    public void getRow() {
        Assert.assertEquals(6, b1.getRow());
        Assert.assertEquals(6, b2.getRow());
        Assert.assertEquals(1, b3.getRow());
        Assert.assertEquals(5, b4.getRow());
    }

    @org.junit.Test
    public void getColumn() {
        Assert.assertEquals(0, b1.getColumn());
        Assert.assertEquals(1, b2.getColumn());
        Assert.assertEquals(0, b3.getColumn());
        Assert.assertEquals(1, b4.getColumn());
    }

    @org.junit.Test
    public void getColor() {
        Assert.assertEquals(ChessPieceImplementation.TypeOfColor.WHITE, b1.getColor());
        Assert.assertEquals(ChessPieceImplementation.TypeOfColor.WHITE, b2.getColor());
        Assert.assertEquals(ChessPieceImplementation.TypeOfColor.BLACK, b3.getColor());
        Assert.assertEquals(ChessPieceImplementation.TypeOfColor.BLACK, b4.getColor());

    }

    @org.junit.Test
    public void setRow() {
        // 1. valid row
        b2.setRow(6);
        b3.setRow(4);
        Assert.assertEquals(6, b2.getRow());
        Assert.assertEquals(4, b3.getRow());
    }

    @org.junit.Test (expected = IllegalArgumentException.class)
    public void setRowInvalidInput() {
        // 2. invalid row
        b2.setRow(10);
        b3.setRow(9);
        Assert.assertEquals(6, b2.getRow());
        Assert.assertEquals(4, b3.getRow());
    }

    @org.junit.Test
    public void setColumn() {
        // 1. valid row
        b2.setColumn(0);
        b3.setColumn(4);
        Assert.assertEquals(0, b2.getColumn());
        Assert.assertEquals(4, b3.getColumn());
    }

    @org.junit.Test (expected = IllegalArgumentException.class)
    public void setColumnInvalidInput() {
        // 2. invalid column
        b2.setColumn(-1);
        b3.setColumn(9);
        Assert.assertEquals(0, b2.getColumn());
        Assert.assertEquals(4, b3.getColumn());

    }

    @org.junit.Test
    public void setColor() {
        b2.setColor(ChessPieceImplementation.TypeOfColor.BLACK);
        b3.setColor(ChessPieceImplementation.TypeOfColor.WHITE);
        Assert.assertEquals(ChessPieceImplementation.TypeOfColor.BLACK, b2.getColor());
        Assert.assertEquals(ChessPieceImplementation.TypeOfColor.WHITE, b3.getColor());
    }

    @org.junit.Test
    public void canMove() {
        // can move
        assertTrue(b1.canMove(0, 5));
        assertTrue(b2. canMove(1, 5));
        assertTrue(b3. canMove(0, 2));
        assertTrue(b4. canMove(1, 6));

        // cannot move 1 -- Not "ahead" move
        assertFalse(b1. canMove(1, 7));
        assertFalse(b2. canMove(6, 5));
        assertFalse(b3. canMove(1, 2));
        assertFalse(b4. canMove(6, 0));

        // cannot move 2 -- stay the current position
        assertFalse(b1. canMove(0, 6));
        assertFalse(b2. canMove(7, 6));
        assertFalse(b3. canMove(0, 1));
        assertFalse(b4. canMove(7, 1));

        // cannot move 3 -- outside the chessboard
        assertFalse(b1. canMove(-3, 1));
        assertFalse(b2. canMove(9, 1));
        assertFalse(b3. canMove(0, 10));
        assertFalse(b4. canMove(4, -4));

    }

    @org.junit.Test
    public void canKill() {
        // can kill
        assertTrue(b1.canKill(b4));

        // cannot kill 1 -- same color
        assertFalse(b3.canKill(b4));

        // cannot kill 2 -- cannot move to the position
        assertFalse(b2.canKill(b3));
    }
}