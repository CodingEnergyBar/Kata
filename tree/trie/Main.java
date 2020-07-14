package trie;

import java.io.File;
import java.util.ArrayList;
import utils.FileOperation;
import bst.BSTSet;

public class Main {
    public static void main(String[] args) {
        //test trie
        System.out.println("Price and Prejudice");
        ArrayList<String> words = new ArrayList<>();
        String filename = "pride-and-prejudice.txt";
		if(FileOperation.readFile(filename, words)){
            long startTime = System.nanoTime();
            BSTSet<String> set = new BSTSet<>();
            for(String word: words){
                set.add(word);
            }
            for (String word : words) {
                set.contains(word);
            }
            long endTime = System.nanoTime();
            double time = (endTime - startTime)/ 1000000000.0;
            System.out.println("Total different words: "+ set.getSize());
            System.out.println("BST time: "+ time);

            // Trie
            startTime = System.nanoTime();
            Trie trie = new Trie(words);
            for (String word : words) {
                trie.add(word);
            }
            for (String word : words) {
                trie.contains(word);
            }
             endTime = System.nanoTime();
             time = (endTime - startTime) / 1000000000.0;
            System.out.println("Total different words: " + trie.getSize());
            System.out.println("trie time: " + time);
        }
    }

    // 某个区间相应的最大值或者最小值
}