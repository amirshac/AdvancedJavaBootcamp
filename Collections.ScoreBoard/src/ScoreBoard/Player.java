package ScoreBoard;

import java.util.Objects;

import Utils.Utils;
import Utils.StringGenerator;

public class Player implements Comparable<Player>{
	protected static int idCounter;
	private static final int DEF_SCORE = 0;
	private static final int DEF_RANK = 0;
	private static final String DEF_COUNTRY = "United States";
	private static final String DEF_NAME = "John Doe";
	
	static {
		idCounter = 0;
	}
	
	protected int id;
	protected String name;
	protected String country;
	protected int score;
	protected int rank;
	
	
	// Constructors
	
	public Player(String name, String country, int score, int rank) {
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
	
	public Player() {
		this(DEF_NAME, DEF_COUNTRY, DEF_SCORE, DEF_RANK);
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

	public void setScore(int score) {
		this.score = score;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
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
		return Double.doubleToLongBits(id) == Double.doubleToLongBits(other.id);	}


	public void RandomizeAll() {
		randomizeName();
		randomizeCountry();
		randomizeScore();
		randomizeRank();
	}
	
	public void randomizeStats() {
		randomizeScore();
		randomizeRank();	
	}
	
	public void randomizeName() {
		setName(StringGenerator.fullName());
	}
	
	public void randomizeCountry() {
		setCountry(StringGenerator.country());
	}
	
	public void randomizeScore() {
		setScore(Utils.getRandomInt(0, 1000));
	}
	
	public void randomizeRank() {
		setRank(Utils.getRandomInt(0, 1000));
	}

}
