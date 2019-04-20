import java.util.HashSet;

class Solution {

    /**
     * Leetcode 929. Unique Email Addresses
     * @param emails
     * @return
     */
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();
        for (String email:emails) {
            set.add(getEmail(email));
        }
        return set.size();
    }

    public String getEmail(String email) {
        StringBuilder sb = new StringBuilder();
        int index = email.indexOf("@");
        for (int i = 0; i < index; i++) {
            Character c = email.charAt(i);
            if (c == '.') continue;
            if (c == '+') break;
            sb.append(c);
        }
        sb.append(email.substring(index));
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] emails = new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        Solution sol = new Solution();

        System.out.println("Expected: 2, Output: " + sol.numUniqueEmails(emails));
    }
}