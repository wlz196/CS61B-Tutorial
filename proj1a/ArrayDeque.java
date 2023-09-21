public class ArrayDeque<T> {
    private int fpos = 0;
    private int lpos = 0;
    private int size =0;
    private T[] items;
    private static int length = 8;

    public ArrayDeque() {
        items =(T[]) new Object[8];
        fpos = 0;
        lpos = 1;
        size =0;
    }
    public ArrayDeque(ArrayDeque other) {
        items =(T[]) new Object[8];
        for(int i = 0; i < length ; i++){
            items[i]= (T)other.items[i];
        }
        fpos = other.fpos;
        lpos = other.lpos;
        size = other.size;
    }

    public void addFirst(T item) {
        if(size == length) return;
        if(fpos == -1) {
            fpos = length-1 ;
        }
        items[fpos--] = item;
        size ++;

    }
    public void addLast(T item) {
        if(size == length) return;
        if(lpos == length - 1)
            lpos = 0;
        items[lpos++] = item;
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
        return items[++fpos];
    }
    public T removeLast() {
        if(size == 0) return null;
        size--;
        return items[--lpos];
    }
    public T get(int index) {
        if(index > lpos && index < fpos)
            return  null;
        return items[index];
    }

}
