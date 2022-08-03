import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Book } from "./model/Book";
import { Observable } from "rxjs";

@Injectable()
export class BooksService {

  private readonly url = 'https://sheet.best/api/sheets/9acab264-892b-42ac-9308-a584820bfce1'
  //private httpOptions: HttpHeaders = new HttpHeaders({ 'content-type': 'application/json' })

  constructor(private http: HttpClient) {}

  getBooks(): Observable<Book[]> {
    return this.http.get<Book[]>(this.url)
  }
}

