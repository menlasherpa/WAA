const Post = (props) => {
    return ( 
        <div class="post">
            <h1>{props.title}</h1>
            <h2>{props.author}</h2>
        </div>
     );
}
 
export default Post;