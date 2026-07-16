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
        /// </summary>
        [JsonProperty("text")]
        public string Text { get; set; }

        /// <summary>
        /// Words per minute reading speed
        /// </summary>
        [JsonProperty("wpm")]
        public int? Wpm { get; set; }
    }
}
