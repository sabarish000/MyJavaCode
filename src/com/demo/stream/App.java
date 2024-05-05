package com.demo.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static com.demo.stream.StreamsUtils.*;


public class App {
	static List<Employee> employeeList = new ArrayList<>();

	public static void main(String[] args) throws Exception {

		EmployeeFactory employeeFactory = new EmployeeFactory();
		employeeList = employeeFactory.getAllEmployee();


		Map<String, Employee> employeeMap = convertToMap(employeeList);
		System.out.println("Map: " + employeeMap);
		System.out.println("Salaried Map: " + getMaxSalariedEmployees(employeeMap, 1));

		// TODO
		//listAllDistinctProjects(employeeList).forEach(System.out::println);
		// printAnyEmployeeWithPrefixInName(employeeList, "D");
		// filterEmployeesByYear(employeeList, "2017").forEach(System.out::println);
		//sortByNameAndSalary(employeeList).forEach(System.out::println);
		System.out.println("*********");
		// printAllEmployeeWithNthMaxSalary(employeeList, 3);
		// System.out.println("**********");
		// printAnyEmployeeWithNthMaxSalary(employeeList,3);
		// printAllEmployeesWithMinSalary(employeeList);
		// getEmployeesWorkingMoreThanProjects(employeeList, 2).forEach(System.out::println);
		System.out.println("Tot laptop count: "+totalLaptopCount(employeeList));
		// System.out.println("Tot project count: "+countOfProjectsOfPM(employeeList, "Robert Downey Jr"));
		// getEmployeesOfPM(employeeList, "Robert Downey Jr").forEach(System.out::println);
		// getEmployeeCountByYear(employeeList).forEach((key, value) -> {System.out.println(key + ":" + value);});
		// printUnique(new int[] {1,3,2,1,3,4});
	}

}
