class Solution {
    public boolean isPalindrome(String s) {
        Character[] words = new Character[s.length()];
        int index = 0;
        for (char c: s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                words[index] = Character.toLowerCase(c);
                index++;
            }
        }

        for (int i = 0; i < index/2; i++)
            if (!(words[i].equals(words[index-i-1])))
                return false;
        return true;
    }
}