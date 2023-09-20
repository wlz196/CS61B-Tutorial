public class OffByOne implements CharacterComparator{
    @Override
    public boolean equalChars(char x, char y) {
        if(Math.abs(x-y) == 1)
            return true;
        return false;
    }
    public boolean isPalindrome(String word){
        if(word.length() == 0 || word.length() == 1) {
            return true;
        }
        int i = 0, j = word.length()-1;
        while(i<j){
            if(!equalChars(word.charAt(i),word.charAt(j))){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
