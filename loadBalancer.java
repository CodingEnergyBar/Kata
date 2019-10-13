public class LoadBalancer {

    Map<Integer, Integer> idToIndex = new HashMap();

    Random rand = new Random();

    List<Integer> ids = new ArrayList();

    /*
     * @param server_id: add a new server to the cluster
     * 
     * @return: nothing
     */
    public void add(int server_id) {
        // write your code here
        ids.add(server_id);

        idToIndex.put(server_id, ids.size() - 1);

        // System.out.println(ids);
        // System.out.println(idToIndex);
    }

    /*
     * @param server_id: server_id remove a bad server from the cluster
     * 
     * @return: nothing
     */
    public void remove(int server_id) {
        // write your code here
        // get the index

        int index = idToIndex.get(server_id);

        idToIndex.remove(server_id);

        int tmp_id = ids.get(ids.size() - 1);
        // set to change the value
        ids.set(index, tmp_id);
        ids.remove(ids.size() - 1);

        // update hash
        idToIndex.put(tmp_id, index);

        // System.out.println(ids);
        // System.out.println(idToIndex);

    }

    /*
     * @return: pick a server in the cluster randomly with equal probability
     */
    public int pick() {
        // write your code here
        int r = rand.nextInt(ids.size());

        return ids.get(r);
    }
}