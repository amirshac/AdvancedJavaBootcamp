package Stream.Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Runner {

	public static void main(String[] args) {
		List<GameCharacter> characters = Arrays.asList(
				new GameCharacter("Arthas Menethil", "Lich King", "Icecrown", 80, 1500, Continent.Northrend),
				new GameCharacter("Thrall", "Warchief", "Orgrimmar", 90, 1200, Continent.Kalimdor),
				new GameCharacter("Jaina Proudmoore", "Lord Admiral", "Kul Tiras", 120, 1000,
						Continent.Eastern_Kingdoms),
				new GameCharacter("Tyrande Whisperwind", "Priestess of Elune", "Teldrassil", 120, 1100,
						Continent.Kalimdor),
				new GameCharacter("Sylvanas Windrunner", "Dark Ranger", "Undercity", 120, 1100,
						Continent.Eastern_Kingdoms));
		
		List<String> fromKalimdorList = characters
				.stream()
				.filter(p -> p.getContinent()==Continent.Kalimdor)
				.map(p -> p.getName()).toList();
		
		System.out.println("Names from kalimdor");
		fromKalimdorList.forEach(p->System.out.println(p));
		
		System.out.println("----------------------------------------------------\n");
		System.out.println("Sorted by hitpoints");
		
		characters.sort((p1, p2) -> (int)(p2.hitPoints - p1.hitPoints));
		characters.forEach(p -> System.out.println(p));
		
		System.out.println("----------------------------------------------------\n");
		
		System.out.println("Average hit points of characters in level 120 only");
		List<Double> hitPoints = characters.stream().filter(p->p.getLevel() == 120).map(p->p.hitPoints).toList();
		Double averageHitPoints = hitPoints.stream().reduce(0.0, (t, u) -> t+u) / hitPoints.size();
		System.out.println(hitPoints);
		System.out.println(averageHitPoints);
		
		System.out.println("Creating new game characters from name list");
		
		List<String> names = List.of("Uzugi", "Mushugi", "Buzugi", "Ferdinand", "Casparov");
		
		List<GameCharacter> newCharacters = names.stream().map((name) -> new GameCharacter(name, "Orc", "Ogimar", 10, 1500, Continent.Eastern_Kingdoms)).collect(Collectors.toList());
		newCharacters.forEach(p->System.out.println(p));
	}
}

