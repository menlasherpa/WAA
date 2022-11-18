import axios from "axios";
import { useState } from "react";

const PostDetails = (props) => {
  const [comments, setComments] = useState(0);

  return (
    <div className="PostDetails">
      <h2>
        <u>{props.title}</u>
      </h2>
      <h3>{props.author}</h3>
      <div className="text">
        <p>{props.content}</p>
      </div>
      <br />
      <br />

      <button onClick={edit}>Edit</button>
      <button
        onClick={() => {
          props.deletePost(props.id);
        }}
      >
        Delete
      </button>
    </div>
  );
};
export default PostDetails;
