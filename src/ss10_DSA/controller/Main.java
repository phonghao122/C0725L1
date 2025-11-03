package ss10_DSA.controller;

import ss10_DSA.service.MyList;

public class Main {
    public static void main(String[] args) {
        MyList<String> list = new MyList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        System.out.println("Phần tử đầu: " + list.get(0));
        System.out.println("Kích thước: " + list.size());

        list.remove(1);
        System.out.println("Sau khi xóa: " + list.get(1));

        list.set(0, "Z");
        System.out.println("Phần tử đầu mới: " + list.get(0));

        System.out.println("Vị trí của C: " + list.indexOf("C"));
        System.out.println("Danh sách rỗng? " + list.isEmpty());

        list.clear();
        System.out.println("Sau khi clear, rỗng? " + list.isEmpty());
    }
}
