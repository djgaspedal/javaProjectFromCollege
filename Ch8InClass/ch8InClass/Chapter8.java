package ch8InClass;

// Class that takes a predefined array of:
//		[ employee numbers (X-axis) x hours worked/day of the week (y-axis) ]
public class Chapter8 {
	
	// Main method that contains the 'hoursWorked' Array object,
	// 						totals the hours, sorts the hours,
	//						and outputs the hours by invoking the 'outputHours()' methods.
	public static void main(String[] args) {
		
		int[][] hoursWorked = { // Predetermined 2-dimensional Array
				
				{2,4,3,4,5,8,8},  // Employee #0
				{7,3,4,3,3,4,4},   // Employee #1
				{3,3,4,3,3,2,2}, 	// Employee #2
				{9,3,4,7,3,4,1}, 	 // Employee #3
				{3,5,4,3,6,3,8}, 	  // Employee #4
				{3,4,4,6,3,4,4}, 	   // Employee #5
				{3,7,4,8,3,6,4}, 	    // Employee #6
				{6,3,5,9,2,7,9}};	     // Employee #7
		
		int[][] employeeHourTotals = totalEmployeeHrs(hoursWorked); // New 2-Dim. Array with totaled hours
		
		sortByHours(employeeHourTotals); //   Sorts totaled hours
		
		outputHours(employeeHourTotals); // Outputs totaled hours

	}
	
	// Sorts the 2-Dim array 'employeeTotals' as a parameter
	public static void sortByHours( int[][] employeeTotals) {
		
		for(int i = 0; i < employeeTotals.length; i++) {
			
			for(int j = i + 1; j < employeeTotals.length; j++) {
				
				if(employeeTotals[i][1] < employeeTotals[j][1]) {
					int temp[] = employeeTotals[i];
					
					employeeTotals[i] = employeeTotals[j];
					employeeTotals[j] = temp;
					
				}
			}		
		}
	}
	
	// Outputs the hours and uses 'printf()' to format output
	public static void outputHours(int[][] employeeHourTotals) {
	
		System.out.print(" ");
		
		for(int employee = 0; employee < employeeHourTotals.length; employee++) {
			
			System.out.printf("Employee Number: %2d Hours Worked: %3d %n ", 
					employeeHourTotals[employee][0], employeeHourTotals[employee][1]);
			
		}
	}
	
	// Totals the employee's hours and returns a 2-Dim array with the totaled hours called 'totalHrs'
	public static int[][] totalEmployeeHrs(int[][] empHrs) {
		
		int[][] totalHrs = new int[empHrs.length][2];
		
		//totalHours[]
		
		for(int emp = 0; emp < empHrs.length; emp++) {
			
			totalHrs[emp][0] = emp;
			
			for(int day = 0; day < empHrs[emp].length; day++) {
				
				totalHrs[emp][1] += empHrs[emp][day];
				
			}
		}
		return totalHrs;
		
	}
}