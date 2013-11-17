package kata.bowlinggame;

class Frame {
	private Integer firstThrow;
	private Integer secondThrow;

	public int getScore() {
		if (secondThrow == null) {
			return this.firstThrow;
		}
		return this.firstThrow + this.secondThrow;
	}

	public boolean isStrike() {
		if (this.firstThrow == 10) {
			return true;
		}
		return false;
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
