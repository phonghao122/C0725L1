package ss11.Map;

import java.util.TreeMap;

public class CountWord {
    public static void main(String[] args) {
        String str = "Chương trình đếm các lần xuất hiện của từ trong một văn bản và hiển thị các từ và sự xuất hiện của chúng theo thứ tự trong bảng chữ cái của các từ.";
        str = str.toLowerCase();
        str = str.replaceAll("[^\\p{L}\\s]", "");
        TreeMap<String, Integer> map = new TreeMap<>();
        String[] words = str.split(" ");
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        map.entrySet().stream().forEach(entry -> {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        });
    }
}
