function AuditResult({ result }) {

    if (!result) {
        return null;
    }

    return (
        <div className="result-card">

            <h2>Analysis Result</h2>

            <p><strong>Status:</strong> {result.status}</p>

            <p><strong>Response Time:</strong> {result.responseTime} ms</p>

            <p><strong>Title:</strong> {result.title}</p>

            <p><strong>H1 Count:</strong> {result.h1Count}</p>

            <p><strong>Missing Alt Tags:</strong> {result.missingAltTags}</p>

            <p><strong>Word Count:</strong> {result.wordCount}</p>

        </div>
    );
}

export default AuditResult;