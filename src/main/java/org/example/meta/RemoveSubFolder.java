package org.example.meta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class FolderNode{

    String folderName;
    boolean isEnd;
    Map<String, FolderNode> folderNodeMap;

    public FolderNode(String folderName){
        this.folderName = folderName;
        isEnd = false;
        folderNodeMap = new HashMap<>();
    }
}
public class RemoveSubFolder {

    FolderNode headNode;
    List<String> output;

    private void addFolder(String folder){
        String[] fs = folder.split("/");
        FolderNode folderNode = this.headNode;
        for (String s : fs){
            if (s.isEmpty()){
                continue;
            }
            if (folderNode.isEnd){
                return;
            }
            if (folderNode.folderNodeMap.containsKey(s)){
                folderNode = folderNode.folderNodeMap.get(s);
            }
            else {
                FolderNode next = new FolderNode(s);
                folderNode.folderNodeMap.put(s,next);
                folderNode = next;
            }
        }
        folderNode.isEnd = true;
    }

    private String getString(List<String> sList){
        StringBuilder sb = new StringBuilder();
        for (String s : sList){
            sb.append('/');
            sb.append(s);
        }
        return sb.toString();
    }

    private void getFolders(FolderNode folderNode, List<String> sList){
        if (folderNode.isEnd){
            this.output.add(this.getString(sList));
            return;
        }
        for (Map.Entry<String,FolderNode> entry : folderNode.folderNodeMap.entrySet()){
            sList.add(entry.getKey());
            this.getFolders(entry.getValue(),sList);
            sList.remove(sList.size()-1);
        }
    }

    public List<String> removeSubfolders(String[] folder) {
        headNode = new FolderNode("$");
        output = new ArrayList<>();
        for (String f : folder){
            this.addFolder(f);
        }
        this.getFolders(headNode, new ArrayList<>());
        return this.output;
    }
}
