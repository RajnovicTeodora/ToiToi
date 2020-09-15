package controller.ButtonActions;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.AbstractAction;

import model.Recipe;
import view.MainFrame;

public class SearchRecipesButtonAction extends AbstractAction{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 7344829217204344593L;

	public SearchRecipesButtonAction(String name) {
		super(name);
	}
	
	static final int ALPHABET_SIZE = 26; 
	static TrieNode root;
    
    // trie node 
    static class TrieNode 
    { 
        TrieNode[] children = new TrieNode[ALPHABET_SIZE]; 
       
        // isEndOfWord is true if the node represents 
        // end of a word 
        boolean isEndOfWord; 
          
        TrieNode(){ 
            isEndOfWord = false; 
            for (int i = 0; i < ALPHABET_SIZE; i++) 
                children[i] = null; 
        } 
    };
	
    // If not present, inserts key into trie 
    // If the key is prefix of trie node,  
    // just marks leaf node 
    static void insert(String key) 
    { 
        int level; 
        int length = key.length(); 
        int index; 
       
        TrieNode pCrawl = root; 
       
        for (level = 0; level < length; level++) 
        { 
            index = key.charAt(level) - 'a'; 
            if (pCrawl.children[index] == null) 
                pCrawl.children[index] = new TrieNode(); 
       
            pCrawl = pCrawl.children[index]; 
        } 
       
        // mark last node as leaf 
        pCrawl.isEndOfWord = true; 
    }
    
    // Returns true if key presents in trie, else false 
	public boolean search(String key) 
    { 
        int level; 
        int length = key.length(); 
        int index; 
        TrieNode pCrawl = root; 
       
        for (level = 0; level < length; level++) 
        { 
            index = key.charAt(level) - 'a'; 
       
            if (pCrawl.children[index] == null) 
                return false; 
       
            pCrawl = pCrawl.children[index]; 
        } 
       
        return (pCrawl != null && pCrawl.isEndOfWord); 
    }
	
	public HashMap<Recipe, Integer> containsResult(Recipe recipe, HashMap<Recipe, Integer> searchResults) {
		if(searchResults.containsKey(recipe)) {
			searchResults.replace(recipe, searchResults.get(recipe), searchResults.get(recipe)+1);
		}
		else if(!searchResults.containsKey(recipe)) {
			searchResults.put(recipe, 1);
		}
		return searchResults;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		MainFrame.getInstance().getRecipesTab().setSearchClicked(true);
		HashMap<Recipe, Integer> searchResults = new HashMap<Recipe, Integer>();
		
		String searchTerm = MainFrame.getInstance().getRecipesTab().getSearchTxtField().getText();
		ArrayList<String> keys = new ArrayList<String>();
		
		MainFrame.getInstance().getRecipesTab().setSearchTerm(searchTerm);
		if(searchTerm.isEmpty()) {
			try {
				for (Recipe recipe : (ArrayList<Recipe>) MainFrame.getInstance().getToiToiController().getToiToi().getRecipe()) {
					searchResults.put(recipe, 0);				
				}
				MainFrame.getInstance().getRecipesTab().setSearchResults(searchResults);
				MainFrame.getInstance().getRecipesTab().combineSearchAndFilter();
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			MainFrame.getInstance().getRecipesTab().setSearchTerm(searchTerm);
			for (String string : searchTerm.split(" ")) {
				if(!string.equals(" ") && !string.equals("")) {
					keys.add(string.toLowerCase());
				}
			}			
			root = new TrieNode(); 
		       
	        // Construct trie 
	        int i; 
	        for (i = 0; i < keys.size() ; i++) {
	            insert(keys.get(i));
	        }
			
			for (Recipe recipe : (ArrayList<Recipe>) MainFrame.getInstance().getToiToiController().getToiToi().getRecipe()) {
				String name[] = recipe.getName().split(" ");
				for (String string : name) {
					if(search(string.toLowerCase()) == true) {
						searchResults = containsResult(recipe, searchResults);
					}
				}
				for (String string : keys) {
					if((recipe.getName().toLowerCase()).contains(string)) {
						searchResults = containsResult(recipe, searchResults);
					}
				}
			}
			
			MainFrame.getInstance().getRecipesTab().setSearchResults(searchResults);
			try {
				MainFrame.getInstance().getRecipesTab().combineSearchAndFilter();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        
		}
		
	}

}
