package com.pendycorp.todo.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

/**
 * This class defines the items in the list.
 * @author spendyala
 *
 */
@DynamoDBDocument
public class Item {

	private String itemName;
	
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

}
