package com.pendycorp.todo.model;

import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

/**
 * This class defines the List
 * @author spendyala
 *
 */
@DynamoDBTable(tableName = "TodoList")
public class TodoList {
	
	private String listName;
	
	private String user;
	
	private List<Item> itemList;

	@DynamoDBHashKey
	@DynamoDBAttribute
	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	@DynamoDBAttribute
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@DynamoDBAttribute
	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

}
