package com.java.features.eight.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Shashwat Singh
 * 
 *         Demo class for Employee Stream.
 */
public class EmployeeStreamDemo {
	static List<Employee> empList = null;
	static {
		empList = new ArrayList<>();
		empList.add(new Employee(1, "abc", 28, 123, "F", "HR", "Blore", 2020));
		empList.add(new Employee(2, "xyz", 29, 120, "F", "HR", "Hyderabad", 2015));
		empList.add(new Employee(3, "efg", 30, 115, "M", "HR", "Chennai", 2014));
		empList.add(new Employee(4, "def", 32, 125, "F", "HR", "Chennai", 2013));
		empList.add(new Employee(5, "ijk", 22, 150, "F", "IT", "Noida", 2013));
		empList.add(new Employee(6, "mno", 27, 140, "M", "IT", "Gurugram", 2017));
		empList.add(new Employee(7, "uvw", 26, 130, "F", "IT", "Pune", 2016));
		empList.add(new Employee(8, "pqr", 23, 145, "M", "IT", "Trivandam", 2015));
		empList.add(new Employee(9, "stv", 25, 160, "M", "IT", "Blore", 2010));
	}

	public static void main(String[] args) {
		System.out.println(
				"=========================================================================================================");
		System.out.println("Total Employees in list : " + empList.size());
		System.out.println(
				"=========================================================================================================");

		Map<String, Map<String, Long>> dataMap = empList.stream().collect(Collectors.groupingBy(Employee::getDeptName,
				Collectors.groupingBy(Employee::getGender, Collectors.counting())));
		System.out.println("Example of first grouping by depatment and then grouping by Gender within each Department");
		System.out.println("Map : " + dataMap);
		System.out.println(
				"=========================================================================================================");
		System.out.println("Example of average salary of males and females in each dept");
		Map<String, Map<String, Double>> dataMap1 = empList.stream()
				.collect(Collectors.groupingBy(Employee::getDeptName,
						Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary))));
		System.out.println("Department wise average salary of males and females " + dataMap1);
		System.out.println(
				"=========================================================================================================");
		System.out.println("Example of highest salary of males and females department wise");
		Map<String, Map<String, Optional<Employee>>> dataMap2 = empList.stream()
				.collect(Collectors.groupingBy(Employee::getDeptName, Collectors.groupingBy(Employee::getGender,
						Collectors.maxBy(Comparator.comparing(Employee::getSalary)))));
		System.out.println("Department Wise Highest Earning Male and Female Employee : " + dataMap2);
		System.out.println(
				"=========================================================================================================");
		System.out.println("Getting All the department Names");
		empList.stream().map(Employee::getDeptName).distinct().forEach(System.out::println);
		System.out.println(
				"=========================================================================================================");
		System.out.println("Finding the Oldest Employee");
		Optional<Employee> employee = empList.stream().max(Comparator.comparing(Employee::getAge));
		System.out.println("Employee with Highest Age :: " + employee.get().getAge());
		System.out.println(
				"=========================================================================================================");
		System.out.println("Average age of Male and Female in the compamy");
		Map<String, Double> dataMap3 = empList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)));
		System.out.println("Average Age of Male and Female : " + dataMap3);
		System.out.println(
				"=========================================================================================================");
		System.out.println("Find Average age of Male And Female in each Department");
		Map<String, Map<String, Double>> dataMap4 = empList.stream()
				.collect(Collectors.groupingBy(Employee::getDeptName,
						Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge))));
		System.out.println("Department wise Age Average : " + dataMap4);
		System.out.println(
				"=========================================================================================================");
		System.out.println("Getting the Longes Serving Employee");
		Optional<Employee> employee1 = empList.stream().sorted(Comparator.comparing(Employee::getYearOfJoining))
				.min((e1, e2) -> e1.getYearOfJoining() - e2.getYearOfJoining());
		System.out.println("Longest Serving Employee : "+employee1.get().getName());
		System.out.println(
				"=========================================================================================================");

	}
}
