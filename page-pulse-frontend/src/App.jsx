import { useState } from "react";
import AuditForm from "./components/AuditForm";
import AuditResult from "./components/AuditResult";
import { analyzeUrl } from "./services/auditService";
import "./styles.css";

function App() {

  const [result, setResult] = useState(null);
  const [error, setError] = useState("");
  const [loading, setLoading] = useState(false);

  const handleAnalyze = async (url) => {

    try {

      setLoading(true);
      setError("");
      setResult(null);

      const data = await analyzeUrl(url);

      setResult(data);

    } catch (err) {

      setError(
        err.response?.data?.error ||
        "Something went wrong"
      );

    } finally {

      setLoading(false);
    }
  };

  return (
    <div className="container">

      <h1>Page Pulse</h1>

      <p>
        Analyze any webpage and get quick SEO insights.
      </p>

      <AuditForm onAnalyze={handleAnalyze} />

      {loading && <p>Analyzing...</p>}

      {error && (
        <p className="error">
          {error}
        </p>
      )}

      <AuditResult result={result} />

    </div>
  );
}

export default App;