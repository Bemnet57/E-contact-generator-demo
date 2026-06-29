import { useState } from "react";
import "../../styles/EmployeeSearch.css";

interface EmployeeSearchProps {
    onSearch: (name: string) => void;
}

function EmployeeSearch({
                            onSearch
                        }: EmployeeSearchProps) {

    const [name, setName] = useState("");

    const handleSearch = () => {
        onSearch(name);
    };

    return (
        <div className="search-container">
            <input
                type="text"
                placeholder="Search employee..."
                value={name}
                onChange={(e) =>
                    setName(e.target.value)
                }
            />

            <button onClick={handleSearch}>
                Search
            </button>
        </div>
    );
}

export default EmployeeSearch;