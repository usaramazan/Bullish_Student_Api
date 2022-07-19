@EditingStudent, @Regression, @Smoke
Feature: Test for editing student

	@AddStudent
	Scenario: Test Add Student
	    Given Send POST request to add student
	    Then Status code is <201>


	@DeleteStudent
	Scenario: Test Delete Student
	    Given Send Delete request to delete student
	    Then Status code is <204>


	@UpdateStudent
	Scenario: Test Update Student
		Given Send Update request to update student
		Then Verify lastname is updated
		Then Status code is <204>

	@GetStudent
	Scenario: Test Get Student
		Given Send Get request to retrieve student
		Then Status code is <200>