Q: What would be the output of the following program?
public static void main(String[] args) {
String[] strArray = new String[]{"1", "2", "3", "4", "5", "6"};
List<String> aMainList = new ArrayList(Arrays.asList(strArray));
List<String> aSubList = aMainList.subList(2, 4);
System.out.println("Sub List :: " + aSubList);
// 3,4
aSubList.add("Java");
System.out.println("Sub List :: " + aSubList);
//3, 4, Java
System.out.println("Main List :: " + aMainList);
//1,2,3,4,Java,5, 6
 
int x = 1;
aMainList.remove(4); // removed from the mainlist
// 1,2,3,4,5,6
for(String obj : aSubList) {
System.out.println( " Item - " + obj);

// Item - Java
aMainList.add("A" + x);
x++;
}
 // Item - 1
System.out.println("Sub List :: " + aSubList);
 
System.out.println("Main List :: " + aMainList);
 }

Q: Turning number is the maximum number in a unimodal array that increases and then decreases. Write a function that finds the index of a turning number/
 
    [ 1,2,3,4,5,10,9,8,7,6]
    if(arr == null || arr.length == 0)
        return -1;
    //[left...right]
    int left=0, right=arr.length-1;
    while(left < right){
        int mid = (left + right)/2;
    
        if(isTurnPoint(arr, mid))
            return mid;
        else if (arr[mid] > arr[mid + 1])
            right = mid;
        else
            left = mid + 1;
    }
    return left;
    
    boolean isTurnPoint(int[] arr, int mid){
         int mid_left =  mid-1;
         int mid_right = mid + 1;
         boolean valid =  false;
         if((mid_left >=0 && arr[mid] > arr[mid_left]) && (mid_right < arr.length && arr[mid] > arr[mid_right]))
            return true;
        return false;
    }
