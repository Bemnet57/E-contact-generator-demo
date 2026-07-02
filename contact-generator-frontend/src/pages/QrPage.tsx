
import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import "../styles/QrPage.css";

import type { Employee } from "../types/Employee";


import { getEmployeeById } from "../services/employeeService";

function QrPage() {

    const { id } = useParams();

    const navigate = useNavigate();

    const [employee, setEmployee] =
        useState<Employee | null>(null);

    useEffect(() => {

        loadEmployee();

    }, []);

    const loadEmployee = async () => {

        if (!id) return;

        try {

            const response =
                await getEmployeeById(Number(id));

            setEmployee(response.data);

        } catch (error) {

            console.error(error);

        }

    };

    if (!employee) {

        return <p>Loading...</p>;

    }

    return (

        <div className="qr-container">

            <button
                className="back-button"
                onClick={() => navigate("/")}
            >
                ← Back
            </button>

            <h1>Enat Bank Employee Contact</h1>

            <div className="employee-info">

                <h2>{employee.fullName}</h2>

                <p>
                    <strong>Email:</strong> {employee.email}
                </p>

                <p>
                    <strong>Phone:</strong> {employee.phoneNumber}
                </p>

            </div>

            <img
                src={`http://localhost:8080/api/employees/${id}/qrcode`}
                alt="Employee QR Code"
            />

            <div className="button-group">

                <a
                    href={`http://localhost:8080/api/employees/${id}/qrcode`}
                    download={`employee-${id}.png`}
                >
                    <button>
                        Download QR
                    </button>
                </a>

                <button
                    onClick={() => window.print()}
                >
                    Print
                </button>

            </div>

        </div>

    );

}

export default QrPage;