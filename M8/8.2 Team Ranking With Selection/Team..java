
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

	public boolean compareTo(Team that) {
		if (this.getNumberOfWins() < that.getNumberOfWins())
			return true;
		if (this.getNumberOfDraws() > that.getNumberOfDraws())
			return false;
		if (this.getNumberOfLosses() < that.getNumberOfLosses())
			return true;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.getTeamName() + ",");
		sb.append(this.getNumberOfWins() + ",");
		sb.append(this.getNumberOfDraws() + ",");
		sb.append(this.getNumberOfLosses());
		return sb.toString();
	}
}