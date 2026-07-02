import type { Employee } from '../../types/Employee';
import "../../styles/EmployeeCard.css";

interface EmployeeCardProps {
    employee: Employee;
    onGenerateQr: (id: number) => void;
}

function EmployeeCard({
                          employee,
                          onGenerateQr
                      }: EmployeeCardProps) {

    return (
        <div className="employee-card">
            <h3>{employee.fullName}</h3>

            <p>{employee.email}</p>

            <p>{employee.phoneNumber}</p>

            <button
                onClick={() => onGenerateQr(employee.id)}
            >
                Generate QR
            </button>
        </div>
    );
}

export default EmployeeCard;