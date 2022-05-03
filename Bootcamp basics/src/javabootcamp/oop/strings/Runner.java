package javabootcamp.oop.strings;

public class Runner {

	// 1
	public static boolean isStringTheSameWrittenBackwards(String str1, String str2) {		
		boolean result = isStringTheSameWrittenBackwards(str1, str2, str1.length());
		return result;
	}
	
	public static boolean isStringTheSameWrittenBackwards(String str1, String str2, int untilIndexInStr1) {
		boolean result = true;
		char chr1, chr2;
		int pos1, pos2;
		int len = untilIndexInStr1;
		
		if (str1.length() != str2.length() ) {
			return false;
		}
		
		pos1 = 0;
		pos2 = str2.length()-1;
		
		while (pos1 < len) {
			chr1 = str1.charAt(pos1);
			chr2 = str2.charAt(pos2);
			
			if (chr1 != chr2) {
				result = false;
				break;
			}
			
			pos1 ++;
			pos2 --;
		}
		
		return result;
	}
	
	// 2
	public static boolean isStringPalindrome(String str) {
		boolean result = isStringTheSameWrittenBackwards(str, str, (str.length()/2) );
		return result;
	}
	
	// 3 
	public static String removeWordFromString(String str, String strToRemove) {
		String resultStr = new String();
		
		String[] splitArray = str.split(strToRemove);
		
		for (String element : splitArray) {
			element=element.trim();
			
			if (!element.isEmpty()) 
				resultStr += element+" ";
			}
	
		resultStr = resultStr.trim();
		
		return resultStr;
	}
	
	// 4
	public static String capitalizeWordsInString(String str) {
		String resultString = new String();
		String[] strArr;
		strArr = str.split(" ");
		String firstLetter;
		String newElement;
		
		for (String element : strArr) {
			firstLetter = element.substring(0,1);
			firstLetter = firstLetter.toUpperCase();
			
			newElement = new String();
			newElement += firstLetter;
			
			if (element.length() > 1)
				newElement += element.substring(1);
				
			resultString += newElement + " ";
		}
		
		return resultString;
	}
	
	public static void test4() {
		String[] testArray = {
				"hello capitalize this Please",
				"majoR capitaL",
				"a",
				"ab",
				"ab cd ef ghi jklmnop q r s tuv wx y z"		
		};		
		
		String resultStr;
		
		for (String element : testArray) {
			System.out.println(element);
			resultStr = capitalizeWordsInString(element);
			System.out.println(resultStr);
			System.out.println();
		}
		
/* Test run:
		hello capitalize this Please
		Hello Capitalize This Please 

		majoR capitaL
		MajoR CapitaL 

		a
		A 

		ab
		Ab 

		ab cd ef ghi jklmnop q r s tuv wx y z
		Ab Cd Ef Ghi Jklmnop Q R S Tuv Wx Y Z 
		*/
	}
	
	public static void test3() {
		String str1 = "Hello cat I'm a cat cat dog and I hate catrats";
		String[] testArray = {
				"cat",
				"dog",
				"rat",
				"I",
				"a"
		};
		
		String strToRemove;
		String resultStr;
		
		System.out.println("String: " + str1 + "\n");
		
		for (String element : testArray) {
			strToRemove = element;
			System.out.println("Removing " + strToRemove);
			resultStr = removeWordFromString(str1, strToRemove);
			System.out.println(resultStr);
			System.out.println();
		}
		
		
/*test run:
String: Hello cat I'm a cat cat dog and I hate catrats

Removing cat
Hello I'm a dog and I hate rats

Removing dog
Hello cat I'm a cat cat and I hate catrats

Removing rat
Hello cat I'm a cat cat dog and I hate cat s

Removing I
Hello cat 'm a cat cat dog and hate catrats

Removing a
Hello c t I'm c t c t dog nd I h te c tr ts
 */
	}
	
	public static void test2() {

		boolean result;

		String[] testStrArr = {
				"dogod",
				"doggod",
				"dood",
				"a",
				"bb",
				"dognod",
				"abBa"		
		};
		
		for (String testStr : testStrArr) {
			result = isStringPalindrome(testStr);
			System.out.printf("%s is palindrome? -> %b%n", testStr, result);
		}
/*Test run:
dogod is palindrome? -> true
doggod is palindrome? -> true
dood is palindrome? -> true
a is palindrome? -> true
bb is palindrome? -> true
dognod is palindrome? -> false
abBa is palindrome? -> false
 */
	}
	
	public static void test1() {
		
		boolean result;

		String[] testArr1 = {
				"dog",
				"Hello",
				"123456789",
				"A",
				"1234",
				"ikea"
		};
		
		String[] testArr2 = {
				"god",
				"olleH",
				"987654321",
				"A",
				"4322",
				"aekm"
		};

		for (int i=0; i<testArr1.length; i++) {
			result = isStringTheSameWrittenBackwards(testArr1[i], testArr2[i]);
			System.out.printf("%s <-> %s written backwards? %b%n", testArr1[i], testArr2[i], result);
		}
		
/*Test Run:
dog <-> god written backwards? true
Hello <-> olleH written backwards? true
123456789 <-> 987654321 written backwards? true
A <-> A written backwards? true
1234 <-> 4322 written backwards? false
ikea <-> aekm written backwards? false
 */
	}
	
	public static void main(String[] args) {
		test4();
		//test3();
		//test2();
		//test1();
	}

}
