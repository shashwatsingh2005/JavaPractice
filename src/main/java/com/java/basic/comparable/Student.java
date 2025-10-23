package com.java.basic.comparable;

/**
 * The {@code Comparable} interface defines the natural ordering for objects of
 * a class.
 * <p>
 * A class that implements this interface establishes its <b>natural
 * ordering</b>, which is typically based on one of its key attributes (for
 * example, an Employee's ID or a Product's price). This ordering is used by
 * sorting utilities like {@link java.util.Collections#sort(List)} and
 * {@link java.util.Arrays#sort(Object[])} when no explicit
 * {@link java.util.Comparator} is provided.
 * </p>
 *
 * <h3>Usage Example:</h3>
 * 
 * <pre>{@code
 * public class Employee implements Comparable<Employee> {
 * 	private int id;
 * 	private String name; @Override
 * 	public int compareTo(Employee other) {
 * 		return Integer.compare(this.id, other.id); // Natural order by ID
 * 	}
 * }
 *
 * List<Employee> employees = new ArrayList<>();
 * employees.add(new Employee(3, "Alice"));
 * employees.add(new Employee(1, "Bob"));
 * employees.add(new Employee(2, "Charlie"));
 *
 * Collections.sort(employees); // Uses compareTo()
 * }</pre>
 *
 * <p>
 * <b>Key Points:</b>
 * </p>
 * <ul>
 * <li>Defines a single, consistent "natural order" for objects of that
 * class.</li>
 * <li>Used when objects have a default or logical way of being ordered.</li>
 * <li>Implementing classes should ensure that compareTo() is consistent with
 * equals().</li>
 * </ul>
 *
 * @param <T> the type of objects that this object may be compared to
 * @see java.util.Comparator
 * @see java.util.Collections#sort(List)
 * @see java.util.Arrays#sort(Object[])
 */

public class Student implements Comparable<Student> {

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
