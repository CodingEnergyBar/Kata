public class Sheet {
    int row;
    int col;
    String[][] contents;

    Sheet(int row, int  col){
        this.row = row;
        this.col = col;
        this.contents = new String[row][col];
    }
    public void print() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if(contents[i][j] != null){
                    System.out.print(contents[i][j]);
                }
                if(j != col-1)
                    System.out.print("|");
            }
            System.out.println();
        }
    }
    void prettyPrint(){
        int[] maxWidth = new int[col];
        //findMax in column 0 [ from all the rows ]to col-1
        for(int j=0; j< col; j++){
            int max = 0;
            for(int i=0; i< row; i++){
                if(contents[i][j] != null)
                    max = Math.max(max, contents[i][j].length());
            }
            maxWidth[j] = max;
        }
        // prettyPrint
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int spacesCnt = 0;
                if(contents[i][j] != null){
                    System.out.print(contents[i][j]);
                    spacesCnt = maxWidth[j] - contents[i][j].length();
                }else
                    spacesCnt = maxWidth[j];
                // print some space maxWidth[j] - contents[i][j].length()
                for(int z=0; z<spacesCnt;z++){
                    System.out.print(" ");
                }
                if(j != col-1)
                    System.out.print("|");
            }
            System.out.println();
        }

    }

    public void update(String content, int row, int col){
        contents[row][col] = content;
    }
    public void calculate(String str){
        String region = str.substring(4, str.length()-1);

        System.out.println("region "+ region);

        String  ops = region.split("-");


    }

    public static void main(String[] args) {
        Sheet sheet = new Sheet(4, 3);
        sheet.update ("bob", 0,0);
        sheet.update("10", 0,1);
        sheet.update ("foo", 0,2);

        sheet.update("alice", 1,0);
        sheet.update("5", 1,1);
        sheet.update("a",1,0);
        sheet.prettyPrint();

        sheet.calculate("=sum(1:1-2:2)");


    }
}
