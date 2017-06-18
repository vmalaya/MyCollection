package MyCollection;


public class Main {
    public static void main(String[] args) {
        MyCollection collection = new MyCollection();
        MyCollection collection1 = new MyCollection();
        Object[] people = new Object[3];
        String ivanov ="Ivanov";
        String petrov = "Petrov";
        people[0]= petrov;
        Integer number = 54;
        people[1] = number;
        String sparrow = "Sparrow";
        people[2]= sparrow;
        collection.add(ivanov);
        collection.print();
        System.out.println(collection.size());
        System.out.println(collection.isEmpty());
        System.out.println(collection.contains(ivanov));
        collection.remove(ivanov);
        collection.print();
        for (int i = 0; i <people.length ; i++) {
            collection.add(people[i]);
        }
        collection1.add(ivanov);
        collection1.add(petrov);
        System.out.println("------ADD ALL TEST");
        collection.addAll(collection1);
        collection.print();

        System.out.println("-----CLEAR TEST");
        collection.clear();
        collection.print();

        System.out.println("------REMOVE ALL TEST");
        collection.add(ivanov);
        collection.add(number);
        collection.add(sparrow);
        collection.add(petrov);
        collection.removeAll(collection1);
        collection.print();

        System.out.println("------CONTAIN ALL TEST");
        collection.add(ivanov);
        collection.add(petrov);
        System.out.println(collection.containsAll(collection1));








    }
}
