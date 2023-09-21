public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> ans = new LinkedListDeque<Character>();
        for(int i = 0; i < word.length(); i++){
            ans.addLast(word.charAt(i));
        }
        return ans;
    }
    public boolean isPalindrome(String word) {
        if(word.length() == 0 || word.length() == 1)
            return true;
        Deque<Character> ans = wordToDeque(word);

        int i=0,j=ans.size()-1;
        while(i<j){
            if(ans.get(i) != ans.get(j)){
                return false;

            }
            i++;
            j--;
        }
        return true;
    }
    public boolean isPalindrome(String word, CharacterComparator cc) {
        if(word.length() == 0 || word.length() == 1)
            return true;
        int i = 0, j =word.length()-1;
        while(i < j){
            if(!cc.equalChars(word.charAt(i),word.charAt(j)))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
