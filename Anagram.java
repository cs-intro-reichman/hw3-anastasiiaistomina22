/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String str3 = preProcess(str1);
		String str4 = preProcess(str2);

		if(str3.length() != str4.length())
			return false;
	
		for (int i = 0; i < str3.length(); i++){
			char ch = str3.charAt(i);
		    int count1 = 0;
			int count2 = 0;
            for(int j = 0; j < str3.length(); j++){
				if(str3.charAt(j) == ch)
                    count1++;
			}
			for(int j = 0; j < str4.length(); j++){
				if(str4.charAt(j) == ch)
					count2++;
			}
			if(count1 != count2)
				return false;	
		}	
	
		return true;
}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
	    String ans = "";
		int i = 0;
		while(i < str.length()){
			char ch = str.charAt(i);
			if((65 <= ch) &&(ch <= 90)){
                ans = ans + (char)(str.charAt(i) + 32);
            }else if((97 <= ch) && (ch <= 122)) {
                ans = ans + ch;
			}
			i++;
		}
		
		return ans;
    } 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String ans = "";
		String str1 = str;

		while (str1.length() > 0) {
			int random = (int)(Math.random() * str1.length());
			ans += str1.charAt(random);
			str1 = str1.substring(0, random) + str1.substring(random + 1);	
		}
		return ans;
	}
}
