import Comment from "./Comment";

const Comments = (props) => {
  const comments = props.comments.map((c) => {
    return;
    <Comment id={c.id} name={c.name} />;
  });
  return comments;
};

export default Comments;
