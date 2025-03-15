class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> roman = new HashMap<>();
		roman.put('I', 1);
		roman.put('V', 5);
		roman.put('X', 10);
		roman.put('L', 50);
		roman.put('C', 100);
		roman.put('D', 500);
		roman.put('M', 1000);

		// String s = "";

		int ans = 0;
		int i = 0;
		while(i<s.length()) {
			if(i==s.length()-1) {
				ans += roman.get(s.charAt(i));
				return ans;
			}
			int curr=roman.get(s.charAt(i));
			int next=roman.get(s.charAt(i+1));
			if(curr >= next) {
				ans += roman.get(s.charAt(i));
				i++;
			} else {
				ans += next;
				ans -= roman.get(s.charAt(i));
				i+=2;
			}
		}
		return ans;
    }
}