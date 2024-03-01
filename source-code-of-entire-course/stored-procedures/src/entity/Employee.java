package entity;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.StoredProcedureParameter;

import dto.EmployeeDto;

@Entity
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(
            name = "CountByDepartmentProcedure",
            procedureName = "count_employee_by_department",
            parameters = {
                    @StoredProcedureParameter(
                            name = "dept",
                            type = String.class,
                            mode = ParameterMode.IN),
                    @StoredProcedureParameter(
                            name = "count",
                            type = Integer.class,
                            mode = ParameterMode.OUT)
            }
    ),
    @NamedStoredProcedureQuery(
            name = "FindByDepartmentProcedure",
            procedureName = "find_employee_by_department",
            resultClasses = Employee.class,
            parameters = {
                    @StoredProcedureParameter(
                            name = "dept",
                            type = String.class,
                            mode = ParameterMode.IN)
            }
    ),
    @NamedStoredProcedureQuery(
            name = "FindNameAndSalaryByDepartmentProcedure",
            procedureName = "find_name_and_salary_by_department",
            resultSetMappings = "EmployeeDtoMapping",
            parameters = {
                    @StoredProcedureParameter(
                            name = "dept",
                            type = String.class,
                            mode = ParameterMode.IN)
            }
    )
})
@SqlResultSetMapping(
		name = "EmployeeDtoMapping",
		classes = @ConstructorResult(
							targetClass = EmployeeDto.class,
							columns = {
												@ColumnResult(name = "name"),
												@ColumnResult(name = "salary")
							}
					)
)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer salary;
    
    private String department;

    public Employee() {}
	public Employee(String name, Integer salary, String department) {
		this.name = name;
		this.salary = salary;
		this.department = department;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", department=" + department + "]";
	} 
    
}
