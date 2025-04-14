package org.example.meta;


import java.util.*;

class DictNode {
    boolean isWordEnd;
    Map<Character, DictNode> dictNodeMap;
    Character lastAdded;

    public DictNode() {
        isWordEnd = false;
        dictNodeMap = new HashMap<>();
        lastAdded = null;
    }
}

public class AlienDict {

    private DictNode headNode;
    private Map<Character, Set<Character>> edgeMap;
    private Map<Character, Integer> edgeCounts;

    private void addEdges(Set<Character> cList, Character dest) {
        int edgesAdded = 0;
        for (Character c : cList) {
            if (edgeMap.containsKey(c)){
                if (!edgeMap.get(c).contains(dest)){
                    edgeMap.get(c).add(dest);
                    edgesAdded++;
                }
            }
            else {
                Set<Character> dests = new HashSet<>();
                dests.add(dest);
                edgesAdded++;
                edgeMap.put(c,dests);
            }
            if (!edgeCounts.containsKey(c)){
                edgeCounts.put(c, 0);
            }
        }
        edgeCounts.put(dest,edgesAdded+edgeCounts.getOrDefault(dest,0));
    }

    private boolean addWords(String[] words) {
        for (String word : words) {
            DictNode curr = headNode;
            for (char c : word.toCharArray()) {
                if (curr.dictNodeMap.containsKey(c)) {
                    if (curr.lastAdded != c){
                        return true;
                    }
                    curr = curr.dictNodeMap.get(c);
                } else {
                    addEdges(curr.dictNodeMap.keySet(), c);
                    DictNode next = new DictNode();
                    curr.dictNodeMap.put(c, next);
                    curr.lastAdded = c;
                    curr = next;
                }
            }
            curr.isWordEnd = true;
        }
        return false;
    }

    private Character getNext(){
        for (char c : edgeCounts.keySet()){
            if (edgeCounts.get(c) == 0){
                edgeCounts.remove(c);
                return c;
            }
        }
        return null;
    }

    public String alienOrder(String[] words) {
        headNode = new DictNode();
        edgeMap = new HashMap<>();
        edgeCounts = new HashMap<>();
        boolean isCycle = addWords(words);
        if (isCycle){
            return "";
        }

        List<Character> letters = new ArrayList<>();

        while (true){
            Character next = getNext();
            if (next == null){
                break;
            }
            letters.add(next);
            if (edgeMap.containsKey(next)) {
                for (char d : edgeMap.get(next)) {
                    edgeCounts.put(d, edgeCounts.get(d) - 1);
                }
            }
        }

        if (!edgeCounts.isEmpty()){
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (Character l : letters){
            sb.append(l);
        }


        LinkedHashMap<String, String> test = new LinkedHashMap<>();


        return sb.toString();

    }
}
