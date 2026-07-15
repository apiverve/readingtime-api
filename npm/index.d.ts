declare module '@apiverve/readingtime' {
  export interface readingtimeOptions {
    api_key: string;
    secure?: boolean;
  }

  /**
   * Describes fields the current plan does not unlock. Locked fields arrive as null
   * in `data`; `locked_fields` names them, using dot paths for nested fields.
   * Absent when the plan unlocks everything.
   */
  export interface PremiumInfo {
    message: string;
    upgrade_url: string;
    locked_fields: string[];
  }

  export interface readingtimeResponse {
    status: string;
    error: string | null;
    data: ReadingTimeCalculatorData;
    code?: number;
    premium?: PremiumInfo;
  }


  interface ReadingTimeCalculatorData {
      textLength:         number | null;
      wordCount:          number | null;
      readingTimeMinutes: number | null;
      readingTimeSeconds: number | null;
      readingTimeText:    null | string;
      wordsPerMinute:     number | null;
  }

  export default class readingtimeWrapper {
    constructor(options: readingtimeOptions);

    execute(callback: (error: any, data: readingtimeResponse | null) => void): Promise<readingtimeResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: readingtimeResponse | null) => void): Promise<readingtimeResponse>;
    execute(query?: Record<string, any>): Promise<readingtimeResponse>;
  }
}
