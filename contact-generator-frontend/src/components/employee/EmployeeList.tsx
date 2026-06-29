import EmployeeCard from "./EmployeeCard";
// import { Employee } from "../../types/Employee";
import type { Employee } from '../../types/Employee';

interface EmployeeListProps {
    employees: Employee[];
    onGenerateQr: (id: number) => void;
}

function EmployeeList({
                          employees,
                          onGenerateQr
                      }: EmployeeListProps) {

    return (
        <>
            {employees.map(employee => (
                <EmployeeCard
                    key={employee.id}
                    employee={employee}
                    onGenerateQr={onGenerateQr}
                />
            ))}
        </>
    );
}

export default EmployeeList;