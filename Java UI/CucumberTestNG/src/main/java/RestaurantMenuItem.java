public class RestaurantMenuItem {
    public RestaurantMenuItem(String itemName, String description, int price) {
        ItemName = itemName;
        Description = description;
        Price = price;
    }
    private String Description;
    private int Price;
    private String ItemName;


    public String getItemName() {
        return ItemName;
    }


    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }


}
