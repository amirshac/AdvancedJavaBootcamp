package Runner;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import Tent.Tent;

public class Runner {

		/**
		 * Sorts tent list by area
		 * @param sourceList
		 * @return sorted list
		 */
		static List<Tent> sortTentsByArea(List<Tent> sourceList){

			Comparator<Tent> tentAreaComparator = new Comparator<Tent>() {
				@Override
				public int compare(Tent t1, Tent t2) {
					if (t1.getArea() < t2.getArea()) 
						return -1;
					else if (t1.getArea() > t2.getArea()) 
						return 1;
					else
						return 0;
				}
			};
			
			return sourceList
					.stream()
					.sorted(tentAreaComparator)
					.toList();
		}
		
		/**
		 * Filters and sorts tent list by minimum number of people
		 * @param minPeople
		 * @param sourceList
		 * @return sorted filtered list by minimum number of people onwards
		 */
		static List<Tent> filterTentsByMinPeople(int minPeople, List<Tent> sourceList){
						
			return sourceList
					.stream()
					.filter( tent->tent.getNumPeople() >= minPeople )
					.sorted( (p,q) -> p.getNumPeople()-q.getNumPeople() )
					.toList();
		}
		
		/**
		 * Checks is tent is the highest tent in a tent list
		 * @param sourceList
		 * @param maxTent
		 * @return true is tent is highest, false otherwise
		 */
		static boolean isTentMaxHeight(List<Tent> sourceList, Tent maxTent) {
			
			Comparator<Tent> tentMaxHeightComparator = new Comparator<Tent>() {
				@Override
				public int compare(Tent t1, Tent t2) {
					if (t1.getHeight() > t2.getHeight()) 
						return -1;
					else if (t1.getHeight() < t2.getHeight()) 
						return 1;
					else
						return 0;
				}
			};
			
			PriorityQueue<Tent> tentHeightQueue = new PriorityQueue<>(tentMaxHeightComparator);
			tentHeightQueue.addAll(sourceList);
						
			Tent maxInQueue = tentHeightQueue.poll();
			
			return (maxTent.getHeight() >= maxInQueue.getHeight());
		}
		
		
		/**
		 * returns a map of heights and a list of tents of each height
		 * @param sourceList
		 */
		
		static LinkedHashMap<Double, List<Tent>> mapOfHeights(List<Tent> sourceList) {
			
			LinkedHashMap<Double, List<Tent>> resultMap = new LinkedHashMap<>();
		
			List<Double> allHeights = sourceList.stream().map(p->p.getHeight()).distinct().toList();
			
			for (Double height : allHeights) {
				List<Tent> newList = sourceList.stream().filter(p->p.getHeight() == height).toList();
				resultMap.put(height, newList);
			}
			
			return (resultMap);
		}
		
		/**
		 * Returns list of tents within height values
		 * @param minHeight
		 * @param maxHeight
		 * @param sourceMap
		 * @return
		 */
		static List<Tent> tentsInRange(double minHeight, double maxHeight, LinkedHashMap<Double, List<Tent>> sourceMap){
			List<Tent> resultList = new LinkedList<Tent>();
			sourceMap.forEach((Double key, List<Tent> value) -> {
				if (key >= minHeight && (key <= maxHeight) ){
				resultList.addAll(value);
			}
			});
			return resultList;
		}
		
		public static void main(String[] args) {
			
		LinkedList<Tent> tentList = new LinkedList<Tent>();
		List<Tent> sortedByAreaTents = null;
		List<Tent> sortedByMinPeople = null;
		LinkedHashMap<Double, List<Tent>> heightMap = null;
		List<Tent> betweenRangeTents = null;
		
		for (int i=10; i>=1; i--)
			tentList.add(new Tent(i, i, i, i));
		
		tentList.add(new Tent(11, 11, 11, 10));
		

		System.out.println("Original tent list:");
		tentList.forEach(tent -> System.out.println(tent));
		
		System.out.println("----------------------");
		System.out.println("Sorted by area list:");
		sortedByAreaTents = sortTentsByArea(tentList);
		sortedByAreaTents.forEach(tent -> System.out.println(tent));
		
		System.out.println("----------------------");
		System.out.println("Sorted and filtered by min people(5):");
		sortedByMinPeople = filterTentsByMinPeople(5, tentList);
		sortedByMinPeople.forEach(tent -> System.out.println(tent));
		
		System.out.println("----------------------");
		System.out.println("is tent max height:");
		Tent tent = new Tent(10, 2, 2, 10);
		System.out.println(isTentMaxHeight(tentList, tent));		
		
		heightMap = mapOfHeights(tentList);
		System.out.println("----------------------");
		System.out.println("Height map list:");
		heightMap.forEach((Double key, List<Tent> value)->System.out.println(key + ":" + value));
		
		System.out.println("----------------------");
		System.out.println("Tree list between range 2 and 9");
		betweenRangeTents = tentsInRange(2, 9, heightMap);
		betweenRangeTents.forEach(t -> System.out.println(t));
	}
}

