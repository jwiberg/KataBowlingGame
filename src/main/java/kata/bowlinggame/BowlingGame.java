package kata.bowlinggame;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

	private final List<Frame> allFrames = new ArrayList<Frame>();
	private Frame currentFrame = new Frame();

	public int getScore() {
		int score = 0;
		for (int i = 0; i < allFrames.size(); i++) {
			Frame frame = allFrames.get(i);
			if (i < allFrames.size() - 1 && frame.isSpare()) {
				score += frame.getScore();
				score += allFrames.get(i + i).getFirstThrow();
			} else {
				score += frame.getScore();
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
			currentFrame = new Frame();
			currentFrame.setFirstThrow(throwScore);
			allFrames.add(currentFrame);
		} else {
			currentFrame.setSecondThrow(throwScore);
			currentFrame = new Frame();
		}
	}

	public class Frame {
		private Integer firstThrow;
		private Integer secondThrow;

		public int getScore() {
			if (secondThrow == null) {
				return this.firstThrow;
			}
			return this.firstThrow + this.secondThrow;
		}

		public boolean isSpare() {
			if (this.firstThrow != null && this.secondThrow != null
					&& this.getScore() == 10) {
				return true;
			}
			return false;
		}

		public Integer getFirstThrow() {
			return firstThrow;
		}

		public void setFirstThrow(Integer firstThrow) {
			this.firstThrow = firstThrow;
		}

		public Integer getSecondThrow() {
			return secondThrow;
		}

		public void setSecondThrow(Integer secondThrow) {
			this.secondThrow = secondThrow;
		}
	}
}
