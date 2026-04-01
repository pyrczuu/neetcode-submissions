class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();

        if (l1 > l2){
            return false;
        }

        int[] chars1 = new int[26];
        int[] chars2 = new int[26];

        for (int i = 0; i < l1; i++){
            chars1[s1.charAt(i) - 'a']++;
            chars2[s2.charAt(i) - 'a']++;
        }

        for (int i = l1; i < l2; i++){
            if (Arrays.equals(chars1, chars2)){
                return true;
            }
            chars2[(int)s2.charAt(i) - 'a']++;
            chars2[(int)s2.charAt(i-l1) - 'a']--;
        }
        
        return Arrays.equals(chars1, chars2);
    }
}
