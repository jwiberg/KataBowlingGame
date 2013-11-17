package kata.bowlinggame;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BowlingGameTest {
	private BowlingGame bowlingGame;

	@Before
	public void before() {
		this.bowlingGame = new BowlingGame();
	}

	@Test
	public void getScoreBeforeFirstThrow() {
		assertEquals(0, bowlingGame.getScore());
	}

	@Test
	public void getScoreAfterFirstThrow() {
		bowlingGame.addThrows(5);
		assertEquals(5, bowlingGame.getScore());
	}

	@Test
	public void getScoreAfterSecondThrow() {
		bowlingGame.addThrows(5, 3);
		assertEquals(8, bowlingGame.getScore());
	}

	@Test
	public void getScoreAfterThreeThrows() {
		bowlingGame.addThrows(5, 3, 2);
		assertEquals(10, bowlingGame.getScore());
	}

	@Test
	public void getScoreAfterFourThrows() {
		bowlingGame.addThrows(5, 3, 2, 2);
		assertEquals(12, bowlingGame.getScore());
	}

	@Test
	public void getScoreAfter20Throws() {
		bowlingGame.addThrows(1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1,
				2, 3, 4, 5);
		assertEquals(60, bowlingGame.getScore());
	}

	@Test
	public void getHeartbreakScore() {
		bowlingGame.addThrows(9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0, 9, 0,
				9, 0, 9, 0);
		assertEquals(90, bowlingGame.getScore());
	}

	@Test
	public void getScoreAfterFirstSpare() {
		bowlingGame.addThrows(5, 5, 5);
		assertEquals(20, bowlingGame.getScore());
	}

	@Test
	public void getScoreAfterFirstStrike() {
		bowlingGame.addThrows(10, 5, 4);
		assertEquals(28, bowlingGame.getScore());
	}

	@Test
	public void getScoreAfterSecondStrike() {
		bowlingGame.addThrows(10, 10);
		assertEquals(30, bowlingGame.getScore());
	}

	@Test
	public void getScoreAfterThirdStrike() {
		bowlingGame.addThrows(10, 10, 10);
		assertEquals(60, bowlingGame.getScore());
	}

	@Test
	public void getScoreIfSpareEveryRound() {
		bowlingGame.addThrows(5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5,
				5, 5, 5, 5, 5);
		assertEquals(150, bowlingGame.getScore());
	}

	@Test
	public void getScoreOfPerfectGame() {
		bowlingGame.addThrows(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10);
		assertEquals(300, bowlingGame.getScore());
	}
}
