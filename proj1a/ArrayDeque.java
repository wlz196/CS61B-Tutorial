public class ArrayDeque<T> {
    private int size =0;
    T[] item;
    private static int length = 8;

    public ArrayDeque(){
        item =(T[]) new Object[8];
        size =0;
    }
    public ArrayDeque(ArrayDeque other){
        item =(T[]) new Object[8];
        for(int i =0;i<length ;i++){
            item[i]= (T)other.item[i];
        }
        size = other.size;
    }

    public void addFirst(T item){
        if(size == length) return;


    }
}
