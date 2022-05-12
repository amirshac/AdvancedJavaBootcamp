package Runner;

import java.util.LinkedList;
import java.util.List;

import Tent.Tent;

public class Runner {

		/**
		 * Sorts tent list by area
		 * @param sourceList
		 * @return sorted list
		 */
		static List<Tent> sortTentsByArea(List<Tent> sourceList){

			return sourceList
					.stream()
					.sorted((p,q)->(int)p.getArea()-(int)q.getArea())
					.toList();
		}
		
		static List<Tent> filterTentsByMinPeople(int minPeople, List<Tent> sourceList){
			
			return sourceList
					.stream()
					.filter( tent->tent.getNumPeople() >= minPeople )
					.sorted( (p,q) -> p.getNumPeople()-q.getNumPeople() )
					.toList();
		}
		
		public static void main(String[] args) {
			
		LinkedList<Tent> tents = new LinkedList<Tent>();
		List<Tent> sortedByAreaTents = null;
		List<Tent> sortedByMinPeople = null;
		
		for (int i=10; i>=1; i--)
			tents.add(new Tent(i, i, i, i));
		
		System.out.println("Original tent list:");
		for (Tent tent : tents) {
			System.out.println(tent);
		}
		
		System.out.println("----------------------");
		System.out.println("Sorted by area list:");
		sortedByAreaTents = sortTentsByArea(tents);
		sortedByAreaTents.forEach(tent -> System.out.println(tent));
		
		System.out.println("----------------------");
		System.out.println("Sorted and filtered by min people:");
		sortedByMinPeople = filterTentsByMinPeople(5, tents);
		sortedByMinPeople.forEach(tent -> System.out.println(tent));
		
	}

}
