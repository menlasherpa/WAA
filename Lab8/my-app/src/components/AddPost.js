import axios from "axios";
import { useRef } from "react";

const AddPost = (props) => {
  const [post, setPost] = useState({
    title: "",
    content: "",
    author: "",
  });

  const addPost = (event) => {
    event.preventDefault();
    axios
      .post("http://localhost:8000/posts", post)
      .then((response) => {
        props.updateFlag();
        console.log("successfully saved");
      })
      .catch((error) => {
        console.log(error.message);
      });
  };

  return (
    <div className="AddPost">
      <h1>Add Post</h1>
      <form>
        <label>ID: </label>
        <input
          type="text"
          label={"id"}
          name={"id"}
          value={props.id}
          onChange={(event) => setPost({ ...post, id: event.target.value })}
        />
        <label>Title: </label>
        <input
          type="text"
          label={"title"}
          name={"title"}
          value={props.title}
          onChange={(event) => setPost({ ...post, title: event.target.value })}
        />

        <label>Author: </label>
        <input
          type="text"
          label={"author"}
          name={"author"}
          value={props.author}
          onChange={(event) => setPost({ ...post, author: event.target.value })}
        />

        <label>Content: </label>
        <input
          type="text"
          label={"content"}
          name={"content"}
          value={props.content}
          onChange={(event) =>
            setPost({ ...post, content: event.target.value })
          }
        />

        <button onClick={addPost}>Add Post </button>
      </form>
    </div>
  );
};

export default AddPost;
