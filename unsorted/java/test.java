import java.util.*;

class Test {
    public static void main(final String[] args) {
        final String[] strArray = new String[] { "1", "2", "3", "4", "5", "6" };
        final List<String> aMainList = new ArrayList(Arrays.asList(strArray));
        final List<String> aSubList = aMainList.subList(2, 4);
        System.out.println("Sub List :: " + aSubList);
        // 3,4
        aSubList.add("Java");
        System.out.println("Sub List :: " + aSubList);
        // 3, 4, Java
        System.out.println("Main List :: " + aMainList);
        // 1,2,3,4,Java,5, 6

        int x = 1;
        aMainList.remove(4); // removed from the mainlist
        // 1,2,3,4,5,6

        for (final String obj : aSubList) {
            System.out.println(" Item - " + obj);

            // Item - Java
            aMainList.add("A" + x);
            x++;
        }
       
        System.out.println("Sub List :: " + aSubList);

        System.out.println("Main List :: " + aMainList);
    }
}