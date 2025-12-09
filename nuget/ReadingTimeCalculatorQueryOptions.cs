using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.ReadingTimeCalculator
{
    /// <summary>
    /// Query options for the Reading Time Calculator API
    /// </summary>
    public class ReadingTimeCalculatorQueryOptions
    {
        /// <summary>
        /// The text to calculate reading time for
        /// Example: This is a sample article with multiple paragraphs. Reading time will be calculated based on word count.
        /// </summary>
        [JsonProperty("text")]
        public string Text { get; set; }

        /// <summary>
        /// Words per minute reading speed (50-1000, default: 250)
        /// Example: 250
        /// </summary>
        [JsonProperty("wpm")]
        public string Wpm { get; set; }
    }
}
