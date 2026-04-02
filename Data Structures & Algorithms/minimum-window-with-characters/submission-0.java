class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length() || t == "") {
            return "";
        }

        HashMap<Character, Integer> charsT = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            charsT.merge(c, 1, Integer::sum);
        }
        int have = 0;
        int need = charsT.size();
        String res = s;
        int resSize = Integer.MAX_VALUE; 
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            window.merge(c, 1, Integer::sum);
            if (charsT.containsKey(c) && charsT.get(c) == window.get(c)) {
                have++;
            }

            while (have == need) {
                if ((r - l + 1) < resSize) {
                    res = s.substring(l, r+1);
                    resSize = r - l + 1;
                }
                char charL = s.charAt(l);
                int val = window.getOrDefault(charL, 0);
                if (val > 0) {
                    window.put(charL, val-1);
                }
                if (charsT.containsKey(charL) && window.get(charL) < charsT.get(charL)) {
                    have--;
                }
                l++;
            }
        }
        return resSize < Integer.MAX_VALUE ? res : "";
    }
}
