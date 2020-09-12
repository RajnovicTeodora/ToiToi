package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import model.Recipe;

public class OrderBy {
	
	private String chosenOrder;
	private HashMap<Recipe, Integer> filterList;
	private ArrayList<Recipe>searchList;
	private boolean filterClicked, searchClicked;
	
	public OrderBy(boolean filterClicked, boolean searchClicked) {
		super();
		this.filterClicked = filterClicked;
		this.searchClicked = searchClicked;
	}
	
	
	public ArrayList<Recipe> getSearchList() {
		return searchList;
	}

	public void setSearchList(ArrayList<Recipe> searchList) {
		this.searchList = searchList;
	}

	public String getChosenOrder() {
		return chosenOrder;
	}

	public void setChosenOrder(String chosenOrder) {
		this.chosenOrder = chosenOrder;
	}

	public HashMap<Recipe, Integer> getFilterList() {
		return filterList;
	}

	public void setFilterList(HashMap<Recipe, Integer> filterList) {
		this.filterList = filterList;
	}



	public ArrayList<Recipe> orderAndArray() {///za filterClicked==true i searchClicked ==false
		Map<Recipe, Integer> result = new LinkedHashMap<>();
		ArrayList<Recipe> filtered = new ArrayList<Recipe>();
		ArrayList<Recipe> combined = new ArrayList<Recipe>();
		
		if(filterClicked) {
			result = sortByValue(filterList);
			for (Recipe recipe : result.keySet()) {
				filtered.add(recipe);
			}
			if(!searchClicked) {
				combined = filtered;
			}
		}
		if(searchClicked && !filterClicked) {
			combined = searchList;
		}
		if(filterClicked && searchClicked) {
			for (Recipe recipe : searchList) {
				if(filtered.contains(recipe)) {
					combined.add(recipe);
				}
			}
		}
		
		int n = combined.size();
		if(!combined.isEmpty() && !chosenOrder.equals(null)) 
		{
			if(chosenOrder.equals("oldest")) {
	
		        sort(combined, 0, n-1,"latest");
		        
		        for (int i = 0; i < combined.size() / 2; i++) { 
		            Recipe temp = combined.get(i); 
		            combined.set(i, combined.get(combined.size() - i - 1)); 
		            combined.set(combined.size() - i - 1, temp); 
		        }			
			}
			else if(chosenOrder.equals("latest")) {
				
				sort(combined, 0, n-1,"latest");
			}
			else if(chosenOrder.equals("easiest")) {
				
				sort(combined, 0, n-1,"easiest");
			}
			else if(chosenOrder.equals("hardest")) {
				
				sort(combined, 0, n-1,"easiest");
				
				for (int i = 0; i < combined.size() / 2; i++) { 
		            Recipe temp = combined.get(i); 
		            combined.set(i, combined.get(combined.size() - i - 1)); 
		            combined.set(combined.size() - i - 1, temp); 
		        }
			}
			else if(chosenOrder.equals("likes")) {
				
				sort(combined, 0, n-1,"likes");
			}
		}
		
		return combined;
	}
	
	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Entry.comparingByValue());

        Map<K, V> result = new LinkedHashMap<>();
        for (Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }
		
	public int partitionEasiest(ArrayList<Recipe> arr, int low, int high) 
    { 
        int pivot = arr.get(high).getDifficulty(); 
        int i = (low-1); // index of smaller element 
        for (int j=low; j<high; j++) 
        { 
            // If current element is smaller than the pivot 
            if (arr.get(j).getDifficulty() < pivot) 
            { 
                i++; 
  
                // swap arr[i] and arr[j] 
                Recipe temp = arr.get(i); 
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            } 
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        Recipe temp = arr.get(i+1); 
        arr.set(i+1, arr.get(high)); 
        arr.set(high, temp); 
  
        return i+1; 
    }
	
	public int partitionLikes(ArrayList<Recipe> arr, int low, int high) //most->least liked
    { 
        int pivot = arr.get(high).getLikes();
        int i = (low-1); // index of smaller element 
        for (int j=low; j<high; j++) 
        { 
            // If current element is smaller than the pivot 
            if (arr.get(j).getLikes() > pivot) 
            { 
                i++; 
  
                // swap arr[i] and arr[j] 
                Recipe temp = arr.get(i); 
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            } 
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        Recipe temp = arr.get(i+1); 
        arr.set(i+1, arr.get(high)); 
        arr.set(high, temp); 
  
        return i+1; 
    }
	
	public int partitionNewest(ArrayList<Recipe> arr, int low, int high) //newest->oldest
    { 
		LocalDate pivot = arr.get(high).getDateCreated();
        int i = (low-1); // index of smaller element 
        for (int j=low; j<high; j++) 
        { 
            // If current element is smaller than the pivot 
            if (pivot.isBefore(arr.get(j).getDateCreated())) 
            { 
                i++; 
  
                // swap arr[i] and arr[j] 
                Recipe temp = arr.get(i); 
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            } 
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        Recipe temp = arr.get(i+1); 
        arr.set(i+1, arr.get(high)); 
        arr.set(high, temp); 
  
        return i+1; 
    }
	
    public void sort(ArrayList<Recipe> arr, int low, int high, String partitionType) 
    { 
        if (low < high) 
        { 
            /* pi is partitioning index, arr[pi] is  
              now at right place */
        	int pi = 0;
        	if(partitionType.equals("easiest")) {
        		pi = partitionEasiest(arr, low, high);
        	}
        	else if(partitionType.equals("likes")) {
        		pi = partitionLikes(arr, low, high);
        	}
        	else if(partitionType.equals("latest")) {
        		pi = partitionNewest(arr, low, high);
        	}
        	
            
            sort(arr, low, pi-1, partitionType); 
            sort(arr, pi+1, high, partitionType); 
        } 
    } 
	
}
