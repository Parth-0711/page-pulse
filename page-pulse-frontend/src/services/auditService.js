import axios from "axios";

const API_URL = "http://localhost:8080/api";

export const analyzeUrl = async (url) => {

    const response = await axios.post(
        `${API_URL}/analyze`,
        { url }
    );

    return response.data;
};