public class ArrayDeque<T> {
    private int fpos = 0;
    private int lpos = 0;
    private int size =0;
    private T[] items;
    private static int length = 8;

    public ArrayDeque() {
        items =(T[]) new Object[8];
        fpos = 0;
        lpos = 0;
        size =0;
    }
    public int calleft(int fpos){
        return (fpos+length-1)%length;
    }
    public int calright(int lpos) {
        return (lpos+length+1)%length;
    }

    public void addFirst(T item) {
        if(size == length) return;
        fpos = calleft(fpos);
        items[fpos] = item;
        size ++;

    }
    public void addLast(T item) {
        if(size == length) return;
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
        if(size == 0) return null;
        size--;
        T res = items[fpos];
        fpos = calright(fpos);
        return res;
    }
    public T removeLast() {
        if(size == 0) return null;
        size--;
        lpos =calleft(lpos);
        T res = items[lpos];
        return res;
    }
    public T get(int index) {
        if(index > lpos && index < fpos)
            return  null;
        return items[index];
    }

}
