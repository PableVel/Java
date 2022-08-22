package cambiae;

import java.util.ArrayList;

public class RestaurantMenu {

    ArrayList<RestaurantMenuItem> MenuItems = new ArrayList<RestaurantMenuItem>();

    public boolean addMenuItem(RestaurantMenuItem newMenuItem)  {
        if(DoesItemExists(newMenuItem)){
            throw new IllegalArgumentException("Duplicate Item");
        }
        return MenuItems.add(newMenuItem);
    }

    public boolean DoesItemExists(RestaurantMenuItem newMenuItem){
        boolean Exists =false;
        if (MenuItems.contains(newMenuItem)){
            Exists = true;
        }
        return Exists;
    }
}
