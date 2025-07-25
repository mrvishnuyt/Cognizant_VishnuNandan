import React, { Component } from 'react';

// 4. Create a new class-based component named as Posts
class Posts extends Component {
  // 5. Initialize the component with a list of Post in state
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      error: null,
    };
  }

  // 6. Create a method to fetch posts using the Fetch API
  async loadPosts() {
    try {
      const response = await fetch('https://jsonplaceholder.typicode.com/posts');
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      const data = await response.json();
      // Assign the fetched data to the component state
      this.setState({ posts: data });
    } catch (error) {
      this.setState({ error: error });
      console.error("Failed to fetch posts:", error);
    }
  }

  // 7. Implement componentDidMount() to call loadPosts()
  componentDidMount() {
    this.loadPosts();
  }

  // 9. Define componentDidCatch() to handle errors in child components
  componentDidCatch(error, info) {
    // Note: This lifecycle method catches errors in the component tree *below* it.
    // It won't catch errors in this component itself (like in render or componentDidMount).
    // We are using a simple alert as requested.
    alert(`An error occurred: ${error.message}`);
    console.error("Component Error:", error, info);
  }

  // 8. Implement render() to display the posts
  render() {
    const { posts, error } = this.state;

    if (error) {
      return <div>Error loading posts: {error.message}</div>;
    }

    return (
      <div>
        <h1>Blog Posts 📝</h1>
        {posts.map(post => (
          <article key={post.id}>
            <h2>{post.title}</h2>
            <p>{post.body}</p>
          </article>
        ))}
      </div>
    );
  }
}

export default Posts;