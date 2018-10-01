
public class Team implements Comparable {
	private String teamName;
	private int numberOfWins;
	private int numberOfLosses;
	private int numberOfDraws;

	public Team(final String teamName,
	            final int numberOfWins,
	            final int numberOfLosses,
	            final int numberOfDraws) {
		this.teamName = teamName;
		this.numberOfWins = numberOfWins;
		this.numberOfLosses = numberOfLosses;
		this.numberOfDraws = numberOfDraws;
	}

	public int getNumberOfDraws() {
		return numberOfDraws;
	}

	public void setNumberOfDraws(int numberOfDraws) {
		this.numberOfDraws = numberOfDraws;
	}

	public int getNumberOfLosses() {
		return numberOfLosses;
	}

	public void setNumberOfLosses(int numberOfLosses) {
		this.numberOfLosses = numberOfLosses;
	}

	public int getNumberOfWins() {
		return numberOfWins;
	}

	public void setNumberOfWins(int numberOfWins) {
		this.numberOfWins = numberOfWins;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int compareTo(Object other) {
		Team that = (Team) other;
		if (this.getNumberOfWins() > that.getNumberOfWins())
			return -1;
		if (this.getNumberOfWins() < that.getNumberOfWins())
			return 1;

		if (this.getNumberOfLosses() < that.getNumberOfLosses())
			return -1;
		if (this.getNumberOfLosses() > that.getNumberOfLosses())
			return 1;

		if (this.getNumberOfDraws() > that.getNumberOfDraws())
			return -1;
		if (this.getNumberOfDraws() < that.getNumberOfDraws())
			return 1;

		return 0;
	}

	public String toString() {
		// StringBuffer sb = new StringBuffer();
		// sb.append(this.getTeamName() + ",");
		// sb.append(this.getNumberOfWins() + ",");
		// sb.append(this.getNumberOfDraws() + ",");
		// sb.append(this.getNumberOfLosses());
		return this.getTeamName();
	}
}