package com.pendycorp.todo.repositories;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.pendycorp.todo.model.TodoList;

/**
 * Implementation of CrudRepository
 * @author spendyala
 *
 */
@EnableScan
public interface TodoListRepository extends CrudRepository<TodoList, String> {

	
}
