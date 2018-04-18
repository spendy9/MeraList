package com.pendycorp.todo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pendycorp.todo.model.TodoList;
import com.pendycorp.todo.service.TodoListService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
/**
 * TodoListController is the main REST Controller that handles all the request related to the List
 * @author spendyala
 *
 */
@RestController
public class TodoListController {

	@Autowired
	private TodoListService service;
	
	/**
	 * Gets all the list names
	 * @return List<String>
	 */
	@RequestMapping(value ="/allListNames", method = RequestMethod.GET)
	@ApiOperation(value ="Get All List Names")
	public List<String> getAllLists(){
		
		return service.getAllLists();
	}
	
	/**
	 * First checks if the list name already exists and returns the list.
	 * Creates a new list if doesn't exist
	 * @param listName
	 * @return TodoList
	 */
	@RequestMapping(value="/list/{listName}", method=RequestMethod.GET)
	@ApiOperation(value = "Add List")
	public TodoList addList(@PathVariable String listName)
	{
		return service.addList(listName);
	}
	
	/**
	 * Adds the item to the list
	 * @param listName
	 * @param itemName
	 * @return TodoList
	 */
	@RequestMapping(value="/list/{listName}/item/{itemName}", method=RequestMethod.GET)
	@ApiOperation(value ="Add Item to the List")
	public TodoList addItem(@PathVariable String listName, @PathVariable String itemName)
	{
		return service.addItem(listName, itemName);
	}
	
	/**
	 * Deleted the item from the list
	 * @param listName
	 * @param itemName
	 * @return TodoList
	 */
	@RequestMapping(value="/list/{listName}/item/{itemName}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Remove Item from the List")
	public TodoList deleteItem(@PathVariable String listName, @PathVariable String itemName)
	{
		return service.deleteItem(listName, itemName);
	}
	
	
	/**
	 * Deletes the list and returns rest of the list names
	 * @param listName
	 * @return
	 */
	@RequestMapping(value="/list/{listName}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete a List")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully removed the list")
	})
	public List<String> deleteList(@PathVariable(value ="listName") String listName)
	{
		return service.deleteList(listName);
	}
}
