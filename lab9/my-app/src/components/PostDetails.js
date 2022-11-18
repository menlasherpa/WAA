import Comment from "./Comment";
import "./Posts.css"

const PostDetails = (props) => {

    const post = (
        <div class="postDetails">
            <p>{props.title}</p>
            <p>{props.author}</p>
            <p>{post.comments ? post.comments.length : 0} comments</p>
            <p>{(post.comments || []).map((comment, index) => {
                <Comment key={comment.id+index} comment={comment.name}/>
            })}</p>
            <button>Edit</button>
            <button onClick={props.deletePost}>Delete</button>
        </div>
    )
    return post;
}
 
export default PostDetails;