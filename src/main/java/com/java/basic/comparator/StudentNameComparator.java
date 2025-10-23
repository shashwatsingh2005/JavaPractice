package com.java.basic.comparator;

import java.util.Comparator;

import com.java.basic.comparable.Student;

/**
 * The {@code Comparator} interface defines a custom comparison strategy for
 * objects.
 * <p>
 * Unlike {@link java.lang.Comparable}, which defines a natural order within the
 * class itself, {@code Comparator} allows you to define <b>multiple, external
 * sorting strategies</b> without modifying the target class. This makes it
 * ideal for sorting objects in various ways based on different attributes
 * (e.g., name, salary, age).
 * </p>
 *
 * <h3>Usage Example:</h3>
 * 
 * <pre>{@code
 * public class Employee {
 * 	private int id;
 * 	private String name;
 * 	private double salary;
 *
 * 	// Constructors, getters, and setters
 * }
 *
 * // Sort by name
 * Comparator<Employee> nameComparator = Comparator.comparing(Employee::getName);
 *
 * // Sort by salary (descending)
 * Comparator<Employee> salaryDescComparator = (e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary());
 *
 * List<Employee> employees = new ArrayList<>();
 * employees.add(new Employee(3, "Alice", 80000));
 * employees.add(new Employee(1, "Bob", 95000));
 * employees.add(new Employee(2, "Charlie", 90000));
 *
 * // Apply different sorting strategies
 * employees.sort(nameComparator);
 * employees.sort(salaryDescComparator);
 * }</pre>
 *
 * <p>
 * <b>Key Points:</b>
 * </p>
 * <ul>
 * <li>Defines flexible, reusable sorting logic outside the target class.</li>
 * <li>Supports multiple sorting strategies for the same class.</li>
 * <li>Can be combined using methods like {@code thenComparing()} for
 * multi-level sorting.</li>
 * <li>Introduced as a functional interface in Java 8, allowing concise lambda
 * expressions.</li>
 * </ul>
 *
 * @param <T> the type of objects that may be compared by this comparator
 * @see java.lang.Comparable
 * @see java.util.Collections#sort(List, java.util.Comparator)
 * @see java.util.Comparator#comparing(java.util.function.Function)
 */

public class StudentNameComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		return 0;
	}

}
