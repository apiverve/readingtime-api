/**
 * Basic Example - Reading Time Calculator API
 *
 * This example demonstrates how to use the Reading Time Calculator API.
 * Make sure to set your API key in the .env file or replace '[YOUR_API_KEY]' below.
 */

require('dotenv').config();
const readingtimeAPI = require('../index.js');

// Initialize the API client
const api = new readingtimeAPI({
    api_key: process.env.API_KEY || '[YOUR_API_KEY]'
});

// Example query
var query = {
  "text": "This is a sample article with multiple paragraphs. Reading time will be calculated based on word count. The average reading speed is 250 words per minute, which can be customized. This helps content creators provide accurate time estimates to their readers.",
  "wpm": 250
};

// Make the API request using callback
console.log('Making request to Reading Time Calculator API...\n');

api.execute(query, function (error, data) {
    if (error) {
        console.error('Error occurred:');
        if (error.error) {
            console.error('Message:', error.error);
            console.error('Status:', error.status);
        } else {
            console.error(JSON.stringify(error, null, 2));
        }
        return;
    }

    console.log('Response:');
    console.log(JSON.stringify(data, null, 2));
});
