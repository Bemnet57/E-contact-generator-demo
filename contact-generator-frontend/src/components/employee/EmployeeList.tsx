import EmployeeCard from "./EmployeeCard";
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
        <div className="employee-grid">
            {employees.map(employee => (
                <EmployeeCard
                    key={employee.id}
                    employee={employee}
                    onGenerateQr={onGenerateQr}
                />
            ))}
        </div>
    );
}

export default EmployeeList;