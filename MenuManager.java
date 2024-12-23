import java.util.Scanner;

public class MenuManager {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n菜單管理系統");
            System.out.println("1. 增加品項");
            System.out.println("2. 刪除品項");
            System.out.println("3. 更新品項");
            System.out.println("4. 查詢品項");
            System.out.println("5. 顯示菜單");
            System.out.println("6. 退出");
            System.out.print("選擇一個選項（請使用數字選擇）: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("輸入品項名稱: ");
                    String name = scanner.nextLine();
                    System.out.print("輸入品項價格: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    menu.addItem(new MenuItem(name, price));
                    System.out.println("品項已增加。");
                    break;
                case 2:
                    System.out.print("輸入要刪除的品項名稱: ");
                    name = scanner.nextLine();
                    menu.removeItem(name);
                    System.out.println("品項已刪除。");
                    break;
                case 3:
                    System.out.print("輸入要更新的品項名稱: ");
                    name = scanner.nextLine();
                    System.out.print("輸入新品項名稱: ");
                    String newName = scanner.nextLine();
                    System.out.print("輸入新品項價格: ");
                    double newPrice = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    menu.updateItem(name, newName, newPrice);
                    System.out.println("品項已更新。");
                    break;
                case 4:
                    System.out.print("輸入要查詢的品項名稱: ");
                    name = scanner.nextLine();
                    MenuItem item = menu.getItem(name);
                    if (item != null) {
                        System.out.println("查詢到的品項: " + item);
                    } else {
                        System.out.println("未找到品項。");
                    }
                    break;
                case 5:
                    System.out.println("菜單:");
                    menu.displayMenu();
                    break;
                case 6:
                    System.out.println("已成功退出(請注意資料不會被保存)");
                    exit = true;
                    break;
                default:
                    System.out.println("無效的選擇。請再試一次。");
            }
        }

        scanner.close();
    }
}
