import axios from "axios";

const API_URL =
    "http://localhost:8080/api/employees";

export const getAllEmployees = () => {
    return axios.get(API_URL);
};

export const searchEmployees = (
    name: string
) => {
    return axios.get(
        `${API_URL}/search?name=${name}`
    );
};

export const getQrCodeUrl = (
    id: number
) => {
    return `${API_URL}/${id}/qrcode`;
};

export const getEmployeeById = (
    id: number
) => {
    return axios.get(
        `${API_URL}/${id}`
    );
};