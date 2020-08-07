import java.util.ArrayList;
import java.util.List;

public class ListStorage implements Storage {
    private List<Integer> list = new ArrayList<>();
    private int number;

    public ListStorage() {
    }

    public ListStorage(int n) {
        this.number = n;
    }

    public int getNumber() {
        return number;
    }

    public List<Integer> getList() {
        return list;
    }

    @Override
    public void init(int[] array) {
        for (int value : array) {
            if (((double) value) % number == 0) {
                list.add(value);
            }
        }
        sort();
    }

    @Override
    public void print() {
        if (list.isEmpty()) {
            System.out.println("Список type пуст");
        } else {
            for (int value : list) {
                System.out.print(value + ", ");
            }
        }
        System.out.println();
    }

    @Override
    public void clear() {
        list.clear();
    }

    public int getLength() {
        return list.size();
    }

    @Override
    public void add(List<Integer> addList) {
        list.addAll(addList);
        sort();
    }

    private void sort() {
        list.sort((o1, o2) -> o1 - o2);
    }
}
