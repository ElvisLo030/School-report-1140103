import java.util.ArrayList;

public class Menu {
    private ArrayList<MenuItem> items;

    public Menu() {
        items = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public void removeItem(String name) {
        items.removeIf(item -> item.getName().equals(name));
    }

    public void updateItem(String name, String newName, double newPrice) {
        for (MenuItem item : items) {
            if (item.getName().equals(name)) {
                item.setName(newName);
                item.setPrice(newPrice);
                break;
            }
        }
    }

    public MenuItem getItem(String name) {
        for (MenuItem item : items) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }

    public void displayMenu() {
        if (items.isEmpty()) {
            System.out.println("Menu is empty.");
        } else {
            for (MenuItem item : items) {
                System.out.println(item);
            }
        }
    }
}