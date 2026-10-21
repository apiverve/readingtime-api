# Reading Time Calculator API - Ruby Gem

Reading Time Calculator estimates how long it will take to read a given text. It calculates reading time based on word count and customizable reading speed (WPM).

## Installation

Add this line to your application's Gemfile:

```ruby
gem 'apiverve_readingtime'
```

And then execute:

```bash
$ bundle install
```

Or install it yourself as:

```bash
$ gem install apiverve_readingtime
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```ruby
require 'apiverve_readingtime'

# Initialize the client
client = APIVerve::Readingtime::Client.new(api_key: "YOUR_API_KEY")

# Make a request
response = client.execute({
  text: "This is a sample article with multiple paragraphs. Reading time will be calculated based on word count. The average reading speed is 250 words per minute, which can be customized. This helps content creators provide accurate time estimates to their readers.",
  wpm: 250
})

# Print the response
puts response
```


### Error Handling

```ruby
begin
  response = client.execute({ text: "This is a sample article with multiple paragraphs. Reading time will be calculated based on word count. The average reading speed is 250 words per minute, which can be customized. This helps content creators provide accurate time estimates to their readers.", wpm: 250 })
  puts response["data"]
rescue APIVerve::Readingtime::ValidationError => e
  puts "Validation error: #{e.errors.join(', ')}"
rescue APIVerve::Readingtime::APIError => e
  puts "API error: #{e.message}"
  puts "Status code: #{e.status_code}"
end
```

### Debug Mode

```ruby
# Enable debug logging
client = APIVerve::Readingtime::Client.new(
  api_key: "YOUR_API_KEY",
  debug: true
)
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

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/readingtime?utm_source=rubygems&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/readingtime?utm_source=ruby&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/readingtime?utm_source=ruby&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This gem is available under the [MIT License](LICENSE).
