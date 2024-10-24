import java.util.*;

class Solution {
    int N;
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        N = phone_book.length;
        
        Set<Integer> lens = new HashSet<>();
        Set<String> words = new TreeSet<>();
        
        for (int i = 0; i < N; i++){
            lens.add(phone_book[i].length());
            words.add(phone_book[i]);
        }
        
        return find(lens, words, phone_book);
    }
    boolean find(Set<Integer> lens, Set<String> words, String[] phone_book){
        for (int i = 0; i < N; i++){
            String now = phone_book[i];
            words.remove(now);
            Iterator<Integer> lenIterator = lens.iterator(); 
            
            while (lenIterator.hasNext()) {
                int len = lenIterator.next();
                if (len > now.length()) break;
                if (words.contains(now.substring(0, len))) { 
                    return false;
                }
            }
            
            words.add(now);

        }
        return true;
    }
}