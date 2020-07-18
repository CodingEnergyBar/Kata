package unionfind;
interface UF{
    boolean isConnected(int p, int q);
    int quickFind(int p);
    void unionElements(int p, int q);
    int getSize();
}