/*
 OUTPUT: 
 
 Original tent list:
Tent [numPeople=10, width=10.0, length=10.0, height=10.0]
Tent [numPeople=9, width=9.0, length=9.0, height=9.0]
Tent [numPeople=8, width=8.0, length=8.0, height=8.0]
Tent [numPeople=7, width=7.0, length=7.0, height=7.0]
Tent [numPeople=6, width=6.0, length=6.0, height=6.0]
Tent [numPeople=5, width=5.0, length=5.0, height=5.0]
Tent [numPeople=4, width=4.0, length=4.0, height=4.0]
Tent [numPeople=3, width=3.0, length=3.0, height=3.0]
Tent [numPeople=2, width=2.0, length=2.0, height=2.0]
Tent [numPeople=1, width=1.0, length=1.0, height=1.0]
Tent [numPeople=11, width=11.0, length=11.0, height=10.0]
----------------------
Sorted by area list:
Tent [numPeople=1, width=1.0, length=1.0, height=1.0]
Tent [numPeople=2, width=2.0, length=2.0, height=2.0]
Tent [numPeople=3, width=3.0, length=3.0, height=3.0]
Tent [numPeople=4, width=4.0, length=4.0, height=4.0]
Tent [numPeople=5, width=5.0, length=5.0, height=5.0]
Tent [numPeople=6, width=6.0, length=6.0, height=6.0]
Tent [numPeople=7, width=7.0, length=7.0, height=7.0]
Tent [numPeople=8, width=8.0, length=8.0, height=8.0]
Tent [numPeople=9, width=9.0, length=9.0, height=9.0]
Tent [numPeople=10, width=10.0, length=10.0, height=10.0]
Tent [numPeople=11, width=11.0, length=11.0, height=10.0]
----------------------
Sorted and filtered by min people(5):
Tent [numPeople=5, width=5.0, length=5.0, height=5.0]
Tent [numPeople=6, width=6.0, length=6.0, height=6.0]
Tent [numPeople=7, width=7.0, length=7.0, height=7.0]
Tent [numPeople=8, width=8.0, length=8.0, height=8.0]
Tent [numPeople=9, width=9.0, length=9.0, height=9.0]
Tent [numPeople=10, width=10.0, length=10.0, height=10.0]
Tent [numPeople=11, width=11.0, length=11.0, height=10.0]
----------------------
is tent max height:
true
----------------------
Height map list:
10.0:[Tent [numPeople=10, width=10.0, length=10.0, height=10.0], Tent [numPeople=11, width=11.0, length=11.0, height=10.0]]
9.0:[Tent [numPeople=9, width=9.0, length=9.0, height=9.0]]
8.0:[Tent [numPeople=8, width=8.0, length=8.0, height=8.0]]
7.0:[Tent [numPeople=7, width=7.0, length=7.0, height=7.0]]
6.0:[Tent [numPeople=6, width=6.0, length=6.0, height=6.0]]
5.0:[Tent [numPeople=5, width=5.0, length=5.0, height=5.0]]
4.0:[Tent [numPeople=4, width=4.0, length=4.0, height=4.0]]
3.0:[Tent [numPeople=3, width=3.0, length=3.0, height=3.0]]
2.0:[Tent [numPeople=2, width=2.0, length=2.0, height=2.0]]
1.0:[Tent [numPeople=1, width=1.0, length=1.0, height=1.0]]
----------------------
Tree list between range 2 and 9
Tent [numPeople=9, width=9.0, length=9.0, height=9.0]
Tent [numPeople=8, width=8.0, length=8.0, height=8.0]
Tent [numPeople=7, width=7.0, length=7.0, height=7.0]
Tent [numPeople=6, width=6.0, length=6.0, height=6.0]
Tent [numPeople=5, width=5.0, length=5.0, height=5.0]
Tent [numPeople=4, width=4.0, length=4.0, height=4.0]
Tent [numPeople=3, width=3.0, length=3.0, height=3.0]
Tent [numPeople=2, width=2.0, length=2.0, height=2.0]

*/
