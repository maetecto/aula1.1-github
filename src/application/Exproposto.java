package application;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

import Entities.Employee;

public class Exproposto {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		List<Employee> listEmp = new ArrayList<>();
		
		System.out.print("How many employees will be registered? ");
		int registed = sc.nextInt();
		
		for(int i = 1; i <= registed; i++) {
			System.out.println();
			System.out.println("Employee #" + i + ":");
			System.out.print("id: ");
			Integer id = sc.nextInt();
			
			while(hasId(listEmp,id)) {
				System.out.println("Id already taken! Please try again: ");
				id = sc.nextInt();
			}
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			Double salary = sc.nextDouble();
			Employee emp = new Employee(id, name, salary);
			listEmp.add(emp);
		}
		
		System.out.println();
		System.out.println("Enter the employee id that will"
				+ " have salary increase : ");
		Integer searchId = sc.nextInt();
		
//		alternativa com a funcao position
//		Integer pos = position(listEmp, searchId);
		Employee emp = listEmp.stream().filter(x -> x.getId() == searchId).findFirst().orElse(null);
		if(emp == null) {
			System.out.println("This id does not exist!");
		}	
		else {
			System.out.println("Enter the percentage: ");
			double percentage = sc.nextDouble();
//			listEmp.get(pos).increaseSalary(percentage);
			emp.increaseSalary(percentage);
			
		}
		
		System.out.println("List of employees:");
		
		for(Employee emplo : listEmp) {
			System.out.println(emplo);
		}

		sc.close();
	}
	
	//(alternativa ao Employee emp = listEmp.stream().filter(x -> x.getId() == searchId).findFirst().orElse(null);)
	//funcao para descobrir o index do id escolhido para aumentar salario
	public static Integer position(List<Employee> list, int id ) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getId() == id) {
				return i;
			}
		}
		return null;
	}
	
	public static boolean hasId(List<Employee> list, int id) {
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}

}
