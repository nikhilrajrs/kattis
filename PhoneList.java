import java.util.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.io.*;

public class PhoneList {

    public static void main(String args[]) throws IOException {
        //Scanner scanner = new Scanner(System.in);
        File file = new File("phone_list.txt");
        Scanner scanner = new Scanner(file, Charset.forName("US-ASCII"));

        int testCases = scanner.nextInt();

        while (testCases > 0) {
            int entries = scanner.nextInt();
            
            testCases--;
            //String[] phoneNos = new String[entries];
            PhoneList.Trie trie = new PhoneList.Trie();
            boolean isConsistent = true;
            scanner.nextLine();

            for (int i = 0; i < entries; i++) {
                //phoneNos[i] = scanner.nextLine();
                // Build Trie and in parallel check whether there is another one with prefix
                if (!isConsistent) {
                    // Avoid work for test cases that have already been proved as inconsistent
                    scanner.nextLine();
                } else {
                    String newEntry = scanner.nextLine();
                    if (trie.containsPrefix(newEntry)) {
                        isConsistent = false;
                    } else {
                        trie.insert(newEntry);
                    }
                }
                
            }

            /*Arrays.sort(phoneNos);

            for (int i = 0; i < phoneNos.length; i++) {
                String first = phoneNos[0];
                for (int j = i + 1; j < phoneNos.length; j++) {
                    if (phoneNos[j].startsWith(first)) {
                        isConsistent = false;
                        break;
                    }
                }
            }*/

            if (isConsistent) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }

    public static class Trie {
        
        // trie node
        static class TrieNode {
            public static final Character LEAF = Character.valueOf('*');

            Map<Character, TrieNode> children;
            Character character;
            
            // isEndOfWord is true if the node represents 
            // end of a word 
            boolean isEndOfWord; 
            
            TrieNode(Character character, boolean leaf){
                this.character = character;
                if (!leaf) {
                    children = new HashMap<>();
                    isEndOfWord = false;
                } else {
                    isEndOfWord = true;
                }
            }

            boolean isCompleteWord() {
                Character leaf = LEAF;
                return this.children.containsKey(LEAF);
            }
        }; 
        
        TrieNode root;  

        public Trie() {
            root = new TrieNode(null, false);
        }
        
        // If not present, inserts key into trie 
        // If the key is prefix of trie node,  
        // just marks leaf node.
        void insert(String key) {
            char[] characters = key.toCharArray();
            this.addAll(characters, this.root);            
        }

        private void addAll(char[] characters, TrieNode node) {
            if (characters.length == 0) {
                if (!node.children.containsKey(TrieNode.LEAF)) {
                    TrieNode leafNode = new TrieNode(TrieNode.LEAF, true);
                    node.children.put(TrieNode.LEAF, leafNode);
                }
                return;
            }

            Character currentChar = Character.valueOf(characters[0]);
            TrieNode child = node.children.get(currentChar);
            if (child == null) {
                child = new TrieNode(currentChar, false);
                node.children.put(currentChar, child);
            }

            this.addAll(Arrays.copyOfRange(characters, 1, characters.length), child);
        }
        
        // Returns the number of characters in key that is present in the Trie already. (in the same order)
        int search(String key) { 
            char[] characters = key.toCharArray();

            int counter = 0;
            TrieNode currentNode = this.root;

            for (char c : characters) {
                Character currentChar = Character.valueOf(c);

                if (!currentNode.children.containsKey(currentChar)) {
                    break;
                } else {
                    counter++;
                    currentNode = currentNode.children.get(currentChar);
                }
            }
            return counter;
        }

        // Function that checks whether an existing node is a 
        // prefix of key or if key is the prefix of an existing node. 
        boolean containsPrefix(String key) {
            boolean result = false;
            char[] characters = key.toCharArray();

            TrieNode currentNode = this.root;

            // Check for prefix in trie
            for (char c : characters) {
                Character currentChar = Character.valueOf(c);
                
                if (currentNode.isCompleteWord()) {
                    result = true;
                    break;
                } else if (currentNode.children.get(currentChar) == null){
                    break;
                } else {
                    currentNode = currentNode.children.get(currentChar);
                }
            }
            //check if key is prefix
            if (!result) {
                currentNode = this.root;
                for (char c : characters) {
                    if (currentNode == null) {
                        break;
                    }
                    Character currentChar = Character.valueOf(c);
                    currentNode = currentNode.children.get(currentChar);
                }
                if (currentNode != null && currentNode.children.size() > 0) {
                    result = true;
                }
            }
            
            return result;
        }
    } 
}