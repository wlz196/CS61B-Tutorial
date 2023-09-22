import org.junit.Test;

public class ArrayDeque<T> {
    private int fpos = 0;
    private int lpos = 0;
    private int size =0;
    private T[] items;
    private  int length = 8;

    public ArrayDeque() {
        items =(T[]) new Object[8];
        fpos = 0;
        lpos = 0;
        size =0;
    }
    private int calleft(int fpos){
        return (fpos+length-1)%length;
    }
    private int calright(int lpos) {
        return (lpos+length+1)%length;
    }
    private void changeSize(){
        if(size == length) {
            T newItems[] = (T[]) new Object[length * 2];
            for (int i = fpos, j = 0; i!=lpos; i = calright(i), j++) {
                newItems[j] = items[i];
            }
            items = newItems;
            lpos = length;
            fpos = 0;
            length *= 2;
        }
        if(size <0.25*length && length>=16){
            T newItems[] = (T[]) new Object[length /2];
            for (int i = fpos, j = 0; i!=lpos; i = calright(i), j++) {
                newItems[j] = items[i];
            }
            items = newItems;
            lpos = length;
            fpos = 0;
            length/=2;
        }
    }
    public void addFirst(T item) {
        changeSize();
        fpos = calleft(fpos);
        items[fpos] = item;
        size ++;

    }
    public void addLast(T item) {
        changeSize();
        items[lpos] = item;
        lpos = calright(lpos);
        size ++;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    public void printDeque() {
        if(size == 0) return;
        for(int i = fpos; i != lpos; i = (i + 1) % length ){
            System.out.println(items[i]+" ");
        }
        System.out.println();

    }
    public T removeFirst() {
        if(isEmpty()) return null;
        changeSize();
        size--;
        T res = items[fpos];
        fpos = calright(fpos);
        return res;
    }
    public T removeLast() {
        if(isEmpty()) return null;
        changeSize();
        size--;
        lpos =calleft(lpos);
        T res = items[lpos];
        return res;
    }
    public T get(int index) {
        if(index > lpos && index < fpos)
            return  null;
        int res = fpos;
        while(index>0){
            res = calright(fpos);
            index--;
        }
        return items[res];
    }


}
