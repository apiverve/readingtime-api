# Reading Time Calculator API - PHP Package

Reading Time Calculator estimates how long it will take to read a given text. It calculates reading time based on word count and customizable reading speed (WPM).

## Installation

Install via Composer:

```bash
composer require apiverve/readingtime
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```php
<?php

require_once 'vendor/autoload.php';

use APIVerve\Readingtime\Client;

// Initialize the client
$client = new Client('YOUR_API_KEY');

// Make a request
$response = $client->execute([
    'text' => 'This is a sample article with multiple paragraphs. Reading time will be calculated based on word count. The average reading speed is 250 words per minute, which can be customized. This helps content creators provide accurate time estimates to their readers.',
    'wpm' => 250
]);

// Print the response
print_r($response);
```


### Error Handling

```php
use APIVerve\Readingtime\Client;
use APIVerve\Readingtime\Exceptions\APIException;
use APIVerve\Readingtime\Exceptions\ValidationException;

try {
    $response = $client->execute(['text' => 'This is a sample article with multiple paragraphs. Reading time will be calculated based on word count. The average reading speed is 250 words per minute, which can be customized. This helps content creators provide accurate time estimates to their readers.', 'wpm' => 250]);
    print_r($response['data']);
} catch (ValidationException $e) {
    echo "Validation error: " . implode(', ', $e->getErrors());
} catch (APIException $e) {
    echo "API error: " . $e->getMessage();
    echo "Status code: " . $e->getStatusCode();
}
```

### Debug Mode

```php
// Enable debug logging
$client = new Client(
    apiKey: 'YOUR_API_KEY',
    debug: true
);
```

## Example Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "text_length": 257,
    "word_count": 41,
    "reading_time_minutes": 1,
    "reading_time_seconds": 10,
    "reading_time_text": "1 min read",
    "words_per_minute": 250
  }
}
```

## Requirements

- PHP 7.4 or higher
- Guzzle HTTP client

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/readingtime?utm_source=packagist&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/readingtime?utm_source=php&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/readingtime?utm_source=php&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This package is available under the [MIT License](LICENSE).
