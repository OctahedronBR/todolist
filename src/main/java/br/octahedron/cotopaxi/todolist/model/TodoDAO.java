/*
 *  TodoList - A common learning application for popular
 *  organizations.
 *  Copyright (C) 2011 Octahedron 
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.octahedron.cotopaxi.todolist.model;

import java.util.Collection;

import javax.jdo.Query;

import br.octahedron.cotopaxi.datastore.jdo.GenericDAO;

/**
 * @author Vítor Avelino <vitoravelino@octahedron.com.br>
 */
@SuppressWarnings("unchecked")
public class TodoDAO extends GenericDAO<Todo> {

	public TodoDAO() {
		super(Todo.class);
	}
	
	public Collection<Todo> getAllDesc() {
		Query query = this.datastoreFacade.createQueryForClass(Todo.class);
		query.setOrdering("id descending");
		return (Collection<Todo>) query.execute();
	}

}
