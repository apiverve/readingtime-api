/// Response models for the Reading Time Calculator API.

/// API Response wrapper.
class ReadingtimeResponse {
  final String status;
  final dynamic error;
  final ReadingtimeData? data;

  /// Set only when the current plan locks one or more fields; null otherwise.
  final PremiumInfo? premium;

  ReadingtimeResponse({
    required this.status,
    this.error,
    this.data,
    this.premium,
  });

  factory ReadingtimeResponse.fromJson(Map<String, dynamic> json) => ReadingtimeResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? ReadingtimeData.fromJson(json['data']) : null,
    premium: json['premium'] != null ? PremiumInfo.fromJson(json['premium']) : null,
  );

  Map<String, dynamic> toJson() => {
    'status': status,
    if (error != null) 'error': error,
    if (data != null) 'data': data,
    if (premium != null) 'premium': premium!.toJson(),
  };
}

/// Describes fields the current plan does not unlock. Locked fields arrive as null
/// in [data], and [lockedFields] names them (nested ones use dot paths).
class PremiumInfo {
  final String? message;
  final String? upgradeUrl;
  final List<String>? lockedFields;

  PremiumInfo({this.message, this.upgradeUrl, this.lockedFields});

  factory PremiumInfo.fromJson(Map<String, dynamic> json) => PremiumInfo(
    message: json['message'] as String?,
    upgradeUrl: json['upgrade_url'] as String?,
    lockedFields: (json['locked_fields'] as List?)?.map((e) => e.toString()).toList(),
  );

  Map<String, dynamic> toJson() => {
    if (message != null) 'message': message,
    if (upgradeUrl != null) 'upgrade_url': upgradeUrl,
    if (lockedFields != null) 'locked_fields': lockedFields,
  };
}

/// Response data for the Reading Time Calculator API.

class ReadingtimeData {
  num? textLength;
  num? wordCount;
  num? readingTimeMinutes;
  num? readingTimeSeconds;
  String? readingTimeText;
  num? wordsPerMinute;

  ReadingtimeData({
    this.textLength,
    this.wordCount,
    this.readingTimeMinutes,
    this.readingTimeSeconds,
    this.readingTimeText,
    this.wordsPerMinute,
  });

  factory ReadingtimeData.fromJson(Map<String, dynamic> json) => ReadingtimeData(
      textLength: json['text_length'],
      wordCount: json['word_count'],
      readingTimeMinutes: json['reading_time_minutes'],
      readingTimeSeconds: json['reading_time_seconds'],
      readingTimeText: json['reading_time_text'],
      wordsPerMinute: json['words_per_minute'],
    );
}

class ReadingtimeRequest {
  String text;
  num? wpm;

  ReadingtimeRequest({
    required this.text,
    this.wpm,
  });

  Map<String, dynamic> toJson() => {
      'text': text,
      if (wpm != null) 'wpm': wpm,
    };
}
