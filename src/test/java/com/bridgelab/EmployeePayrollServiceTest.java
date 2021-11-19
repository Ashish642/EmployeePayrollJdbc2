package com.bridgelab;
import com.bridgelabz.EmployeePayrollDBService;
import com.bridgelabz.EmployeePayrollData;
import com.bridgelabz.EmployeePayrollException;
import com.bridgelabz.EmployeePayrollService;
import org.junit.Before;
import org.junit.Test;
import org.junit.junit.jupiter.api.Assertions;

import java.util.List;

import static com.bridgelabz.EmployeePayrollService.IOService.DB_IO;

public class EmployeePayrollServiceTest {
    EmployeePayrollService employeePayrollService = null;
    @Before
    void setUp() {
        employeePayrollService = new EmployeePayrollService();

    }
    @Test
    void  givenEmployeePayrolInDB_WhenRetrieved_ShouldMatchEmployeeCount() {
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        List<EmployeePayrollData> employeePayrollData = employeePayrollService.readEmployeePayrollData(DB_IO);
        Assertions.assertEquals(4, employeePayrollData.size());

    }
    @Test
    void givenEmployeePayrolInDB_WhenRetrieved_ShouldSyncWithDB() throws EmployeePayrollException {
        List<EmployeePayrollData> employeePayrollData = employeePayrollService.readEmployeePayrollData(DB_IO);
        employeePayrollService.updateEmployeeSalary("Terisa",50000.00);
        boolean result = employeePayrollService.checkEmployeePayrollSyncWithDB("Terisa");
        Assertion.assertTrue(result);
    }

}
