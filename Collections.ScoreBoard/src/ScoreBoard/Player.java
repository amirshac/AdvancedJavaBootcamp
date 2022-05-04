package ScoreBoard;

import java.util.Objects;

public class Player implements Comparable<Player>{
	protected static double idCounter;
	private static final double DEF_SCORE = 0;
	private static final double DEF_RANK = 0;
	private static final String DEF_COUNTRY = "United States";
	
	static {
		idCounter = 0;
	}
	
	protected double id;
	protected String name;
	protected String country;
	protected double score;
	protected double rank;
	
	
	// Constructors
	public Player(String name, String country, double score, double rank) {
		super();
		this.name = name;
		this.country = country;
		this.score = score;
		this.rank = rank;
		this.id = idCounter++;
	}
	
	public Player(String name, String country) {
		this(name, country, DEF_SCORE, DEF_RANK);
	}
	
	public Player(String name) {
		this(name, DEF_COUNTRY, DEF_SCORE, DEF_RANK);
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", country=" + country + ", score=" + score + ", rank=" + rank+ "]";
	}

	// Setters / Getters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public double getRank() {
		return rank;
	}

	public void setRank(double rank) {
		this.rank = rank;
	}

	@Override
	public int compareTo(Player otherPlayer) {
		return (int)(this.id - otherPlayer.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		return Double.doubleToLongBits(id) == Double.doubleToLongBits(other.id);
	}

	
}
