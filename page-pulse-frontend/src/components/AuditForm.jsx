import { useState } from "react";

function AuditForm({ onAnalyze }) {

    const [url, setUrl] = useState("");

    const handleSubmit = (e) => {
        e.preventDefault();

        if (!url.trim()) {
            return;
        }

        onAnalyze(url);
    };

    return (
        <form onSubmit={handleSubmit}>
            <input
                type="text"
                placeholder="Enter website URL..."
                value={url}
                onChange={(e) => setUrl(e.target.value)}
            />

            <button type="submit">
                Analyze
            </button>
        </form>
    );
}

export default AuditForm;