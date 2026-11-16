# Reading Time Calculator API - Dart/Flutter Client

Reading Time Calculator estimates how long it will take to read a given text. It calculates reading time based on word count and customizable reading speed (WPM).

[![pub package](https://img.shields.io/pub/v/apiverve_readingtime.svg)](https://pub.dev/packages/apiverve_readingtime)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This is the Dart/Flutter client for the [Reading Time Calculator API](https://apiverve.com/marketplace/readingtime?utm_source=dart&utm_medium=referral&utm_content=readme).

## Installation

Add this to your `pubspec.yaml`:

```yaml
dependencies:
  apiverve_readingtime: ^1.2.6
```

Then run:

```bash
dart pub get
# or for Flutter
flutter pub get
```

## Usage

```dart
import 'package:apiverve_readingtime/apiverve_readingtime.dart';

void main() async {
  final client = ReadingtimeClient('YOUR_API_KEY');

  try {
    final response = await client.execute({
      'text': 'This is a sample article with multiple paragraphs. Reading time will be calculated based on word count. The average reading speed is 250 words per minute, which can be customized. This helps content creators provide accurate time estimates to their readers.',
      'wpm': 250
    });

    print('Status: ${response.status}');
    print('Data: ${response.data}');
  } catch (e) {
    print('Error: $e');
  }
}
```

## Response

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

## API Reference

- **API Home:** [Reading Time Calculator API](https://apiverve.com/marketplace/readingtime?utm_source=dart&utm_medium=referral&utm_content=readme)
- **Documentation:** [docs.apiverve.com/ref/readingtime](https://docs.apiverve.com/ref/readingtime?utm_source=dart&utm_medium=referral&utm_content=readme)

## Authentication

All requests require an API key. Get yours at [apiverve.com](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme).

## License

MIT License - see [LICENSE](LICENSE) for details.

---

Built with Dart for [APIVerve](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme)
