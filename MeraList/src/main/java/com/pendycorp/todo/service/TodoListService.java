package com.pendycorp.todo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pendycorp.todo.model.Item;
import com.pendycorp.todo.model.TodoList;
import com.pendycorp.todo.repositories.TodoListRepository;

/**
 * Main Service class that handles business logic
 * @author spendyala
 *
 */
@Service
public class TodoListService {

	@Autowired
	private TodoListRepository repository;
	
	//remove this after login feature is added
	private static final String USER = "spendyal";
	
	/**
	 * First checks if the list name already exists and returns the list.
	 * Creates a new list if doesn't exist
	 * @param listName
	 * @return TodoList
	 */
	public TodoList addList(String listName)
	{
		TodoList returnList = null;
		
		try {
			returnList = getList(listName);	
		}catch(NoSuchElementException e)
		{
			TodoList newList = new TodoList();
			newList.setListName(listName);
			newList.setUser(USER);
			
			returnList = repository.save(newList);
			
		}
		
		return returnList;
	}
	
	/**
	 * Gets list
	 * @param listName
	 * @return TodoList
	 */
	public TodoList getList(String listName)
	{
		Optional<TodoList> list =  repository.findById(listName);
		return list.get();
	}
	
	/**
	 * Adds the item to the list
	 * @param listName
	 * @param itemName
	 * @return TodoList
	 */
	public TodoList addItem(String listName, String itemName)
	{
		TodoList todoList = getList(listName);		
		
		List<Item> itemList = todoList.getItemList();
		if(itemList == null) {
			itemList = new ArrayList<Item>();
		}
		Item newItem = new Item();	
		newItem.setItemName(itemName);
		itemList.add(newItem);
		
		todoList.setItemList(itemList);
		
		return repository.save(todoList);
		
	}
	
	/**
	 * Deleted the item from the list
	 * @param listName
	 * @param itemName
	 * @return TodoList
	 */
	public TodoList deleteItem(String listName, String itemName) {
		
		TodoList todoList = getList(listName);
		
		List<Item> itemList = todoList.getItemList();
		
		if(itemList != null && !itemList.isEmpty()) {
			itemList.removeIf(p -> p.getItemName().equalsIgnoreCase(itemName));
			todoList.setItemList(itemList);
		}
		
		return repository.save(todoList);
	}
	
	/**
	 * Deletes the list and returns rest of the list names
	 * @param listName
	 * @return List<String>
	 */
	public List<String> deleteList(String listName) 
	{
		try {
			repository.deleteById(listName);
		}catch(Exception e)
		{
			//Do Nothing
		}
		
		return getAllLists();
	}
	
	
	/**
	 * Gets all the list names
	 * @return List<String>
	 */
	public List<String> getAllLists(){
		Iterable<TodoList> listIterable = repository.findAll();
		
		List<TodoList> todoList = new ArrayList<TodoList>();
		listIterable.iterator().forEachRemaining(todoList::add);
		
		return todoList.stream().map(TodoList :: getListName).collect(Collectors.toCollection(ArrayList:: new));
	}
}
