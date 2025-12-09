declare module '@apiverve/readingtime' {
  export interface readingtimeOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface readingtimeResponse {
    status: string;
    error: string | null;
    data: ReadingTimeCalculatorData;
    code?: number;
  }


  interface ReadingTimeCalculatorData {
      textLength:         number;
      wordCount:          number;
      readingTimeMinutes: number;
      readingTimeSeconds: number;
      readingTimeText:    string;
      wordsPerMinute:     number;
  }

  export default class readingtimeWrapper {
    constructor(options: readingtimeOptions);

    execute(callback: (error: any, data: readingtimeResponse | null) => void): Promise<readingtimeResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: readingtimeResponse | null) => void): Promise<readingtimeResponse>;
    execute(query?: Record<string, any>): Promise<readingtimeResponse>;
  }
}
