package course.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import course.entity.Todo;

@Transactional//Does all the transactions
public class TodoService {
	
	@PersistenceContext//Does the persistance
	EntityManager entityManager;
	
	public Todo createTodo(Todo todo) {
		//persist into db
		entityManager.persist(todo);
		return todo;
	}
	
	public Todo updateTodo(Todo todo) {
		//update into db
		entityManager.merge(todo);
		return todo;
	}
	
	public Todo findTodoById(Long id) {
		//returns froms db
		return entityManager.find(Todo.class, id);
	}
	
	public List<Todo> getTodos(){
        return entityManager.createQuery("SELECT t from Todo t", Todo.class).getResultList();
    }
}
