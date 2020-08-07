import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<Storage> lists = new ArrayList<>();

    public static void main(String[] args) {
        int[] inputArrayInt = new int[args.length];

        for (int i = 0; i < args.length; i++) {
            inputArrayInt[i] = Integer.parseInt(args[i]);
        }

        lists.add(new ListStorage(3));
        lists.add(new ListStorage(7));
        lists.add(new ListStorage(21));

        init(inputArrayInt);
        print(7);
        anyMore(inputArrayInt);
        merge();
    }

    static void init(int[] array) {
        for (Storage storage : lists) {
            storage.init(array);
        }
    }

    static void print() {
        for (Storage storage : lists) {
            storage.print();
        }
    }

    static void print(int n) {
        for (Storage storage : lists) {
            if (((ListStorage) storage).getNumber() == n) {
                storage.print();
            }
        }
    }

    static boolean anyMore(int[] array) {
        int sum = 0;
        boolean isAnyMore = false;
        for (Storage storage : lists) {
            sum += ((ListStorage) storage).getLength();
        }
        if (sum < array.length) {
            isAnyMore = true;
        }
        System.out.println(isAnyMore);
        return isAnyMore;
    }

    static void clear(int n) {
        for (Storage storage : lists) {
            if (((ListStorage) storage).getNumber() == n) {
                storage.clear();
            }
        }
    }

    static void merge() {
        Storage generalStorage = new ListStorage();
        for (Storage storage : lists) {
            generalStorage.add(((ListStorage) storage).getList());
            storage.clear();
        }
        generalStorage.print();
    }

    static void help() {
        System.out.println("init array - инициализация списков набором значений array\n" +
                "\n" +
                "print - печать всех списков\n" +
                "\n" +
                "print type - печать конкретного списка, где type принимает значения X,S,M\n" +
                "\n" +
                "anyMore - выводит на экран были ли значения не вошедшие ни в один список, возможные значения true, false\n" +
                "\n" +
                "clear type - чистка списка , где type принимает значения X,S,M\n" +
                "\n" +
                "merge - слить все списки в один вывести на экран и очистить все списки\n");
    }
}
