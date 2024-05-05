package com.demo.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsUtils {

    // List all distinct project in non-ascending order.
    public  List<Project> listAllDistinctProjects(List<Employee> employeeList){
        return employeeList.stream()
                .flatMap(employee -> employee.getProjects().stream())
                //.map(project -> project.getName())
                .distinct()
                .sorted((a,b) -> b.getName().compareTo(a.getName()))
                .collect(Collectors.toList());
    }

    // Print full name of any employee whose firstName starts with ‘A’.
    public static void printAnyEmployeeWithPrefixInName(List<Employee> employeeList, String prefix) {
        Optional<Employee> emp = employeeList.stream()
                //.sorted((a,b) -> b.getFirstName().compareTo(a.getFirstName()))
                .filter(e -> e.getFirstName().toUpperCase().startsWith(prefix))
                .findAny();
        if(emp.isPresent()){
            System.out.println(emp.get().getFirstName() + " " + emp.get().getLastName());
        }
    }

    // List of all employee who joined in year 2023 (year to be extracted from employee id i.e., 1st 4 characters)
    public static List<Employee> filterEmployeesByYear(List<Employee> employeeList, String year) {
        return employeeList.stream()
                .filter(e -> e.getId().startsWith(year))
                .collect(Collectors.toList());
    }

    //Sort employees based on firstName, for same firstName sort by salary.
//	public static List<Employee> sortByNameAndSalary(List<Employee> employeeList) {
//		return employeeList.stream()
//				.sorted((a,b) -> {
//					if(a.getFirstName().compareTo(b.getFirstName()) == 0) {
//						if(a.getSalary() < b.getSalary()) {
//							return -1;
//						} else if(a.getSalary() > b.getSalary()) {
//							return 1;
//						} else {
//							return 0;
//						}
//					} else {
//						return a.getFirstName().compareTo(b.getFirstName());
//					}
//				})
//				.collect(Collectors.toList());
//	}

    // .sorted(Comparator.comparing(Employee::getFirstName).thenComparing((a,b)-> Integer.compare(b.getSalary(), a.getSalary())))
    public static List<Employee> sortByNameAndSalary(List<Employee> employeeList) {
        return employeeList.stream()
                .sorted(Comparator.comparing(Employee::getFirstName).thenComparing(Employee::getSalary, (a, b) -> b-a))
                // .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .collect(Collectors.toList());
    }

    //Print name of an employee with 3rd highest salary. (generalise it for nth highest salary).
    public static void printAnyEmployeeWithNthMaxSalary(List<Employee> employeeList, int n) {
        Optional<Employee> emp =  employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .skip(n-1)
                .findFirst();

        if(emp.isPresent()) {
            System.out.println(emp.get().getFullName() );
        }
    }

    //Print names of all employee with 3rd highest salary. (generalise it for nth highest salary).
    public static void printAllEmployeeWithNthMaxSalary(List<Employee> employeeList, int n) {
        employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getSalary))
                .entrySet()
                .stream()
                .sorted((a,b)-> b.getKey().compareTo(a.getKey()))
                .collect(Collectors.toList())
                .stream()
                .skip(n-1)
                .findFirst()
                .ifPresent(entry -> System.out.println(entry.getValue()));
    }

    //	Print min salary.
    public static void printMinSalary(List<Employee> employeeList){
        employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .findFirst()
                .ifPresent(emp -> System.out.println(emp.getSalary()));
    }

    //	Print list of all employee with min salary.
    public static void printAllEmployeesWithMinSalary(List<Employee> employeeList) {
        employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getSalary))
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .findFirst()
                .get()
                .getValue()
                .forEach(System.out::println);
    }

    //	List of people working on more than 2 projects.
    public static List<Employee> getEmployeesWorkingMoreThanProjects(List<Employee> employeeList, int n)  {
        return employeeList.stream()
                .filter(employee -> employee.getProjects().size() > n)
                .collect(Collectors.toList());
    }

    //	Count of total laptops assigned to the employees.
    public static int totalLaptopCount(List<Employee> employeeList) {
        return employeeList.stream()
                .map(employee -> employee.getProjects().size())
                .collect(Collectors.toList())
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
        //.reduce(0, (a,b) -> a+b);
    }
    //	Count of all projects with Robert Downey Jr as PM.
    public static int countOfProjectsOfPM(List<Employee> employeeList, String pmName) {
        return (int) employeeList.stream()
                .flatMap(employee -> employee.getProjects().stream())
//				.collect(Collectors.toList())
//				.stream()
                .distinct()
                .filter(project -> project.getProjectManager().equals(pmName))
                .count();
    }
    //	List of all projects with Robert Downey Jr as PM.
    public static List<Project> getProjectsOfPM(List<Employee> employeeList, String pmName) {
        return employeeList.stream()
                .flatMap(employee -> employee.getProjects().stream())
                .distinct()
                .filter(project -> project.getProjectManager().equals(pmName))
                .collect(Collectors.toList());
    }
    //	List of all people working with Robert Downey Jr.
    public static List<Employee> getEmployeesOfPM(List<Employee> employeeList, String pmName) {
        return employeeList.stream()
                .filter(employee -> employee.getProjects()
                        .stream()
                        .filter(project -> project.getProjectManager().equals(pmName))
                        .findAny().isPresent())
                .collect(Collectors.toList());
    }
    //	Create a map based on this data, they key should be the year of joining, and value should be list of all the employees who joined the particular year. (Hint : Collectors.toMap)
    public static Map<String, List<Employee>> groupEmployeesByJoiningYear(List<Employee> employeeList) {
        return employeeList.stream()
                .collect(Collectors.groupingBy(employee -> employee.getId().substring(0,4)));
    }
    //	Create a map based on this data, the key should be year of joining and value should be the count of people joined in that particular year. (Hint : Collectors.groupingBy())
    public static Map<String, Long> getEmployeeCountByYear(List<Employee> employeeList){
        return employeeList.stream()
                .map(employee -> employee.getId().substring(0,4))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//				.entrySet()
//				.stream()
//				.map(entry -> entry.getValue().size())
    }
    // remove duplicates from the array using stream API
    public static void printUnique(int[] arr) {
        // System.out.println(Arrays.toString(arr));
        Arrays.stream(arr)
                .distinct()
                .forEach(System.out::println);
    }
    // return Map
    public static Map<String, Employee> convertToMap(List<Employee> employeeList) {
        return employeeList.stream()
                .collect(Collectors.toMap(Employee::getId, Function.identity()));
    }

    public static Map<Integer,Employee> getMaxSalariedEmployees(Map<String,Employee> employeeMap, int n) {
        return employeeMap.values().stream()
                .sorted((a,b) -> b.getSalary()-a.getSalary())
                .skip(n)
                .findFirst()
                .stream()
                // Exception in thread "main" java.lang.IllegalStateException: Duplicate key 2200000 (attempted merging values Employee
                // .collect(Collectors.toMap(Employee::getSalary, Function.identity()));
                .collect(Collectors.toMap(Employee::getSalary, Function.identity(), (e1,e2) -> e1));
        // (e1,e2) -> e1 is the mergeFunction

    }
}
