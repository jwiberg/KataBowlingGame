package kata.bowlinggame;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
	private static final int BASE_FRAME_COUNT = 10;
	private final List<Frame> allFrames = new ArrayList<Frame>();
	private Frame currentFrame = new Frame();

	public int getScore() {
		Integer score = 0;
		for (int frameNumber = 0; frameNumber < allFrames.size()
				&& frameNumber < BASE_FRAME_COUNT; frameNumber++) {
			score += allFrames.get(frameNumber).getScore();
			if (isStrike(frameNumber)) {
				score += countStrikeBonus(frameNumber);
			} else if (isSpare(frameNumber)) {
				score += countSpareBonus(frameNumber);
			}
		}
		return score;
	}

	public void addThrows(int... throwScores) {
		for (int throwScore : throwScores) {
			this.addThrow(throwScore);
		}
	}

	private void addThrow(int throwScore) {
		if (currentFrame.getFirstThrow() == null) {
			currentFrame.setFirstThrow(throwScore);
			allFrames.add(currentFrame);
			if (throwScore == 10) {
				currentFrame = new Frame();
			}
		} else {
			currentFrame.setSecondThrow(throwScore);
			currentFrame = new Frame();
		}
	}

	private boolean hasNextFrame(int frameNumber) {
		return frameNumber < allFrames.size() - 1;
	}

	private Frame getNextFrame(int frameNumber) {
		return allFrames.get(frameNumber + 1);
	}

	private int countStrikeBonus(int frameNumber) {
		int bonus = 0;
		bonus += getNextFrame(frameNumber).getFirstThrow();
		if (!getNextFrame(frameNumber).isStrike()) {
			bonus += getNextFrame(frameNumber).getSecondThrow();
		} else if (hasNextFrame(frameNumber + 1)) {
			bonus += getNextFrame(frameNumber + 1).getFirstThrow();
		}
		return bonus;
	}

	private int countSpareBonus(int frameNumber) {
		return allFrames.get(frameNumber + 1).getFirstThrow();
	}

	private boolean isSpare(int frameNumber) {
		return hasNextFrame(frameNumber)
				&& allFrames.get(frameNumber).isSpare();
	}

	private boolean isStrike(int frameNumber) {
		return hasNextFrame(frameNumber)
				&& allFrames.get(frameNumber).isStrike();
	}
}
