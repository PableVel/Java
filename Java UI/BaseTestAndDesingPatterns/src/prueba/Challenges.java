package prueba;

public class Challenges {
    public static void main(String[] args) {
        System.out.println("Hola Mundo");
        int target = 13;
        int[] inputArray = {2, 7, 11, 15};
        Mymethods myMethodsObject = new Mymethods();
        myMethodsObject.twoSum(inputArray,target);

    }
}

    class Mymethods {
        public int twoSum(int[] numbers, int target){
            int sum = 0;
            for(int i = 0; i < numbers.length; i++) {
                if(sum==target){break;}
                for (int j = i+1; j < numbers.length; j++) {
                    if((numbers[i]+numbers[j])==target){
                        System.out.println("Index1: "+numbers[i]);
                        System.out.println("Index2: "+numbers[j]);
                        System.out.println("Target: "+target);
                        sum = numbers[i]+numbers[j];
                        break;
                    }
                }
            }
            return sum;
        }


    }
