import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class NumberGenerator {

    public static void main(String[] args) throws IOException {
        List<Integer> zahlen = new ArrayList<Integer>();

        for (int i = 0; i <= 50000; i++) {
            int zahl = (int) (Math.random() * (90000 + 1));
            if (zahlen.contains(zahl)) {
                i--;
                continue;
            } else {
                zahlen.add(zahl);
            }
        }
        for (int list : zahlen) {
            FileWriter writer = new FileWriter(new File("numbers.txt"), true);
            writer.write(list + "");
            writer.close();
        }
        analyze();
    }

    static void analyze() throws IOException {
        Scanner scanner = new Scanner(new File("numbers.txt"));
        StringBuilder number = new StringBuilder();
        Map<Integer, Integer> numbersCounter = new HashMap<>();
        List<Integer[]> sortedByCount = new ArrayList<>();
        while (scanner.hasNextLine()) {
            number.append(scanner.nextLine());
        }
        for (int i = 0; i < number.length() - 4; i++) {
            Integer num = Integer.parseInt(number.substring(i, i + 5));
            if (num < 10000) {
                continue;
            }
            if (numbersCounter.containsKey(num)) {
                Integer count = numbersCounter.get(num);
                count++;
                numbersCounter.put(num, count);
            } else {
                numbersCounter.put(num, 1);
            }
        }
        numbersCounter.forEach((k, v) -> sortedByCount.add(new Integer[]{v, k}));
        List<Integer[]> list = sortedByCount.stream().sorted(Comparator.comparing(num -> num[0])).collect(Collectors.toList());
        list.forEach(i -> System.out.println(i[1] + " appears " + i[0] + " times"));
    }
}


