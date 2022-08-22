import java.util.ArrayList;
import java.util.List;

public class ModArrayList<D> extends ArrayList<D> {
    public D getUsingMod(int index){
        int validIndex = Math.abs(index) % this.size();
        return this.get(validIndex);
    }
}
