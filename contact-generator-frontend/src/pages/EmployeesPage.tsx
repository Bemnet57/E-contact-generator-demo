import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

import EmployeeList from "../components/employee/EmployeeList";
import EmployeeSearch from "../components/employee/EmployeeSearch";

import {
    getAllEmployees,
    searchEmployees
} from "../services/employeeService";

// import { Employee } from "../types/Employee";
import type { Employee } from '../types/Employee';

function EmployeesPage() {

    const [employees, setEmployees] =
        useState<Employee[]>([]);

    const navigate = useNavigate();

    useEffect(() => {
        loadEmployees();
    }, []);

    const loadEmployees = async () => {

        try {

            const response =
                await getAllEmployees();

            setEmployees(response.data);

        } catch (error) {

            console.error(error);

        }
    };

    const handleSearch = async (
        name: string
    ) => {

        try {

            const response =
                await searchEmployees(name);

            setEmployees(response.data);

        } catch (error) {

            console.error(error);

        }
    };

    const handleGenerateQr = (
        id: number
    ) => {

        navigate(`/qr/${id}`);

    };

    return (
        <div className="container">

            <h1>Employee Directory</h1>

            <EmployeeSearch
                onSearch={handleSearch}
            />

            <button onClick={loadEmployees}>
                Show All
            </button>

            <EmployeeList
                employees={employees}
                onGenerateQr={
                    handleGenerateQr
                }
            />

        </div>
    );
}

export default EmployeesPage;