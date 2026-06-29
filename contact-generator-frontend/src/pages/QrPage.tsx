// export default QrPage;
import { useNavigate } from "react-router-dom";
import { useParams } from "react-router-dom";

function QrPage() {

    const { id } = useParams();

    const navigate = useNavigate();

    return (
        <div>

            <h1>Employee QR Code</h1>

            <img
                src={`http://localhost:8080/api/employees/${id}/qrcode`}
                alt="Employee QR"
            />

            <br />

            <button
                onClick={() => navigate("/")}
            >
                Back
            </button>

        </div>
    );
}

export default QrPage;