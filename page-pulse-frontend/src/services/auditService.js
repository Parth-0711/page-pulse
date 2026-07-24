import axios from "axios";

const API_URL = "https://page-pulse-u04t.onrender.com/api";

export const analyzeUrl = async (url) => {

    const response = await axios.post(
        `${API_URL}/analyze`,
        { url }
    );

    return response.data;
};