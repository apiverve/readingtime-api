"""
Reading Time Calculator API - Basic Usage Example

This example demonstrates the basic usage of the Reading Time Calculator API.
API Documentation: https://docs.apiverve.com/ref/readingtime
"""

import os
import requests
import json

API_KEY = os.getenv('APIVERVE_API_KEY', 'YOUR_API_KEY_HERE')
API_URL = 'https://api.apiverve.com/v1/readingtime'

def call_readingtime_api():
    """
    Make a POST request to the Reading Time Calculator API
    """
    try:
        # Request body
        request_body &#x3D; {
    &#x27;text&#x27;: &#x27;This is a sample article with multiple paragraphs. Reading time will be calculated based on word count. The average reading speed is 250 words per minute, which can be customized. This helps content creators provide accurate time estimates to their readers.&#x27;,
    &#x27;wpm&#x27;: 250
}

        headers = {
            'x-api-key': API_KEY,
            'Content-Type': 'application/json'
        }

        response = requests.post(API_URL, headers=headers, json=request_body)

        # Raise exception for HTTP errors
        response.raise_for_status()

        data = response.json()

        # Check API response status
        if data.get('status') == 'ok':
            print('✓ Success!')
            print('Response data:', json.dumps(data['data'], indent=2))
            return data['data']
        else:
            print('✗ API Error:', data.get('error', 'Unknown error'))
            return None

    except requests.exceptions.RequestException as e:
        print(f'✗ Request failed: {e}')
        return None

if __name__ == '__main__':
    print('📤 Calling Reading Time Calculator API...\n')

    result = call_readingtime_api()

    if result:
        print('\n📊 Final Result:')
        print(json.dumps(result, indent=2))
    else:
        print('\n✗ API call failed')
