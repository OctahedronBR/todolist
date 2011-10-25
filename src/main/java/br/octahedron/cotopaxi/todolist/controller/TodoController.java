package br.octahedron.cotopaxi.todolist.controller;

import br.octahedron.cotopaxi.controller.Controller;
import br.octahedron.cotopaxi.inject.Inject;
import br.octahedron.cotopaxi.todolist.model.Todo;
import br.octahedron.cotopaxi.todolist.model.TodoDAO;

public class TodoController extends Controller {

	private static final String BASE_TPL = "todo/list.vm";
	private static final String BASE_URL = "/";
	
	@Inject
	private TodoDAO todoDAO;
	
	/*
	 * used by dependency injection
	 */
	public void setTodoDAO(TodoDAO todoDAO) {
		this.todoDAO = todoDAO;
	}
	
	public void getList() {
		out("todos", todoDAO.getAll());
		success(BASE_TPL);
	}
	
	public void postCreate() {
		Todo todo = new Todo(in("description"));
		todoDAO.save(todo);
		redirect(BASE_URL);
	}
	
	public void postUpdate() {
		Todo todo = todoDAO.get(in("id"));
		todo.setCompleted(new Boolean(in("completed")));
		jsonSuccess();
	}
	
	public void postDelete() {
		todoDAO.delete(in("id"));
		jsonSuccess();
	}

}
