import axios from "axios";
import { useRef } from "react";

const AddPost = (props) => {
  const addPostRef = useRef({});

  const addPostHandler = (e) => {
    e.preventDefault();
    const ref = addPostRef.current;
    const data = {
      title: ref["title"].value,
      author: ref["author"].value,
      content: ref["conent"].value,
    };
    axios
      .post("https://localhost:8000/posts/", data)
      .then((res) => {
        props.execute();
        console.log("New post added", res);
      })
      .catch((err) => {
        console.error(err);
      });
  };

  return (
    <div class="addPost">
      <h1>Add new Post</h1>
      <form ref={addPostRef}>
        <label>Title:</label>
        <input type="text" name="title"></input>

        <label>Author:</label>
        <input type="text" name="author"></input>

        <label>Post content:</label>
        <textarea name="content"></textarea>
        <button onClick={addPostHandler}>Add Post</button>
      </form>
    </div>
  );
};

export default AddPost;
