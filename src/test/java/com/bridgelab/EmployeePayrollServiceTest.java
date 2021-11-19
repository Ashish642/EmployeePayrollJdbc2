package com.bridgelab;
import com.bridgelabz.EmployeePayrollDBService;
import com.bridgelabz.EmployeePayrollData;
import com.bridgelabz.EmployeePayrollService;
import org.junit.Test;
import org.junit.junit.jupiter.api.Assertions;

import java.util.List;

import static com.bridgelabz.EmployeePayrollService.IOService.DB_IO;

public class EmployeePayrollServiceTest {
    @Test
    void  givenEmployeePayrolInDB_WhenRetrieved_ShouldMatchEmployeeCount() {
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        List<EmployeePayrollData> employeePayrollData = employeePayrollService.readEmployeePayrollData(DB_IO);
        Assertions.assertEquals(4, employeePayrollData.size());

    }

}
