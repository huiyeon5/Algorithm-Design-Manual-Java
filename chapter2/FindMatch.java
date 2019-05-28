package chapter2;

public class FindMatch {
    public static void main(String[] args) {
        String word = "abaabba";
        String toSearch = "abba";

        System.out.println("toSearch found from index: " + findMatch(word, toSearch));
    }

    public static int findMatch(String word, String toSearch) {
        int i,j;
        int m, n;

        m = toSearch.length();
        n = word.length();

        for(i = 0; i <= (n - m); i++) {
            j = 0;
            while((j < m) && (word.charAt(i + j) == toSearch.charAt(j))) {
                j++;
            }

            if(j == m) return i;
        }

        return -1;
    }
}