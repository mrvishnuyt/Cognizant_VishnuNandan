// This class isn't strictly necessary for fetching and displaying data,
// but it's included as requested to define the data model.
export default class Post {
  constructor(userId, id, title, body) {
    this.userId = userId;
    this.id = id;
    this.title = title;
    this.body = body;
  }
}