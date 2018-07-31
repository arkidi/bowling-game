import Game.Game;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GameTest {

    private Game game;

    @Test
    public void nothing(){

    }

    @Before
    public void setUp() throws Exception {
        game = new Game();
    }

    @Test
    public void canRoll() {
        Game g = new Game();
        g.roll(0);
    }

    @Test
    public void gutterGame() {
        rollMany(20, 0);
        assertThat(game.getScore(), is(0));
    }

    @Test
    public void allOnes() {
        rollMany(20, 1);
        assertThat(game.getScore(), is(20));
    }

    @Test
    public void oneSpare() {
        rollSpare();
        game.roll(3);
        rollMany(17, 0);
        assertThat(game.getScore(), is(16));
    }

    @Test
    public void oneStrike() {
        rollStrike();
        game.roll(5);
        game.roll(3);
        rollMany(16, 0);
        assertThat(game.getScore(), is(26));
    }

    @Test
    public void perfectGame1() {
        rollMany(12, 10);
        assertThat(game.getScore(), is(300));
    }

    @Test
    public void perfectGame2() {
        rollMany(10, 10);
        rollStrike();
        rollStrike();
        assertThat(game.getScore(), is(300));
    }

    @Test
    public void lackPerfectGame() {
        rollMany(10, 10);
        rollStrike();
        game.roll(9);
        assertThat(game.getScore(), is(299));
    }

    private void rollStrike() {
        game.roll(10);
    }

    private void rollSpare() {
        game.roll(5);
        game.roll(5);
    }

    private void rollMany(int rolls, int pins) {
        for(int i = 0; i < rolls; i++)
            game.roll(pins);
    }
}
